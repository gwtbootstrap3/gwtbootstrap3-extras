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
 * Triggered when the gallery item slide ends.
 *
 * @author Ben Dol
 */
public class GallerySlideEndEvent extends GwtEvent<GallerySlideEndHandler> {

    public static  void fire(final Gallery source, final Event nativeEvent, int index) {
        GallerySlideEndEvent event = new GallerySlideEndEvent(source, nativeEvent, index);
        source.fireEvent(event);
    }

    private static final Type<GallerySlideEndHandler> TYPE = new Type<GallerySlideEndHandler>();

    private final Gallery gallery;
    private final Event nativeEvent;
    private final int index;

    public static Type<GallerySlideEndHandler> getType() {
        return TYPE;
    }

    private GallerySlideEndEvent(final Gallery gallery, final Event nativeEvent, int index) {
        this.gallery = gallery;
        this.nativeEvent = nativeEvent;
        this.index = index;
    }

    public Gallery getGallery() {
        return gallery;
    }

    public Event getNativeEvent() {
        return nativeEvent;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public Type<GallerySlideEndHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final GallerySlideEndHandler handler) {
        handler.onSlideEnd(this);
    }
}
