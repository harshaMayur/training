package de.hybris.training.facades.populators;


import de.hybris.platform.commercefacades.order.converters.populator.CommerceCartParameterBasicPopulator;
import de.hybris.platform.commercefacades.order.data.AddToCartParams;
import de.hybris.platform.commerceservices.service.data.CommerceCartParameter;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

public class CustomCommerceCartParameterBasicPopulator extends CommerceCartParameterBasicPopulator {
    @Override
    public void populate(final AddToCartParams addToCartParams, final CommerceCartParameter parameter) throws ConversionException{
        super.populate(addToCartParams,parameter);
        parameter.setCreateNewEntry(true);
    }
}
