/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.recoveryservices.backup.v2016_12_01;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonSubTypes;

/**
 * AzureWorkload SQL -specific restore. Specifically for full/diff restore.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType")
@JsonTypeName("AzureWorkloadSQLRestoreRequest")
@JsonSubTypes({
    @JsonSubTypes.Type(name = "AzureWorkloadSQLPointInTimeRestoreRequest", value = AzureWorkloadSQLPointInTimeRestoreRequest.class)
})
public class AzureWorkloadSQLRestoreRequest extends AzureWorkloadRestoreRequest {
    /**
     * Default option set to true. If this is set to false, alternate data
     * directory must be provided.
     */
    @JsonProperty(value = "shouldUseAlternateTargetLocation")
    private Boolean shouldUseAlternateTargetLocation;

    /**
     * SQL specific property where user can chose to set no-recovery when
     * restore operation is tried.
     */
    @JsonProperty(value = "isNonRecoverable")
    private Boolean isNonRecoverable;

    /**
     * Details of target database.
     */
    @JsonProperty(value = "targetInfo")
    private TargetRestoreInfo targetInfo;

    /**
     * Data directory details.
     */
    @JsonProperty(value = "alternateDirectoryPaths")
    private List<SQLDataDirectoryMapping> alternateDirectoryPaths;

    /**
     * Get default option set to true. If this is set to false, alternate data directory must be provided.
     *
     * @return the shouldUseAlternateTargetLocation value
     */
    public Boolean shouldUseAlternateTargetLocation() {
        return this.shouldUseAlternateTargetLocation;
    }

    /**
     * Set default option set to true. If this is set to false, alternate data directory must be provided.
     *
     * @param shouldUseAlternateTargetLocation the shouldUseAlternateTargetLocation value to set
     * @return the AzureWorkloadSQLRestoreRequest object itself.
     */
    public AzureWorkloadSQLRestoreRequest withShouldUseAlternateTargetLocation(Boolean shouldUseAlternateTargetLocation) {
        this.shouldUseAlternateTargetLocation = shouldUseAlternateTargetLocation;
        return this;
    }

    /**
     * Get sQL specific property where user can chose to set no-recovery when restore operation is tried.
     *
     * @return the isNonRecoverable value
     */
    public Boolean isNonRecoverable() {
        return this.isNonRecoverable;
    }

    /**
     * Set sQL specific property where user can chose to set no-recovery when restore operation is tried.
     *
     * @param isNonRecoverable the isNonRecoverable value to set
     * @return the AzureWorkloadSQLRestoreRequest object itself.
     */
    public AzureWorkloadSQLRestoreRequest withIsNonRecoverable(Boolean isNonRecoverable) {
        this.isNonRecoverable = isNonRecoverable;
        return this;
    }

    /**
     * Get details of target database.
     *
     * @return the targetInfo value
     */
    public TargetRestoreInfo targetInfo() {
        return this.targetInfo;
    }

    /**
     * Set details of target database.
     *
     * @param targetInfo the targetInfo value to set
     * @return the AzureWorkloadSQLRestoreRequest object itself.
     */
    public AzureWorkloadSQLRestoreRequest withTargetInfo(TargetRestoreInfo targetInfo) {
        this.targetInfo = targetInfo;
        return this;
    }

    /**
     * Get data directory details.
     *
     * @return the alternateDirectoryPaths value
     */
    public List<SQLDataDirectoryMapping> alternateDirectoryPaths() {
        return this.alternateDirectoryPaths;
    }

    /**
     * Set data directory details.
     *
     * @param alternateDirectoryPaths the alternateDirectoryPaths value to set
     * @return the AzureWorkloadSQLRestoreRequest object itself.
     */
    public AzureWorkloadSQLRestoreRequest withAlternateDirectoryPaths(List<SQLDataDirectoryMapping> alternateDirectoryPaths) {
        this.alternateDirectoryPaths = alternateDirectoryPaths;
        return this;
    }

}
