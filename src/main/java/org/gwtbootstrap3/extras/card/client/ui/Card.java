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

import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.ui.html.Div;

/**
 * @author godi
 */
public class Card extends Div {
    private final Div card;

    public Card() {
        // Add required style names
        addStyleName(CardStyles.FLIP);

        // Inner child to complete the card
        card = new Div();
        card.addStyleName(CardStyles.CARD);

        super.add(card);
    }

    @Override
    public void add(final Widget child) {
        card.add(child);
    }
}