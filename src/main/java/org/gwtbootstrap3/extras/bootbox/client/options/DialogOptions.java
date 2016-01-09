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
 * Bootbox dialog options.
 *
 * @author Xiaodong Sun
 */
public class DialogOptions extends JavaScriptObject {

    private static final String BUTTON_PREFIX = "bootbox_btn_";
    private static int BUTTON_INDEX = 0;

    protected DialogOptions() {
    }

    /**
     * Creates a new {@link DialogOptions}.
     *
     * @param message
     * @return
     */
    public static DialogOptions newOptions(final String message) {
        DialogOptions options = JavaScriptObject.createObject().cast();
        options.setMessage(message);
        return options;
    }

    final native void setMessage(final String message) /*-{
        this.message = message;
    }-*/;

    /**
     * Adds a header to the dialog and places this text in an H4.
     *
     * @param title
     */
    public final native void setTitle(final String title) /*-{
        this.title = title;
    }-*/;

    /**
     * The locale settings used to translate the three standard button
     * labels: <b>OK</b>, <b>CONFIRM</b>, <b>CANCEL</b>.
     *
     * @param locale
     */
    public final void setLocale(final BootboxLocale locale) {
        BootboxLocale l = (locale != null) ? locale : BootboxLocale.getDefault();
        setLocale(l.getLocale());
    }

    private final native void setLocale(final String locale) /*-{
        this.locale = locale;
    }-*/;

    /**
     * Allows the user to dismiss the dialog by hitting
     * <code>ESC</code>, which will invoke this function.<br>
     * <br>
     * Defaults to <code>null</code> for custom dialogs.
     *
     * @param callback
     */
    public final native void setOnEscape(final SimpleCallback callback) /*-{
        if (callback) {
            this.onEscape = function() {
                callback.@org.gwtbootstrap3.extras.bootbox.client.callback.SimpleCallback::callback()();
            };
        } else {
            this.onEscape = undefined;
        }
    }-*/;

    /**
     * Whether the dialog should be shown immediately.<br>
     * <br>
     * Defaults to <code>true</code>.
     *
     * @param show
     */
    public final native void setShow(final boolean show) /*-{
        this.show = show;
    }-*/;

    /**
     * Whether the dialog should have a backdrop or not.
     * Also determines whether clicking on the backdrop dismisses the modal.
     * <ul>
     * <li><code>null</code>: The backdrop is displayed, but clicking on it has no effect.</li>
     * <li><code>true</code>: The backdrop is displayed, and clicking on it dismisses the dialog.</li>
     * <li><code>false</code>: The backdrop is not displayed.</li>
     * </ul>
     * Defaults to <code>null</code>.
     *
     * @param backdrop
     */
    public final native void setBackdrop(final Boolean backdrop) /*-{
        if (backdrop == null)
            this.backdrop = undefined;
        else
            this.backdrop = backdrop.@java.lang.Boolean::booleanValue()();
    }-*/;

    /**
     * Whether the dialog should have a close button or not.<br>
     * <br>
     * Defaults to <code>true</code>.
     *
     * @param closeButton
     */
    public final native void setCloseButton(final boolean closeButton) /*-{
        this.closeButton = closeButton;
    }-*/;

    /**
     * Animate the dialog in and out.<br>
     * <br>
     * Defaults to <code>true</code>.
     *
     * @param animate
     */
    public final native void setAnimate(final boolean animate) /*-{
        this.animate = animate;
    }-*/;

    /**
     * An additional class to apply to the dialog wrapper.<br>
     * <br>
     * Defaults to <code>true</code>.
     *
     * @param className
     */
    public final native void setClassName(final String className) /*-{
        this.className = className;
    }-*/;

    /**
     * Adds the relevant Bootstrap modal size class to the dialog wrapper.<br>
     * <br>
     * Defaults to <code>null</code>.
     *
     * @param size
     */
    public final native void setSize(final BootboxSize size) /*-{
        if (size)
            this.size = size.@org.gwtbootstrap3.extras.bootbox.client.options.BootboxSize::getSize()();
        else
            this.size = undefined;
    }-*/;

    /**
     * Adds a custom button.
     *
     * @param label
     */
    public final void addButton(String label) {
        addButton(label, (String) null);
    }

    /**
     * Adds a custom button with a class name.
     *
     * @param label
     * @param className
     */
    public final void addButton(String label, String className) {
        addButton(label, className, SimpleCallback.DEFAULT_SIMPLE_CALLBACK);
    }

    /**
     * Adds a custom button with a callback.
     *
     * @param label
     * @param callback
     */
    public final void addButton(String label, SimpleCallback callback) {
        addButton(label, null, callback);
    }

    /**
     * Adds a custom button with a class name and a callback.
     *
     * @param label
     * @param className
     * @param callback
     */
    public final void addButton(String label, String className, SimpleCallback callback) {
        addButton(BUTTON_PREFIX + BUTTON_INDEX++, label, className,
            callback != null ? callback : SimpleCallback.DEFAULT_SIMPLE_CALLBACK);
    }

    private final native void addButton(String name, String label, String className, SimpleCallback callback) /*-{
        this.buttons = this.buttons || {};
        this.buttons[name] = {
            label: label,
            callback: function() {
                callback.@org.gwtbootstrap3.extras.bootbox.client.callback.SimpleCallback::callback()();
            }
        };
        if (className) {
            this.buttons[name].className = className;
        }
    }-*/;

}
