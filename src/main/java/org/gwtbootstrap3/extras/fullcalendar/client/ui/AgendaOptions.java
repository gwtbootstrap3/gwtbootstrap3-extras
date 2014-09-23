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
 * @author Jeff Isenhart
 * @see http://arshaw.com/fullcalendar/docs/agenda/
 */
public class AgendaOptions implements IsJavaScriptObject {
    private JavaScriptObject options;

    public AgendaOptions() {
        newInstance();
    }

    /**
     * Sets defaults
     *
     * @see http://arshaw.com/fullcalendar/docs/agenda/
     */
    public native void newInstance() /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options = {
            allDaySlot: true,
            allDayText: "all-day",
            axisFormat: "h(:mm)a",
            slotDuration: '00:30.00',
            scrollTime: '06:00:00',
            minTime: '00:00:00',
            maxTime: '24:00:00',
            slotEventOverlap: true

        };
    }-*/;

    /**
     * @see http://arshaw.com/fullcalendar/docs/agenda/allDaySlot/
     */
    public native void setAllDaySlot(boolean allDay) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.allDaySlot = allDay;
    }-*/;

    /**
     * @see http://arshaw.com/fullcalendar/docs/agenda/allDayText/
     */
    public native void setAllDayText(String text) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.allDayText = text;
    }-*/;

    /**
     * @see http://arshaw.com/fullcalendar/docs/agenda/axisFormat/
     */
    public native void setAxisFormat(String format) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.axisFormat = format;
    }-*/;

    public void setSlotDuration(final int minutes) {
        assert minutes >= 0 && minutes <= 60;
        if (minutes < 10) {
            setSlotDuration("00:0" + minutes + ":00");
        } else {
            setSlotDuration("00:" + minutes + ":00");
        }
    }

    /**
     * @see http://arshaw.com/fullcalendar/docs/agenda/slotDuration/
     */
    public native void setSlotDuration(String timeString) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.slotDuration = timeString;
    }-*/;

    public void setSnapDuration(final int minutes) {
        assert minutes >= 0 && minutes <= 60;
        if (minutes < 10) {
            setSnapDuration("00:0" + minutes + ":00");
        } else {
            setSnapDuration("00:" + minutes + ":00");
        }
    }

    /**
     * @see http://arshaw.com/fullcalendar/docs/agenda/snapDuration/
     */
    public native void setSnapDuration(String timeString) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.snapDuration = timeString;
    }-*/;

    /**
     * @see http://arshaw.com/fullcalendar/docs/agenda/scrollTime/
     */
    public native void setScrollTime(String timeString) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.scrollTime = timeString;
    }-*/;

    /**
     * @see http://arshaw.com/fullcalendar/docs/agenda/minTime/
     */
    public native void setMinTime(String timeString) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.minTime = timeString;
    }-*/;

    /**
     * @see http://arshaw.com/fullcalendar/docs/agenda/maxTime/
     */
    public native void setMaxTime(String timeString) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.maxTime = timeString;
    }-*/;

    /**
     * @see http://arshaw.com/fullcalendar/docs/agenda/slotEventOverlap/
     */
    public native void setSlotEventOverlap(boolean overlap) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.slotEventOverlap = overlap;
    }-*/;

    @Override
    public JavaScriptObject toJavaScript() {
        return options;
    }
}
