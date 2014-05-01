package org.gwtbootstrap3.extras.card.client.ui;

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

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Event;
import org.gwtbootstrap3.client.ui.Icon;
import org.gwtbootstrap3.client.ui.constants.IconType;

/**
 * @author Joshua Godi
 */
public class Trigger extends Icon {

    public Trigger() {
        setType(IconType.EXCHANGE);
        addStyleName(CardStyles.TRIGGER);

        // Sink the needed events
        sinkEvents(Event.ONCLICK);

        // When user clicks front, show back
        addHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                if (getParent() != null && getParent().getParent() != null) {
                    if (getParent().getParent().getStyleName().contains(CardStyles.FLIPPED)) {
                        getParent().getParent().removeStyleName(CardStyles.FLIPPED);
                    } else {
                        getParent().getParent().addStyleName(CardStyles.FLIPPED);
                    }
                }
            }
        }, ClickEvent.getType());
    }
}
