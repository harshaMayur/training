package de.hybris.training.core.services.impl;

import de.hybris.platform.commerceservices.order.CommerceCartCalculationStrategy;
import de.hybris.platform.commerceservices.order.impl.DefaultCommerceCartCalculationStrategy;
import de.hybris.platform.commerceservices.service.data.CommerceCartParameter;
import de.hybris.platform.core.model.order.CartEntryModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.order.impl.DefaultCartService;
import de.hybris.training.core.services.TrainingCartService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.ui.Model;

public class DefaultTrainingCartService extends DefaultCartService implements TrainingCartService {

    private DefaultCommerceCartCalculationStrategy cartCalculationStrategy;


    @Override
    public CartModel addEntryToCart(int entryNumber, Model model) {
        CartEntryModel duplicateEntry;
        CartEntryModel entry;
        if (hasSessionCart()) {
            CartModel cart = getSessionCart();
             //fetch cart entry by entry number
            entry = getEntryForNumber(cart, entryNumber);
            duplicateEntry = getModelService().clone(entry);
            //set Entry To Cart
            addEntryAtPosition(cart, duplicateEntry, -1);
            cart.setCalculated(false);
            getModelService().save(cart);
            getModelService().refresh(cart);

            CommerceCartParameter parameter = new CommerceCartParameter();
            parameter.setCart(cart);
            cartCalculationStrategy.calculateCart(parameter);
            return cart;
        }
        return null;
    }

    public DefaultCommerceCartCalculationStrategy getCartCalculationStrategy() {
        return cartCalculationStrategy;
    }

    public void setCartCalculationStrategy(DefaultCommerceCartCalculationStrategy cartCalculationStrategy) {
        this.cartCalculationStrategy = cartCalculationStrategy;
    }
}
