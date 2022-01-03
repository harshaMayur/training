package de.hybris.training.storefront.controllers.restApi;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.training.core.Dto.ActivityDetailsDTO;
import de.hybris.training.core.form.NameApiForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.training.restServices.TrainingRestService;

import javax.annotation.Resource;

@Controller
public class TrainingRestApiController extends AbstractPageController {

    @Resource(name = "trainingRestService")
    private TrainingRestService trainingRestService;

    private static final String activityPage="activityDetailsPage";
    private static final String nameApiFormPage="nameFormPage";
    private static final String nameApiDetailsPage="nameApiDetailsPage";


    @RequestMapping(value = "/activity",method = RequestMethod.GET)
    public String showActivity(final Model model) throws CMSItemNotFoundException {
        ActivityDetailsDTO activityDetails= trainingRestService.showActivityDetails();
        model.addAttribute("activityDetails", activityDetails);
        final ContentPageModel manufacturerDetailsCMSPage = getContentPageForLabelOrId(activityPage);
        storeCmsPageInModel(model, manufacturerDetailsCMSPage);
        setUpMetaDataForContentPage(model, manufacturerDetailsCMSPage);
        return getViewForPage(model);
    }

    /**
     * Displays Name form
     * @param nameApiForm
     * @param model
     * @return
     * @throws CMSItemNotFoundException
     */
    @RequestMapping(value = "/nameForm")
    public String nameApi(@ModelAttribute("nameApiForm") final NameApiForm nameApiForm, Model model) throws CMSItemNotFoundException {
        final ContentPageModel nameFormCMSPage = getContentPageForLabelOrId(nameApiFormPage);
        storeCmsPageInModel(model, nameFormCMSPage);
        setUpMetaDataForContentPage(model, nameFormCMSPage);
        return getViewForPage(model);
    }

    /**
     * Displays details fetched from occ
     * @param nameApiForm
     * @param model
     * @return
     * @throws CMSItemNotFoundException
     */
    @RequestMapping(value = "/nameForm/getDetails")
    public String ShowNameApiDetails(@ModelAttribute("nameApiForm") final NameApiForm nameApiForm, final Model model) throws CMSItemNotFoundException {
        String name= nameApiForm.getName();
        NameApiForm nameDetails= trainingRestService.displayNameApi(name);
        model.addAttribute("nameDetails",nameDetails);
        final ContentPageModel activityDetailsCMSPage = getContentPageForLabelOrId(nameApiDetailsPage);
        storeCmsPageInModel(model, activityDetailsCMSPage);
        setUpMetaDataForContentPage(model, activityDetailsCMSPage);
        return getViewForPage(model);
    }

}