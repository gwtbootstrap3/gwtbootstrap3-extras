package org.gwtbootstrap3.extras.datepicker.client.ui.base.constants;

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

import com.google.gwt.user.client.Event;
import com.google.web.bindery.event.shared.HandlerRegistration;
import org.gwtbootstrap3.client.shared.event.HideHandler;
import org.gwtbootstrap3.client.shared.event.ShowHandler;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.events.ChangeDateHandler;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.events.ChangeMonthHandler;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.events.ChangeYearHandler;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.events.ClearDateHandler;

/**
 * All handlers for the DateTimePicker
 *
 * @author Joshua Godi
 */
public interface HasDateTimePickerHandlers {
    void onShow(Event e);

    HandlerRegistration addShowHandler(ShowHandler showHandler);

    void onHide(Event e);

    HandlerRegistration addHideHandler(HideHandler hideHandler);

    void onChangeDate(Event e);

    HandlerRegistration addChangeDateHandler(ChangeDateHandler changeDateHandler);

    void onChangeYear(Event e);

    HandlerRegistration addChangeYearHandler(ChangeYearHandler changeYearHandler);

    void onChangeMonth(Event e);

    HandlerRegistration addChangeMonthHandler(ChangeMonthHandler changeMonthHandler);

    void onClearDate(Event e);

    HandlerRegistration addClearDateHandler(ClearDateHandler outOfRangeHandler);
}
