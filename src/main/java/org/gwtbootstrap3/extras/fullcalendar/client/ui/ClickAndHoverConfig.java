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
 * Wraps click and hover events inside a <code>JavaScriptObject</code>
 *
 * @author Jeff Isenhart
 * @see http://arshaw.com/fullcalendar/docs/mouse/
 */
public class ClickAndHoverConfig implements IsJavaScriptObject {
    private JavaScriptObject script;

    public ClickAndHoverConfig(final ClickAndHoverEventCallback handler) {
        if (handler != null) {
            newInstance(handler);
        }
    }

    private native void newInstance(ClickAndHoverEventCallback handler) /*-{
        var theInstance = this;
        var mouseHandler = handler;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ClickAndHoverConfig::script = {};
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ClickAndHoverConfig::script.eventClick = function (calEvent, jsEvent, view) {
            mouseHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ClickAndHoverEventCallback::eventClick(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;Lcom/google/gwt/core/client/JavaScriptObject;)(calEvent, jsEvent, view);
        };
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ClickAndHoverConfig::script.dayClick = function (moment, jsEvent, view) {
            mouseHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ClickAndHoverEventCallback::dayClick(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;Lcom/google/gwt/core/client/JavaScriptObject;)(moment, jsEvent, view);
        };
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ClickAndHoverConfig::script.eventMouseover = function (calEvent, jsEvent, view) {
            mouseHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ClickAndHoverEventCallback::eventMouseover(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;Lcom/google/gwt/core/client/JavaScriptObject;)(calEvent, jsEvent, view);
        };
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ClickAndHoverConfig::script.eventMouseout = function (calEvent, jsEvent, view) {
            mouseHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ClickAndHoverEventCallback::eventMouseout(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;Lcom/google/gwt/core/client/JavaScriptObject;)(calEvent, jsEvent, view);
        };

    }-*/;

    @Override
    public JavaScriptObject toJavaScript() {
        return script;
    }
}
