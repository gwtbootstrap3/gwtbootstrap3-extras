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

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler interface for {@link SlideStopEvent} events.
 *
 * @param <T> slider value type
 */
public interface SlideStopHandler<T> extends EventHandler {

    /**
     * Called when {@link SlideStopEvent} is fired.
     *
     * @param event the {@link SlideStopEvent} that was fired
     */
    void onSlideStop(SlideStopEvent<T> event);
}
