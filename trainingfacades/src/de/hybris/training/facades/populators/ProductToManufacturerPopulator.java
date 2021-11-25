package de.hybris.training.facades.populators;


import de.hybris.platform.commercefacades.product.data.ManufacturerInfoData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.training.core.model.ManufacturerInfoModel;
import org.apache.log4j.Logger;

public class ProductToManufacturerPopulator implements Populator<ProductModel, ProductData> {
    private static final Logger LOG = Logger.getLogger(ProductToManufacturerPopulator.class);

    Converter<ManufacturerInfoModel, ManufacturerInfoData> defaultManufacturerInfoConverter;
    @Override
    public void populate(ProductModel productModel, ProductData productData) throws ConversionException {
        LOG.info("Inside ProductToManufacturerPopulator ");
        productData.setManufacturerInfo(getDefaultManufacturerInfoConverter().convertAll(productModel.getManufacturer()));
    }

    public Converter<ManufacturerInfoModel, ManufacturerInfoData> getDefaultManufacturerInfoConverter() {
        return defaultManufacturerInfoConverter;
    }

    public void setDefaultManufacturerInfoConverter(Converter<ManufacturerInfoModel, ManufacturerInfoData> defaultManufacturerInfoConverter) {
        this.defaultManufacturerInfoConverter = defaultManufacturerInfoConverter;
    }
}
