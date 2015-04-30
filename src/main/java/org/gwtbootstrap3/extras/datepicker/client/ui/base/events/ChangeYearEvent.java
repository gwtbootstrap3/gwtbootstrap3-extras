package org.gwtbootstrap3.extras.datepicker.client.ui.base.events;

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

/**
 * @author Joshua Godi
 */
public class ChangeYearEvent extends GwtEvent<ChangeYearHandler> {

    private static final Type<ChangeYearHandler> TYPE = new Type<ChangeYearHandler>();

    private final Event nativeEvent;

    public static Type<ChangeYearHandler> getType() {
        return TYPE;
    }

    public ChangeYearEvent(final Event nativeEvent) {
        this.nativeEvent = nativeEvent;
    }

    public Event getNativeEvent() {
        return nativeEvent;
    }

    @Override
    public Type<ChangeYearHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final ChangeYearHandler handler) {
        handler.onChangeYear(this);
    }
}