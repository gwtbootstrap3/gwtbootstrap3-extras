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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.shared.GwtEvent;

/**
 * The {@link SummernoteImageUploadEvent} is fired when inserting images into the
 * summernote editor.
 *
 * @author Xiaodong Sun
 */
public class SummernoteImageUploadEvent extends GwtEvent<SummernoteImageUploadHandler> {

    /**
     * JavaScript overlay type of image file.
     */
    public static class ImageFile extends JavaScriptObject {

        protected ImageFile() {
        }

        public final native String getName() /*-{
            return this.name;
        }-*/;

        public final native double getSize() /*-{
            return this.size;
        }-*/;

        public final native String getType() /*-{
            return this.type;
        }-*/;

        public final String getMetadata() {
            return new StringBuilder("ImageFile [")
                .append("name = ").append(getName()).append(", ")
                .append("size = ").append(getSize()).append(", ")
                .append("type = ").append(getType())
                .append("]").toString();
        }

    }

    private static Type<SummernoteImageUploadHandler> TYPE;

    private final JsArray<ImageFile> images;

    /**
     * Fires a summernote image upload event on all registered handlers in the
     * handler manager. If no such handlers exist, this method will do nothing.
     *
     * @param source the source of the handlers
     */
    public static void fire(final HasSummernoteImageUploadHandlers source, JsArray<ImageFile> images) {
        if (TYPE != null) {
            SummernoteImageUploadEvent event = new SummernoteImageUploadEvent(images);
            source.fireEvent(event);
        }
    }

    /**
     * Gets the type associated with this event.
     *
     * @return returns the handler type
     */
    public static Type<SummernoteImageUploadHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type<SummernoteImageUploadHandler>();
        }
        return TYPE;
    }

    @Override
    public Type<SummernoteImageUploadHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final SummernoteImageUploadHandler handler) {
        handler.onSummernoteImageUpload(this);
    }

    /**
     * Creates a summernote image upload event.
     */
    protected SummernoteImageUploadEvent(JsArray<ImageFile> images) {
        this.images = images;
    }

    @Override
    public String toDebugString() {
        return super.toDebugString() + " with " + images.length() + " images";
    }

    /**
     * Returns the JavaScript array of the {@link ImageFile}s to be
     * inserted.
     *
     * @return the JavaScript array of the {@link ImageFile}s to be
     * 	    inserted.
     */
    public JsArray<ImageFile> getImages() {
        return images;
    }
}