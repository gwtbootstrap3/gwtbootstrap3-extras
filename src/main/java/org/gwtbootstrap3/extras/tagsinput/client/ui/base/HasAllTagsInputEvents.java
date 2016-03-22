package org.gwtbootstrap3.extras.tagsinput.client.ui.base;

import org.gwtbootstrap3.extras.tagsinput.client.event.BeforeItemAddEvent;
import org.gwtbootstrap3.extras.tagsinput.client.event.HasBeforeItemAddHandlers;
import org.gwtbootstrap3.extras.tagsinput.client.event.HasBeforeItemRemoveHandlers;
import org.gwtbootstrap3.extras.tagsinput.client.event.HasItemAddedHandlers;

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

import org.gwtbootstrap3.extras.tagsinput.client.event.HasItemAddedOnInitHandlers;
import org.gwtbootstrap3.extras.tagsinput.client.event.HasItemRemovedHandlers;
import org.gwtbootstrap3.extras.tagsinput.client.event.ItemAddedOnInitEvent;

/**
 * Convenience interface used to implement all tagsinput handlers at once.
 *
 * @author Marko Nikolić <marko.nikolic@iten.rs>
 */
public interface HasAllTagsInputEvents<T> extends HasItemAddedOnInitHandlers<T>, HasBeforeItemAddHandlers<T>, HasItemAddedHandlers<T>,
                                                  HasBeforeItemRemoveHandlers<T>, HasItemRemovedHandlers<T> {

    /**
     * The {@link ItemAddedOnInitEvent} name
     */
    static final String ITEM_ADDED_ON_INIT_EVENT = "itemAddedOnInit";

    /**
     * The {@link BeforeItemAddEvent} name
     */
    static final String BEFORE_ITEM_ADD_EVENT = "beforeItemAdd";

    /**
     * The {@link ItemAddedEvent} name
     */
    static final String ITEM_ADDED_EVENT = "itemAdded";

    /**
     * The {@link BeforeItemRemoveEvent} name
     */
    static final String BEFORE_ITEM_REMOVE_EVENT = "beforeItemRemove";

    /**
     * The {@link ItemRemovedEvent} name
     */
    static final String ITEM_REMOVED_EVENT = "itemRemoved";

    /**
     * The {@link ItemChangedEvent} name
     */
    static final String ITEM_CHANGED_EVENT = "change";
}
