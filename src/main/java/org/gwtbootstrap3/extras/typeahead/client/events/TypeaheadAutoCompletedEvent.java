package org.gwtbootstrap3.extras.typeahead.client.events;

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


import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Event;
import org.gwtbootstrap3.extras.typeahead.client.base.Suggestion;
import org.gwtbootstrap3.extras.typeahead.client.ui.Typeahead;

/**
 * Triggered when the query is autocompleted. Autocompleted means the query was changed to the hint.
 *
 * @author Florian Kremser <florian.kremser@sage.com>
 */
public class TypeaheadAutoCompletedEvent<T> extends GwtEvent<TypeaheadAutoCompletedHandler<T>> {

    public static <T> void fire(final Typeahead<T> source, final Suggestion<T> suggestion, final Event nativeEvent) {
        TypeaheadAutoCompletedEvent<T> event = new TypeaheadAutoCompletedEvent<T>(source, suggestion, nativeEvent);
        source.fireEvent(event);
    }

    private static final Type<TypeaheadAutoCompletedHandler<?>> TYPE = new Type<TypeaheadAutoCompletedHandler<?>>();

    private final Typeahead<T> typeahead;
    private final Suggestion<T> suggestion;
    private final Event nativeEvent;

    public static Type<TypeaheadAutoCompletedHandler<?>> getType() {
        return TYPE;
    }

    private TypeaheadAutoCompletedEvent(final Typeahead<T> typeahead, final Suggestion<T> suggestion, final  Event nativeEvent) {
        this.typeahead = typeahead;
        this.suggestion = suggestion;
        this.nativeEvent = nativeEvent;
    }

    public Typeahead<T> getTypeahead() {
        return typeahead;
    }

    public Suggestion<T> getSuggestion() {
        return suggestion;
    }

    public Event getNativeEvent() {
        return nativeEvent;
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Type<TypeaheadAutoCompletedHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    @Override
    protected void dispatch(final TypeaheadAutoCompletedHandler<T> handler) {
        handler.onAutoCompleted(this);
    }
}
