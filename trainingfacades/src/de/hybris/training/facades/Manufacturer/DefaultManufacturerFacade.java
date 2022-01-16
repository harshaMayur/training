package de.hybris.training.facades.Manufacturer;

import de.hybris.platform.commercefacades.product.data.ManufacturerInfoData;
import de.hybris.training.core.services.ManufacturerService;
import de.hybris.training.facades.populators.ManufacturerDetailsPopulator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

public class DefaultManufacturerFacade implements ManufacturerFacade {

    @Resource(name="manufacturerDetailsPopulator")
    private ManufacturerDetailsPopulator manufacturerDetailsPopulator;

    @Resource(name="manufacturerService")
    private ManufacturerService manufacturerService;

    @Override
    public ManufacturerInfoData getManufacturerDetails(HttpServletRequest request) {
        final ManufacturerInfoData manufacturerInfoData=new ManufacturerInfoData();
        manufacturerDetailsPopulator.populate(request,manufacturerInfoData);
        return manufacturerInfoData;
    }

    @Override
    public void saveManuDetails(ManufacturerInfoData manufacturerInfoData) {
        manufacturerService.saveManuDetails(manufacturerInfoData);
    }
}
