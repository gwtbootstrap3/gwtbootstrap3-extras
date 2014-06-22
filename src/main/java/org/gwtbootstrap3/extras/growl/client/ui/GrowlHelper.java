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


public class GrowlHelper {


    public static GrowlOptions getNewOptions() {
        GrowlOptions go = getNewNativeOptions();
        go.setGrowlPosition(getNewPosition());
        return go;
    }

    private static native GrowlOptions getNewNativeOptions() /*-{
        var go = {};
        go.ele = 'body';
        go.allow_dismiss = true;
        go.offset = 20;
        go.spacing = 10;
        go.z_index = 1031;
        go.fade_in = 400;
        go.delay = 5000;
        go.type = null;
        go.pause_on_mouseover = false;
        return go;
    }-*/;


    public static native GrowlPosition getNewPosition() /*-{
        return {from: "top", align: "right"};
    }-*/;

    public static native GrowlTemplate getNewTemplate() /*-{
        return {icon_type: 'class'};//set icon_type to class by default, otherwise set to 'image' when appropirate
    }-*/;
}
