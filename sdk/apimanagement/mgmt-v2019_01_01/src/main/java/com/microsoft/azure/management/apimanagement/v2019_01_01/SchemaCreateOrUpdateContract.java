/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.apimanagement.v2019_01_01;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.ProxyResource;

/**
 * Schema Contract details.
 */
@JsonFlatten
public class SchemaCreateOrUpdateContract extends ProxyResource {
    /**
     * Must be a valid a media type used in a Content-Type header as defined in
     * the RFC 2616. Media type of the schema document (e.g. application/json,
     * application/xml). &lt;/br&gt; - `Swagger` Schema use
     * `application/vnd.ms-azure-apim.swagger.definitions+json` &lt;/br&gt; -
     * `WSDL` Schema use `application/vnd.ms-azure-apim.xsd+xml` &lt;/br&gt; -
     * `OpenApi` Schema use `application/vnd.oai.openapi.components+json`
     * &lt;/br&gt; - `WADL Schema` use
     * `application/vnd.ms-azure-apim.wadl.grammars+xml`.
     */
    @JsonProperty(value = "properties.contentType", required = true)
    private String contentType;

    /**
     * Json escaped string defining the document representing the Schema.
     */
    @JsonProperty(value = "properties.document.value")
    private String value;

    /**
     * Get must be a valid a media type used in a Content-Type header as defined in the RFC 2616. Media type of the schema document (e.g. application/json, application/xml). &lt;/br&gt; - `Swagger` Schema use `application/vnd.ms-azure-apim.swagger.definitions+json` &lt;/br&gt; - `WSDL` Schema use `application/vnd.ms-azure-apim.xsd+xml` &lt;/br&gt; - `OpenApi` Schema use `application/vnd.oai.openapi.components+json` &lt;/br&gt; - `WADL Schema` use `application/vnd.ms-azure-apim.wadl.grammars+xml`.
     *
     * @return the contentType value
     */
    public String contentType() {
        return this.contentType;
    }

    /**
     * Set must be a valid a media type used in a Content-Type header as defined in the RFC 2616. Media type of the schema document (e.g. application/json, application/xml). &lt;/br&gt; - `Swagger` Schema use `application/vnd.ms-azure-apim.swagger.definitions+json` &lt;/br&gt; - `WSDL` Schema use `application/vnd.ms-azure-apim.xsd+xml` &lt;/br&gt; - `OpenApi` Schema use `application/vnd.oai.openapi.components+json` &lt;/br&gt; - `WADL Schema` use `application/vnd.ms-azure-apim.wadl.grammars+xml`.
     *
     * @param contentType the contentType value to set
     * @return the SchemaCreateOrUpdateContract object itself.
     */
    public SchemaCreateOrUpdateContract withContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    /**
     * Get json escaped string defining the document representing the Schema.
     *
     * @return the value value
     */
    public String value() {
        return this.value;
    }

    /**
     * Set json escaped string defining the document representing the Schema.
     *
     * @param value the value value to set
     * @return the SchemaCreateOrUpdateContract object itself.
     */
    public SchemaCreateOrUpdateContract withValue(String value) {
        this.value = value;
        return this;
    }

}
