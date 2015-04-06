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
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.client.JsDate;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;

import java.util.Date;

/**
 * Represents and event on a FullCalendar
 *
 * @author Jeff Isenhart
 * @see http://arshaw.com/fullcalendar/docs/event_data/Event_Object/
 */
public class Event implements IsJavaScriptObject {

    private JavaScriptObject event;

    public Event(final String id, final String title) {
        newEvent(id, title, true, true, true);
    }

    public Event(final JavaScriptObject jso) {
        event = jso;
    }

    public Event(final String id, final String title, final boolean isEditable, final boolean isStartEditable, final boolean isDurationEditable) {
        newEvent(id, title, isEditable, isStartEditable, isDurationEditable);
    }

    private native void newEvent(String eventId, String eventTitle, boolean isEditable, boolean isStartEditable, boolean isDurationEditable) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event = {id: eventId,
            title: eventTitle,
            allDay: false,
            editable: isEditable,
            startEditable: isStartEditable,
            durationEditable: isDurationEditable
        };
    }-*/;

    public native String getId() /*-{
        var theInstance = this;
        return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.id;
    }-*/;

    public native String getTitle() /*-{
        var theInstance = this;
        return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.title;
    }-*/;

    public native void setTitle(String title) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.title = title;
    }-*/;

    public native void setAllDay(boolean isAllDay) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.allDay = isAllDay;
    }-*/;

    public native boolean isAllDay() /*-{
        var theInstance = this;
        return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.allDay;
    }-*/;

    public void setStart(final Date d) {
        if (d != null) {
            setStart(getDateAsISO8601(d));
        }
    }

    private native void setStart(String start) /*-{
		var theInstance = this;
    	theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.start = start;
	}-*/;

    public native void setStart(final JavaScriptObject start) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.start = start;
    }-*/;

    public native JsDate getStart() /*-{
        var theInstance = this;
        if (theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.start) {
            return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.start.toDate();
        }
        return null;

    }-*/;

    public Date getStartFromYearMonthDay() {
        Date iso = null;
        final String isoString = getISOStart();
        if (isoString != null && isoString.length() >= 10) {
            iso = DateTimeFormat.getFormat("yyyy-MM-dd").parse(isoString.substring(0, 10));
        }
        return iso;
    }

    public native String getISOStart() /*-{
        var theInstance = this;
        if (theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.start) {
            return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.start.toDate().toISOString();
        }
        return null;

    }-*/;

    public void setEnd(final Date d) {
        if (d != null) {
            setEnd(getDateAsISO8601(d));
        }
    }

    private native void setEnd(String end) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.end = end;
    }-*/;

    public native void setEnd(final JavaScriptObject end) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.end = end;
    }-*/;

    public native JsDate getEnd() /*-{
        var theInstance = this;
        if (theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.end) {
            return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.end.toDate();
        }
        return null;
    }-*/;

    public native String getISOEnd() /*-{
        var theInstance = this;
        if (theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.end) {
            return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.end.toDate().toISOString();
        }
        return null;
    }-*/;

    public Date getEndFromYearMonthDay() {
        Date iso = null;
        final String isoString = getISOEnd();
        if (isoString != null && isoString.length() >= 10) {
            iso = DateTimeFormat.getFormat("yyyy-MM-dd").parse(isoString.substring(0, 10));
        }
        return iso;
    }

    public native void setUrl(String url) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.url = url;
    }-*/;

    public native String getUrl() /*-{
        var theInstance = this;
        return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.url;
    }-*/;

    public native void setClassName(String className) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.className = className;
    }-*/;

    public native void setClassNames(JsArrayString classNames) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.className = className;
    }-*/;

    public native void setEditable(boolean editable) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.editable = editable;
    }-*/;

    public native boolean isEditable() /*-{
        var theInstance = this;
        if (theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.editable) {
            return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.editable;
        }
        return false;
    }-*/;

    public native void setStartEditable(boolean startEditable) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.startEditable = startEditable;
    }-*/;

    public native boolean getStartEditable() /*-{
        var theInstance = this;
        if (theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.startEditable) {
            return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.startEditable;
        }
        return false;
    }-*/;

    public native void setDurationEditable(boolean durationEditable) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.durationEditable = durationEditable;
    }-*/;

    public native boolean getDurationEditable() /*-{
        var theInstance = this;
        if (theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.durationEditable) {
            return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.durationEditable;
        }
        return false;
    }-*/;

    public native void setColor(String color) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.color = color;
    }-*/;

    public native void setBackgroundColor(String bgColor) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.backgroundColor = bgColor;
    }-*/;

    public native void setBorderColor(String borderColor) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.borderColor = borderColor;
    }-*/;

    public native void setTextColor(String textColor) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.textColor = textColor;
    }-*/;

    /**
     * ************* non standard / add-on fields and methods *********************
     */
    public native void setDescription(String description) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.description = description;
    }-*/;

    public native String getDescription() /*-{
        var theInstance = this;
        return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Event::event.description;
    }-*/;

    public static String getDateAsRFC_2822(final Date d) {
        return d == null ? "" : DateTimeFormat.getFormat(PredefinedFormat.RFC_2822).format(d);
    }

    public static String getDateAsISO8601(final Date d) {
        return d == null ? "" : DateTimeFormat.getFormat(PredefinedFormat.ISO_8601).format(d);
    }

    public static String getDateAsUnixTimestamp(final Date d) {
        if (d == null) {
            return "";
        }
        final int iTimeStamp = (int) (d.getTime() * .001);
        return "" + iTimeStamp;
    }

    @Override
    public JavaScriptObject toJavaScript() {
        return this.event;
    }
}
