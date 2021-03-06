/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.eventgrid.v2020_04_01_preview;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Information about the delivery for an event subscription with resource
 * identity.
 */
public class DeliveryWithResourceIdentity {
    /**
     * The identity to use when delivering events.
     */
    @JsonProperty(value = "identity")
    private EventSubscriptionIdentity identity;

    /**
     * Information about the destination where events have to be delivered for
     * the event subscription.
     * Uses Azure Event Grid's identity to acquire the authentication tokens
     * being used during delivery / dead-lettering.
     */
    @JsonProperty(value = "destination")
    private EventSubscriptionDestination destination;

    /**
     * Get the identity to use when delivering events.
     *
     * @return the identity value
     */
    public EventSubscriptionIdentity identity() {
        return this.identity;
    }

    /**
     * Set the identity to use when delivering events.
     *
     * @param identity the identity value to set
     * @return the DeliveryWithResourceIdentity object itself.
     */
    public DeliveryWithResourceIdentity withIdentity(EventSubscriptionIdentity identity) {
        this.identity = identity;
        return this;
    }

    /**
     * Get information about the destination where events have to be delivered for the event subscription.
     Uses Azure Event Grid's identity to acquire the authentication tokens being used during delivery / dead-lettering.
     *
     * @return the destination value
     */
    public EventSubscriptionDestination destination() {
        return this.destination;
    }

    /**
     * Set information about the destination where events have to be delivered for the event subscription.
     Uses Azure Event Grid's identity to acquire the authentication tokens being used during delivery / dead-lettering.
     *
     * @param destination the destination value to set
     * @return the DeliveryWithResourceIdentity object itself.
     */
    public DeliveryWithResourceIdentity withDestination(EventSubscriptionDestination destination) {
        this.destination = destination;
        return this;
    }

}
