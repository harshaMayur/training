package de.hybris.training.storefront.controllers.training;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.training.core.Dto.ActivityDetailsDTO;
import de.hybris.training.core.form.NameApiDto;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.training.restServices.TrainingRestService;


import javax.annotation.Resource;
import java.net.http.HttpTimeoutException;

@Controller
public class TrainingRestApiController extends AbstractPageController {

    @Resource(name="trainingRestService")
    private TrainingRestService trainingRestService;

    private static final String activityPage="activityDetailsPage";
    private static final String nameApiDetailsPage="nameApiDetailsPage";
    private static final String nameApiFormPage="nameFormPage";


    @RequestMapping(value = "/activity",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String showActivity(final Model model) throws CMSItemNotFoundException {
        ActivityDetailsDTO activityDetails=null;
        try {
           activityDetails = trainingRestService.showActivityDetails();
           model.addAttribute("activityDetails", activityDetails);
        }catch(RestClientException e){
            model.addAttribute("error","Please try again after some time");
        }
        final ContentPageModel activityDetailsCMSPage = getContentPageForLabelOrId(activityPage);
        storeCmsPageInModel(model, activityDetailsCMSPage);
        setUpMetaDataForContentPage(model, activityDetailsCMSPage);
        return getViewForPage(model);
        /*return ControllerConstants.Views.Pages.Training.TrainingActivityDetailPage;*/
    }

    /**
     * Displays Name form
     * @param nameApidto
     * @param model
     * @return
     * @throws CMSItemNotFoundException
     */
    @RequestMapping(value = "/nameForm")
    public String nameApi(@ModelAttribute("nameApiForm") final NameApiDto nameApidto, Model model) throws CMSItemNotFoundException {
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
    @ResponseStatus(HttpStatus.OK)
    public String ShowNameApiDetails(@ModelAttribute("nameApiForm") final NameApiDto nameApiForm, final Model model) throws CMSItemNotFoundException {
        String name= nameApiForm.getName();
        NameApiDto nameDetails=null;
        if(StringUtils.isNotEmpty(name)){
            try{
                nameDetails= trainingRestService.displayNameApi(name);
                model.addAttribute("nameDetails",nameDetails);
            }catch(RestClientException e){
                model.addAttribute("error","Please try again after some time");
            }
        }
        final ContentPageModel activityDetailsCMSPage = getContentPageForLabelOrId(nameApiDetailsPage);
        storeCmsPageInModel(model, activityDetailsCMSPage);
        setUpMetaDataForContentPage(model, activityDetailsCMSPage);
        return getViewForPage(model);
    }

}
