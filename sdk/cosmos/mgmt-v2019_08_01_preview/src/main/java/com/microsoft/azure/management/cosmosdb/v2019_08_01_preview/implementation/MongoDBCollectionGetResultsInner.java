/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.cosmosdb.v2019_08_01_preview.implementation;

import com.microsoft.azure.management.cosmosdb.v2019_08_01_preview.MongoDBCollectionGetPropertiesResource;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.management.cosmosdb.v2019_08_01_preview.ARMResourceProperties;

/**
 * An Azure Cosmos DB MongoDB collection.
 */
@JsonFlatten
public class MongoDBCollectionGetResultsInner extends ARMResourceProperties {
    /**
     * The resource property.
     */
    @JsonProperty(value = "properties.resource")
    private MongoDBCollectionGetPropertiesResource resource;

    /**
     * Get the resource value.
     *
     * @return the resource value
     */
    public MongoDBCollectionGetPropertiesResource resource() {
        return this.resource;
    }

    /**
     * Set the resource value.
     *
     * @param resource the resource value to set
     * @return the MongoDBCollectionGetResultsInner object itself.
     */
    public MongoDBCollectionGetResultsInner withResource(MongoDBCollectionGetPropertiesResource resource) {
        this.resource = resource;
        return this;
    }

}
