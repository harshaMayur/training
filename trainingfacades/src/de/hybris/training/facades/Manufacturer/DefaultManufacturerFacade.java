package de.hybris.training.facades.Manufacturer;

import de.hybris.platform.commercefacades.product.data.ManufacturerInfoData;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.training.core.model.ManufacturerInfoModel;
import de.hybris.training.core.services.ManufacturerService;
import de.hybris.training.facades.populators.ReverseManufacturerPopulator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

public class DefaultManufacturerFacade implements ManufacturerFacade {

    @Resource(name="manufacturerService")
    private ManufacturerService manufacturerService;

    @Resource(name="modelService")
    private ModelService modelService;

    @Resource(name="reverseManufacturerPopulator")
    private ReverseManufacturerPopulator reverseManufacturerPopulator;

    @Override
    public void saveManuDetails(ManufacturerInfoData manufacturerInfoData) {
        final ManufacturerInfoModel manufacturerInfoModel = modelService.create(ManufacturerInfoModel.class);
        reverseManufacturerPopulator.populate(manufacturerInfoData,manufacturerInfoModel);
        manufacturerService.saveManuDetails(manufacturerInfoModel);
    }
}
