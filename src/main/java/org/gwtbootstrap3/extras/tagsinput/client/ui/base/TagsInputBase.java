package org.gwtbootstrap3.extras.tagsinput.client.ui.base;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

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
import org.gwtbootstrap3.extras.tagsinput.client.event.BeforeItemAddEvent;
import org.gwtbootstrap3.extras.tagsinput.client.event.BeforeItemAddHandler;
import org.gwtbootstrap3.extras.tagsinput.client.event.ItemAddedOnInitEvent;
import org.gwtbootstrap3.extras.tagsinput.client.event.ItemAddedOnInitHandler;
import org.gwtbootstrap3.extras.typeahead.client.base.CollectionDataset;
import org.gwtbootstrap3.extras.typeahead.client.base.Dataset;
import org.gwtbootstrap3.extras.typeahead.client.ui.Typeahead;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Wrapper for Bootstrap Tags Input component.
 *
 * @author Marko Nikolić <marko.nikolic@iten.rs>
 */
public class TagsInputBase<T> extends Widget implements HasAllTagsInputEvents {
    
    private TagsInputOptions options = TagsInputOptions.create();
    
    private Collection<? extends Dataset<T>> datasets;
    
    private Typeahead<T> typeahead;
    private ScheduledCommand attachTypeahead = new ScheduledCommand() {   
        @Override
        public void execute() {
            typeahead = new Typeahead<T>(input(), datasets);
            typeahead.reconfigure();
        }
    };
    
    
    public TagsInputBase() {
        this(new CollectionDataset<T>(Collections.<T>emptyList()));
    }

    public TagsInputBase(final Dataset<T> dataset) {
        this(Arrays.asList(dataset));
        
        setDatasets(dataset);
    }

    public TagsInputBase(final Collection<? extends Dataset<T>> datasets) {
        InputElement tagsInput = Document.get().createTextInputElement();
        tagsInput.setAttribute("data-role", "tagsinput");
        
        setElement(tagsInput);        
        
        setDatasets(datasets);
    }
    
    public void setDatasets(final Dataset<T> dataset) {
        this.datasets = Arrays.asList(dataset);
    }

    public void setDatasets(final Collection<? extends Dataset<T>> datasets) {
        this.datasets = datasets;
    }
    
    /**
     * Sets classname for the tags
     * 
     * @param tagClass Classname for the tags
     */
    public void setTagClass(final String tagClass) {
        options.setTagClass(tagClass);
    }

    /**
     * Array of keycodes which will add a tag when typing in the input.
     * (default: [13, 188], which are ENTER and comma)
     * 
     * @param confirmKeys Array of keycodes
     */
    public void setConfirmKeys(final List<Integer> confirmKeys) {
        JsArrayInteger keys = JsArrayInteger.createArray().cast();
        
        for(int key : confirmKeys) {
            keys.push(key);
        }
        options.setConfirmKeys(keys);
    }
    
    /**
     * When set, no more than the given number of tags are allowed to add (default: undefined).
     * When maxTags is reached, a class 'bootstrap-tagsinput-max' is placed on the tagsinput element.
     * 
     * @param maxTags max number of tags
     */
    public void setMaxTags(final int maxTags) {
        options.setMaxTags(maxTags);
    }
    
    /**
     * Defines the maximum length of a single tag. (default: undefined)
     * 
     * @param maxChars max number of chars
     */
    public void setMaxChars(final int maxChars) {
        options.setMaxChars(maxChars);
    }
    
    /**
     * When true, automatically removes all whitespace around tags. (default: false)
     * 
     * @param trimValue
     */
    public void setTrimValue(final boolean trimValue) {
        options.setTrimValue(trimValue);
    }
    
    /**
     * When true, the same tag can be added multiple times. (default: false)
     * 
     * @param allowDuplicates
     */
    public void setAllowDuplicaties(final boolean allowDuplicates) {
        options.setAllowDuplicates(allowDuplicates);
    }
    
    /**
     * When the input container has focus, the class specified by this config
     * option will be applied to the container.
     * 
     * @param focusClass classname
     */
    public void setFocusClass(final String focusClass) {
        options.setFocusClass(focusClass);
    }

    @Override
    public HandlerRegistration addItemAddedOnInitHandler(final ItemAddedOnInitHandler handler) {
        return addHandler(handler, ItemAddedOnInitEvent.getType());
    }
    
    @Override
    public HandlerRegistration addBeforeItemAddHandler(final BeforeItemAddHandler handler) {
        return addHandler(handler, BeforeItemAddEvent.getType());
    }
    
    public void reconfigure() {
        destroy();
        initialize(getElement(), options);

        // Deferred to make sure the tagsinput component creates <input> field
        // on which typeahead should attach.
        Scheduler.get().scheduleDeferred(attachTypeahead);
    }
    
    /**
     * Initialises tags input component with given options.
     * 
     * @param e tags input element
     * @param options tags input options
     */
    private native void initialize(Element e, JavaScriptObject options) /*-{
        var tagsInput = this;
        $wnd.jQuery(e).tagsinput(options);
        
        $wnd.jQuery(e).on(@org.gwtbootstrap3.extras.tagsinput.client.ui.base.HasAllTagsInputEvents::ITEM_ADDED_ON_INIT_EVENT, function(event) {
            @org.gwtbootstrap3.extras.tagsinput.client.event.ItemAddedOnInitEvent::fire(Lorg/gwtbootstrap3/extras/tagsinput/client/event/HasItemAddedOnInitHandlers;)(tagsInput);
        });

        $wnd.jQuery(e).on(@org.gwtbootstrap3.extras.tagsinput.client.ui.base.HasAllTagsInputEvents::BEFORE_ITEM_ADD_EVENT, function(event) {
            @org.gwtbootstrap3.extras.tagsinput.client.event.BeforeItemAddEvent::fire(Lorg/gwtbootstrap3/extras/tagsinput/client/event/HasBeforeItemAddHandlers;)(tagsInput);
        });
    }-*/;
    
    
    @Override
    protected void onLoad() {
        super.onLoad();

        // Deferred to make sure the tagsinput component creates <input> field
        // on which typeahead should attach.
        Scheduler.get().scheduleDeferred(attachTypeahead);
    }

    @Override
    protected void onUnload() {
        super.onUnload();
        
        command(getElement(), TagsInputCommand.DESTROY);
    }
    
    /**
     * Adds a tag
     * 
     * @param tag tag to add
     */
    public void add(String tag) {
        if (isAttached())
            add(getElement(), tag);
    }

    /**
     * Removes a tag
     * 
     * @param tag tag to remove
     */
    public void remove(String tag) {
        if (isAttached())
            remove(getElement(), tag);
    }
    
    /**
     * Removes all tags
     */
    public void removeAll() {
        if (isAttached())
            command(getElement(), TagsInputCommand.REMOVE_ALL);
    }
    
    /**
     * Sets focus in the tagsinput
     */
    public void focus() {
        if (isAttached())
            command(getElement(), TagsInputCommand.FOCUS);
    }

    /**
     * Returns the tagsinput's internal <input />, which is used for adding tags.
     */
    public Element input() {
        if (isAttached())
            return input(getElement());
        else
            return null;
    }
    
    /**
     * Refreshes the tags input UI.
     */
    public void refresh() {
        if (isAttached())
            command(getElement(), TagsInputCommand.REFRESH);
    }
    
    /**
     * Removes tagsinput behaviour
     */
    public void destroy() {
        if (isAttached())
            command(getElement(), TagsInputCommand.DESTROY);       
    }
    
    private native void command(Element e, String command)/*-{
        $wnd.jQuery(e).tagsinput(command);
    }-*/;

    private native void add(Element e, String tag) /*-{
        $wnd.jQuery(e).tagsinput('add', tag);
    }-*/;
    
    private native void remove(Element e, String tag) /*-{
        $wnd.jQuery(e).tagsinput('remove', tag);
    }-*/;
    
    private native Element input(Element e) /*-{
        return $wnd.jQuery(e).tagsinput('input');
    }-*/;
}
