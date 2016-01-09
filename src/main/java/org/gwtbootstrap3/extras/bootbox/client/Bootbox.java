package org.gwtbootstrap3.extras.bootbox.client;

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
import org.gwtbootstrap3.extras.bootbox.client.callback.PromptCallback;
import org.gwtbootstrap3.extras.bootbox.client.callback.SimpleCallback;
import org.gwtbootstrap3.extras.bootbox.client.options.AlertOptions;
import org.gwtbootstrap3.extras.bootbox.client.options.BootboxLocale;
import org.gwtbootstrap3.extras.bootbox.client.options.ConfirmOptions;
import org.gwtbootstrap3.extras.bootbox.client.options.DialogOptions;
import org.gwtbootstrap3.extras.bootbox.client.options.PromptOptions;

/**
 * Bootbox.js is a small JavaScript library which allows you
 * to create programmatic dialog boxes using Bootstrap modals.
 *
 * @author Xiaodong Sun
 * @see http://bootboxjs.com/
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
    public static native void alert(String msg, SimpleCallback callback) /*-{
        $wnd.bootbox.alert(msg, function () {
            callback.@org.gwtbootstrap3.extras.bootbox.client.callback.SimpleCallback::callback()();
        });
    }-*/;

    /**
     * Displays a customized alert with the given {@link AlertOptions}.
     *
     * @param options
     */
    public static native void alert(AlertOptions options) /*-{
        $wnd.bootbox.alert(options);
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
     * Displays a customized confirm with the given {@link ConfirmOptions}.
     *
     * @param options
     */
    public static native void confirm(ConfirmOptions options) /*-{
        $wnd.bootbox.confirm(options);
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
     * Displays a customized prompt with the given {@link PromptOptions}.
     *
     * @param options
     */
    public static native void prompt(PromptOptions options) /*-{
        $wnd.bootbox.prompt(options);
    }-*/;

    /**
     * Displays a completely customizable dialog in a modal dialog box.
     *
     * @param options the dialog options.
     */
    public static native void dialog(final DialogOptions options) /*-{
        $wnd.bootbox.dialog(options);
    }-*/;

    /**
     * Sets a callback when dialog gets initialized.
     *
     * @param callback
     */
    public static native void init(SimpleCallback callback) /*-{
        $wnd.bootbox.init(function() {
            if (callback)
                callback.@org.gwtbootstrap3.extras.bootbox.client.callback.SimpleCallback::callback()();
        });
    }-*/;

    /**
     * Set many of the default options shown in the dialog example.<br>
     * <br>
     * Many of these options are also applied to the basic wrapper methods
     * and can be overridden whenever the wrapper methods are invoked
     * with a single options argument.
     *
     * @param options
     */
    public static native void setDefaults(DialogOptions options) /*-{
        $wnd.bootbox.setDefaults(options);
    }-*/;

    /**
     * Sets a locale.
     *
     * @param locale if <code>null</code>, defaults to {@link BootboxLocale#EN}.
     */
    public static void setLocale(final BootboxLocale locale) {
        BootboxLocale l = (locale != null) ? locale : BootboxLocale.getDefault();
        setLocale(l.getLocale());
    }

    private static native void setLocale(String locale) /*-{
        $wnd.bootbox.setLocale(locale);
    }-*/;

    /**
     * Hide all currently active bootbox dialogs.
     * <p>Individual dialogs can be closed as per normal Bootstrap dialogs: dialog.modal('hide').
     */
    public static native void hideAll() /*-{
        $wnd.bootbox.hideAll();
    }-*/;
}
