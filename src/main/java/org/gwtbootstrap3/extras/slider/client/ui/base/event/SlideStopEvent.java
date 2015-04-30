package org.gwtbootstrap3.extras.slider.client.ui.base.event;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2015 GwtBootstrap3
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
 * The slide stop event is fired when dragging stops or has been clicked on.
 *
 * @param <T> slider value type
 */
public class SlideStopEvent<T> extends GwtEvent<SlideStopHandler<T>> {

    private static Type<SlideStopHandler<?>> TYPE;

    private T value;

    /**
     * Fires a slide stop event on all registered handlers in the handler
     * manager. If no such handlers exist, this method will do nothing.
     *
     * @param source the source of the handlers
     * @param value the new slider value
     */
    public static <T> void fire(final HasSlideStopHandlers<T> source, final T value) {
        if (TYPE != null) {
            SlideStopEvent<T> event = new SlideStopEvent<T>(value);
            source.fireEvent(event);
        }
    }

    /**
     * Gets the type associated with this event.
     *
     * @return returns the handler type
     */
    public static Type<SlideStopHandler<?>> getType() {
        if (TYPE == null) {
            TYPE = new Type<SlideStopHandler<?>>();
        }
        return TYPE;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Type<SlideStopHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    @Override
    protected void dispatch(final SlideStopHandler<T> handler) {
        handler.onSlideStop(this);
    }

    /**
     * Creates a slide stop event.
     *
     * @param value the new slider value
     */
    protected SlideStopEvent(final T value) {
        this.value = value;
    }

    /**
     * @return the new slider value
     */
    public T getValue() {
        return value;
    }

    @Override
    public String toDebugString() {
        return super.toDebugString() + getValue();
    }
}
