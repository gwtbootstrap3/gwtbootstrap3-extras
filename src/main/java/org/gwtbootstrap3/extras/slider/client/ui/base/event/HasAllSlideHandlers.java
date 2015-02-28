package org.gwtbootstrap3.extras.slider.client.ui.base.event;

import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;

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

/**
 * Convenience interface used to implement all slide handlers at once.
 *
 * @param <T> slider value type
 */
public interface HasAllSlideHandlers<T> extends HasSlideHandlers<T>,
        HasSlideStartHandlers<T>, HasSlideStopHandlers<T>, HasValueChangeHandlers<T>,
        HasSlideEnabledHandlers, HasSlideDisabledHandlers {

    /**
     * The {@link SlideEvent} name
     */
    static final String SLIDE_EVENT = "slide";

    /**
     * The {@link SlideStartEvent} name
     */
    static final String SLIDE_START_EVENT = "slideStart";

    /**
     * The {@link SlideStopEvent} name
     */
    static final String SLIDE_STOP_EVENT = "slideStop";

    /**
     * The {@link ValueChangeEvent} name
     */
    static final String SLIDE_CHANGE_EVENT = "change";

    /**
     * The {@link SlideEnabledEvent} name
     */
    static final String SLIDE_ENABLED_EVENT = "slideEnabled";

    /**
     * The {@link SlideDisabledEvent} name
     */
    static final String SLIDE_DISABLED_EVENT = "slideDisabled";

}
