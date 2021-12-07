package de.hybris.training.facades.process.email.context;

import de.hybris.platform.acceleratorservices.model.cms2.pages.EmailPageModel;
import de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commerceservices.model.process.EmailForProductProcessModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.site.BaseSiteService;

import javax.annotation.Resource;

public class EmailForProductContext extends AbstractEmailContext<EmailForProductProcessModel> {

    @Resource
    private BaseSiteService baseSiteService;
    @Override
    public void init(final EmailForProductProcessModel emailForProductProcessModel, final EmailPageModel emailPageModel){
        super.init(emailForProductProcessModel,emailPageModel);
        ProductModel currentProduct=emailForProductProcessModel.getCurrentProduct();
        put("currentProduct",currentProduct);
        put("email","harsha.mayur@nendrasys.com");
    }
    @Override
    protected BaseSiteModel getSite(EmailForProductProcessModel businessProcessModel) {
        return baseSiteService.getCurrentBaseSite();
    }

    @Override
    protected CustomerModel getCustomer(EmailForProductProcessModel businessProcessModel) {
        return null;
    }

    @Override
    protected LanguageModel getEmailLanguage(EmailForProductProcessModel businessProcessModel) {
        return null;
    }
}
