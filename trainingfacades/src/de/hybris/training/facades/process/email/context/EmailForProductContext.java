package de.hybris.training.facades.process.email.context;

import de.hybris.platform.acceleratorservices.model.cms2.pages.EmailPageModel;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.impl.AbstractPopulatingConverter;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.training.core.model.process.EmailForProductProcessModel;
import de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext;

public class EmailForProductContext extends AbstractEmailContext<EmailForProductProcessModel> {
    private AbstractPopulatingConverter<ProductModel, ProductData> productConverter;

    @Override
    public void init(final EmailForProductProcessModel emailForProductProcessModel, final EmailPageModel emailPageModel){
        super.init(emailForProductProcessModel,emailPageModel);
        ProductModel productModel=emailForProductProcessModel.getCurrentProduct();
        ProductData currentProduct= getProductConverter().convert(productModel);
        put("currentProduct",currentProduct);
        put("displayName","harsha");
        put("email","harsha.mayur@nendrasys.com");
    }
    @Override
    protected BaseSiteModel getSite(EmailForProductProcessModel businessProcessModel) {
        return businessProcessModel.getSite();
    }

    @Override
    protected CustomerModel getCustomer(EmailForProductProcessModel businessProcessModel) {
        return null;
    }

    @Override
    protected LanguageModel getEmailLanguage(EmailForProductProcessModel businessProcessModel) {
        return businessProcessModel.getSite().getDefaultLanguage();
    }

    public AbstractPopulatingConverter<ProductModel, ProductData> getProductConverter() {
        return productConverter;
    }

    public void setProductConverter(AbstractPopulatingConverter<ProductModel, ProductData> productConverter) {
        this.productConverter = productConverter;
    }
}
