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

import org.gwtbootstrap3.extras.tagsinput.client.ui.base.SingleValueTagsInput;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Tags input using objects for tags.
 *
 * @author Marko Nikolić <marko.nikolic@iten.rs>
 */
public class JOComplexTagsInput extends SingleValueTagsInput<JOComplexTag> {
    
    private static final String ITEM_VALUE_FIELD_NAME = "item_value";
    private static final String ITEM_TEXT_FIELD_NAME = "item_text"; 
    
    public JOComplexTagsInput() {
        setItemValue(ITEM_VALUE_FIELD_NAME);
        setItemText(ITEM_TEXT_FIELD_NAME);
    }

    public JOComplexTagsInput(JOComplexDataset dataset) {
        super(dataset);

        setItemValue(ITEM_VALUE_FIELD_NAME);
        setItemText(ITEM_TEXT_FIELD_NAME);
    }

    @Override
    protected JavaScriptObject toJSO(JOComplexTag tag) {
        return toJSO_native(tag);
    }
    
    private final native JavaScriptObject toJSO_native(JOComplexTag tag) /*-{
         var text = tag.@org.gwtbootstrap3.extras.tagsinput.client.ui.JOComplexTag::getText()();
         var value = tag.@org.gwtbootstrap3.extras.tagsinput.client.ui.JOComplexTag::getValue()();

         var result = { };
         result[@org.gwtbootstrap3.extras.tagsinput.client.ui.JOComplexTagsInput::ITEM_TEXT_FIELD_NAME] = text;
         result[@org.gwtbootstrap3.extras.tagsinput.client.ui.JOComplexTagsInput::ITEM_VALUE_FIELD_NAME] = value;
         
         return result;
    }-*/;

    @Override
    protected JOComplexTag toJO(JavaScriptObject tag) {
        JOComplexTag jo_tag = new JOComplexTag();
        
        jo_tag.setText(get_js_text(tag));
        jo_tag.setValue(get_js_value(tag));
        
        return jo_tag;
    }

    private final native String get_js_text(JavaScriptObject tag) /*-{
        return tag[@org.gwtbootstrap3.extras.tagsinput.client.ui.JOComplexTagsInput::ITEM_TEXT_FIELD_NAME];
    }-*/;

    private final native Integer get_js_value(JavaScriptObject tag) /*-{
        return tag[@org.gwtbootstrap3.extras.tagsinput.client.ui.JOComplexTagsInput::ITEM_VALUE_FIELD_NAME];
    }-*/;
}
