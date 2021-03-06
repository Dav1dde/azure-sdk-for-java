/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.eventgrid.v2020_04_01_preview;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Properties of the PartnerNamespace update.
 */
public class PartnerNamespaceUpdateParameters {
    /**
     * Tags of the partner namespace.
     */
    @JsonProperty(value = "tags")
    private Map<String, String> tags;

    /**
     * Get tags of the partner namespace.
     *
     * @return the tags value
     */
    public Map<String, String> tags() {
        return this.tags;
    }

    /**
     * Set tags of the partner namespace.
     *
     * @param tags the tags value to set
     * @return the PartnerNamespaceUpdateParameters object itself.
     */
    public PartnerNamespaceUpdateParameters withTags(Map<String, String> tags) {
        this.tags = tags;
        return this;
    }

}
