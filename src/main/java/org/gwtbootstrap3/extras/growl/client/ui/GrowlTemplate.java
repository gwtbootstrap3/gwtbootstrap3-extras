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

public class GrowlTemplate extends JavaScriptObject {
    protected GrowlTemplate() {
    }

    public final native void setIconType(String iconType) /*-{
        this.icon_type = iconType;
    }-*/;

    public final native void setContainer(String containterHtml) /*-{
        this.container = containterHtml;
    }-*/;

    public final native void setDismiss(String dismissHtml) /*-{
        this.dismiss = dismissHtml;
    }-*/;

    public final native void setTitle(String titleTextOrHtml) /*-{
        this.title = titleTextOrHtml;
    }-*/;

    public final native void setTitleDivider(String titleDividerTextOrHtml) /*-{
        this.title_divider = titleDividerTextOrHtml;
    }-*/;

    public final native void setMessage(String messageTextOrHtml) /*-{
        this.message = messageTextOrHtml;
    }-*/;
}
