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

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.shared.GwtEvent;

/**
 * The {@link SummernoteKeyUpEvent} is fired when a key is released within
 * the summernote editor.
 *
 * @author Xiaodong Sun
 */
public class SummernoteKeyUpEvent extends GwtEvent<SummernoteKeyUpHandler> {

    private static Type<SummernoteKeyUpHandler> TYPE;

    private final NativeEvent nativeEvent;

    /**
     * Fires a summernote key up event on all registered handlers in the handler
     * manager. If no such handlers exist, this method will do nothing.
     *
     * @param source the source of the handlers
     * @param keyUpEvent native key up event
     */
    public static void fire(final HasSummernoteKeyUpHandlers source, NativeEvent nativeEvent) {
        if (TYPE != null) {
            SummernoteKeyUpEvent event = new SummernoteKeyUpEvent(nativeEvent);
            source.fireEvent(event);
        }
    }

    /**
     * Gets the type associated with this event.
     *
     * @return returns the handler type
     */
    public static Type<SummernoteKeyUpHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type<SummernoteKeyUpHandler>();
        }
        return TYPE;
    }

    @Override
    public Type<SummernoteKeyUpHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    public String toDebugString() {
        return super.toDebugString() + " key code is: " + nativeEvent.getKeyCode();
    }

    /**
     * Returns the native key up event.
     *
     * @return native key up event
     */
    public NativeEvent getNativeEvent() {
		return nativeEvent;
	}

    @Override
    protected void dispatch(final SummernoteKeyUpHandler handler) {
        handler.onSummernoteKeyUp(this);
    }

    /**
     * Creates a summernote key up event.
     *
     * @param nativeEvent native key up event
     */
    protected SummernoteKeyUpEvent(NativeEvent nativeEvent) {
        this.nativeEvent = nativeEvent;
    }
}