/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.batch.protocol.models;

import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Azure Batch service log files upload configuration for a compute node.
 */
public class UploadBatchServiceLogsConfiguration {
    /**
     * The URL of the container within Azure Blob Storage to which to upload
     * the Batch Service log file(s).
     * The URL must include a Shared Access Signature (SAS) granting write
     * permissions to the container. The SAS duration must allow enough time
     * for the upload to finish. The start time for SAS is optional and
     * recommended to not be specified.
     */
    @JsonProperty(value = "containerUrl", required = true)
    private String containerUrl;

    /**
     * The start of the time range from which to upload Batch Service log
     * file(s).
     * Any log file containing a log message in the time range will be
     * uploaded. This means that the operation might retrieve more logs than
     * have been requested since the entire log file is always uploaded, but
     * the operation should not retrieve fewer logs than have been requested.
     */
    @JsonProperty(value = "startTime", required = true)
    private DateTime startTime;

    /**
     * The end of the time range from which to upload Batch Service log
     * file(s).
     * Any log file containing a log message in the time range will be
     * uploaded. This means that the operation might retrieve more logs than
     * have been requested since the entire log file is always uploaded, but
     * the operation should not retrieve fewer logs than have been requested.
     * If omitted, the default is to upload all logs available after the
     * startTime.
     */
    @JsonProperty(value = "endTime")
    private DateTime endTime;

    /**
     * Get the containerUrl value.
     *
     * @return the containerUrl value
     */
    public String containerUrl() {
        return this.containerUrl;
    }

    /**
     * Set the containerUrl value.
     *
     * @param containerUrl the containerUrl value to set
     * @return the UploadBatchServiceLogsConfiguration object itself.
     */
    public UploadBatchServiceLogsConfiguration withContainerUrl(String containerUrl) {
        this.containerUrl = containerUrl;
        return this;
    }

    /**
     * Get the startTime value.
     *
     * @return the startTime value
     */
    public DateTime startTime() {
        return this.startTime;
    }

    /**
     * Set the startTime value.
     *
     * @param startTime the startTime value to set
     * @return the UploadBatchServiceLogsConfiguration object itself.
     */
    public UploadBatchServiceLogsConfiguration withStartTime(DateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Get the endTime value.
     *
     * @return the endTime value
     */
    public DateTime endTime() {
        return this.endTime;
    }

    /**
     * Set the endTime value.
     *
     * @param endTime the endTime value to set
     * @return the UploadBatchServiceLogsConfiguration object itself.
     */
    public UploadBatchServiceLogsConfiguration withEndTime(DateTime endTime) {
        this.endTime = endTime;
        return this;
    }

}