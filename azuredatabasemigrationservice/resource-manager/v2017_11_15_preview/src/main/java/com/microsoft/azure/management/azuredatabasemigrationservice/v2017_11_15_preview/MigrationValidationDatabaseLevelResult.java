/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.azuredatabasemigrationservice.v2017_11_15_preview;

import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Database level validation results.
 */
public class MigrationValidationDatabaseLevelResult {
    /**
     * Result identifier.
     */
    @JsonProperty(value = "id", access = JsonProperty.Access.WRITE_ONLY)
    private String id;

    /**
     * Migration Identifier.
     */
    @JsonProperty(value = "migrationId", access = JsonProperty.Access.WRITE_ONLY)
    private String migrationId;

    /**
     * Name of the source database.
     */
    @JsonProperty(value = "sourceDatabaseName", access = JsonProperty.Access.WRITE_ONLY)
    private String sourceDatabaseName;

    /**
     * Name of the target database.
     */
    @JsonProperty(value = "targetDatabaseName", access = JsonProperty.Access.WRITE_ONLY)
    private String targetDatabaseName;

    /**
     * Validation start time.
     */
    @JsonProperty(value = "startedOn", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime startedOn;

    /**
     * Validation end time.
     */
    @JsonProperty(value = "endedOn", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime endedOn;

    /**
     * Provides data integrity validation result between the source and target
     * tables that are migrated.
     */
    @JsonProperty(value = "dataIntegrityValidationResult", access = JsonProperty.Access.WRITE_ONLY)
    private DataIntegrityValidationResult dataIntegrityValidationResult;

    /**
     * Provides schema comparison result between source and target database.
     */
    @JsonProperty(value = "schemaValidationResult", access = JsonProperty.Access.WRITE_ONLY)
    private SchemaComparisonValidationResult schemaValidationResult;

    /**
     * Results of some of the query execution result between source and target
     * database.
     */
    @JsonProperty(value = "queryAnalysisValidationResult", access = JsonProperty.Access.WRITE_ONLY)
    private QueryAnalysisValidationResult queryAnalysisValidationResult;

    /**
     * Current status of validation at the database level. Possible values
     * include: 'Default', 'NotStarted', 'Initialized', 'InProgress',
     * 'Completed', 'CompletedWithIssues', 'Failed', 'Stopped'.
     */
    @JsonProperty(value = "status", access = JsonProperty.Access.WRITE_ONLY)
    private ValidationStatus status;

    /**
     * Get result identifier.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Get migration Identifier.
     *
     * @return the migrationId value
     */
    public String migrationId() {
        return this.migrationId;
    }

    /**
     * Get name of the source database.
     *
     * @return the sourceDatabaseName value
     */
    public String sourceDatabaseName() {
        return this.sourceDatabaseName;
    }

    /**
     * Get name of the target database.
     *
     * @return the targetDatabaseName value
     */
    public String targetDatabaseName() {
        return this.targetDatabaseName;
    }

    /**
     * Get validation start time.
     *
     * @return the startedOn value
     */
    public DateTime startedOn() {
        return this.startedOn;
    }

    /**
     * Get validation end time.
     *
     * @return the endedOn value
     */
    public DateTime endedOn() {
        return this.endedOn;
    }

    /**
     * Get provides data integrity validation result between the source and target tables that are migrated.
     *
     * @return the dataIntegrityValidationResult value
     */
    public DataIntegrityValidationResult dataIntegrityValidationResult() {
        return this.dataIntegrityValidationResult;
    }

    /**
     * Get provides schema comparison result between source and target database.
     *
     * @return the schemaValidationResult value
     */
    public SchemaComparisonValidationResult schemaValidationResult() {
        return this.schemaValidationResult;
    }

    /**
     * Get results of some of the query execution result between source and target database.
     *
     * @return the queryAnalysisValidationResult value
     */
    public QueryAnalysisValidationResult queryAnalysisValidationResult() {
        return this.queryAnalysisValidationResult;
    }

    /**
     * Get current status of validation at the database level. Possible values include: 'Default', 'NotStarted', 'Initialized', 'InProgress', 'Completed', 'CompletedWithIssues', 'Failed', 'Stopped'.
     *
     * @return the status value
     */
    public ValidationStatus status() {
        return this.status;
    }

}