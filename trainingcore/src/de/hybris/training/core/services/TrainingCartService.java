package de.hybris.training.core.services;

import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.order.CartService;
import org.springframework.ui.Model;

public interface TrainingCartService extends CartService {
    CartModel addEntryToCart(int entryNumber, Model model);
}
