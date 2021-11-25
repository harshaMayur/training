package de.hybris.training.core.interceptor;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;
import de.hybris.training.core.jalo.ManufacturerInfo;

public class ManufacturerInfoValidateInterceptor implements ValidateInterceptor<ManufacturerInfo>{
    private ConfigurationService configurationService;
    String limit="product.manufacturer.id.limit";
    String ERROR_MSG="product.manufacturer.id.error";
    @Override
    public void onValidate(ManufacturerInfo manufacturerInfo, InterceptorContext interceptorContext) throws InterceptorException {
       int manuIdLimit= configurationService.getConfiguration().getInt(limit);
       int manuIdLength=manufacturerInfo.getId().length();
       if(manuIdLength!=manuIdLimit){
           throw new InterceptorException(String.format(ERROR_MSG, manufacturerInfo.getId()), this);
       }
    }

    public ConfigurationService getConfigurationService() {
        return configurationService;
    }

    public void setConfigurationService(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }
}
