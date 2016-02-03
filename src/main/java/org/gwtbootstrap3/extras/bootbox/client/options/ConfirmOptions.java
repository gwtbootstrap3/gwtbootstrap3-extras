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

import org.gwtbootstrap3.extras.bootbox.client.callback.ConfirmCallback;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Confirm options.
 *
 * @author Xiaodong Sun
 */
public class ConfirmOptions extends DialogOptions {

    /**
     * 
     */
    protected ConfirmOptions() {}
    
    /**
     * Creates a new {@link ConfirmOptions}.
     *
     * @param message
     * @return
     */
    public static final ConfirmOptions newOptions(final String message) {
        ConfirmOptions options = JavaScriptObject.createObject().cast();
        options.setMessage(message);
        options.setCallback(ConfirmCallback.DEFAULT_CONFIRM_CALLBACK);
        return options;
    }

    public final native void setCallback(ConfirmCallback callback) /*-{
        this.callback = function(result) {
            callback.@org.gwtbootstrap3.extras.bootbox.client.callback.ConfirmCallback::callback(Z)(result);
        };
    }-*/;
}
