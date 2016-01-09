package org.gwtbootstrap3.extras.bootbox.client.callback;

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

/**
 * Confirm callback according to the result.
 *
 * @author Xiaodong Sun
 */
public interface ConfirmCallback extends Callback {

    /**
     * Callback according to the result.
     *
     * @param result <code>true</code> if the user presses the confirm button,
     *     or <code>false</code> if the user presses the cancel button
     */
    void callback(boolean result);

    /**
     * Default {@link ConfirmCallback} does nothing.
     */
    static final ConfirmCallback DEFAULT_CONFIRM_CALLBACK = new ConfirmCallback() {
        @Override
        public void callback(boolean result) {}
    };
}
