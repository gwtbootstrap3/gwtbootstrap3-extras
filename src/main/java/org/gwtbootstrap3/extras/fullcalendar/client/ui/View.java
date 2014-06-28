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
import com.google.gwt.core.client.JsDate;

/**
 * @author Jeff
 * @see http://arshaw.com/fullcalendar/docs/views/View_Object/
 */
public class View {

    private final JavaScriptObject view;

    /**
     * @param jso
     */
    public View(final JavaScriptObject jso) {
        view = jso;
    }

    public native String getName() /*-{
        var theInstance = this;
        return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.View::view.name;
    }-*/;

    public native String getTitle() /*-{
        var theInstance = this;
        return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.View::view.title;
    }-*/;

    public native JsDate getStart() /*-{
        var theInstance = this;
        var returnVal = theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.View::view.start;
        if (returnVal) {
            return returnVal.toDate();
        }
        return null;
    }-*/;

    public native JsDate getEnd() /*-{
        var theInstance = this;
        var returnVal = theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.View::view.end;
        if (returnVal) {
            return returnVal.toDate();
        }
        return null;
    }-*/;

    public native JsDate getIntervalStart() /*-{
        var theInstance = this;
        var returnVal = theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.View::view.intervalStart;
        if (returnVal) {
            return returnVal.toDate();
        }
        return null;
    }-*/;

    public native JsDate getIntervalEnd() /*-{
        var theInstance = this;
        var returnVal = theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.View::view.intervalEnd;
        if (returnVal) {
            return returnVal.toDate();
        }
        return null;
    }-*/;

    public JavaScriptObject toJavaScript() {
        return this.view;
    }
}
