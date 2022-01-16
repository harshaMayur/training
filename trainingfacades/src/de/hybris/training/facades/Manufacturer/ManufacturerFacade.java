package de.hybris.training.facades.Manufacturer;

import de.hybris.platform.commercefacades.product.data.ManufacturerInfoData;

import javax.servlet.http.HttpServletRequest;

public interface ManufacturerFacade {
    /**
     * gets manufacturer details from HttpRequest to to data
     * @param request
     * @return ManufacturerInfoData
     */
    public ManufacturerInfoData getManufacturerDetails(HttpServletRequest request);

    /**
     * saves manufacturer details to DB
     * @param manufacturerInfoData
     * @return
     */
    public void saveManuDetails(ManufacturerInfoData manufacturerInfoData);
}
