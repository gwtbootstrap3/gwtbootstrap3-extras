package org.gwtbootstrap3.extras.growl.client.ui;

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


public class Growl {
    public static void growl(String message) {
        show(message);
    }

    public static void growl(String title, String message) {
        show(title, message);
    }

    public static void growl(String title, String message, String iconStyle) {
        show(title, message, iconStyle);
    }

    public static void growl(String title, String message, String iconStyle, GrowlOptions options) {
        if (options == null) {
            show(title, message, iconStyle);
        } else {
            show(title, message, iconStyle, options);
        }

    }

    private static native void show(String message) /*-{
        $wnd.jQuery.growl(message);
    }-*/;

    private static native void show(String title, String message) /*-{
        $wnd.jQuery.growl({title: title, message: message});
    }-*/;

    private static native void show(String title, String message, String iconStyle) /*-{
        $wnd.jQuery.growl({title: title, message: message, icon: iconStyle});
    }-*/;

    private static native void show(String title,
                                    String message,
                                    String iconStyle,
                                    GrowlOptions options) /*-{
        var parm1 = {title: title, message: message, icon: iconStyle};
        $wnd.jQuery.growl(parm1, options);
    }-*/;
}
