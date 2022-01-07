/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jan 7, 2022, 4:23:21 PM                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.jalo.process;

import de.hybris.platform.commerceservices.jalo.process.StoreFrontProcess;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.product.Product;
import de.hybris.training.core.constants.TrainingCoreConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.commerceservices.jalo.process.EmailForProductProcess EmailForProductProcess}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedEmailForProductProcess extends StoreFrontProcess
{
	/** Qualifier of the <code>EmailForProductProcess.currentProduct</code> attribute **/
	public static final String CURRENTPRODUCT = "currentProduct";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(StoreFrontProcess.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(CURRENTPRODUCT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmailForProductProcess.currentProduct</code> attribute.
	 * @return the currentProduct - Attribute contains product.
	 */
	public Product getCurrentProduct(final SessionContext ctx)
	{
		return (Product)getProperty( ctx, CURRENTPRODUCT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EmailForProductProcess.currentProduct</code> attribute.
	 * @return the currentProduct - Attribute contains product.
	 */
	public Product getCurrentProduct()
	{
		return getCurrentProduct( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmailForProductProcess.currentProduct</code> attribute. 
	 * @param value the currentProduct - Attribute contains product.
	 */
	public void setCurrentProduct(final SessionContext ctx, final Product value)
	{
		setProperty(ctx, CURRENTPRODUCT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EmailForProductProcess.currentProduct</code> attribute. 
	 * @param value the currentProduct - Attribute contains product.
	 */
	public void setCurrentProduct(final Product value)
	{
		setCurrentProduct( getSession().getSessionContext(), value );
	}
	
}
