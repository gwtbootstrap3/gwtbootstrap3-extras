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
import com.google.gwt.dom.client.Element;
import org.gwtbootstrap3.client.ui.Div;

/**
 * Wrapper for the Summernote WYSIWYG Editor
 * <p/>
 * See: http://hackerwins.github.io/summernote/
 *
 * @author godi
 */
public class SummernoteBase extends Div {
    /**
     * Default settings
     */
    private int height = 100;
    private boolean hasFocus = false;
    private String code;
    private Toolbar toolbar = buildDefaultToolbar();

    public SummernoteBase() {
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setHasFocus(boolean hasFocus) {
        this.hasFocus = hasFocus;
    }

    public void setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the HTML code generated from the editor
     *
     * @return
     */
    public String getCode() {
        return getCode(getElement());
    }

    /**
     * Call this when updating settings to ensure everything is up to date
     */
    public void reconfigure() {
        initialize();
    }

    private Toolbar buildDefaultToolbar() {
        return new Toolbar().toggleAll(true);
    }

    private void initialize() {
        initialize(getElement(), height, hasFocus, toolbar.build());

        if (code != null) {
            setCode(getElement(), code);
        }
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        // TODO - still need to sink events - jgodi

        // Initialize
        initialize();
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        // Destroy
        destroy(getElement());
    }

    private native void initialize(Element e, int height, boolean hasFocus, JavaScriptObject toolbar) /*-{
        $wnd.jQuery(e).summernote({
            height: height,
            focus: hasFocus,
            toolbar: toolbar
        });
    }-*/;

    private native void destroy(Element e) /*-{
        $wnd.jQuery(e).destroy();
    }-*/;

    private native void setCode(Element e, String code) /*-{
        $wnd.jQuery(e).code(code);
    }-*/;

    private native String getCode(Element e)/*-{
        return $wnd.jQuery(e).code();
    }-*/;
}
