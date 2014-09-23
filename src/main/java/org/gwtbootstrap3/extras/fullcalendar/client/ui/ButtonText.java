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
 * @see http://arshaw.com/fullcalendar/docs/text/buttonText/
 */
public class ButtonText implements IsJavaScriptObject {

    private JavaScriptObject text;

    public ButtonText() {
        newInstance();
    }

    private native void newInstance() /*-{
        //default vals...
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ButtonText::text = {};
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ButtonText::text.buttonText =
        {
            today: 'today',
            month: 'month',
            week: 'week',
            day: 'day'
        };
    }-*/;

    public native void setToday(String today) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ButtonText::text.buttonText.today = today;
    }-*/;

    public native void setMonth(String month) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ButtonText::text.buttonText.month = month;
    }-*/;

    public native void setWeek(String week) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ButtonText::text.buttonText.week = week;
    }-*/;

    public native void setDay(String day) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ButtonText::text.buttonText.day = day;
    }-*/;

    @Override
    public JavaScriptObject toJavaScript() {
        return text;
    }
}
