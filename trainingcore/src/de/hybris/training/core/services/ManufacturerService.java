package de.hybris.training.core.services;

import de.hybris.platform.commercefacades.product.data.ManufacturerInfoData;
import de.hybris.training.core.model.ManufacturerInfoModel;

public interface ManufacturerService {
    /**
     * saves manufacturer details to DB
     * @param manufacturerInfoModel
     * @return
     */
    void saveManuDetails(ManufacturerInfoModel manufacturerInfoModel);
}
