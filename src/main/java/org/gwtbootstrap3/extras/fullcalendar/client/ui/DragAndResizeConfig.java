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
 * @author Jeff Iesnhart
 * @see http://arshaw.com/fullcalendar/docs/event_ui/
 */
public class DragAndResizeConfig implements IsJavaScriptObject {
    private JavaScriptObject script;

    public DragAndResizeConfig(final DragAndResizeCallback handler) {
        if (handler != null) {
            newInstance(handler);
        }
    }

    private native void newInstance(DragAndResizeCallback handler) /*-{
        var theInstance = this;
        var dragResizeHandler = handler;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeConfig::script = {};
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeConfig::script.eventDragStart = function (event, jsEvent, ui, view) {
            if (event && jsEvent) {
                var originalEvent = null;
                if (jsEvent.originalEvent) {
                    originalEvent = jsEvent.originalEvent;
                }
                dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeCallback::eventDragStart(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event, originalEvent);
            }
        };
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeConfig::script.eventDragStop = function (event, jsEvent, ui, view) {
            if (event && jsEvent) {
                var originalEvent = null;
                if (jsEvent.originalEvent) {
                    originalEvent = jsEvent.originalEvent;
                }
                dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeCallback::eventDragStop(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event, originalEvent);
            }
        };
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeConfig::script.eventDrop = function (event, delta, revertFunc, jsEvent, ui, view) {
            var originalEvent = null;
            if (jsEvent && jsEvent.originalEvent) {
                originalEvent = jsEvent.originalEvent;
            }
            dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeCallback::eventDrop(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event, revertFunc, originalEvent);
        };

        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeConfig::script.eventResizeStart = function (event, jsEvent, ui, view) {
            if (event && jsEvent) {
                var originalEvent = null;
                if (jsEvent.originalEvent) {
                    originalEvent = jsEvent.originalEvent;
                }
                dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeCallback::eventResizeStart(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event, originalEvent);
            }
        };
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeConfig::script.eventResizeStop = function (event, jsEvent, ui, view) {
            if (event && jsEvent) {
                var originalEvent = null;
                if (jsEvent.originalEvent) {
                    originalEvent = jsEvent.originalEvent;
                }
                dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeCallback::eventResizeStop(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event, originalEvent);
            }
        };
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeConfig::script.eventResize = function (event, delta, revertFunc, jsEvent, ui, view) {
            var originalEvent = null;
            if (jsEvent && jsEvent.originalEvent) {
                originalEvent = jsEvent.originalEvent;
            }
            dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeCallback::eventResize(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event, revertFunc, originalEvent);
        };
    }-*/;

    @Override
    public JavaScriptObject toJavaScript() {
        return script;
    }
}
