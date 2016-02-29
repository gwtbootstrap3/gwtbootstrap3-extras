package org.gwtbootstrap3.extras.tagsinput.client.ui.base;

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

import java.util.List;

import org.gwtbootstrap3.client.ui.gwt.Widget;

import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.InputElement;

/**
 * Wrapper for Bootstrap Tags Input component.
 *
 * @author Marko Nikolić <marko.nikolic@iten.rs>
 */
public class TagsInputBase extends Widget {

    private JsArrayString suggestions = (JsArrayString) JsArrayString.createArray();
    
    public TagsInputBase() {
        InputElement tagsInput = Document.get().createTextInputElement();
        tagsInput.setAttribute("data-role", "tagsinput");

        setElement(tagsInput);
    }

    public native void setTagClass(String className) /*-{
        var e = this.@org.gwtbootstrap3.extras.tagsinput.client.ui.base.TagsInputBase::getElement()();
        $wnd.jQuery(e).tagsinput({
          tagClass: className
        });
    }-*/;
    
    public native void setMaxTags(Integer maxTagsNo) /*-{
        var e = this.@org.gwtbootstrap3.extras.tagsinput.client.ui.base.TagsInputBase::getElement()();
        $wnd.jQuery(e).tagsinput({
          maxTags: maxTagsNo
        });
    }-*/;
    
    public native void setMaxChars(Integer maxCharsNo) /*-{
        var e = this.@org.gwtbootstrap3.extras.tagsinput.client.ui.base.TagsInputBase::getElement()();
        $wnd.jQuery(e).tagsinput({
          maxChars: maxCharsNo
        });
    }-*/;

    public native void setTrimValue(String trimValueEnabled) /*-{
        var e = this.@org.gwtbootstrap3.extras.tagsinput.client.ui.base.TagsInputBase::getElement()();
        $wnd.jQuery(e).tagsinput({
          trimValue: trimValueEnabled
        });
    }-*/;
    
    public native void setAllowDuplicates(String allowDuplicatesEnabled) /*-{
        var e = this.@org.gwtbootstrap3.extras.tagsinput.client.ui.base.TagsInputBase::getElement()();
        $wnd.jQuery(e).tagsinput({
          allowDuplicates: allowDuplicatesEnabled
        });
    }-*/;
    
    public native void setFocusClass(String focusClassName) /*-{
        var e = this.@org.gwtbootstrap3.extras.tagsinput.client.ui.base.TagsInputBase::getElement()();
        $wnd.jQuery(e).tagsinput({
          focusClass: focusClassName
        });
    }-*/;
    
    
    @Override
    protected void onLoad() {
        super.onLoad();
        configureTypeahead();
    }

    private native void configureTypeahead() /*-{
        var e = this.@org.gwtbootstrap3.extras.tagsinput.client.ui.base.TagsInputBase::getElement()();
    
        var substringMatcher = function(strs) {
          return function findMatches(q, cb) {
            var matches, substringRegex;
        
            // an array that will be populated with substring matches
            matches = [];
        
            // regex used to determine if a string contains the substring `q`
            substrRegex = new RegExp(q, 'i');
        
            // iterate through the pool of strings and for any string that
            // contains the substring `q`, add it to the `matches` array
            $wnd.$.each(strs, function(i, str) {
              if (substrRegex.test(str)) {
                matches.push(str);
              }
            });
        
            cb(matches);
          };
        };

        $wnd.jQuery(e).tagsinput({
          typeaheadjs: {
            name: 'test',
            displayKey: function(str) { return str; },
            source: substringMatcher(this.@org.gwtbootstrap3.extras.tagsinput.client.ui.base.TagsInputBase::suggestions)
          }
        });
    }-*/;
    
    public void setTypeahead(List<String> typeahead) {
        suggestions.setLength(0);
        for(String str : typeahead) {
            suggestions.push(str);
        }
    }
    
    public native void add(String tag) /*-{
        var e = this.@org.gwtbootstrap3.extras.tagsinput.client.ui.base.TagsInputBase::getElement()();
        $wnd.jQuery(e).tagsinput('add', tag);
    }-*/;
    
    public native void remove(String tag) /*-{
        var e = this.@org.gwtbootstrap3.extras.tagsinput.client.ui.base.TagsInputBase::getElement()();
        $wnd.jQuery(e).tagsinput('remove', tag);
    }-*/;
    
    public native void removeAll() /*-{
        var e = this.@org.gwtbootstrap3.extras.tagsinput.client.ui.base.TagsInputBase::getElement()();
        $wnd.jQuery(e).tagsinput('removeAll');
    }-*/;

    public native void focus() /*-{
        var e = this.@org.gwtbootstrap3.extras.tagsinput.client.ui.base.TagsInputBase::getElement()();
        $wnd.jQuery(e).tagsinput('focus');
    }-*/;

    public native void refresh() /*-{
        var e = this.@org.gwtbootstrap3.extras.tagsinput.client.ui.base.TagsInputBase::getElement()();
        $wnd.jQuery(e).tagsinput('refresh');
    }-*/;
}
