package org.gwtbootstrap3.extras.summernote.client.event;

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
 * The {@link SummernoteInitEvent} is fired when the summernote editor loses focus.
 *
 * @author Xiaodong Sun
 */
public class SummernoteBlurEvent extends GwtEvent<SummernoteBlurHandler> {

    private static Type<SummernoteBlurHandler> TYPE;

    /**
     * Fires a summernote blur event on all registered handlers in the handler
     * manager. If no such handlers exist, this method will do nothing.
     *
     * @param source the source of the handlers
     */
    public static void fire(final HasSummernoteBlurHandlers source) {
        if (TYPE != null) {
            SummernoteBlurEvent event = new SummernoteBlurEvent();
            source.fireEvent(event);
        }
    }

    /**
     * Gets the type associated with this event.
     *
     * @return returns the handler type
     */
    public static Type<SummernoteBlurHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type<SummernoteBlurHandler>();
        }
        return TYPE;
    }

    @Override
    public Type<SummernoteBlurHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final SummernoteBlurHandler handler) {
        handler.onSummernoteBlur(this);
    }

    /**
     * Creates a summernote init event.
     */
    protected SummernoteBlurEvent() {}
}