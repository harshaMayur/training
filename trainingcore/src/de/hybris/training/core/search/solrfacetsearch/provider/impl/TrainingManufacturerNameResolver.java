package de.hybris.training.core.search.solrfacetsearch.provider.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.indexer.IndexerBatchContext;
import de.hybris.platform.solrfacetsearch.indexer.spi.InputDocument;
import de.hybris.platform.solrfacetsearch.provider.impl.AbstractValueResolver;
import de.hybris.training.core.model.ManufacturerInfoModel;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;

public class TrainingManufacturerNameResolver extends AbstractValueResolver<ProductModel,Object,Object> {
    @Override
    protected void addFieldValues(InputDocument inputDocument, IndexerBatchContext indexerBatchContext, IndexedProperty indexedProperty, ProductModel productModel, ValueResolverContext<Object, Object> valueResolverContext) throws FieldValueProviderException {
        final Collection<ManufacturerInfoModel> manufacturerInfoList = productModel.getManufacturer();
        if (!CollectionUtils.isEmpty(manufacturerInfoList)) {
            for (final ManufacturerInfoModel manufacturerInfoModel : manufacturerInfoList) {
                final String manufacturerInfoName = manufacturerInfoModel.getName();
                if (manufacturerInfoName != null) {
                    inputDocument.addField(indexedProperty, manufacturerInfoName, valueResolverContext.getFieldQualifier());
                }
            }

        }

    }
}
