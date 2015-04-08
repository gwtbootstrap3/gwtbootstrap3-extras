package org.gwtbootstrap3.extras.fullcalendar.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2015 GwtBootstrap3
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
 * Wraps selection events inside a <code>JavaScriptObject</code>
 *
 * @see http://fullcalendar.io/docs/selection/
 */
public class SelectConfig implements IsJavaScriptObject {
    private JavaScriptObject script;

    public SelectConfig(final SelectEventCallback handler) {
        if (handler != null) {
            newInstance(handler);
        }
    }

    private native void newInstance(SelectEventCallback handler) /*-{
        var theInstance = this;
        var mouseHandler = handler;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.SelectConfig::script = {};
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.SelectConfig::script.select = function (start, end, jsEvent, view) {
            mouseHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.SelectEventCallback::select(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;Lcom/google/gwt/core/client/JavaScriptObject;)(start, end, jsEvent, view);
        };
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.SelectConfig::script.unselect = function (view, jsEvent) {
            mouseHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.SelectEventCallback::unselect(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(view, jsEvent);
        };
    }-*/;

    @Override
    public JavaScriptObject toJavaScript() {
        return script;
    }
}
