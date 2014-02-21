package org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants;

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
 * ENUM. Default: 2, 'month'
 * <p/>
 * The view that the datetimepicker should show when it is opened. Accepts values of :
 * <p/>
 * 'hour' for the hour view
 * 'day' for the day view
 * 'month' for month view (the default)
 * 'year' for the 12-month overview
 * 'decade' for the 10-year overview. Useful for date-of-birth datetimepickers.
 *
 * @author Joshua Godi
 * @see org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.DateTimePickerView
 */
public interface HasStartView {
    void setStartView(DateTimePickerView dateTimePickerView);
}
