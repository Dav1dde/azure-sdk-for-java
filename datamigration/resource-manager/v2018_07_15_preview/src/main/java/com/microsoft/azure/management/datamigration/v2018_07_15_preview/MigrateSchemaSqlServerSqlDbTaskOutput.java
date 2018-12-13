/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datamigration.v2018_07_15_preview;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonSubTypes;

/**
 * Output for the task that migrates Schema for SQL Server databases to Azure
 * SQL databases.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "resultType")
@JsonTypeName("MigrateSchemaSqlServerSqlDbTaskOutput")
@JsonSubTypes({
    @JsonSubTypes.Type(name = "MigrationLevelOutput", value = MigrateSchemaSqlServerSqlDbTaskOutputMigrationLevel.class),
    @JsonSubTypes.Type(name = "DatabaseLevelOutput", value = MigrateSchemaSqlServerSqlDbTaskOutputDatabaseLevel.class),
    @JsonSubTypes.Type(name = "SchemaErrorOutput", value = MigrateSchemaSqlServerSqlDbTaskOutputError.class),
    @JsonSubTypes.Type(name = "ErrorOutput", value = MigrateSchemaSqlTaskOutputError.class)
})
public class MigrateSchemaSqlServerSqlDbTaskOutput {
    /**
     * Result identifier.
     */
    @JsonProperty(value = "id", access = JsonProperty.Access.WRITE_ONLY)
    private String id;

    /**
     * Get result identifier.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

}