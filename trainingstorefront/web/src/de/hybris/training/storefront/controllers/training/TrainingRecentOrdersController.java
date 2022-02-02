package de.hybris.training.storefront.controllers.training;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.commercefacades.order.OrderFacade;
import de.hybris.platform.commercefacades.order.data.OrderData;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.platform.commercefacades.order.data.OrderHistoryData;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.training.storefront.controllers.ControllerConstants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class TrainingRecentOrdersController extends AbstractPageController {

    private static final Logger LOG = Logger.getLogger(TrainingRecentOrdersController.class);
    /*private static final String ORDERDETAILS_CMS_PAGE = "orderDetailsPage";*/

    @Resource(name = "orderFacade")
    private OrderFacade orderFacade;


    /**
     * gets order details by order id
     * @param orderId
     * @param model
     * @return
     * @throws CMSItemNotFoundException
     */
    @RequestMapping(value="/orderDetails/{orderId}", method = RequestMethod.GET)
    public String getOrderDetails(@PathVariable("orderId") final String orderId, Model model) throws CMSItemNotFoundException {
        if(orderId!=null){
                final OrderData orderDetail= orderFacade.getOrderDetailsForCode(orderId);
                DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                model.addAttribute("CreationDate", formatter.format(orderDetail.getCreated()));
                model.addAttribute("order",orderDetail);
                model.addAttribute("orderEntryDetail" , orderDetail.getEntries());
        }
        return ControllerConstants.Views.Pages.Orders.OrderDetails;
        /*final ContentPageModel orderDetailsCMSPage = getContentPageForLabelOrId(ORDERDETAILS_CMS_PAGE);
        storeCmsPageInModel(model, orderDetailsCMSPage);
        setUpMetaDataForContentPage(model, orderDetailsCMSPage);
        return getViewForPage(model);*/
    }

}
