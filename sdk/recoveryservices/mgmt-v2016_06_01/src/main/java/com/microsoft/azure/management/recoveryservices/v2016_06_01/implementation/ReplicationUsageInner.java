/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.recoveryservices.v2016_06_01.implementation;

import com.microsoft.azure.management.recoveryservices.v2016_06_01.MonitoringSummary;
import com.microsoft.azure.management.recoveryservices.v2016_06_01.JobsSummary;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Replication usages of a vault.
 */
public class ReplicationUsageInner {
    /**
     * Summary of the replication monitoring data for this vault.
     */
    @JsonProperty(value = "monitoringSummary")
    private MonitoringSummary monitoringSummary;

    /**
     * Summary of the replication jobs data for this vault.
     */
    @JsonProperty(value = "jobsSummary")
    private JobsSummary jobsSummary;

    /**
     * Number of replication protected items for this vault.
     */
    @JsonProperty(value = "protectedItemCount")
    private Integer protectedItemCount;

    /**
     * Number of replication recovery plans for this vault.
     */
    @JsonProperty(value = "recoveryPlanCount")
    private Integer recoveryPlanCount;

    /**
     * Number of servers registered to this vault.
     */
    @JsonProperty(value = "registeredServersCount")
    private Integer registeredServersCount;

    /**
     * The authentication type of recovery service providers in the vault.
     */
    @JsonProperty(value = "recoveryServicesProviderAuthType")
    private Integer recoveryServicesProviderAuthType;

    /**
     * Get summary of the replication monitoring data for this vault.
     *
     * @return the monitoringSummary value
     */
    public MonitoringSummary monitoringSummary() {
        return this.monitoringSummary;
    }

    /**
     * Set summary of the replication monitoring data for this vault.
     *
     * @param monitoringSummary the monitoringSummary value to set
     * @return the ReplicationUsageInner object itself.
     */
    public ReplicationUsageInner withMonitoringSummary(MonitoringSummary monitoringSummary) {
        this.monitoringSummary = monitoringSummary;
        return this;
    }

    /**
     * Get summary of the replication jobs data for this vault.
     *
     * @return the jobsSummary value
     */
    public JobsSummary jobsSummary() {
        return this.jobsSummary;
    }

    /**
     * Set summary of the replication jobs data for this vault.
     *
     * @param jobsSummary the jobsSummary value to set
     * @return the ReplicationUsageInner object itself.
     */
    public ReplicationUsageInner withJobsSummary(JobsSummary jobsSummary) {
        this.jobsSummary = jobsSummary;
        return this;
    }

    /**
     * Get number of replication protected items for this vault.
     *
     * @return the protectedItemCount value
     */
    public Integer protectedItemCount() {
        return this.protectedItemCount;
    }

    /**
     * Set number of replication protected items for this vault.
     *
     * @param protectedItemCount the protectedItemCount value to set
     * @return the ReplicationUsageInner object itself.
     */
    public ReplicationUsageInner withProtectedItemCount(Integer protectedItemCount) {
        this.protectedItemCount = protectedItemCount;
        return this;
    }

    /**
     * Get number of replication recovery plans for this vault.
     *
     * @return the recoveryPlanCount value
     */
    public Integer recoveryPlanCount() {
        return this.recoveryPlanCount;
    }

    /**
     * Set number of replication recovery plans for this vault.
     *
     * @param recoveryPlanCount the recoveryPlanCount value to set
     * @return the ReplicationUsageInner object itself.
     */
    public ReplicationUsageInner withRecoveryPlanCount(Integer recoveryPlanCount) {
        this.recoveryPlanCount = recoveryPlanCount;
        return this;
    }

    /**
     * Get number of servers registered to this vault.
     *
     * @return the registeredServersCount value
     */
    public Integer registeredServersCount() {
        return this.registeredServersCount;
    }

    /**
     * Set number of servers registered to this vault.
     *
     * @param registeredServersCount the registeredServersCount value to set
     * @return the ReplicationUsageInner object itself.
     */
    public ReplicationUsageInner withRegisteredServersCount(Integer registeredServersCount) {
        this.registeredServersCount = registeredServersCount;
        return this;
    }

    /**
     * Get the authentication type of recovery service providers in the vault.
     *
     * @return the recoveryServicesProviderAuthType value
     */
    public Integer recoveryServicesProviderAuthType() {
        return this.recoveryServicesProviderAuthType;
    }

    /**
     * Set the authentication type of recovery service providers in the vault.
     *
     * @param recoveryServicesProviderAuthType the recoveryServicesProviderAuthType value to set
     * @return the ReplicationUsageInner object itself.
     */
    public ReplicationUsageInner withRecoveryServicesProviderAuthType(Integer recoveryServicesProviderAuthType) {
        this.recoveryServicesProviderAuthType = recoveryServicesProviderAuthType;
        return this;
    }

}
