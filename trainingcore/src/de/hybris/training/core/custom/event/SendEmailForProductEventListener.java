package de.hybris.training.core.custom.event;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.processengine.model.BusinessProcessModel;
import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.training.core.model.process.EmailForProductProcessModel;

public class SendEmailForProductEventListener extends AbstractEventListener<SendEmailForProductEvent> {

    private BusinessProcessService businessProcessService;
    private ModelService modelService;
    @Override
    protected void onEvent(SendEmailForProductEvent event) {
        final ProductModel currentProduct=event.getCurrentProduct();
        EmailForProductProcessModel emailForProductProcessModel = (EmailForProductProcessModel) getBusinessProcessService().createProcess(
                "emailForProduct-" + currentProduct.getCode() + "-" + EmailForProductProcessModel._TYPECODE + "-" + System.currentTimeMillis(),
                "emailForProduct");
        if (emailForProductProcessModel != null)
        {
            emailForProductProcessModel.setCurrentProduct(currentProduct);
            getModelService().save(emailForProductProcessModel);
            getBusinessProcessService().startProcess(emailForProductProcessModel);
        }
    }

    public BusinessProcessService getBusinessProcessService() {
        return businessProcessService;
    }

    public void setBusinessProcessService(BusinessProcessService businessProcessService) {
        this.businessProcessService = businessProcessService;
    }

    public ModelService getModelService() {
        return modelService;
    }

    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
}
