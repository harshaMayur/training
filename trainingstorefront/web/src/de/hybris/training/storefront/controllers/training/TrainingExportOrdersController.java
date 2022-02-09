package de.hybris.training.storefront.controllers.training;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.commercefacades.order.OrderFacade;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.commercefacades.order.data.OrderData;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.training.facades.training.TrainingCsvFacade;
import de.hybris.training.storefront.controllers.pages.CartPageController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TrainingExportOrdersController extends AbstractPageController {

    private static final Logger LOG = Logger.getLogger(TrainingExportOrdersController.class);
    private static final String REDIRECT_TO_ORDER_DETAILS_PAGE = REDIRECT_PREFIX + "/my-account/orders/{orderCode:.*}";

    @Resource(name = "orderFacade")
    private OrderFacade orderFacade;

    @Resource(name="trainingCsvFacade")
    private TrainingCsvFacade trainingCsvFacade;

    @RequestMapping(value = "/export/{orderId}", method = RequestMethod.GET, produces = "text/csv")
    public String exportCsvFile(@PathVariable("orderId") final String orderId, final HttpServletResponse response, final RedirectAttributes redirectModel) throws IOException
    {
        response.setHeader("Content-Disposition", "attachment;filename=orderDetails.csv");

        try (final StringWriter writer = new StringWriter())
        {
            try
            {
                final List<String> headers = new ArrayList<String>();
                headers.add(getMessageSource().getMessage("order.product.itemcode", null, getI18nService().getCurrentLocale()));
                headers.add(getMessageSource().getMessage("order.quantity", null, getI18nService().getCurrentLocale()));
                headers.add(getMessageSource().getMessage("order.product", null, getI18nService().getCurrentLocale()));
                headers.add(
                        getMessageSource().getMessage("order.itemPrice", null, getI18nService().getCurrentLocale()));
                headers.add(getMessageSource().getMessage("order.totals.subtotal", null, getI18nService().getCurrentLocale()));

                final OrderData orderData = orderFacade.getOrderDetailsForCode(orderId);
                trainingCsvFacade.generateCsvFromOrder(headers, true, orderData, writer);

                StreamUtils.copy(writer.toString(), StandardCharsets.UTF_8, response.getOutputStream());
            }
            catch (final IOException e)
            {
                LOG.error(e.getMessage(), e);
                GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER, "order.details.exceptions", null);

                return REDIRECT_TO_ORDER_DETAILS_PAGE;
            }

        }

        return null;
    }
}
