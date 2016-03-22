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
public class BeforeItemAddEvent<T> extends GwtEvent<BeforeItemAddHandler<T>> {
    
    private static Type<BeforeItemAddHandler<?>> TYPE;

    private final T item;
    
    /**
     * Creates a tagsinput beforeItemAdd event.
     */
    protected BeforeItemAddEvent(T item) {
        this.item = item;
    }
    
    public T getItem() {
        return item;
    }
    
    /**
     * Fires a tagsinput beforeItemAdd event on all registered handlers in the handler
     * manager. If no such handlers exist, this method will do nothing.
     *
     * @param source the source of the handlers
     */
    public static <T> void fire(final HasBeforeItemAddHandlers<T> source, T item) {
        if (TYPE != null) {
            BeforeItemAddEvent<T> event = new BeforeItemAddEvent<T>(item);
            source.fireEvent(event);
        }
    }

    /**
     * Gets the type associated with this event.
     *
     * @return returns the handler type
     */
    public static Type<BeforeItemAddHandler<?>> getType() {
        if (TYPE == null) {
            TYPE = new Type<BeforeItemAddHandler<?>>();
        }
        return TYPE;
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Type<BeforeItemAddHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    @Override
    protected void dispatch(BeforeItemAddHandler<T> handler) {
        handler.onBeforeItemAdd(this);
    }
}