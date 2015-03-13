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
import com.google.gwt.user.client.Event;
import com.google.web.bindery.event.shared.HandlerRegistration;
import org.gwtbootstrap3.client.ui.TextArea;
import org.gwtbootstrap3.extras.summernote.client.event.*;

/**
 * Wrapper for the Summernote WYSIWYG Editor
 * <p/>
 * See: http://hackerwins.github.io/summernote/
 *
 * @author godi
 */
public class SummernoteBase extends TextArea {
    /**
     * Default settings
     */
    private int height = 100;
    private boolean hasFocus = false;
    private String code;
    private Toolbar toolbar = buildDefaultToolbar();

    public SummernoteBase() {
    }

    public void setHeight(final int height) {
        this.height = height;
    }

    public void setHasFocus(final boolean hasFocus) {
        this.hasFocus = hasFocus;
    }

    public void setToolbar(final Toolbar toolbar) {
        this.toolbar = toolbar;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public HandlerRegistration addInitializedHandler(final SummernoteInitializedHandler handler) {
        return addHandler(handler, SummernoteInitializedEvent.getType());
    }

    public HandlerRegistration addBlurHandler(final SummernoteOnBlurHandler handler) {
        return addHandler(handler, SummernoteOnBlurEvent.getType());
    }

    public HandlerRegistration addEnterHandler(final SummernoteOnEnterHandler handler) {
        return addHandler(handler, SummernoteOnEnterEvent.getType());
    }

    public HandlerRegistration addFocusHandler(final SummernoteOnFocusHandler handler) {
        return addHandler(handler, SummernoteOnFocusEvent.getType());
    }

    public HandlerRegistration addImageUploadHandler(final SummernoteOnImageUploadHandler handler) {
        return addHandler(handler, SummernoteOnImageUploadEvent.getType());
    }

    public HandlerRegistration addKeyDownHandler(final SummernoteOnKeyDownHandler handler) {
        return addHandler(handler, SummernoteOnKeyDownEvent.getType());
    }

    public HandlerRegistration addKeyUpHandler(final SummernoteOnKeyUpHandler handler) {
        return addHandler(handler, SummernoteOnKeyUpEvent.getType());
    }

    public HandlerRegistration addPasteHandler(final SummernoteOnPasteHandler handler) {
        return addHandler(handler, SummernoteOnPasteEvent.getType());
    }

    /**
     * Gets the HTML code generated from the editor
     *
     * @return generated code
     */
    public String getCode() {
        return getCode(getElement());
    }
    
    @Override
    public String getText() {
        return getCode(getElement());
    }
    
    @Override
    public void setText(String text) {
        setCode(getElement(), text);
    }

    /**
     * Call this when updating settings to ensure everything is up to date
     */
    public void reconfigure() {
        destroy(getElement());
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

        // Initialize
        initialize();
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        // Destroy
        destroy(getElement());
    }

    protected void onInitialize(final Event evt) {
        fireEvent(new SummernoteInitializedEvent(this, evt));
    }

    protected void onBlue(final Event evt) {
        fireEvent(new SummernoteOnBlurEvent(this, evt));
    }

    protected void onEnter(final Event evt) {
        fireEvent(new SummernoteOnEnterEvent(this, evt));
    }

    protected void onFocus(final Event evt) {
        fireEvent(new SummernoteOnFocusEvent(this, evt));
    }

    protected void onImageUpload(final Event evt) {
        fireEvent(new SummernoteOnImageUploadEvent(this, evt));
    }

    protected void onKeyUp(final Event evt) {
        fireEvent(new SummernoteOnKeyUpEvent(this, evt));
    }

    protected void onKeyDown(final Event evt) {
        fireEvent(new SummernoteOnKeyDownEvent(this, evt));
    }

    protected void onPaste(final Event evt) {
        fireEvent(new SummernoteOnPasteEvent(this, evt));
    }

    private native void initialize(Element e, int height, boolean hasFocus, JavaScriptObject toolbar) /*-{
        var target = this;

        $wnd.jQuery(e).summernote({
            height: height,
            focus: hasFocus,
            toolbar: toolbar,
            oninit: function (evt) {
                target.@org.gwtbootstrap3.extras.summernote.client.ui.base.SummernoteBase::onInitialize(Lcom/google/gwt/user/client/Event;)(evt);
            },
            onenter: function (evt) {
                target.@org.gwtbootstrap3.extras.summernote.client.ui.base.SummernoteBase::onEnter(Lcom/google/gwt/user/client/Event;)(evt);
            },
            onfocus: function (evt) {
                target.@org.gwtbootstrap3.extras.summernote.client.ui.base.SummernoteBase::onFocus(Lcom/google/gwt/user/client/Event;)(evt);
            },
            onblur: function (evt) {
                target.@org.gwtbootstrap3.extras.summernote.client.ui.base.SummernoteBase::onBlue(Lcom/google/gwt/user/client/Event;)(evt);
            },
            onkeyup: function (evt) {
                target.@org.gwtbootstrap3.extras.summernote.client.ui.base.SummernoteBase::onKeyUp(Lcom/google/gwt/user/client/Event;)(evt);
            },
            onkeydown: function (evt) {
                target.@org.gwtbootstrap3.extras.summernote.client.ui.base.SummernoteBase::onKeyDown(Lcom/google/gwt/user/client/Event;)(evt);
            },
            onImageUpload: function (evt) {
                target.@org.gwtbootstrap3.extras.summernote.client.ui.base.SummernoteBase::onImageUpload(Lcom/google/gwt/user/client/Event;)(evt);
            },
            onpaste: function (evt) {
                target.@org.gwtbootstrap3.extras.summernote.client.ui.base.SummernoteBase::onPaste(Lcom/google/gwt/user/client/Event;)(evt);
            }
        });
    }-*/;

    private native void destroy(Element e) /*-{
        $wnd.jQuery(e).destroy();
        $wnd.jQuery(e).off('oninit');
        $wnd.jQuery(e).off('onenter');
        $wnd.jQuery(e).off('onfocus');
        $wnd.jQuery(e).off('onkeydown');
        $wnd.jQuery(e).off('onblur');
        $wnd.jQuery(e).off('onkeyup');
        $wnd.jQuery(e).off('ononkeydowninit');
        $wnd.jQuery(e).off('onImageUpload');
        $wnd.jQuery(e).off('onpaste');
    }-*/;

    private native void setCode(Element e, String code) /*-{
        $wnd.jQuery(e).code(code);
    }-*/;

    private native String getCode(Element e)/*-{
        return $wnd.jQuery(e).code();
    }-*/;
}
