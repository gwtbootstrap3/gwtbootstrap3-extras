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
import com.google.gwt.i18n.client.LocaleInfo;

/**
 * @author Jeff Isenhart
 * @see http://arshaw.com/fullcalendar/docs/text/dayNames/
 * @see http://arshaw.com/fullcalendar/docs/text/dayNamesShort/
 */
public class DayNames implements IsJavaScriptObject {
    private JavaScriptObject names;

    public DayNames() {
        newInstance();
    }

    private native void newInstance() /*-{
        //default vals...
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DayNames::names = {};
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DayNames::names.dayNames = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DayNames::names.dayNamesShort = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
    }-*/;

    public void localize() {
        localized(LocaleInfo.getCurrentLocale().getDateTimeFormatInfo().weekdaysFull(),
                LocaleInfo.getCurrentLocale().getDateTimeFormatInfo().weekdaysShort());
    }

    /**
     * pass in localized names directly
     *
     * @param longNames
     * @param shortNames
     */
    public void localized(final String[] longNames, final String[] shortNames) {
        assert longNames != null && longNames.length == 7;
        assert shortNames != null && shortNames.length == 7;
        final JsArrayString longOnes = (JsArrayString) JsArrayString.createArray();
        for (final String name : longNames) {
            longOnes.push(name);
        }

        final JsArrayString shortOnes = (JsArrayString) JsArrayString.createArray();
        for (final String name : shortNames) {
            shortOnes.push(name);
        }
        localized(longOnes, shortOnes);
    }

    /**
     * pass in localized names directly
     *
     * @param longNames
     * @param shortNames
     */
    public native void localized(JsArrayString longNames, JsArrayString shortNames) /*-{
        var theInstance = this;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DayNames::names.dayNames = longNames;
        theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DayNames::names.dayNamesShort = shortNames;
    }-*/;

    @Override
    public JavaScriptObject toJavaScript() {
        return names;
    }
}
