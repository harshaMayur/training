package de.hybris.training.core.services;

import de.hybris.platform.commercefacades.product.data.ManufacturerInfoData;

public interface ManufacturerService {
    /**
     * saves manufacturer details to DB
     * @param manufacturerInfoData
     * @return
     */
    void saveManuDetails(ManufacturerInfoData manufacturerInfoData);
}
