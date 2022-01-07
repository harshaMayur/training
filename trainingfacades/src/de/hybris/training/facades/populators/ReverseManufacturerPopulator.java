package de.hybris.training.facades.populators;

import de.hybris.platform.commercefacades.product.data.ManufacturerInfoData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.training.core.model.ManufacturerInfoModel;

public class ReverseManufacturerPopulator implements Populator<ManufacturerInfoData, ManufacturerInfoModel> {
    @Override
    public void populate(ManufacturerInfoData manufacturerInfoData, ManufacturerInfoModel manufacturerInfoModel) throws ConversionException {
        manufacturerInfoModel.setId(manufacturerInfoData.getId());
        manufacturerInfoModel.setName(manufacturerInfoData.getName());
        manufacturerInfoModel.setEstablishmentYear(manufacturerInfoData.getEstablishmentYear());
    }
}
