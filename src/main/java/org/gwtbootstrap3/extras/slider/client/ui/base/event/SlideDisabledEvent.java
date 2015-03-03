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
 * The slide disabled event is fired when the slider is disabled.
 */
public class SlideDisabledEvent extends GwtEvent<SlideDisabledHandler> {

    private static Type<SlideDisabledHandler> TYPE;

    /**
     * Fires a slide disabled event on all registered handlers in the handler
     * manager. If no such handlers exist, this method will do nothing.
     *
     * @param source the source of the handlers
     */
    public static void fire(final HasSlideDisabledHandlers source) {
        if (TYPE != null) {
            SlideDisabledEvent event = new SlideDisabledEvent();
            source.fireEvent(event);
        }
    }

    /**
     * Gets the type associated with this event.
     *
     * @return returns the handler type
     */
    public static Type<SlideDisabledHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type<SlideDisabledHandler>();
        }
        return TYPE;
    }

    @Override
    public Type<SlideDisabledHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final SlideDisabledHandler handler) {
        handler.onSlideDisabled(this);
    }

    /**
     * Creates a slide disabled event.
     */
    protected SlideDisabledEvent() {}

}
