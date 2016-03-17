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
 * Triggered after an item gets added.
 *
 * @author Marko Nikolić <marko.nikolic@iten.rs>
 */
public class ItemAddedEvent<T> extends GwtEvent<ItemAddedHandler<T>> {
    
    private static Type<ItemAddedHandler<?>> TYPE;

    private final T item;
    
    /**
     * Creates a tagsinput itemAdded event.
     */
    protected ItemAddedEvent(T item) {
        this.item = item;
    }
    
    public T getItem() {
        return item;
    }
    
    /**
     * Fires a tagsinput itemAdded event on all registered handlers in the handler
     * manager. If no such handlers exist, this method will do nothing.
     *
     * @param source the source of the handlers
     */
    public static <T> void fire(final HasItemAddedHandlers<T> source, T item) {
        if (TYPE != null) {
            ItemAddedEvent<T> event = new ItemAddedEvent<T>(item);
            source.fireEvent(event);
        }
    }

    /**
     * Gets the type associated with this event.
     *
     * @return returns the handler type
     */
    public static Type<ItemAddedHandler<?>> getType() {
        if (TYPE == null) {
            TYPE = new Type<ItemAddedHandler<?>>();
        }
        return TYPE;
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Type<ItemAddedHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    @Override
    protected void dispatch(ItemAddedHandler<T> handler) {
        handler.onItemAdded(this);
    }
}