package de.hybris.training.storefront.controllers.training;

import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import de.hybris.platform.cms2lib.model.components.RecentOrderCarouselComponentModel;
import de.hybris.platform.commercefacades.order.OrderFacade;
import de.hybris.platform.commercefacades.order.data.OrderHistoryData;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.training.storefront.controllers.ControllerConstants;
import de.hybris.training.storefront.controllers.cms.AbstractAcceleratorCMSComponentController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller("RecentOrderCarouselComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.RecentOrderCarouselComponent)
public class RecentOrderCarouselComponentController extends AbstractAcceleratorCMSComponentController<RecentOrderCarouselComponentModel> {

    private static final Logger LOG = Logger.getLogger(TrainingRecentOrdersController.class);
    @Resource(name = "orderFacade")
    private OrderFacade orderFacade;

    @Override
    protected void fillModel(HttpServletRequest request, Model model, RecentOrderCarouselComponentModel component) {
        final PageableData pageableData = createPageable(0, 5);
        try {
            final SearchPageData<OrderHistoryData> orders = orderFacade.getPagedOrderHistoryForStatuses(pageableData, OrderStatus.COMPLETED);
            if (orders != null) {
                List<OrderHistoryData> recentOrders= orders.getResults();
                model.addAttribute("recentOrders", recentOrders);
            }
        }catch(NullPointerException e){
            LOG.error("nullpointer exception occurred for omsOrderFacade.");
        }
    }

    /**
     * Creates a pageableData with provided page, pageSize and sort
     *
     * @param page
     *           current page number
     * @param pageSize
     *           number of items in a page
     * @return a pageableData
     */
    protected PageableData createPageable(final int page, final int pageSize)
    {
        final PageableData pageableData = new PageableData();
        pageableData.setCurrentPage(page);
        pageableData.setPageSize(pageSize);
        return pageableData;
    }
}
