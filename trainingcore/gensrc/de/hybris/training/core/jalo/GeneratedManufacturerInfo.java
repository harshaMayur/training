/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jan 3, 2022, 11:48:35 AM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.training.core.jalo;

import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.util.BidirectionalOneToManyHandler;
import de.hybris.training.core.constants.TrainingCoreConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem ManufacturerInfo}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedManufacturerInfo extends GenericItem
{
	/** Qualifier of the <code>ManufacturerInfo.id</code> attribute **/
	public static final String ID = "id";
	/** Qualifier of the <code>ManufacturerInfo.name</code> attribute **/
	public static final String NAME = "name";
	/** Qualifier of the <code>ManufacturerInfo.establishmentYear</code> attribute **/
	public static final String ESTABLISHMENTYEAR = "establishmentYear";
	/** Qualifier of the <code>ManufacturerInfo.product</code> attribute **/
	public static final String PRODUCT = "product";
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n PRODUCT's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedManufacturerInfo> PRODUCTHANDLER = new BidirectionalOneToManyHandler<GeneratedManufacturerInfo>(
	TrainingCoreConstants.TC.MANUFACTURERINFO,
	false,
	"product",
	null,
	false,
	true,
	CollectionType.COLLECTION
	);
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(ID, AttributeMode.INITIAL);
		tmp.put(NAME, AttributeMode.INITIAL);
		tmp.put(ESTABLISHMENTYEAR, AttributeMode.INITIAL);
		tmp.put(PRODUCT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	@Override
	protected Item createItem(final SessionContext ctx, final ComposedType type, final ItemAttributeMap allAttributes) throws JaloBusinessException
	{
		PRODUCTHANDLER.newInstance(ctx, allAttributes);
		return super.createItem( ctx, type, allAttributes );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerInfo.establishmentYear</code> attribute.
	 * @return the establishmentYear
	 */
	public Integer getEstablishmentYear(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, ESTABLISHMENTYEAR);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerInfo.establishmentYear</code> attribute.
	 * @return the establishmentYear
	 */
	public Integer getEstablishmentYear()
	{
		return getEstablishmentYear( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerInfo.establishmentYear</code> attribute. 
	 * @return the establishmentYear
	 */
	public int getEstablishmentYearAsPrimitive(final SessionContext ctx)
	{
		Integer value = getEstablishmentYear( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerInfo.establishmentYear</code> attribute. 
	 * @return the establishmentYear
	 */
	public int getEstablishmentYearAsPrimitive()
	{
		return getEstablishmentYearAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerInfo.establishmentYear</code> attribute. 
	 * @param value the establishmentYear
	 */
	public void setEstablishmentYear(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, ESTABLISHMENTYEAR,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerInfo.establishmentYear</code> attribute. 
	 * @param value the establishmentYear
	 */
	public void setEstablishmentYear(final Integer value)
	{
		setEstablishmentYear( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerInfo.establishmentYear</code> attribute. 
	 * @param value the establishmentYear
	 */
	public void setEstablishmentYear(final SessionContext ctx, final int value)
	{
		setEstablishmentYear( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerInfo.establishmentYear</code> attribute. 
	 * @param value the establishmentYear
	 */
	public void setEstablishmentYear(final int value)
	{
		setEstablishmentYear( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerInfo.id</code> attribute.
	 * @return the id - Unique Id for Manufacturer
	 */
	public String getId(final SessionContext ctx)
	{
		return (String)getProperty( ctx, ID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerInfo.id</code> attribute.
	 * @return the id - Unique Id for Manufacturer
	 */
	public String getId()
	{
		return getId( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerInfo.id</code> attribute. 
	 * @param value the id - Unique Id for Manufacturer
	 */
	public void setId(final SessionContext ctx, final String value)
	{
		setProperty(ctx, ID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerInfo.id</code> attribute. 
	 * @param value the id - Unique Id for Manufacturer
	 */
	public void setId(final String value)
	{
		setId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerInfo.name</code> attribute.
	 * @return the name - Manufacturer name
	 */
	public String getName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerInfo.name</code> attribute.
	 * @return the name - Manufacturer name
	 */
	public String getName()
	{
		return getName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerInfo.name</code> attribute. 
	 * @param value the name - Manufacturer name
	 */
	public void setName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, NAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerInfo.name</code> attribute. 
	 * @param value the name - Manufacturer name
	 */
	public void setName(final String value)
	{
		setName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerInfo.product</code> attribute.
	 * @return the product
	 */
	public Product getProduct(final SessionContext ctx)
	{
		return (Product)getProperty( ctx, PRODUCT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerInfo.product</code> attribute.
	 * @return the product
	 */
	public Product getProduct()
	{
		return getProduct( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerInfo.product</code> attribute. 
	 * @param value the product
	 */
	public void setProduct(final SessionContext ctx, final Product value)
	{
		PRODUCTHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerInfo.product</code> attribute. 
	 * @param value the product
	 */
	public void setProduct(final Product value)
	{
		setProduct( getSession().getSessionContext(), value );
	}
	
}
