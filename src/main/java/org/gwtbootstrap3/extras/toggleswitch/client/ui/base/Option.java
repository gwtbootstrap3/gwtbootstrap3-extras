package org.gwtbootstrap3.extras.toggleswitch.client.ui.base;

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

enum Option {
    SIZE("size", "data-size"),
    ANIMATE("animate", "data-animate"),
    DISABLED("disabled", "disabled"),
    READONLY("readonly", "readonly"),
    INDETERMINATE("indeterminate", "data-indeterminate"),
    INVERSE("inverse", "data-inverse"),
    RADIO_ALL_OFF("radioAllOff", "data-radio-all-off"),
    ON_COLOR("onColor", "data-on-color"),
    OFF_COLOR("offColor", "data-off-color"),
    ON_TEXT("onText", "data-on-text"),
    OFF_TEXT("offText", "data-off-text"),
    LABEL_TEXT("labelText", "data-label-text"),
    HANDLE_WIDTH("handleWidth", "data-handle-width"),
    LABEL_WIDTH("labelWidth", "data-label-width");
    
    private final String command;
    private final String attribute;
    
    private Option(String command, String attribute) {
        this.command = command;
        this.attribute = attribute;
    }

    public String getCommand() {
        return command;
    }

    public String getAttribute() {
        return attribute;
    }
}
