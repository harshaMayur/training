package de.hybris.training.facades.Manufacturer;

import de.hybris.platform.commercefacades.product.data.ManufacturerInfoData;

import javax.servlet.http.HttpServletRequest;

public interface ManufacturerFacade {
    /**
     * saves manufacturer details to DB
     * @param manufacturerInfoData
     * @return
     */
    public void saveManuDetails(ManufacturerInfoData manufacturerInfoData);
}
