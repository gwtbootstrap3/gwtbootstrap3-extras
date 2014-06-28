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

public class EventRenderConfig implements IsJavaScriptObject {

    private JavaScriptObject config;

    public EventRenderConfig(final EventRenderHandler callback) {
        newInstance(callback);
    }

    private native void newInstance(EventRenderHandler callback) /*-{
        var theInstance = this;
        var theCallback = callback;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventRenderConfig::config = {};
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventRenderConfig::config.eventRender = function (calEvent, element, view) {
            theCallback.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventRenderHandler::render(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/Element;)(calEvent, element[0]);
        }
    }-*/;

    @Override
    public JavaScriptObject toJavaScript() {
        return config;
    }
}
