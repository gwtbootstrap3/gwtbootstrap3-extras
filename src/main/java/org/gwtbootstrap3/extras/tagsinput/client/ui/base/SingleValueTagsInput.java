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

import org.gwtbootstrap3.extras.typeahead.client.base.CollectionDataset;
import org.gwtbootstrap3.extras.typeahead.client.base.Dataset;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Wrapper for Bootstrap Tags Input component implemented with input box as underlying component.
 *
 * @author Marko Nikolić <marko.nikolic@iten.rs>
 */
public abstract class SingleValueTagsInput<T> extends TagsInputBase<T> implements HasValueChangeHandlers<String> {

    public SingleValueTagsInput() {
        this(new CollectionDataset<T>(Collections.<T>emptyList()));
    }

    public SingleValueTagsInput(final Dataset<T> dataset) {
        this(Arrays.asList(dataset));
        
        setDatasets(dataset);
    }

    public SingleValueTagsInput(final Collection<? extends Dataset<T>> datasets) {
        InputElement tagsInput = Document.get().createTextInputElement();
        tagsInput.setAttribute("data-role", "tagsinput");
        
        setElement(tagsInput);        
        
        setDatasets(datasets);
    }
 
    public SingleValueTagsInput(final Element e) {
        this(e, new CollectionDataset<T>(Collections.<T>emptyList()));
    }

    public SingleValueTagsInput(final Element e, final Dataset<T> dataset) {
        this(e, Arrays.asList(dataset));
        
        setDatasets(dataset);
    }

    public SingleValueTagsInput(final Element e, final Collection<? extends Dataset<T>> datasets) {
        e.setAttribute("data-role", "tagsinput");

        setElement(e);
        
        // Wrapped elements are already attached to the DOM and the onAttach method will not be called automatically,
        // so it is called manually to correctly set attached state.
        onAttach();
        
        setDatasets(datasets);
    }
    
    /**
     * Returns comma delimited string with values from tags.
     * 
     * @return comma delimited string
     */
    public String getValue() {
        // TODO return value from attributes mixin if not attached
        if (isAttached())
            return getValue(getElement()).toString();
        else
            return null;
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
        return addHandler(handler, ValueChangeEvent.getType());
    }
}
