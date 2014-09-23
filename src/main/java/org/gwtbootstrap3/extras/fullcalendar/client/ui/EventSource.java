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
import com.google.gwt.core.client.ScriptInjector;
import org.gwtbootstrap3.extras.fullcalendar.client.FullCalendarClientBundle;

/**
 * Models the Event Source Object
 *
 * @author Jeff Isenhart
 * @see http://arshaw.com/fullcalendar/docs/event_data/Event_Source_Object/
 */
public class EventSource implements IsJavaScriptObject {

    private static boolean GCAL_ADDED = false;
    private JavaScriptObject eventSource;

    public EventSource(final JavaScriptObject jso) {
        eventSource = jso;
    }

    public EventSource(final String url,
                       final String color,
                       final String backgroundColor,
                       final String textColor,
                       final String borderColor,
                       final String className,
                       final boolean isEditable,
                       final boolean isStartEditable,
                       final boolean isDurationEditable,
                       final boolean allDayDefault,
                       final boolean ignoreTimeZone,
                       final boolean isGoogle//if true include google script file
    ) {
        if (isGoogle && !GCAL_ADDED) {
            GCAL_ADDED = true;
            ScriptInjector.fromString(FullCalendarClientBundle.INSTANCE.getGoogleCalJS().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        }
        newEvent(url, color, backgroundColor, textColor, borderColor, className, isEditable, isStartEditable, isDurationEditable, allDayDefault, ignoreTimeZone);
    }

    private native void newEvent(String url,
                                 String color,
                                 String backgroundColor,
                                 String textColor,
                                 String borderColor,
                                 String className,
                                 boolean isEditable,
                                 boolean isStartEditable,
                                 boolean isDurationEditable,
                                 boolean allDayDefault,
                                 boolean ignoreTimeZone
    ) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource = {
            url: url,
            color: color,
            backgroundColor: backgroundColor,
            textColor: textColor,
            borderColor: borderColor,
            className: className,
            editable: isEditable,
            startEditable: isStartEditable,
            durationEditable: isDurationEditable,
            allDayDefault: allDayDefault,
            ignoreTimeZone: ignoreTimeZone
        };
    }-*/;

    public native void setEventDataTransform(EventDataTransformCallback callback) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.eventTransform = function (eventData) {
            if (callback) {
                callback.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventDataTransformCallback::eventData(Lcom/google/gwt/core/client/JavaScriptObject;)(eventData);
            }
        }
    }-*/;

    public native String getUrl() /*-{
        var theInstance = this;
        return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.url;
    }-*/;

    public native String getColor() /*-{
        var theInstance = this;
        return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.color;
    }-*/;

    public native String getBackgroundColor() /*-{
        var theInstance = this;
        return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.backgroundColor;
    }-*/;

    public native String getTextColor() /*-{
        var theInstance = this;
        return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.textColor;
    }-*/;

    public native String getBorderColor() /*-{
        var theInstance = this;
        return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.borderColor;
    }-*/;

    public native String getClassName() /*-{
        var theInstance = this;
        return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.className;
    }-*/;

    public native boolean getIsEditable() /*-{
        var theInstance = this;
        return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.editable;
    }-*/;

    public native boolean getStartEditable() /*-{
        var theInstance = this;
        return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.startEditable;
    }-*/;

    public native boolean getDurationEditable() /*-{
        var theInstance = this;
        if (theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.durationEditable) {
            return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.durationEditable;
        }
        return false;
    }-*/;

    public native boolean isAllDayDefault() /*-{
        var theInstance = this;
        return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.allDayDefault;
    }-*/;

    public native boolean ignoreTimeZone() /*-{
        var theInstance = this;
        return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.ignoreTimeZone;
    }-*/;

    @Override
    public JavaScriptObject toJavaScript() {
        return this.eventSource;
    }
}
