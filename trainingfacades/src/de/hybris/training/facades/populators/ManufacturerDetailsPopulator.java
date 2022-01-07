package de.hybris.training.facades.populators;

import de.hybris.platform.commercefacades.product.data.ManufacturerInfoData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.training.populator.AbstractHttpRequestDataPopulator;

import javax.servlet.http.HttpServletRequest;

public class ManufacturerDetailsPopulator extends AbstractHttpRequestDataPopulator
        implements Populator<HttpServletRequest, ManufacturerInfoData> {
    @Override
    public void populate(HttpServletRequest request, ManufacturerInfoData manufacturerInfoData) throws ConversionException {
        manufacturerInfoData.setId(updateStringValueFromRequest(request,"id", manufacturerInfoData.getId()));
        manufacturerInfoData.setName(updateStringValueFromRequest(request, "name", manufacturerInfoData.getName()));
        manufacturerInfoData.setEstablishmentYear(Integer.valueOf(updateStringValueFromRequest(request, "establishmentYear", String.valueOf(manufacturerInfoData.getEstablishmentYear()))));
    }
}
