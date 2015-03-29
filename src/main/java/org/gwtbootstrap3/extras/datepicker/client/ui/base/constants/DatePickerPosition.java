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
 * Position to display the DateTimePicker popup
 *
 * @author Joshua Godi
 */
public enum DatePickerPosition {
    AUTO("auto"),
    TOP_AUTO("top auto"),
    BOTTOM_AUTO("bottom auto"),
    AUTO_RIGHT("auto right"),
    AUTO_LEFT("auto left"),
    TOP_LEFT("top left"),
    TOP_RIGHT("top right"),
    BOTTOM_LEFT("bottom left"),
    BOTTOM_RIGHT("bottom right");

    private final String position;

    DatePickerPosition(final String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
}
