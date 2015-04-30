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

/**
 * Enum, Array enums. Default: none
 * <p/>
 * Days of the week that should be disabled. Values are enum of DateTimePickerDayOfWeek.
 * Multiple values should be comma-separated. Example: disable weekends: SUNDAY, MONDAY.
 *
 * @author Joshua Godi
 * @see org.gwtbootstrap3.extras.datepicker.client.ui.base.constants.DatePickerDayOfWeek
 */
public interface HasDaysOfWeekDisabled {
    void setDaysOfWeekDisabled(DatePickerDayOfWeek... daysOfWeekDisabled);
}
