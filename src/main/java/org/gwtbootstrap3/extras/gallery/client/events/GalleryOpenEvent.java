package org.gwtbootstrap3.extras.gallery.client.events;

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
import org.gwtbootstrap3.extras.gallery.client.ui.Gallery;

/**
 * Triggered when the gallery is opened.
 *
 * @author Ben Dol
 */
public class GalleryOpenEvent extends GwtEvent<GalleryOpenHandler> {

    public static  void fire(final Gallery source, final Event nativeEvent) {
        GalleryOpenEvent event = new GalleryOpenEvent(source, nativeEvent);
        source.fireEvent(event);
    }

    private static final Type<GalleryOpenHandler> TYPE = new Type<GalleryOpenHandler>();

    private final Gallery gallery;
    private final Event nativeEvent;

    public static Type<GalleryOpenHandler> getType() {
        return TYPE;
    }

    private GalleryOpenEvent(final Gallery gallery, final Event nativeEvent) {
        this.gallery = gallery;
        this.nativeEvent = nativeEvent;
    }

    public Gallery getGallery() {
        return gallery;
    }

    public Event getNativeEvent() {
        return nativeEvent;
    }

    @Override
    public Type<GalleryOpenHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final GalleryOpenHandler handler) {
        handler.onOpen(this);
    }
}
