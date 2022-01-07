package de.hybris.training.core.services.impl;

import de.hybris.platform.commercefacades.product.data.ManufacturerInfoData;
import de.hybris.platform.servicelayer.exceptions.ModelSavingException;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.training.core.model.ManufacturerInfoModel;
import de.hybris.training.core.services.ManufacturerService;
import org.apache.log4j.Logger;

import javax.annotation.Resource;

public class DefaultManufacturerService implements ManufacturerService {

    @Resource(name="modelService")
    private ModelService modelService;

    private static final Logger LOG = Logger.getLogger(DefaultManufacturerService.class);
    @Override
    public void saveManuDetails(final ManufacturerInfoModel manufacturerInfoModel) {
        try {
            modelService.save(manufacturerInfoModel);
            modelService.refresh(manufacturerInfoModel);
        }catch (ModelSavingException e){
            LOG.error("Error while saving manufacturer info model.");
        }
    }
}
