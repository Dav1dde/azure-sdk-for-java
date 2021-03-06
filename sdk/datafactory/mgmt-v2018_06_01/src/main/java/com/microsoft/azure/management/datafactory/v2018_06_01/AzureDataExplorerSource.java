/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datafactory.v2018_06_01;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * A copy activity Azure Data Explorer (Kusto) source.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", defaultImpl = AzureDataExplorerSource.class)
@JsonTypeName("AzureDataExplorerSource")
public class AzureDataExplorerSource extends CopySource {
    /**
     * Database query. Should be a Kusto Query Language (KQL) query. Type:
     * string (or Expression with resultType string).
     */
    @JsonProperty(value = "query", required = true)
    private Object query;

    /**
     * The name of the Boolean option that controls whether truncation is
     * applied to result-sets that go beyond a certain row-count limit.
     */
    @JsonProperty(value = "noTruncation")
    private Object noTruncation;

    /**
     * Query timeout. Type: string (or Expression with resultType string),
     * pattern: ((\d+)\.)?(\d\d):(60|([0-5][0-9])):(60|([0-5][0-9]))..
     */
    @JsonProperty(value = "queryTimeout")
    private Object queryTimeout;

    /**
     * Specifies the additional columns to be added to source data. Type: array
     * of objects (or Expression with resultType array of objects).
     */
    @JsonProperty(value = "additionalColumns")
    private List<AdditionalColumns> additionalColumns;

    /**
     * Get database query. Should be a Kusto Query Language (KQL) query. Type: string (or Expression with resultType string).
     *
     * @return the query value
     */
    public Object query() {
        return this.query;
    }

    /**
     * Set database query. Should be a Kusto Query Language (KQL) query. Type: string (or Expression with resultType string).
     *
     * @param query the query value to set
     * @return the AzureDataExplorerSource object itself.
     */
    public AzureDataExplorerSource withQuery(Object query) {
        this.query = query;
        return this;
    }

    /**
     * Get the name of the Boolean option that controls whether truncation is applied to result-sets that go beyond a certain row-count limit.
     *
     * @return the noTruncation value
     */
    public Object noTruncation() {
        return this.noTruncation;
    }

    /**
     * Set the name of the Boolean option that controls whether truncation is applied to result-sets that go beyond a certain row-count limit.
     *
     * @param noTruncation the noTruncation value to set
     * @return the AzureDataExplorerSource object itself.
     */
    public AzureDataExplorerSource withNoTruncation(Object noTruncation) {
        this.noTruncation = noTruncation;
        return this;
    }

    /**
     * Get query timeout. Type: string (or Expression with resultType string), pattern: ((\d+)\.)?(\d\d):(60|([0-5][0-9])):(60|([0-5][0-9]))..
     *
     * @return the queryTimeout value
     */
    public Object queryTimeout() {
        return this.queryTimeout;
    }

    /**
     * Set query timeout. Type: string (or Expression with resultType string), pattern: ((\d+)\.)?(\d\d):(60|([0-5][0-9])):(60|([0-5][0-9]))..
     *
     * @param queryTimeout the queryTimeout value to set
     * @return the AzureDataExplorerSource object itself.
     */
    public AzureDataExplorerSource withQueryTimeout(Object queryTimeout) {
        this.queryTimeout = queryTimeout;
        return this;
    }

    /**
     * Get specifies the additional columns to be added to source data. Type: array of objects (or Expression with resultType array of objects).
     *
     * @return the additionalColumns value
     */
    public List<AdditionalColumns> additionalColumns() {
        return this.additionalColumns;
    }

    /**
     * Set specifies the additional columns to be added to source data. Type: array of objects (or Expression with resultType array of objects).
     *
     * @param additionalColumns the additionalColumns value to set
     * @return the AzureDataExplorerSource object itself.
     */
    public AzureDataExplorerSource withAdditionalColumns(List<AdditionalColumns> additionalColumns) {
        this.additionalColumns = additionalColumns;
        return this;
    }

}
