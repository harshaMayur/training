package de.hybris.training.core.custom.event;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.event.events.AbstractEvent;

public class SendEmailForProductEvent extends AbstractEvent{
    private ProductModel currentProduct;

    public SendEmailForProductEvent(ProductModel productModel) {
        currentProduct=productModel;
    }
    public ProductModel getCurrentProduct() {
        return currentProduct;
    }

    public void setCurrentProduct(ProductModel currentProduct) {
        this.currentProduct = currentProduct;
    }
}
