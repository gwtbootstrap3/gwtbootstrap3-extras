package org.gwtbootstrap3.extras.fullcalendar.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2014 GwtBootstrap3
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Models the configuration of an <code>Event</code> object
 *
 * @author Jeff Isenhart
 * @see http://arshaw.com/fullcalendar/docs/event_data/
 */
public class EventDataConfig implements IsJavaScriptObject {
    private JavaScriptObject config;

    public EventDataConfig() {
        newInstance();
    }

    private native void newInstance() /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventDataConfig::config = {
            allDayDefault: null,
            startParam: 'start',
            endParam: 'end',
            timezoneParam: 'timezone',
            lazyFetching: true,
            defaultTimedEventDuration: '02:00:00',
            defaultAllDayEventDuration: {days: 1},
            forceEventDuration: false
        };
    }-*/;

    public void addEventDataTransformCallback(final EventDataTransformCallback callback) {
        if (callback != null) {
            addTransformCallback(callback);
        }
    }

    private native void addTransformCallback(EventDataTransformCallback callback) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventDataConfig::config.eventDataTransform = function (eventData) {
            callback.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventDataTransformCallback::eventData(Lcom/google/gwt/core/client/JavaScriptObject;)(eventData);
        }
    }-*/;

    public void addEventLoadingCallback(final EventLoadingCallback callback) {
        if (callback != null) {
            addLoadingCallback(callback);
        }
    }

    private native void addLoadingCallback(EventLoadingCallback callback) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventDataConfig::config.loading = function (loading, view) {
            callback.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventLoadingCallback::isLoading(ZLcom/google/gwt/core/client/JavaScriptObject;)(loading, view);
        }
    }-*/;

    @Override
    public JavaScriptObject toJavaScript() {
        return config;
    }
}
