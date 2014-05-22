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


import com.google.gwt.core.client.JavaScriptObject;

public class GrowlPosition extends JavaScriptObject {

    protected GrowlPosition() {
    }

    public final native void setTop(boolean top) /*-{
        if (top) {
            this.from = "top";
        } else {
            this.from = "bottom";
        }
    }-*/;


    public final native void setLeft() /*-{
        this.align = "left";
    }-*/;

    public final native void setCenter() /*-{
        this.align = "center";
    }-*/;

    public final native void setRight() /*-{
        this.align = "right";
    }-*/;

}
