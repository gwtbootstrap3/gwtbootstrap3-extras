package org.gwtbootstrap3.extras.tagsinput.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2016 GwtBootstrap3
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

/**
 * ComplexTags implementation used for {@link JSComplexTagsInput} component.
 * 
 * @author Marko Nikolić <marko.nikolic@iten.rs>
 */
public class JSComplexTag extends JavaScriptObject {

    protected JSComplexTag() {}
    
    /**
     * Creates a new instance of {@link JSComplexTag}.
     *
     * @return a new instance of {@link JSComplexTag}.
     */
    public static JSComplexTag create() {
        return JavaScriptObject.createObject().cast();
    }
    
    public final native void setValue(String value) /*-{
        this.item_value = value;
    }-*/;

    public final native String getValue() /*-{
        return this.item_value;
    }-*/;

    public final native void setText(String text) /*-{
        this.item_text = text;
    }-*/;

    public final native String getText() /*-{
        return this.item_text;
    }-*/;

    public final native void setPayload(String payload) /*-{
        this.payload = payload;
    }-*/;

    public final native String getPayload() /*-{
        return this.payload;
    }-*/;
}
