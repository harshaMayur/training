package de.hybris.training.core.service;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commerceservices.order.impl.DefaultCommerceCartCalculationStrategy;
import de.hybris.platform.commerceservices.service.data.CommerceCartParameter;
import de.hybris.platform.core.model.order.CartEntryModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.order.CartServiceTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.training.core.services.TrainingCartService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.Model;

import static org.mockito.Mockito.doReturn;

@UnitTest
public abstract class DefaultTrainingCartServiceTest extends CartServiceTest implements TrainingCartService {

    @Mock
    private DefaultCommerceCartCalculationStrategy cartCalculationStrategy;

    @Mock
    private ModelService modelService;

    private CartModel cart;

    @Before
    public void setup(){
        CartModel cart = getSessionCart();

    }
    @Test
    public void testAddEntryToCart() {
            int entryNumber=0;
            if (cart!= null) {
                CartEntryModel entry = doReturn(CartEntryModel.class).when(getEntryForNumber(cart, entryNumber));
                CartEntryModel duplicateEntry = doReturn(CartEntryModel.class).when(modelService.clone(entry));
                doReturn(1).when(addEntryAtPosition(cart, duplicateEntry, -1));
                cart.setCalculated(false);
                modelService.save(cart);
                modelService.refresh(cart);
                CommerceCartParameter parameter = new CommerceCartParameter();
                parameter.setCart(cart);
                doReturn(true).when(cartCalculationStrategy.calculateCart(parameter));
                Assert.assertEquals(true, cartCalculationStrategy.calculateCart(parameter));
            }
        }


    private int addEntryAtPosition(CartModel cart, CartEntryModel duplicateEntry, int i) {
        return 1;
    }

}
