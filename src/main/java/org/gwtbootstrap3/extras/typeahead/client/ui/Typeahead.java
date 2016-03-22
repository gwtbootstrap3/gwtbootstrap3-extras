package org.gwtbootstrap3.extras.typeahead.client.ui;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.extras.typeahead.client.base.CollectionDataset;
import org.gwtbootstrap3.extras.typeahead.client.base.Dataset;
import org.gwtbootstrap3.extras.typeahead.client.base.Suggestion;
import org.gwtbootstrap3.extras.typeahead.client.events.TypeaheadAutoCompletedEvent;
import org.gwtbootstrap3.extras.typeahead.client.events.TypeaheadAutoCompletedHandler;
import org.gwtbootstrap3.extras.typeahead.client.events.TypeaheadClosedEvent;
import org.gwtbootstrap3.extras.typeahead.client.events.TypeaheadClosedHandler;
import org.gwtbootstrap3.extras.typeahead.client.events.TypeaheadCursorChangedEvent;
import org.gwtbootstrap3.extras.typeahead.client.events.TypeaheadCursorChangedHandler;
import org.gwtbootstrap3.extras.typeahead.client.events.TypeaheadOpenedEvent;
import org.gwtbootstrap3.extras.typeahead.client.events.TypeaheadOpenedHandler;
import org.gwtbootstrap3.extras.typeahead.client.events.TypeaheadSelectedEvent;
import org.gwtbootstrap3.extras.typeahead.client.events.TypeaheadSelectedHandler;

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
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;

/**
 * Twitter typeahead.js
 *
 * https://github.com/twitter/typeahead.js
 *
 * @author Florian Kremser <florian.kremser@sage.com>
 */
public class Typeahead<T> extends TextBox {
    private Collection<? extends Dataset<T>> datasets;
    private boolean highlight = false;
    private boolean hint = true;
    private int minLength = 1;

    public Typeahead() {
        List<T> empty = Collections.emptyList();
        setDatasets(new CollectionDataset<T>(empty));
    }

    /**
     * A typeahead is composed of one or more datasets. When an end-user
     * modifies the value of a typeahead, each dataset will attempt to
     * render suggestions for the new value.
     *
     * @param dataset a dataset for providing suggestions
     */
    public Typeahead(final Dataset<T> dataset) {
        setDatasets(dataset);
    }

    public Typeahead(final Collection<? extends Dataset<T>> datasets) {
        setDatasets(datasets);
    }

    public Typeahead(final Element e, final Dataset<T> dataset) {
        super(e);
        setDatasets(dataset);
    }

    public Typeahead(final Element e, final Collection<? extends Dataset<T>> datasets) {
        super(e);
        setDatasets(datasets);
    }
    
    public void setDatasets(final Dataset<T> dataset) {
        this.datasets = Arrays.asList(dataset);
    }

    public void setDatasets(final Collection<? extends Dataset<T>> datasets) {
        this.datasets = datasets;
    }

    @Override
    public void setValue(final String value, final boolean fireEvents) {
        setValueNative(getElement(), value);
        super.setValue(value, fireEvents);
    }

    /**
     * If {@code true}, when suggestions are rendered, pattern matches for the
     * current query in text nodes will be wrapped in a {@code strong} element
     * with the {@code tt-highlight} class. Defaults to {@code false}.
     *
     * @param highlight {@code true} to highlight pattern matches in suggestions
     */
    public void setHighlight(final boolean highlight) {
        this.highlight = highlight;
    }

    /**
     * If {@code false}, the typeahead will not show a hint. Defaults to {@code true}.
     *
     * @param hint {@code true} to show a hint
     */
    public void setHint(final boolean hint) {
        this.hint = hint;
    }

    /**
     * The minimum character length needed before suggestions start getting
     * rendered. Defaults to 1.
     *
     * @param minLength minimum required input length for matching
     */
    public void setMinLength(final int minLength) {
        this.minLength = minLength;
    }

    public HandlerRegistration addTypeaheadOpenedHandler(final TypeaheadOpenedHandler<T> handler) {
        return addHandler(handler, TypeaheadOpenedEvent.getType());
    }

    public HandlerRegistration addTypeaheadClosedHandler(final TypeaheadClosedHandler<T> handler) {
        return addHandler(handler, TypeaheadClosedEvent.getType());
    }

    public HandlerRegistration addTypeaheadCursorChangededHandler(final TypeaheadCursorChangedHandler<T> handler) {
        return addHandler(handler, TypeaheadCursorChangedEvent.getType());
    }

    public HandlerRegistration addTypeaheadAutoCompletedHandler(final TypeaheadAutoCompletedHandler<T> handler) {
        return addHandler(handler, TypeaheadAutoCompletedEvent.getType());
    }

    public HandlerRegistration addTypeaheadSelectedHandler(final TypeaheadSelectedHandler<T> handler) {
        return addHandler(handler, TypeaheadSelectedEvent.getType());
    }

    /**
     * Triggered when the dropdown menu of the typeahead is opened.
     *
     * @param event the event
     */
    private void onOpened(final Event event) {
        TypeaheadOpenedEvent.fire(this, event);
    }

    /**
     * Triggered when the dropdown menu of the typeahead is closed.
     *
     * @param event the event
     */
    private void onClosed(final Event event) {
        TypeaheadClosedEvent.fire(this, event);
    }

    /**
     * Triggered when the dropdown menu cursor is moved to a different suggestion.
     *
     * @param event the event
     * @param suggestion the suggestion object
     */
    private void onCursorChanged(final Event event, final Suggestion<T> suggestion) {
        TypeaheadCursorChangedEvent.fire(this, suggestion, event);
    }

    /**
     * Triggered when the query is autocompleted. Autocompleted means the query was changed to the hint.
     *
     * @param event the event
     * @param suggestion the suggestion object
     */
    private void onAutoCompleted(final Event event, final Suggestion<T> suggestion) {
        TypeaheadAutoCompletedEvent.fire(this, suggestion, event);
    }

    /**
     * Triggered when a suggestion from the dropdown menu is selected.
     *
     * @param event the event
     * @param suggestion the suggestion object
     */
    private void onSelected(final Event event, final Suggestion<T> suggestion) {
        TypeaheadSelectedEvent.fire(this, suggestion, event);
    }

    public void reconfigure() {
        remove(getElement());
        configure();
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        configure();
    }

    @Override
    protected void onUnload() {
        super.onUnload();
        remove(getElement());
    }

    protected void configure() {
        JsArray<JavaScriptObject> datasetJSOs = JsArray.createArray().cast();
        for (Dataset<T> dataset : datasets) {
            JavaScriptObject jso = toJSO(dataset);
            datasetJSOs.push(jso);
        }
        configure(getElement(), highlight, hint, minLength, datasetJSOs);
    }

    private native JavaScriptObject toJSO(Dataset<T> dataset) /*-{
        var emptyTemplate = dataset.@org.gwtbootstrap3.extras.typeahead.client.base.Dataset::getEmptyTemplate()();
        var headerTemplate = dataset.@org.gwtbootstrap3.extras.typeahead.client.base.Dataset::getHeaderTemplate()();
        var footerTemplate = dataset.@org.gwtbootstrap3.extras.typeahead.client.base.Dataset::getFooterTemplate()();
        var suggestionTemplate = dataset.@org.gwtbootstrap3.extras.typeahead.client.base.Dataset::getSuggestionTemplate()();

        var findMatches = function () {
            return function (query, cb) {
                var scb = @org.gwtbootstrap3.extras.typeahead.client.base.SuggestionCallback::new(Lcom/google/gwt/core/client/JavaScriptObject;)(cb);
                return dataset.@org.gwtbootstrap3.extras.typeahead.client.base.Dataset::findMatches(Ljava/lang/String;Lorg/gwtbootstrap3/extras/typeahead/client/base/SuggestionCallback;)(query, scb);
            };
        };

        return {
            name: dataset.@org.gwtbootstrap3.extras.typeahead.client.base.Dataset::name,
            source: findMatches(),
            templates: {
                empty: (emptyTemplate != null ? function (query) {
                    return emptyTemplate.@org.gwtbootstrap3.extras.typeahead.client.base.Template::render()();
                } : undefined),
                header: (headerTemplate != null ? function (query) {
                    return headerTemplate.@org.gwtbootstrap3.extras.typeahead.client.base.Template::render()();
                } : undefined),
                footer: (footerTemplate != null ? function (query) {
                    return footerTemplate.@org.gwtbootstrap3.extras.typeahead.client.base.Template::render()();
                } : undefined),
                suggestion: (suggestionTemplate != null ? function (suggestion) {
                    return suggestionTemplate.@org.gwtbootstrap3.extras.typeahead.client.base.SuggestionTemplate::render(Lorg/gwtbootstrap3/extras/typeahead/client/base/Suggestion;)(suggestion);
                } : undefined)
            }

        };
    }-*/;

    private native void configure(
            Element e, boolean highlight, boolean hint, int minLength, JsArray<JavaScriptObject> datasets) /*-{
        var that = this;
        $wnd.jQuery(e).typeahead({
                highlight: highlight,
                hint: hint,
                minLength: minLength
            },
            datasets)
            .on('typeahead:opened', function (e) {
                that.@org.gwtbootstrap3.extras.typeahead.client.ui.Typeahead::onOpened(Lcom/google/gwt/user/client/Event;)(e);
            })
            .on('typeahead:closed', function (e) {
                that.@org.gwtbootstrap3.extras.typeahead.client.ui.Typeahead::onClosed(Lcom/google/gwt/user/client/Event;)(e);
            })
            .on('typeahead:cursorchanged', function (e, value, datasetName) {
                that.@org.gwtbootstrap3.extras.typeahead.client.ui.Typeahead::onCursorChanged(Lcom/google/gwt/user/client/Event;Lorg/gwtbootstrap3/extras/typeahead/client/base/Suggestion;)(e, value);
            })
            .on('typeahead:autocompleted', function (e, value, datasetName) {
                that.@org.gwtbootstrap3.extras.typeahead.client.ui.Typeahead::onAutoCompleted(Lcom/google/gwt/user/client/Event;Lorg/gwtbootstrap3/extras/typeahead/client/base/Suggestion;)(e, value);
            })
            .on('typeahead:selected', function (e, value, datasetName) {
                that.@org.gwtbootstrap3.extras.typeahead.client.ui.Typeahead::onSelected(Lcom/google/gwt/user/client/Event;Lorg/gwtbootstrap3/extras/typeahead/client/base/Suggestion;)(e, value);
            });
    }-*/;

    private native void remove(Element e) /*-{
        $wnd.jQuery(e).typeahead('destroy');
    }-*/;

    private native void setValueNative(Element e, String value) /*-{
        $wnd.jQuery(e).typeahead('val', value);
    }-*/;
}
