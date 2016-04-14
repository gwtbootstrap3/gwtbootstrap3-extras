package org.gwtbootstrap3.extras.tagsinput.client.ui.base;

import org.gwtbootstrap3.extras.tagsinput.client.callback.ItemTextCallback;
import org.gwtbootstrap3.extras.tagsinput.client.callback.ItemValueCallback;
import org.gwtbootstrap3.extras.tagsinput.client.callback.OnTagExistsCallback;
import org.gwtbootstrap3.extras.tagsinput.client.callback.TagClassCallback;

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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;

/**
 * Tags Input options, used for customisation of TagsInput widget.
 *
 * @author Marko Nikolić <marko.nikolic@iten.rs>
 */
public class TagsInputOptions<T> extends JavaScriptObject {

    protected TagsInputOptions() {}
    
    /**
     * Creates a new instance of {@link TagsInputOptions}.
     *
     * @return a new instance of {@link TagsInputOptions}.
     */
    @SuppressWarnings("rawtypes")
    static TagsInputOptions create() {
        return JavaScriptObject.createObject().cast();
    }

    public final native void setTagClass(String className) /*-{
        this.tagClass = className;
    }-*/;

    public final native void setTagClass(final TagClassCallback<T> callback) /*-{
        this.tagClass = function(item) {
            return callback.@org.gwtbootstrap3.extras.tagsinput.client.callback.TagClassCallback::getTagClass(Ljava/lang/Object;)(item);
        }
    }-*/;
    
    public final native void setItemValue(String itemValue) /*-{
        this.itemValue = itemValue;
    }-*/;

    public final native void setItemValue(final ItemValueCallback<T> callback) /*-{
        this.itemValue = function(item) {
            return callback.@org.gwtbootstrap3.extras.tagsinput.client.callback.ItemValueCallback::getItemValue(Ljava/lang/Object;)(item);
        }
    }-*/;
    
    public final native void setItemText(String itemText) /*-{
        this.itemText = itemText;
    }-*/;
    
    public final native void setItemText(final ItemTextCallback<T> callback) /*-{
        this.itemText = function(item) {
            return callback.@org.gwtbootstrap3.extras.tagsinput.client.callback.ItemTextCallback::getItemText(Ljava/lang/Object;)(item);
        }
    }-*/;

    public final native void setConfirmKeys(JsArrayInteger keys) /*-{
        this.confirmKeys = keys;
    }-*/;
    
    public final native void setMaxTags(int maxTags) /*-{
        this.maxTags = maxTags;
    }-*/;

    public final native void setMaxChars(int maxChars) /*-{
        this.maxChars = maxChars;
    }-*/;
    
    public final native void setTrimValue(boolean trimValue) /*-{
        this.trimValue = trimValue;
    }-*/;
    
    public final native void setAllowDuplicates(boolean allowDuplicates) /*-{
        this.allowDuplicates = allowDuplicates;
    }-*/;
    
    public final native void setFocusClass(String focusClass) /*-{
        this.focusClass = focusClass;
    }-*/;
    
    public final native void setFreeInput(boolean freeInput) /*-{
        this.freeInput = freeInput;
    }-*/;
    
    public final native void setCancelConfirmKeysOnEmpty(boolean cancelConfirmKeysOnEmpty) /*-{
        this.cancelConfirmKeysOnEmpty = cancelConfirmKeysOnEmpty;
    }-*/;
    
    public final native void onTagExists(final OnTagExistsCallback<T> callback) /*-{
        this.onTagExists = function(item, tag) {
            callback.@org.gwtbootstrap3.extras.tagsinput.client.callback.OnTagExistsCallback::onTagExists(Ljava/lang/Object;Lcom/google/gwt/dom/client/Element;)(item, tag[0]);
        }
    }-*/;
}
