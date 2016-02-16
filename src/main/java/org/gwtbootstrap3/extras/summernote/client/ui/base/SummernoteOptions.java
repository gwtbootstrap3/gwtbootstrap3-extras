package org.gwtbootstrap3.extras.summernote.client.ui.base;

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
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.core.client.JsArrayString;

/**
 * This class represents Summernote options, that you can use to
 * customize the editor.
 *
 * @author Xiaodong SUN
 */
class SummernoteOptions extends JavaScriptObject {

    /**
     * Default constructor
     */
    protected SummernoteOptions() {}

    /**
     * Creates a new instance of {@link SummernoteOptions}.
     *
     * @return a new instance of {@link SummernoteOptions}.
     */
    static SummernoteOptions newOptions() {
        return JavaScriptObject.createObject().cast();
    }

    /**
     * @see {@link SummernoteBase#setPlaceholder(String)}
     */
    final native void setPlaceholder(String placeholder) /*-{
        this.placeholder = placeholder;
    }-*/;

    /**
     * @see {@link SummernoteBase#setFontNames(boolean)}
     */
    final native void setFontNames(JsArrayString fontNames) /*-{
        this.fontNames = fontNames;
    }-*/;

    /**
     * @see {@link SummernoteBase#setFontNamesIgnoreCheck(boolean)}
     */
    final native void setFontNamesIgnoreCheck(JsArrayString fontNamesIgnoreCheck) /*-{
        this.fontNamesIgnoreCheck = fontNamesIgnoreCheck;
    }-*/;

    /**
     * @see {@link SummernoteBase#setDialogsInBody(boolean)}
     */
    final native void setDialogsInBody(boolean dialogsInBody) /*-{
        this.dialogsInBody = dialogsInBody;
    }-*/;

    /**
     * @see {@link SummernoteBase#setDialogsFade(boolean)}
     */
    final native void setDialogsFade(boolean dialogsFade) /*-{
        this.dialogsFade = dialogsFade;
    }-*/;

    /**
     * @see {@link SummernoteBase#setDisableDragAndDrop(boolean)}
     */
    final native void setDisableDragAndDrop(boolean disableDragAndDrop) /*-{
        this.disableDragAndDrop = disableDragAndDrop;
    }-*/;

    /**
     * @see {@link SummernoteBase#setShortcuts(boolean)}
     */
    final native void setShortcuts(boolean shortcuts) /*-{
        this.shortcuts = shortcuts;
    }-*/;

    /**
     * @see {@link SummernoteBase#setShowToolbar(boolean)}
     */
    final native void setShowToolbar(boolean showToolbar) /*-{
        if (!showToolbar)
            this.toolbar = false;
        else if (this.toolbar)
            delete this.toolbar;
    }-*/;

    /**
     * Creates a new toolbar group.
     *
     * @param name
     * @param buttons
     * @return
     */
    static final JsArrayMixed newToolbarGroup(String name, ToolbarButton... buttons) {
        JsArrayString arr = JavaScriptObject.createArray().cast();
        for (ToolbarButton button : buttons) {
            arr.push(button.getId());
        }
        return getToolbarGroup(name, arr);
    }

    private static final native JsArrayMixed getToolbarGroup(String name, JsArrayString buttons) /*-{
        return [name, buttons];
    }-*/;

    /**
     * Builds the toolbar.
     *
     * @param toolbarGroups
     * @return
     */
    static final native JsArrayMixed buildToolbar(JsArrayMixed... toolbarGroups) /*-{
        var arr = [];
        for (var i = 0; i < toolbarGroups.length; i++) {
            arr.push(toolbarGroups[i]);
        }
        return arr;
    }-*/;

    /**
     * @see {@link SummernoteBase#setToolbar(Toolbar)}
     */
    final native void setToolbar(Toolbar toolbar) /*-{
        this.toolbar = toolbar.@org.gwtbootstrap3.extras.summernote.client.ui.base.Toolbar::build()();
    }-*/;

    /**
     * @see {@link SummernoteBase#setDefaultHeight(int)}
     */
    final native void setHeight(int height) /*-{
        this.height = height;
    }-*/;

    /**
     * @see {@link SummernoteBase#setMaxHeight(int)}
     */
    final native void setMaxHeight(int maxHeight) /*-{
        this.maxHeight = maxHeight;
    }-*/;

    /**
     * @see {@link SummernoteBase#setMinHeight(int)}
     */
    final native void setMinHeight(int minHeight) /*-{
        this.minHeight = minHeight;
    }-*/;

    /**
     * @see {@link SummernoteBase#setHasFocus(boolean)}
     */
    final native void setFocus(boolean focus) /*-{
        this.focus = focus;
    }-*/;

    /**
     * @see {@link SummernoteBase#setLanguage(SummernoteLanguage)}
     */
    final native void setLanguage(SummernoteLanguage language) /*-{
        this.lang = language.@org.gwtbootstrap3.extras.summernote.client.ui.base.SummernoteLanguage::getCode()();
    }-*/;

    /**
     * @see {@link SummernoteBase#setAirMode(boolean)}
     */
    final native void setAirMode(boolean airMode) /*-{
        this.airMode = airMode;
    }-*/;

    /**
     * @see {@link SummernoteBase#setHint(String, HintHandler)}
     */
    final native void setHint(String match, HintHandler searchHandler) /*-{
        this.hint = {
            match: new RegExp(match),
            search: function (keyword, callback) {
                var items = searchHandler.@org.gwtbootstrap3.extras.summernote.client.ui.base.HintHandler::onSearch(Ljava/lang/String;)(keyword);
                var result = [];
                for (var i = 0; i < items.length; i++) {
                    result.push(items[i]);
                }
                callback(result);
            },
            template: function (item) {
                return searchHandler.@org.gwtbootstrap3.extras.summernote.client.ui.base.HintHandler::getTemplate(Ljava/lang/String;)(item);
            },
            content: function (item) {
                return searchHandler.@org.gwtbootstrap3.extras.summernote.client.ui.base.HintHandler::getContent(Ljava/lang/String;)(item);
            }
        };
    }-*/;

}
