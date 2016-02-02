package org.gwtbootstrap3.extras.bootbox.client.options;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2016 GwtBootstrap3
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

import org.gwtbootstrap3.extras.bootbox.client.callback.SimpleCallback;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Alert options.
 *
 * @author Xiaodong Sun
 */
public class AlertOptions extends DialogOptions {

    /**
     * 
     */
    protected AlertOptions() {}
    
    /**
     * Creates a new {@link AlertOptions}.
     *
     * @param message
     * @return
     */
    public static final AlertOptions newOptions(final String message) {
        AlertOptions options = JavaScriptObject.createObject().cast();
        options.setMessage(message);
        return options;
    }

    public final native void setCallback(SimpleCallback callback) /*-{
        this.callback = function() {
            callback.@org.gwtbootstrap3.extras.bootbox.client.callback.SimpleCallback::callback()();
        };
    }-*/;
}
