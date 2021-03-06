/**
 * Copyright 2016-2020 The Reaktivity Project
 *
 * The Reaktivity Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.reaktivity.nukleus.mqtt.internal;

import java.util.concurrent.TimeUnit;

import org.reaktivity.nukleus.Configuration;

public class MqttConfiguration extends Configuration
{
    public static final String PUBLISH_TIMEOUT_NAME = "nukleus.mqtt.publish.timeout";
    public static final String CLIENT_ID_NAME = "nukleus.mqtt.client.id";

    private static final ConfigurationDef MQTT_CONFIG;
    public static final LongPropertyDef PUBLISH_TIMEOUT;
    public static final PropertyDef<String> CLIENT_ID;

    static
    {
        final ConfigurationDef config = new ConfigurationDef("nukleus.mqtt");
        PUBLISH_TIMEOUT = config.property("publish.timeout", TimeUnit.SECONDS.toSeconds(30));
        CLIENT_ID = config.property("client.id", "client");
        MQTT_CONFIG = config;
    }

    public MqttConfiguration(
        Configuration config)
    {
        super(MQTT_CONFIG, config);
    }

    public long getPublishTimeout()
    {
        return PUBLISH_TIMEOUT.get(this);
    }

    public String getClientId()
    {
        return CLIENT_ID.get(this);
    }
}
