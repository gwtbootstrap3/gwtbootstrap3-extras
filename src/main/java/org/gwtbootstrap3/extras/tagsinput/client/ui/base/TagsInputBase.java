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


import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.gwtbootstrap3.client.ui.base.mixin.AttributeMixin;
import org.gwtbootstrap3.client.ui.gwt.Widget;
import org.gwtbootstrap3.extras.tagsinput.client.event.BeforeItemAddEvent;
import org.gwtbootstrap3.extras.tagsinput.client.event.BeforeItemAddHandler;
import org.gwtbootstrap3.extras.tagsinput.client.event.BeforeItemRemoveEvent;
import org.gwtbootstrap3.extras.tagsinput.client.event.BeforeItemRemoveHandler;
import org.gwtbootstrap3.extras.tagsinput.client.event.ItemAddedEvent;
import org.gwtbootstrap3.extras.tagsinput.client.event.ItemAddedHandler;
import org.gwtbootstrap3.extras.tagsinput.client.event.ItemAddedOnInitEvent;
import org.gwtbootstrap3.extras.tagsinput.client.event.ItemAddedOnInitHandler;
import org.gwtbootstrap3.extras.tagsinput.client.event.ItemRemovedEvent;
import org.gwtbootstrap3.extras.tagsinput.client.event.ItemRemovedHandler;
import org.gwtbootstrap3.extras.typeahead.client.base.CollectionDataset;
import org.gwtbootstrap3.extras.typeahead.client.base.Dataset;
import org.gwtbootstrap3.extras.typeahead.client.events.TypeaheadSelectedEvent;
import org.gwtbootstrap3.extras.typeahead.client.events.TypeaheadSelectedHandler;
import org.gwtbootstrap3.extras.typeahead.client.ui.Typeahead;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Wrapper for Bootstrap Tags Input component.
 * 
 * Type T represents type of the tags. Tags can be objects or in special case strings.
 * If tags are strings, no special handling is necessary. However, if tags are objects,
 * it is required to set in options 'itemValue' and 'itemText'. If 'itemText' is not
 * set, 'itemValue' is used instead.
 *
 * @author Marko Nikolić <marko.nikolic@iten.rs>
 */
public class TagsInputBase<T> extends Widget implements HasAllTagsInputEvents<T>, HasChangeHandlers {
    // TODO Add attributes mixin
    // TODO Add firing of ItemAddOnInit event
    // TODO Add HasValue interface
    // TODO Add getItems()
    // TODO Add toJSO() and fromJSO() methods
    
    private TagsInputOptions options = TagsInputOptions.create();
    
    private Collection<? extends Dataset<T>> datasets;
    
    private Typeahead<T> typeahead;
    private ScheduledCommand attachTypeahead = new ScheduledCommand() {   
        @Override
        public void execute() {
            typeahead = new Typeahead<T>(input(), datasets);
            typeahead.reconfigure();
            typeahead.addTypeaheadSelectedHandler(new TypeaheadSelectedHandler<T>() {
                @Override
                public void onSelected(TypeaheadSelectedEvent<T> event) {
                    add(event.getSuggestion().getData());
                }
            });
        }
    };
    
    private final AttributeMixin<TagsInputBase<T>> attributeMixin = new AttributeMixin<TagsInputBase<T>>(this);
    
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
     * Sets classname for the tags.
     * 
     * @param tagClass Classname for the tags
     */
    public void setTagClass(final String tagClass) {
        options.setTagClass(tagClass);
    }

     /**
     * Sets item value name that will be used if tags are objects other then String.
     * 
     * @param itemValue name of field used for the tag value
     */
    public void setItemValue(final String itemValue) {
        options.setItemValue(itemValue);
    }

    /**
     * Sets item text name that will be used if tags are objects other then String.
     * If it item text name is not provided, item value will be used instead.
     * 
     * @param itemText name of field used for the tag text
     */
    public void setItemText(final String itemText) {
        options.setItemText(itemText);
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
    public HandlerRegistration addItemAddedOnInitHandler(final ItemAddedOnInitHandler<T> handler) {
        return addHandler(handler, ItemAddedOnInitEvent.getType());
    }
    
    @Override
    public HandlerRegistration addBeforeItemAddHandler(final BeforeItemAddHandler<T> handler) {
        return addHandler(handler, BeforeItemAddEvent.getType());
    }

    @Override
    public HandlerRegistration addItemAddedHandler(final ItemAddedHandler<T> handler) {
        return addHandler(handler, ItemAddedEvent.getType());
    }

    @Override
    public HandlerRegistration addBeforeItemRemoveHandler(final BeforeItemRemoveHandler<T> handler) {
        return addHandler(handler, BeforeItemRemoveEvent.getType());
    }

    @Override
    public HandlerRegistration addItemRemovedHandler(final ItemRemovedHandler<T> handler) {
        return addHandler(handler, ItemRemovedEvent.getType());
    }
    
    @Override
    public HandlerRegistration addChangeHandler(ChangeHandler handler) {
        return addDomHandler(handler, ChangeEvent.getType());
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
            @org.gwtbootstrap3.extras.tagsinput.client.event.ItemAddedOnInitEvent::fire(Lorg/gwtbootstrap3/extras/tagsinput/client/event/HasItemAddedOnInitHandlers;Ljava/lang/Object;)(tagsInput, event.item);
        });

        $wnd.jQuery(e).on(@org.gwtbootstrap3.extras.tagsinput.client.ui.base.HasAllTagsInputEvents::BEFORE_ITEM_ADD_EVENT, function(event) {
            @org.gwtbootstrap3.extras.tagsinput.client.event.BeforeItemAddEvent::fire(Lorg/gwtbootstrap3/extras/tagsinput/client/event/HasBeforeItemAddHandlers;Ljava/lang/Object;)(tagsInput, event.item);
        });

        $wnd.jQuery(e).on(@org.gwtbootstrap3.extras.tagsinput.client.ui.base.HasAllTagsInputEvents::ITEM_ADDED_EVENT, function(event) {
            @org.gwtbootstrap3.extras.tagsinput.client.event.ItemAddedEvent::fire(Lorg/gwtbootstrap3/extras/tagsinput/client/event/HasItemAddedHandlers;Ljava/lang/Object;)(tagsInput, event.item);
        });

        $wnd.jQuery(e).on(@org.gwtbootstrap3.extras.tagsinput.client.ui.base.HasAllTagsInputEvents::BEFORE_ITEM_REMOVE_EVENT, function(event) {
            @org.gwtbootstrap3.extras.tagsinput.client.event.BeforeItemRemoveEvent::fire(Lorg/gwtbootstrap3/extras/tagsinput/client/event/HasBeforeItemRemoveHandlers;Ljava/lang/Object;)(tagsInput, event.item);
        });

        $wnd.jQuery(e).on(@org.gwtbootstrap3.extras.tagsinput.client.ui.base.HasAllTagsInputEvents::ITEM_REMOVED_EVENT, function(event) {
            @org.gwtbootstrap3.extras.tagsinput.client.event.ItemRemovedEvent::fire(Lorg/gwtbootstrap3/extras/tagsinput/client/event/HasItemRemovedHandlers;Ljava/lang/Object;)(tagsInput, event.item);
        });

        // Workaround to make triggering 'change' event from jQuery working with GWT. Probably related to the issue https://github.com/jquery/jquery/issues/1783.
        $wnd.jQuery(e).on(@org.gwtbootstrap3.extras.tagsinput.client.ui.base.HasAllTagsInputEvents::ITEM_CHANGED_EVENT, function(event) {
        });
    }-*/;
    
    
    @Override
    protected void onLoad() {
        super.onLoad();

        initialize(getElement(), options);

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
     * Returns comma delimited string with values from tags.
     * 
     * @return comma delimited string
     */
    public String getValue() {
        // TODO return value from attributes mixin if not attached
        if (isAttached())
            return getValue(getElement());
        else
            return null;
    }

    /**
     * Returns list of items contained in the 
     * @return
     */
    public List<T> getItems() {
        return null;
    }
    
    /**
     * Adds a tag
     * 
     * @param tag tag to add
     */
    public void add(T tag) {
        if (isAttached())
            add(getElement(), tag);
    }

    /**
     * Removes a tag
     * 
     * @param tag tag to remove
     */
    public void remove(T tag) {
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
            destroy(getElement());       
    }
    
    private native void command(Element e, String command)/*-{
        $wnd.jQuery(e).tagsinput(command);
    }-*/;

    private native void add(Element e, T tag) /*-{
        $wnd.jQuery(e).tagsinput(@org.gwtbootstrap3.extras.tagsinput.client.ui.base.TagsInputCommand::ADD, tag);
    }-*/;
    
    private native void remove(Element e, T tag) /*-{
        $wnd.jQuery(e).tagsinput(@org.gwtbootstrap3.extras.tagsinput.client.ui.base.TagsInputCommand::REMOVE, tag);
    }-*/;
    
    private native Element input(Element e) /*-{
        return $wnd.jQuery(e).tagsinput(@org.gwtbootstrap3.extras.tagsinput.client.ui.base.TagsInputCommand::INPUT);
    }-*/;

    private native String getValue(Element e) /*-{
        return $wnd.jQuery(e).val();
    }-*/;

    private native JsArray<JavaScriptObject> getItems(Element e) /*-{
        return $wnd.jQuery(e).items();
    }-*/;
    
    private native void destroy(Element e) /*-{
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.tagsinput.client.ui.base.HasAllTagsInputEvents::ITEM_ADDED_ON_INIT_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.tagsinput.client.ui.base.HasAllTagsInputEvents::BEFORE_ITEM_ADD_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.tagsinput.client.ui.base.HasAllTagsInputEvents::ITEM_ADDED_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.tagsinput.client.ui.base.HasAllTagsInputEvents::BEFORE_ITEM_REMOVE_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.tagsinput.client.ui.base.HasAllTagsInputEvents::ITEM_REMOVED_EVENT);
                
        return $wnd.jQuery(e).tagsinput(@org.gwtbootstrap3.extras.tagsinput.client.ui.base.TagsInputCommand::DESTROY);
    }-*/;
}
