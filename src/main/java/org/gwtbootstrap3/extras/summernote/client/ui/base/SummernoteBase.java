package org.gwtbootstrap3.extras.summernote.client.ui.base;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2015 GwtBootstrap3
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

import org.gwtbootstrap3.client.ui.html.Div;
import org.gwtbootstrap3.extras.summernote.client.event.HasAllSummernoteHandlers;
import org.gwtbootstrap3.extras.summernote.client.event.SummernoteBlurEvent;
import org.gwtbootstrap3.extras.summernote.client.event.SummernoteBlurHandler;
import org.gwtbootstrap3.extras.summernote.client.event.SummernoteChangeEvent;
import org.gwtbootstrap3.extras.summernote.client.event.SummernoteChangeHandler;
import org.gwtbootstrap3.extras.summernote.client.event.SummernoteEnterEvent;
import org.gwtbootstrap3.extras.summernote.client.event.SummernoteEnterHandler;
import org.gwtbootstrap3.extras.summernote.client.event.SummernoteFocusEvent;
import org.gwtbootstrap3.extras.summernote.client.event.SummernoteFocusHandler;
import org.gwtbootstrap3.extras.summernote.client.event.SummernoteImageUploadEvent;
import org.gwtbootstrap3.extras.summernote.client.event.SummernoteImageUploadEvent.ImageFile;
import org.gwtbootstrap3.extras.summernote.client.event.SummernoteImageUploadHandler;
import org.gwtbootstrap3.extras.summernote.client.event.SummernoteInitEvent;
import org.gwtbootstrap3.extras.summernote.client.event.SummernoteInitHandler;
import org.gwtbootstrap3.extras.summernote.client.event.SummernoteKeyDownEvent;
import org.gwtbootstrap3.extras.summernote.client.event.SummernoteKeyDownHandler;
import org.gwtbootstrap3.extras.summernote.client.event.SummernoteKeyUpEvent;
import org.gwtbootstrap3.extras.summernote.client.event.SummernoteKeyUpHandler;
import org.gwtbootstrap3.extras.summernote.client.event.SummernotePasteEvent;
import org.gwtbootstrap3.extras.summernote.client.event.SummernotePasteHandler;
import org.gwtbootstrap3.extras.summernote.client.ui.SummernoteLanguage;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.UIObject;

/**
 * Wrapper for the Summernote WYSIWYG Editor
 * <p/>
 * See: http://summernote.org/
 *
 * @author Xiaodong Sun
 */
public class SummernoteBase extends Div implements HasAllSummernoteHandlers {

    /**
     * Language; defaults to {@link SummernoteLanguage#EN_US}
     */
    private SummernoteLanguage language = SummernoteLanguage.EN_US;

    /**
     * Initialize options
     */
    private SummernoteOptions options = SummernoteOptions.newOptions();

    private boolean hasInitHandler = false;
    private boolean hasEnterHandler = false;
    private boolean hasFocusHandler = false;
    private boolean hasBlurHandler = false;
    private boolean hasKeyUpHandler = false;
    private boolean hasKeyDownHandler = false;
    private boolean hasPasteHandler = false;
    private boolean hasUploadImageHandler = false;
    private boolean hasChangeHandler = false;

    /**
     *
     */
    public SummernoteBase() {}

    /**
     * Sets the default height of the editor (in pixel).<br>
     * <br>
     * <b>Note</b>: DO NOT renamed this method to <em>setHeight</em>
     * to avoid UiBinder name clash with {@link UIObject#setHeight(String)}.
     *
     * @param height
     */
    public void setDefaultHeight(final int height) {
        options.setHeight(height);
    }

    /**
     * If <code>false</code> the toolbar will be hidden.<br>
     * <br>
     * Defaults to <code>true</code>.
     *
     * @param showToolbar
     */
    public void setShowToolbar(final boolean showToolbar) {
        options.setShowToolbar(showToolbar);
    }

    /**
     * Customizes the toolbar.<br>
     * <br>
     * Example:
     * <pre>
     * summernote.setToolbar(new Toolbar()
     *     .addGroup(ToolbarButton.OL, ToolbarButton.BOLD)
     *     .addGroup(ToolbarButton.HELP));
     * </pre>
     *
     * @param toolbar
     */
    public void setToolbar(final Toolbar toolbar) {
        options.setToolbar(toolbar);
    }

    /**
     * Set the focus of the editor.
     *
     * @param focus if <code>true</code>, focus on the editor
     */
    public void setHasFocus(final boolean focus) {
        options.setFocus(focus);
    }

    /**
     * Set placeholder of the editor.
     *
     * @param placeholder placeholder of the editor
     */
    public void setPlaceholder(final String placeholder) {
        options.setPlaceholder(placeholder);
    }

    /**
     * Set the air mode of the editor. Air-mode gives clearer interface with
     * hidden toolbar. To reveal toolbar, select a text where you want to
     * shape up.<br>
     * <br>
     * Defaults to <code>false</code>.
     *
     * @param airMode if <code>true</code>, the air mode is turn on
    */
    public void setAirMode(final boolean airMode) {
        options.setAirMode(airMode);
    }

    /**
     * Set <code>false</code> to disable custom shortcuts.<br>
     * <br>
     * Defaults to <code>true</code>.
     *
     * @param shortcuts if <code>false</code>, disable custom shortcuts
     */
    public void setShortcuts(final boolean shortcuts) {
        options.setShortcuts(shortcuts);
    }

    /**
     * Set <code>true</code> to disable drag and drop. Defaults to <code>false</code>.
     *
     * @param disableDragAndDrop if <code>true</code>, disable drag and drop
     */
    public void setDisableDragAndDrop(final boolean disableDragAndDrop) {
        options.setDisableDragAndDrop(disableDragAndDrop);
    }

    /**
     * Summernote support hint (autocomplete) feature. You can define custom hint
     * with options.
     *
     * @param matchRegexp
     * @param hintHandler
     */
    public void setHint(String matchRegexp, HintHandler hintHandler) {
        options.setHint(matchRegexp, hintHandler);
    }

    /**
     * Set the editor language.
     *
     * @param language supported editor language
     */
    public void setLanguage(final SummernoteLanguage language) {
        options.setLanguage(language);
        this.language = language;
    }

    /**
     * Returns the editor language.
     *
     * @return
     */
    public SummernoteLanguage getLanguage() {
        return language;
    }

    @Override
    public HandlerRegistration addSummernoteInitHandler(final SummernoteInitHandler handler) {
        hasInitHandler = true;
        return addHandler(handler, SummernoteInitEvent.getType());
    }

    @Override
    public HandlerRegistration addSummernoteEnterHandler(final SummernoteEnterHandler handler) {
        hasEnterHandler = true;
        return addHandler(handler, SummernoteEnterEvent.getType());
    }

    @Override
    public HandlerRegistration addSummernoteFocusHandler(final SummernoteFocusHandler handler) {
        hasFocusHandler = true;
        return addHandler(handler, SummernoteFocusEvent.getType());
    }

    @Override
    public HandlerRegistration addSummernoteBlurHandler(final SummernoteBlurHandler handler) {
        hasBlurHandler = true;
        return addHandler(handler, SummernoteBlurEvent.getType());
    }

    @Override
    public HandlerRegistration addSummernoteKeyUpHandler(final SummernoteKeyUpHandler handler) {
        hasKeyUpHandler = true;
        return addHandler(handler, SummernoteKeyUpEvent.getType());
    }

    @Override
    public HandlerRegistration addSummernoteKeyDownHandler(final SummernoteKeyDownHandler handler) {
        hasKeyDownHandler = true;
        return addHandler(handler, SummernoteKeyDownEvent.getType());
    }

    @Override
    public HandlerRegistration addSummernotePasteHandler(final SummernotePasteHandler handler) {
        hasPasteHandler = true;
        return addHandler(handler, SummernotePasteEvent.getType());
    }

    @Override
    public HandlerRegistration addSummernoteImageUploadHandler(final SummernoteImageUploadHandler handler) {
        hasUploadImageHandler = true;
        return addHandler(handler, SummernoteImageUploadEvent.getType());
    }

    @Override
    public HandlerRegistration addSummernoteChangeHandler(final SummernoteChangeHandler handler) {
        hasChangeHandler = true;
        return addHandler(handler, SummernoteChangeEvent.getType());
    }

    /**
     * Gets the HTML code generated from the editor
     *
     * @return generated code
     */
    public String getCode() {
        if (isAttached()) {
            return getCode(getElement());
        }
        return getElement().getInnerHTML();
    }

    /**
     * Sets the given HTML code to the editor.
     *
     * @param code
     */
    public void setCode(final String code) {
        if (isAttached()) {
            setCode(getElement(), code);
        } else {
            getElement().setInnerHTML(code);
        }
    }

    /**
     * Returns <code>true</code> if the content is empty.<br>
     * <br>
     * Editing area needs <code>&lt;p&gt;&lt;br&gt;&lt;/p&gt;</code></code>
     * for focus, even if contents is empty. So summernote supports this method
     * for helping to check contents is empty.
     *
     * @return <code>true</code> if the editor is empty
     */
    public boolean isEmpty() {
        if (isAttached()) {
            return isEmpty(getElement());
        }
        return getElement().getInnerHTML().isEmpty();
    }

    /**
     * Call this when updating options to ensure everything is up to date
     */
    public void reconfigure() {
        destroy(getElement());
        initialize();
    }

    private void initialize() {
        // Inject the language JS is necessary
        if (language.getJs() != null) {
            ScriptInjector.fromString(language.getJs().getText())
            	.setWindow(ScriptInjector.TOP_WINDOW).inject();
        }
        // Initialize
        initialize(getElement(), options);
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

    /**
     * Inserts the given images to the editor.<br>
     * <br>
     * This method should be used only when you customize
     * the image upload handler.
     *
     * @param images
     */
    public void insertImages(JsArray<ImageFile> images) {
        insertImages(getElement(), images);
    }

    private native void initialize(Element e, SummernoteOptions options) /*-{
        var target = this;
        options.callbacks = {};
        if (this.@org.gwtbootstrap3.extras.summernote.client.ui.base.SummernoteBase::hasInitHandler) {
            options.callbacks.onInit = function() {
                @org.gwtbootstrap3.extras.summernote.client.event.SummernoteInitEvent::fire(Lorg/gwtbootstrap3/extras/summernote/client/event/HasSummernoteInitHandlers;)(target);
            };
        }
        if (this.@org.gwtbootstrap3.extras.summernote.client.ui.base.SummernoteBase::hasEnterHandler) {
            options.callbacks.onEnter = function () {
                @org.gwtbootstrap3.extras.summernote.client.event.SummernoteEnterEvent::fire(Lorg/gwtbootstrap3/extras/summernote/client/event/HasSummernoteEnterHandlers;)(target);
            };
        }
        if (this.@org.gwtbootstrap3.extras.summernote.client.ui.base.SummernoteBase::hasFocusHandler) {
            options.callbacks.onFocus = function() {
                @org.gwtbootstrap3.extras.summernote.client.event.SummernoteFocusEvent::fire(Lorg/gwtbootstrap3/extras/summernote/client/event/HasSummernoteFocusHandlers;)(target);
            };
        }
        if (this.@org.gwtbootstrap3.extras.summernote.client.ui.base.SummernoteBase::hasBlurHandler) {
            options.callbacks.onBlur = function() {
                @org.gwtbootstrap3.extras.summernote.client.event.SummernoteBlurEvent::fire(Lorg/gwtbootstrap3/extras/summernote/client/event/HasSummernoteBlurHandlers;)(target);
            };
        }
        if (this.@org.gwtbootstrap3.extras.summernote.client.ui.base.SummernoteBase::hasKeyUpHandler) {
            options.callbacks.onKeyup = function(e) {
                @org.gwtbootstrap3.extras.summernote.client.event.SummernoteKeyUpEvent::fire(Lorg/gwtbootstrap3/extras/summernote/client/event/HasSummernoteKeyUpHandlers;Lcom/google/gwt/dom/client/NativeEvent;)(target, e.originalEvent);
            };
        }
        if (this.@org.gwtbootstrap3.extras.summernote.client.ui.base.SummernoteBase::hasKeyDownHandler) {
            options.callbacks.onKeydown = function(e) {
                @org.gwtbootstrap3.extras.summernote.client.event.SummernoteKeyDownEvent::fire(Lorg/gwtbootstrap3/extras/summernote/client/event/HasSummernoteKeyDownHandlers;Lcom/google/gwt/dom/client/NativeEvent;)(target, e.originalEvent);
            };
        }
        if (this.@org.gwtbootstrap3.extras.summernote.client.ui.base.SummernoteBase::hasUploadImageHandler) {
            options.callbacks.onImageUpload = function(files) {
                @org.gwtbootstrap3.extras.summernote.client.event.SummernoteImageUploadEvent::fire(Lorg/gwtbootstrap3/extras/summernote/client/event/HasSummernoteImageUploadHandlers;Lcom/google/gwt/core/client/JsArray;)(target, files);
            };
        }
        if (this.@org.gwtbootstrap3.extras.summernote.client.ui.base.SummernoteBase::hasPasteHandler) {
            options.callbacks.onPaste = function() {
                @org.gwtbootstrap3.extras.summernote.client.event.SummernotePasteEvent::fire(Lorg/gwtbootstrap3/extras/summernote/client/event/HasSummernotePasteHandlers;)(target);
            };
        }
        if (this.@org.gwtbootstrap3.extras.summernote.client.ui.base.SummernoteBase::hasChangeHandler) {
            options.callbacks.onChange = function() {
                @org.gwtbootstrap3.extras.summernote.client.event.SummernoteChangeEvent::fire(Lorg/gwtbootstrap3/extras/summernote/client/event/HasSummernoteChangeHandlers;)(target);
            };
        }
        $wnd.jQuery(e).summernote(options);
    }-*/;

    private native void destroy(Element e) /*-{
        $wnd.jQuery(e).summernote('destroy');
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.summernote.client.event.HasAllSummernoteHandlers::SUMMERNOTE_INIT_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.summernote.client.event.HasAllSummernoteHandlers::SUMMERNOTE_ENTER_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.summernote.client.event.HasAllSummernoteHandlers::SUMMERNOTE_FOCUS_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.summernote.client.event.HasAllSummernoteHandlers::SUMMERNOTE_BLUR_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.summernote.client.event.HasAllSummernoteHandlers::SUMMERNOTE_KEYUP_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.summernote.client.event.HasAllSummernoteHandlers::SUMMERNOTE_KEYDOWN_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.summernote.client.event.HasAllSummernoteHandlers::SUMMERNOTE_PASTE_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.summernote.client.event.HasAllSummernoteHandlers::SUMMERNOTE_IMAGE_UPLOAD_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.summernote.client.event.HasAllSummernoteHandlers::SUMMERNOTE_CHANGE_EVENT);
    }-*/;

    private native void setCode(Element e, String code) /*-{
        $wnd.jQuery(e).summernote('code', code);
    }-*/;

    private native String getCode(Element e)/*-{
        return $wnd.jQuery(e).summernote('code');
    }-*/;

    private native boolean isEmpty(Element e)/*-{
        return $wnd.jQuery(e).summernote('isEmpty');
    }-*/;

    private native void insertImages(Element e, JsArray<ImageFile> images) /*-{
        $wnd.jQuery(e).summernote('insertImages', images);
    }-*/;
}
