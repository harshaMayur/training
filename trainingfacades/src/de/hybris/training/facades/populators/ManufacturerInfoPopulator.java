package de.hybris.training.facades.populators;

import de.hybris.platform.commercefacades.product.data.ManufacturerInfoData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.training.core.model.ManufacturerInfoModel;

public class ManufacturerInfoPopulator implements Populator<ManufacturerInfoModel, ManufacturerInfoData> {
    @Override
    public void populate(ManufacturerInfoModel manufacturerInfoModel, ManufacturerInfoData manufacturerInfoData) throws ConversionException {
        manufacturerInfoData.setId(manufacturerInfoModel.getId());
        manufacturerInfoData.setName(manufacturerInfoModel.getName());
        manufacturerInfoData.setEstablishmentYear(manufacturerInfoModel.getEstablishmentYear());
    }
}
