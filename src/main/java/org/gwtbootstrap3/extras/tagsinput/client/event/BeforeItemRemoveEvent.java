package org.gwtbootstrap3.extras.tagsinput.client.event;

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

import com.google.gwt.event.shared.GwtEvent;

/**
 * Triggered just before an item gets added.
 *
 * @author Marko Nikolić <marko.nikolic@iten.rs>
 */
public class BeforeItemRemoveEvent<T> extends GwtEvent<BeforeItemRemoveHandler<T>> {
    
    private static Type<BeforeItemRemoveHandler<?>> TYPE;

    private final T item;
    
    /**
     * Creates a tagsinput beforeItemRemove event.
     */
    protected BeforeItemRemoveEvent(T item) {
        this.item = item;
    }
    
    public T getItem() {
        return item;
    }
    
    /**
     * Fires a tagsinput beforeItemRemove event on all registered handlers in the handler
     * manager. If no such handlers exist, this method will do nothing.
     *
     * @param source the source of the handlers
     */
    public static <T> void fire(final HasBeforeItemRemoveHandlers<T> source, T item) {
        if (TYPE != null) {
            BeforeItemRemoveEvent<T> event = new BeforeItemRemoveEvent<T>(item);
            source.fireEvent(event);
        }
    }

    /**
     * Gets the type associated with this event.
     *
     * @return returns the handler type
     */
    public static Type<BeforeItemRemoveHandler<?>> getType() {
        if (TYPE == null) {
            TYPE = new Type<BeforeItemRemoveHandler<?>>();
        }
        return TYPE;
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Type<BeforeItemRemoveHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    @Override
    protected void dispatch(BeforeItemRemoveHandler<T> handler) {
        handler.onBeforeItemRemove(this);
    }
}