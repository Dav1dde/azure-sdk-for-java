/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.eventgrid.v2018_01_01.implementation;

import com.microsoft.azure.management.eventgrid.v2018_01_01.TopicTypeInfo;
import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.eventgrid.v2018_01_01.TopicTypeProvisioningState;
import com.microsoft.azure.management.eventgrid.v2018_01_01.ResourceRegionType;
import java.util.List;

class TopicTypeInfoImpl extends WrapperImpl<TopicTypeInfoInner> implements TopicTypeInfo {
    private final EventGridManager manager;
    TopicTypeInfoImpl(TopicTypeInfoInner inner, EventGridManager manager) {
        super(inner);
        this.manager = manager;
    }

    @Override
    public EventGridManager manager() {
        return this.manager;
    }

    @Override
    public String description() {
        return this.inner().description();
    }

    @Override
    public String displayName() {
        return this.inner().displayName();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public String provider() {
        return this.inner().provider();
    }

    @Override
    public TopicTypeProvisioningState provisioningState() {
        return this.inner().provisioningState();
    }

    @Override
    public ResourceRegionType resourceRegionType() {
        return this.inner().resourceRegionType();
    }

    @Override
    public List<String> supportedLocations() {
        return this.inner().supportedLocations();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

}
