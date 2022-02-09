package de.hybris.training.facades.training;

import de.hybris.platform.acceleratorfacades.csv.impl.DefaultCsvFacade;
import de.hybris.platform.commercefacades.order.data.OrderData;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringEscapeUtils;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class DefaultTrainingCsvFacade  implements TrainingCsvFacade{

    public static final String LINE_SEPERATOR = "\n";
    public static final String DELIMITER = ",";

    @Override
    public void generateCsvFromOrder(List<String> headers, boolean includeHeader, OrderData orderData, Writer writer) throws IOException {
        if (includeHeader && CollectionUtils.isNotEmpty(headers))
        {
            final StringBuilder csvHeader = new StringBuilder();
            int i = 0;
            for (; i < headers.size() - 1; i++)
            {
                csvHeader.append(StringEscapeUtils.escapeCsv(headers.get(i))).append(DELIMITER);
            }
            csvHeader.append(StringEscapeUtils.escapeCsv(headers.get(i))).append(LINE_SEPERATOR);
            writer.write(csvHeader.toString());
        }

        if (orderData != null && CollectionUtils.isNotEmpty(orderData.getEntries()))
        {
            writeOrderEntries(writer, orderData.getTotalPrice().getFormattedValue(), orderData.getEntries());
        }
    }

    protected void writeOrderEntries(final Writer writer, final String orderTotal, final List<OrderEntryData> entries) throws IOException
    {
        for (final OrderEntryData entry : entries)
        {
            if (Boolean.TRUE.equals(entry.getProduct().getMultidimensional()))
            {
                for (final OrderEntryData subEntry : entry.getEntries())
                {
                    writeOrderEntry(writer, subEntry, orderTotal);
                }
            }
            else
            {
                writeOrderEntry(writer, entry, orderTotal);
            }
        }
    }

    protected void writeOrderEntry(final Writer writer, final OrderEntryData entry, final String orderTotal) throws IOException
    {
        final StringBuilder csvContent = new StringBuilder();
        csvContent.append(StringEscapeUtils.escapeCsv(entry.getProduct().getCode())).append(DELIMITER)
                .append(StringEscapeUtils.escapeCsv(entry.getQuantity().toString())).append(DELIMITER)
                .append(StringEscapeUtils.escapeCsv(entry.getProduct().getName())).append(DELIMITER)
                .append(StringEscapeUtils.escapeCsv(entry.getBasePrice().getFormattedValue())).append(DELIMITER)
                .append(StringEscapeUtils.escapeCsv(entry.getTotalPrice().getFormattedValue())).append(DELIMITER)
            .append(StringEscapeUtils.escapeCsv("Order total:" +orderTotal)).append(LINE_SEPERATOR);

        writer.write(csvContent.toString());
    }

}
