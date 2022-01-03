package de.hybris.training.storefront.controllers.training;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.AbstractController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.training.core.Dto.ActivityDetailsDTO;
import de.hybris.training.storefront.controllers.ControllerConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.training.restServices.TrainingRestService;


import javax.annotation.Resource;

@Controller
public class TrainingRestApiController extends AbstractPageController {

    @Resource(name = "trainingRestService")
    private TrainingRestService trainingRestService;

    private static final String activityPage="activityDetailsPage";


    @RequestMapping(value = "/activity",method = RequestMethod.GET)
    public String showActivity(final Model model) throws CMSItemNotFoundException {
        ActivityDetailsDTO activityDetails= trainingRestService.showActivityDetails();
        model.addAttribute("activityDetails", activityDetails);
        final ContentPageModel activityDetailsCMSPage = getContentPageForLabelOrId(activityPage);
        storeCmsPageInModel(model, activityDetailsCMSPage);
        setUpMetaDataForContentPage(model, activityDetailsCMSPage);
        return getViewForPage(model);
        /*return ControllerConstants.Views.Pages.Training.TrainingActivityDetailPage;*/
    }

}
