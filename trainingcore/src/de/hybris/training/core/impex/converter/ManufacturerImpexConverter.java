package de.hybris.training.core.impex.converter;

import de.hybris.platform.acceleratorservices.dataimport.batch.converter.impl.DefaultImpexConverter;
import de.hybris.platform.servicelayer.exceptions.SystemException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.Assert;

import java.util.Calendar;
import java.util.Map;

public class ManufacturerImpexConverter extends DefaultImpexConverter {
    private static final char PLUS_CHAR = '+';
    private String impexRow;

    protected void processValues(final Map<Integer, String> row, final StringBuilder builder, final int idx, final int endIdx)
    {
        final boolean mandatory = impexRow.charAt(idx + 1) == PLUS_CHAR;
        Integer mapIdx = null;
        try
        {
            mapIdx = Integer.valueOf(impexRow.substring(mandatory ? idx + 2 : idx + 1, endIdx));
        }
        catch (final NumberFormatException e)
        {
            throw new SystemException("Invalid row syntax [invalid column number]: " + impexRow, e);
        }
        final String colValue = row.get(mapIdx);
        if(mapIdx.equals(3)){
            String isOld="false";
            int establishmentYear= Integer.parseInt(row.get(mapIdx-1));
            int CurrentYear= Calendar.getInstance().get(Calendar.YEAR);
            if(CurrentYear-establishmentYear>=10){
                isOld="true";
            }
            row.put(3,isOld);
        }
        if (mandatory && StringUtils.isBlank(colValue))
        {
            throw new IllegalArgumentException("Missing value for " + mapIdx);
        }
        if (colValue != null)
        {
            builder.append(colValue);
        }
    }
    /**
     * @param impexRow
     *           the impexRow to set
     */
    @Required
    public void setImpexRow(final String impexRow)
    {
        Assert.hasText(impexRow);
        this.impexRow = impexRow;
        super.setImpexRow(impexRow);
    }
}
