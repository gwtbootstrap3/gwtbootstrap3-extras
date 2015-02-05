package org.gwtbootstrap3.extras.bootbox.client;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 GwtBootstrap3
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
import org.gwtbootstrap3.extras.bootbox.client.callback.AlertCallback;
import org.gwtbootstrap3.extras.bootbox.client.callback.ConfirmCallback;
import org.gwtbootstrap3.extras.bootbox.client.callback.PromptCallback;

/**
 * Created by kyle on 2013/12/11.
 */
public class Bootbox {
    /**
     * Displays a message in a modal dialog box.
     *
     * @param msg the message to be displayed.
     */
    public static native void alert(String msg) /*-{
        $wnd.bootbox.alert(msg);
    }-*/;

    /**
     * Displays a message in a modal dialog box.
     * With callback handler.
     *
     * @param msg      the message to be displayed.
     * @param callback the callback handler.
     */
    public static native void alert(String msg, AlertCallback callback) /*-{
        $wnd.bootbox.alert(msg, function () {
            callback.@org.gwtbootstrap3.extras.bootbox.client.callback.AlertCallback::callback()();
        });
    }-*/;

    /**
     * Displays a message in a modal dialog box, along with the standard 'OK' and
     * 'Cancel' buttons.
     *
     * @param msg      the message to be displayed.
     * @param callback the callback handler.
     */
    public static native void confirm(String msg, ConfirmCallback callback) /*-{
        $wnd.bootbox.confirm(msg, function (result) {
            callback.@org.gwtbootstrap3.extras.bootbox.client.callback.ConfirmCallback::callback(Z)(result);
        });
    }-*/;

    /**
     * Displays a request for information in a modal dialog box, along with the
     * standard 'OK' and 'Cancel' buttons.
     *
     * @param msg      the message to be displayed.
     * @param callback the callback handler.
     */
    public static native void prompt(String msg, PromptCallback callback) /*-{
        $wnd.bootbox.prompt(msg, function (result) {
            callback.@org.gwtbootstrap3.extras.bootbox.client.callback.PromptCallback::callback(Ljava/lang/String;)(result);
        });
    }-*/;

    /**
     * Hide all currently active bootbox dialogs. 
     * <p>Individual dialogs can be closed as per normal Bootstrap dialogs: dialog.modal('hide').
     */
    public static native void hideAll() /*-{
        $wnd.bootbox.hideAll();
    }-*/;

    /**
     * Creates a Defaults object.
     */
    public static Defaults createDefaults() {
        return JavaScriptObject.createObject().cast();
    }

    /**
     * Used to provide defaults configurations to Bootbox.
     *
     * @author Tercio Gaudencio Filho (terciofilho [at] gmail.com)
     */
    public static class Defaults extends JavaScriptObject {

        protected Defaults() {
        }

        public final native Defaults setLocale(final String locale) /*-{
            this.locale = locale;
            return this;
        }-*/;

        public final native Defaults setShow(final boolean show) /*-{
            this.show = show;
            return this;
        }-*/;

        public final native Defaults setBackdrop(final boolean backdrop) /*-{
            this.backdrop = backdrop;
            return this;
        }-*/;

        public final native Defaults setCloseButton(final boolean closeButton) /*-{
            this.closeButton = closeButton;
            return this;
        }-*/;

        public final native Defaults setAnimate(final boolean animate) /*-{
            this.animate = animate;
            return this;
        }-*/;

        public final native Defaults setClassName(final String className) /*-{
            this.className = className;
            return this;
        }-*/;
        
        /**
         * Define Bootbox defaults. Call this method to set the defaults in Bootbox. 
         */
        public final native void setDefaults() /*-{
            $wnd.bootbox.setDefaults(this);
        }-*/;

    }

}
