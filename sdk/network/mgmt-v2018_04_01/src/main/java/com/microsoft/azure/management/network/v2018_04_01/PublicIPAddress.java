/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2018_04_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.Resource;
import com.microsoft.azure.arm.resources.models.GroupableResourceCore;
import com.microsoft.azure.arm.resources.models.HasResourceGroup;
import com.microsoft.azure.arm.model.Refreshable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.network.v2018_04_01.implementation.NetworkManager;
import java.util.List;
import com.microsoft.azure.management.network.v2018_04_01.implementation.PublicIPAddressInner;

/**
 * Type representing PublicIPAddress.
 */
public interface PublicIPAddress extends HasInner<PublicIPAddressInner>, Resource, GroupableResourceCore<NetworkManager, PublicIPAddressInner>, HasResourceGroup, Refreshable<PublicIPAddress>, Updatable<PublicIPAddress.Update>, HasManager<NetworkManager> {
    /**
     * @return the dnsSettings value.
     */
    PublicIPAddressDnsSettings dnsSettings();

    /**
     * @return the etag value.
     */
    String etag();

    /**
     * @return the idleTimeoutInMinutes value.
     */
    Integer idleTimeoutInMinutes();

    /**
     * @return the ipAddress value.
     */
    String ipAddress();

    /**
     * @return the ipConfiguration value.
     */
    IPConfiguration ipConfiguration();

    /**
     * @return the ipTags value.
     */
    List<IpTag> ipTags();

    /**
     * @return the provisioningState value.
     */
    String provisioningState();

    /**
     * @return the publicIPAddressVersion value.
     */
    IPVersion publicIPAddressVersion();

    /**
     * @return the publicIPAllocationMethod value.
     */
    IPAllocationMethod publicIPAllocationMethod();

    /**
     * @return the resourceGuid value.
     */
    String resourceGuid();

    /**
     * @return the sku value.
     */
    PublicIPAddressSku sku();

    /**
     * @return the zones value.
     */
    List<String> zones();

    /**
     * The entirety of the PublicIPAddress definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithGroup, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of PublicIPAddress definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a PublicIPAddress definition.
         */
        interface Blank extends GroupableResourceCore.DefinitionWithRegion<WithGroup> {
        }

        /**
         * The stage of the PublicIPAddress definition allowing to specify the resource group.
         */
        interface WithGroup extends GroupableResourceCore.DefinitionStages.WithGroup<WithCreate> {
        }

        /**
         * The stage of the publicipaddress definition allowing to specify DnsSettings.
         */
        interface WithDnsSettings {
            /**
             * Specifies dnsSettings.
             * @param dnsSettings The FQDN of the DNS record associated with the public IP address
             * @return the next definition stage
             */
            WithCreate withDnsSettings(PublicIPAddressDnsSettings dnsSettings);
        }

        /**
         * The stage of the publicipaddress definition allowing to specify Etag.
         */
        interface WithEtag {
            /**
             * Specifies etag.
             * @param etag A unique read-only string that changes whenever the resource is updated
             * @return the next definition stage
             */
            WithCreate withEtag(String etag);
        }

        /**
         * The stage of the publicipaddress definition allowing to specify IdleTimeoutInMinutes.
         */
        interface WithIdleTimeoutInMinutes {
            /**
             * Specifies idleTimeoutInMinutes.
             * @param idleTimeoutInMinutes The idle timeout of the public IP address
             * @return the next definition stage
             */
            WithCreate withIdleTimeoutInMinutes(Integer idleTimeoutInMinutes);
        }

        /**
         * The stage of the publicipaddress definition allowing to specify IpAddress.
         */
        interface WithIpAddress {
            /**
             * Specifies ipAddress.
             * @param ipAddress The IP address associated with the public IP address resource
             * @return the next definition stage
             */
            WithCreate withIpAddress(String ipAddress);
        }

        /**
         * The stage of the publicipaddress definition allowing to specify IpTags.
         */
        interface WithIpTags {
            /**
             * Specifies ipTags.
             * @param ipTags The list of tags associated with the public IP address
             * @return the next definition stage
             */
            WithCreate withIpTags(List<IpTag> ipTags);
        }

        /**
         * The stage of the publicipaddress definition allowing to specify ProvisioningState.
         */
        interface WithProvisioningState {
            /**
             * Specifies provisioningState.
             * @param provisioningState The provisioning state of the PublicIP resource. Possible values are: 'Updating', 'Deleting', and 'Failed'
             * @return the next definition stage
             */
            WithCreate withProvisioningState(String provisioningState);
        }

        /**
         * The stage of the publicipaddress definition allowing to specify PublicIPAddressVersion.
         */
        interface WithPublicIPAddressVersion {
            /**
             * Specifies publicIPAddressVersion.
             * @param publicIPAddressVersion The public IP address version. Possible values are: 'IPv4' and 'IPv6'. Possible values include: 'IPv4', 'IPv6'
             * @return the next definition stage
             */
            WithCreate withPublicIPAddressVersion(IPVersion publicIPAddressVersion);
        }

        /**
         * The stage of the publicipaddress definition allowing to specify PublicIPAllocationMethod.
         */
        interface WithPublicIPAllocationMethod {
            /**
             * Specifies publicIPAllocationMethod.
             * @param publicIPAllocationMethod The public IP allocation method. Possible values are: 'Static' and 'Dynamic'. Possible values include: 'Static', 'Dynamic'
             * @return the next definition stage
             */
            WithCreate withPublicIPAllocationMethod(IPAllocationMethod publicIPAllocationMethod);
        }

        /**
         * The stage of the publicipaddress definition allowing to specify ResourceGuid.
         */
        interface WithResourceGuid {
            /**
             * Specifies resourceGuid.
             * @param resourceGuid The resource GUID property of the public IP resource
             * @return the next definition stage
             */
            WithCreate withResourceGuid(String resourceGuid);
        }

        /**
         * The stage of the publicipaddress definition allowing to specify Sku.
         */
        interface WithSku {
            /**
             * Specifies sku.
             * @param sku The public IP address SKU
             * @return the next definition stage
             */
            WithCreate withSku(PublicIPAddressSku sku);
        }

        /**
         * The stage of the publicipaddress definition allowing to specify Zones.
         */
        interface WithZones {
            /**
             * Specifies zones.
             * @param zones A list of availability zones denoting the IP allocated for the resource needs to come from
             * @return the next definition stage
             */
            WithCreate withZones(List<String> zones);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<PublicIPAddress>, Resource.DefinitionWithTags<WithCreate>, DefinitionStages.WithDnsSettings, DefinitionStages.WithEtag, DefinitionStages.WithIdleTimeoutInMinutes, DefinitionStages.WithIpAddress, DefinitionStages.WithIpTags, DefinitionStages.WithProvisioningState, DefinitionStages.WithPublicIPAddressVersion, DefinitionStages.WithPublicIPAllocationMethod, DefinitionStages.WithResourceGuid, DefinitionStages.WithSku, DefinitionStages.WithZones {
        }
    }
    /**
     * The template for a PublicIPAddress update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<PublicIPAddress>, Resource.UpdateWithTags<Update>, UpdateStages.WithDnsSettings, UpdateStages.WithEtag, UpdateStages.WithIdleTimeoutInMinutes, UpdateStages.WithIpAddress, UpdateStages.WithIpTags, UpdateStages.WithProvisioningState, UpdateStages.WithPublicIPAddressVersion, UpdateStages.WithPublicIPAllocationMethod, UpdateStages.WithResourceGuid, UpdateStages.WithSku, UpdateStages.WithZones {
    }

    /**
     * Grouping of PublicIPAddress update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the publicipaddress update allowing to specify DnsSettings.
         */
        interface WithDnsSettings {
            /**
             * Specifies dnsSettings.
             * @param dnsSettings The FQDN of the DNS record associated with the public IP address
             * @return the next update stage
             */
            Update withDnsSettings(PublicIPAddressDnsSettings dnsSettings);
        }

        /**
         * The stage of the publicipaddress update allowing to specify Etag.
         */
        interface WithEtag {
            /**
             * Specifies etag.
             * @param etag A unique read-only string that changes whenever the resource is updated
             * @return the next update stage
             */
            Update withEtag(String etag);
        }

        /**
         * The stage of the publicipaddress update allowing to specify IdleTimeoutInMinutes.
         */
        interface WithIdleTimeoutInMinutes {
            /**
             * Specifies idleTimeoutInMinutes.
             * @param idleTimeoutInMinutes The idle timeout of the public IP address
             * @return the next update stage
             */
            Update withIdleTimeoutInMinutes(Integer idleTimeoutInMinutes);
        }

        /**
         * The stage of the publicipaddress update allowing to specify IpAddress.
         */
        interface WithIpAddress {
            /**
             * Specifies ipAddress.
             * @param ipAddress The IP address associated with the public IP address resource
             * @return the next update stage
             */
            Update withIpAddress(String ipAddress);
        }

        /**
         * The stage of the publicipaddress update allowing to specify IpTags.
         */
        interface WithIpTags {
            /**
             * Specifies ipTags.
             * @param ipTags The list of tags associated with the public IP address
             * @return the next update stage
             */
            Update withIpTags(List<IpTag> ipTags);
        }

        /**
         * The stage of the publicipaddress update allowing to specify ProvisioningState.
         */
        interface WithProvisioningState {
            /**
             * Specifies provisioningState.
             * @param provisioningState The provisioning state of the PublicIP resource. Possible values are: 'Updating', 'Deleting', and 'Failed'
             * @return the next update stage
             */
            Update withProvisioningState(String provisioningState);
        }

        /**
         * The stage of the publicipaddress update allowing to specify PublicIPAddressVersion.
         */
        interface WithPublicIPAddressVersion {
            /**
             * Specifies publicIPAddressVersion.
             * @param publicIPAddressVersion The public IP address version. Possible values are: 'IPv4' and 'IPv6'. Possible values include: 'IPv4', 'IPv6'
             * @return the next update stage
             */
            Update withPublicIPAddressVersion(IPVersion publicIPAddressVersion);
        }

        /**
         * The stage of the publicipaddress update allowing to specify PublicIPAllocationMethod.
         */
        interface WithPublicIPAllocationMethod {
            /**
             * Specifies publicIPAllocationMethod.
             * @param publicIPAllocationMethod The public IP allocation method. Possible values are: 'Static' and 'Dynamic'. Possible values include: 'Static', 'Dynamic'
             * @return the next update stage
             */
            Update withPublicIPAllocationMethod(IPAllocationMethod publicIPAllocationMethod);
        }

        /**
         * The stage of the publicipaddress update allowing to specify ResourceGuid.
         */
        interface WithResourceGuid {
            /**
             * Specifies resourceGuid.
             * @param resourceGuid The resource GUID property of the public IP resource
             * @return the next update stage
             */
            Update withResourceGuid(String resourceGuid);
        }

        /**
         * The stage of the publicipaddress update allowing to specify Sku.
         */
        interface WithSku {
            /**
             * Specifies sku.
             * @param sku The public IP address SKU
             * @return the next update stage
             */
            Update withSku(PublicIPAddressSku sku);
        }

        /**
         * The stage of the publicipaddress update allowing to specify Zones.
         */
        interface WithZones {
            /**
             * Specifies zones.
             * @param zones A list of availability zones denoting the IP allocated for the resource needs to come from
             * @return the next update stage
             */
            Update withZones(List<String> zones);
        }

    }
}
