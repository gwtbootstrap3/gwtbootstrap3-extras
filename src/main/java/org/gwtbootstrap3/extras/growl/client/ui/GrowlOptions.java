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

public class GrowlOptions extends JavaScriptObject {

    protected GrowlOptions() {
    }
    
    public final void setGrowlPosition(GrowlPosition pos) {
        if (pos != null) {
        	setPosition(pos);
        }
    }

    private final native void setPosition(JavaScriptObject pos) /*-{
        this.position = pos;
    }-*/;

    public final native void setAllowDismiss(boolean allowDismiss) /*-{
        this.allow_dismiss = allowDismiss;
    }-*/;

    public final native void setOffset(int off) /*-{
        this.offset = off;
    }-*/;

    public final native void setSpacing(int space) /*-{
        this.spacing = space;
    }-*/;

    public final native void setZIndex(int zIndex) /*-{
        this.z_index = zIndex;
    }-*/;

    public final native void setFadeIn(int mFade) /*-{
        this.fade_in = mFade;
    }-*/;

    public final native void setDelay(int mDelay) /*-{
        this.delay = mDelay;
    }-*/;

    public final native void setPauseOnMouseOver(boolean pauseOnMouseOver) /*-{
        this.pause_on_mouseover = pauseOnMouseOver;
    }-*/;

    public final void setTemplateObject(JavaScriptObject temp) {
        if (temp != null && temp instanceof GrowlTemplate) {
            setTemplate(temp);
        }
    }

    private final native void setTemplate(JavaScriptObject temp) /*-{
        this.template = temp;
    }-*/;

    public final void setGrowlDefaultOptions(JavaScriptObject go) {
        if (go != null && go instanceof GrowlOptions) {
            setDefaultOptions(go);
        }
    }

    private final native void setDefaultOptions(JavaScriptObject go) /*-{
        console.log(go);
        $wnd.jQuery.growl.default_options = go;
    }-*/;

    public final native void setNullType() /*-{
        this.type = null;
    }-*/;

    public final native void setInfoType() /*-{
        this.type = 'info';
    }-*/;

    public final native void setSuccessType() /*-{
        this.type = 'success';
    }-*/;

    public final native void setDangerType() /*-{
        this.type = 'danger';
    }-*/;

    public final native void setWarningType() /*-{
        this.type = 'warning';
    }-*/;
}
