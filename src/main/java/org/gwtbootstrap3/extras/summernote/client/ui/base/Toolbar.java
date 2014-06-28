package org.gwtbootstrap3.extras.summernote.client.ui.base;

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
import com.google.gwt.core.client.JsArray;

/**
 * Custom toolbar builder for the summernote editor
 * <p/>
 * See: http://hackerwins.github.io/summernote/
 *
 * @author godi
 */
public class Toolbar {
    private static final String STYLE = "style";
    private static final String FONT_SIZE = "fontsize";
    private static final String COLOR = "color";
    private static final String PARA = "para";
    private static final String HEIGHT = "height";
    private static final String INSERT = "insert";
    private static final String TABLE = "table";
    private static final String VIEW = "view";
    private static final String HELP = "help";
    private static final String BOLD = "bold";
    private static final String ITALIC = "italic";
    private static final String UNDERLINE = "underline";
    private static final String CLEAR = "clear";
    private static final String UL = "ul";
    private static final String OL = "ol";
    private static final String PARAGRAPH = "paragraph";
    private static final String PICTURE = "picture";
    private static final String LINK = "link";
    private static final String VIDEO = "video";
    private static final String FULL_SCREEN = "fullscreen";
    private static final String CODE_VIEW = "codeview";

    private boolean showStyleButton;
    private boolean showBoldButton;
    private boolean showItalicButton;
    private boolean showUnderlineButton;
    private boolean showClearButton;
    private boolean showFontSizeButton;
    private boolean showColorButton;
    private boolean showUnorderedListButton;
    private boolean showOrderedListButton;
    private boolean showParagraphButton;
    private boolean showLineHeightButton;
    private boolean showInsertPictureButton;
    private boolean showInsertLinkButton;
    private boolean showInsertTableButton;
    private boolean showInsertVideoButton;
    private boolean showFullScreenButton;
    private boolean showCodeViewButton;
    private boolean showHelpButton;

    public Toolbar setShowStyleButton(final boolean showStyleButton) {
        this.showStyleButton = showStyleButton;
        return this;
    }

    public Toolbar setShowBoldButton(final boolean showBoldButton) {
        this.showBoldButton = showBoldButton;
        return this;
    }

    public Toolbar setShowItalicButton(final boolean showItalicButton) {
        this.showItalicButton = showItalicButton;
        return this;
    }

    public Toolbar setShowUnderlineButton(final boolean showUnderlineButton) {
        this.showUnderlineButton = showUnderlineButton;
        return this;
    }

    public Toolbar setShowClearButton(final boolean showClearButton) {
        this.showClearButton = showClearButton;
        return this;
    }

    public Toolbar setShowFontSizeButton(final boolean showFontSizeButton) {
        this.showFontSizeButton = showFontSizeButton;
        return this;
    }

    public Toolbar setShowColorButton(final boolean showColorButton) {
        this.showColorButton = showColorButton;
        return this;
    }

    public Toolbar setShowUnorderedListButton(final boolean showUnorderedListButton) {
        this.showUnorderedListButton = showUnorderedListButton;
        return this;
    }

    public Toolbar setShowOrderedListButton(final boolean showOrderedListButton) {
        this.showOrderedListButton = showOrderedListButton;
        return this;
    }

    public Toolbar setShowParagraphButton(final boolean showParagraphButton) {
        this.showParagraphButton = showParagraphButton;
        return this;
    }

    public Toolbar setShowLineHeightButton(final boolean showLineHeightButton) {
        this.showLineHeightButton = showLineHeightButton;
        return this;
    }

    public Toolbar setShowInsertPictureButton(final boolean showInsertPictureButton) {
        this.showInsertPictureButton = showInsertPictureButton;
        return this;
    }

    public Toolbar setShowInsertLinkButton(final boolean showInsertLinkButton) {
        this.showInsertLinkButton = showInsertLinkButton;
        return this;
    }

    public Toolbar setShowInsertTableButton(final boolean showInsertTableButton) {
        this.showInsertTableButton = showInsertTableButton;
        return this;
    }

    public Toolbar setShowHelpButton(final boolean showHelpButton) {
        this.showHelpButton = showHelpButton;
        return this;
    }

    public Toolbar setShowInsertVideoButton(final boolean showInsertVideoButton) {
        this.showInsertVideoButton = showInsertVideoButton;
        return this;
    }

    public Toolbar setShowFullScreenButton(final boolean showFullScreenButton) {
        this.showFullScreenButton = showFullScreenButton;
        return this;
    }

    public Toolbar setShowCodeViewButton(final boolean showCodeViewButton) {
        this.showCodeViewButton = showCodeViewButton;
        return this;
    }

    /**
     * Quick toggle to use everything or nothing
     *
     * @param visible toggle visible
     * @return Toolbar
     */
    public Toolbar toggleAll(final boolean visible) {
        showStyleButton = visible;
        showBoldButton = visible;
        showItalicButton = visible;
        showUnderlineButton = visible;
        showClearButton = visible;
        showFontSizeButton = visible;
        showColorButton = visible;
        showUnorderedListButton = visible;
        showOrderedListButton = visible;
        showParagraphButton = visible;
        showLineHeightButton = visible;
        showInsertPictureButton = visible;
        showInsertLinkButton = visible;
        showInsertTableButton = visible;
        showInsertVideoButton = visible;
        showCodeViewButton = visible;
        showFullScreenButton = visible;
        showHelpButton = visible;
        return this;
    }

    public JsArray build() {
        final JsArray array = JavaScriptObject.createArray().cast();

        buildArray(showStyleButton, array, STYLE);
        buildStyles(array);
        buildArray(showFontSizeButton, array, FONT_SIZE);
        buildArray(showColorButton, array, COLOR);
        buildPara(array);
        buildArray(showLineHeightButton, array, HEIGHT);
        buildInsert(array);
        buildArray(showInsertTableButton, array, TABLE);
        buildView(array);
        buildArray(showHelpButton, array, HELP);

        return array;
    }

    private void buildArray(final boolean toggle, final JsArray array, final String value) {
        if (toggle) {
            array.push(toJSArray(value, toValueArray(value)));
        }
    }

    private void addToValueArray(final boolean toggle, final JavaScriptObject object, final String value) {
        if (toggle) {
            pushToValueArray(object, value);
        }
    }

    private void buildView(final JsArray array) {
        final JsArray view = JavaScriptObject.createArray().cast();

        addToValueArray(showFullScreenButton, view, FULL_SCREEN);
        addToValueArray(showCodeViewButton, view, CODE_VIEW);

        if (!view.toString().isEmpty()) {
            array.push(toJSArray(VIEW, view));
        }
    }

    private void buildInsert(final JsArray array) {
        final JsArray insert = JavaScriptObject.createArray().cast();

        addToValueArray(showInsertPictureButton, insert, PICTURE);
        addToValueArray(showInsertLinkButton, insert, LINK);
        addToValueArray(showInsertVideoButton, insert, VIDEO);

        if (!insert.toString().isEmpty()) {
            array.push(toJSArray(INSERT, insert));
        }
    }

    private void buildPara(final JsArray array) {
        final JsArray para = JavaScriptObject.createArray().cast();

        addToValueArray(showUnorderedListButton, para, UL);
        addToValueArray(showOrderedListButton, para, OL);
        addToValueArray(showParagraphButton, para, PARAGRAPH);

        if (!para.toString().isEmpty()) {
            array.push(toJSArray(PARA, para));
        }
    }

    private void buildStyles(final JsArray array) {
        final JsArray styles = JavaScriptObject.createArray().cast();

        addToValueArray(showBoldButton, styles, BOLD);
        addToValueArray(showItalicButton, styles, ITALIC);
        addToValueArray(showUnderlineButton, styles, UNDERLINE);
        addToValueArray(showClearButton, styles, CLEAR);

        if (!styles.toString().isEmpty()) {
            array.push(toJSArray(STYLE, styles));
        }
    }

    private native JavaScriptObject toJSArray(String key, JavaScriptObject value)/*-{
        return [key, value];
    }-*/;

    private native JavaScriptObject toValueArray(String value1)/*-{
        return [value1];
    }-*/;

    private native void pushToValueArray(JavaScriptObject object, String value)/*-{
        object.push(value);
    }-*/;
}

