package de.hybris.training.facades.training;

import de.hybris.platform.acceleratorfacades.csv.CsvFacade;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.commercefacades.order.data.OrderData;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public interface TrainingCsvFacade {

    void generateCsvFromOrder(final List<String> headers, final boolean includeHeader, final OrderData orderData, final Writer writer)
            throws IOException;

}
