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
public class BeforeItemAddEvent extends GwtEvent<BeforeItemAddHandler> {
    // TODO Add Item as payload to event.
    
    private static Type<BeforeItemAddHandler> TYPE;

    /**
     * Fires a tagsinput beforeItemAdd event on all registered handlers in the handler
     * manager. If no such handlers exist, this method will do nothing.
     *
     * @param source the source of the handlers
     */
    public static void fire(final HasBeforeItemAddHandlers source) {
        if (TYPE != null) {
            BeforeItemAddEvent event = new BeforeItemAddEvent();
            source.fireEvent(event);
        }
    }

    /**
     * Gets the type associated with this event.
     *
     * @return returns the handler type
     */
    public static Type<BeforeItemAddHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type<BeforeItemAddHandler>();
        }
        return TYPE;
    }


    @Override
    public Type<BeforeItemAddHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(BeforeItemAddHandler handler) {
        handler.onBeforeItemAdd(this);
    }

    /**
     * Creates a tagsinput beforeItemAdd event.
     */
    protected BeforeItemAddEvent() {}
}