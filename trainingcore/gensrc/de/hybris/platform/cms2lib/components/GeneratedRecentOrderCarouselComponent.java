/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jan 31, 2022, 3:06:26 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cms2lib.components;

import de.hybris.platform.cms2.jalo.contents.components.SimpleCMSComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.training.core.constants.TrainingCoreConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.cms2lib.components.RecentOrderCarouselComponent RecentOrderCarouselComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedRecentOrderCarouselComponent extends SimpleCMSComponent
{
	/** Qualifier of the <code>RecentOrderCarouselComponent.limit</code> attribute **/
	public static final String LIMIT = "limit";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(SimpleCMSComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(LIMIT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RecentOrderCarouselComponent.limit</code> attribute.
	 * @return the limit
	 */
	public Integer getLimit(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, LIMIT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RecentOrderCarouselComponent.limit</code> attribute.
	 * @return the limit
	 */
	public Integer getLimit()
	{
		return getLimit( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RecentOrderCarouselComponent.limit</code> attribute. 
	 * @return the limit
	 */
	public int getLimitAsPrimitive(final SessionContext ctx)
	{
		Integer value = getLimit( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>RecentOrderCarouselComponent.limit</code> attribute. 
	 * @return the limit
	 */
	public int getLimitAsPrimitive()
	{
		return getLimitAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RecentOrderCarouselComponent.limit</code> attribute. 
	 * @param value the limit
	 */
	public void setLimit(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, LIMIT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RecentOrderCarouselComponent.limit</code> attribute. 
	 * @param value the limit
	 */
	public void setLimit(final Integer value)
	{
		setLimit( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RecentOrderCarouselComponent.limit</code> attribute. 
	 * @param value the limit
	 */
	public void setLimit(final SessionContext ctx, final int value)
	{
		setLimit( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>RecentOrderCarouselComponent.limit</code> attribute. 
	 * @param value the limit
	 */
	public void setLimit(final int value)
	{
		setLimit( getSession().getSessionContext(), value );
	}
	
}
