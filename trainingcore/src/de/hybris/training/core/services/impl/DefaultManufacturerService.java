package de.hybris.training.core.services.impl;

import com.training.core.model.ManufacturerInfoModel;
import de.hybris.platform.commercefacades.product.data.ManufacturerInfoData;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.training.core.services.ManufacturerService;

import javax.annotation.Resource;

public class DefaultManufacturerService implements ManufacturerService {

    @Resource(name="modelService")
    private ModelService modelService;


    @Override
    public void saveManuDetails(ManufacturerInfoData manufacturerInfoData) {
            final ManufacturerInfoModel manufacturerInfoModel = modelService.create(ManufacturerInfoModel.class);
            manufacturerInfoModel.setName(manufacturerInfoData.getName());
            manufacturerInfoModel.setEstablishmentYear(manufacturerInfoData.getEstablishmentYear());
    }
}
