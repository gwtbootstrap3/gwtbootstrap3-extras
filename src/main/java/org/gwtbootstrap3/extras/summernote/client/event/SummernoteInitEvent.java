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
 * The {@link SummernoteInitEvent} is fired when the summernote editor is launched.
 *
 * @author Xiaodong Sun
 */
public class SummernoteInitEvent extends GwtEvent<SummernoteInitHandler> {

    private static Type<SummernoteInitHandler> TYPE;

    /**
     * Fires a summernote init event on all registered handlers in the handler
     * manager. If no such handlers exist, this method will do nothing.
     *
     * @param source the source of the handlers
     */
    public static void fire(final HasSummernoteInitHandlers source) {
        if (TYPE != null) {
        	SummernoteInitEvent event = new SummernoteInitEvent();
            source.fireEvent(event);
        }
    }

    /**
     * Gets the type associated with this event.
     *
     * @return returns the handler type
     */
    public static Type<SummernoteInitHandler> getType() {
    	if (TYPE == null) {
    		TYPE = new Type<SummernoteInitHandler>();
    	}
        return TYPE;
    }

    @Override
    public Type<SummernoteInitHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final SummernoteInitHandler handler) {
        handler.onSummernoteInit(this);
    }

    /**
     * Creates a summernote init event.
     */
    protected SummernoteInitEvent() {}
}