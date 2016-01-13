package org.gwtbootstrap3.extras.gallery.client.ui;

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

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.ui.Anchor;
import org.gwtbootstrap3.client.ui.Heading;
import org.gwtbootstrap3.client.ui.base.ComplexWidget;
import org.gwtbootstrap3.client.ui.constants.HeadingSize;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.html.Div;
import org.gwtbootstrap3.client.ui.html.OrderedList;
import org.gwtbootstrap3.extras.gallery.client.events.GalleryCloseEvent;
import org.gwtbootstrap3.extras.gallery.client.events.GalleryCloseHandler;
import org.gwtbootstrap3.extras.gallery.client.events.GalleryClosedEvent;
import org.gwtbootstrap3.extras.gallery.client.events.GalleryClosedHandler;
import org.gwtbootstrap3.extras.gallery.client.events.GalleryOpenEvent;
import org.gwtbootstrap3.extras.gallery.client.events.GalleryOpenHandler;
import org.gwtbootstrap3.extras.gallery.client.events.GalleryOpenedEvent;
import org.gwtbootstrap3.extras.gallery.client.events.GalleryOpenedHandler;
import org.gwtbootstrap3.extras.gallery.client.events.GallerySlideCompleteEvent;
import org.gwtbootstrap3.extras.gallery.client.events.GallerySlideCompleteHandler;
import org.gwtbootstrap3.extras.gallery.client.events.GallerySlideEndEvent;
import org.gwtbootstrap3.extras.gallery.client.events.GallerySlideEndHandler;
import org.gwtbootstrap3.extras.gallery.client.events.GallerySlideEvent;
import org.gwtbootstrap3.extras.gallery.client.events.GallerySlideHandler;

/**
 * Bootstrap Gallery
 *
 * https://github.com/blueimp/Bootstrap-Image-Gallery
 *
 * @author Ben Dol
 */
public class Gallery extends ComplexWidget {

    private static Div galleryRoot;

    // Controls
    private Heading title;
    private Anchor prev;
    private Anchor next;
    private Anchor close;
    private OrderedList indicator;

    // Options
    private String thumbnailHeight;
    private String thumbnailWidth;

    public Gallery() {
        setElement(Document.get().createDivElement());
        getElement().setId("links");

        // Ensure the root gallery components are setup
        if(galleryRoot == null) {
            setupRootGallery();
        }
    }

    @Override
    public String getTitle() {
        return title.getText();
    }

    @Override
    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setPrevIcon(IconType iconType) {
        prev.setIcon(iconType);
    }

    public void setShowPrevButton(boolean show) {
        prev.setVisible(show);
    }

    public void setNextIcon(IconType iconType) {
        next.setIcon(iconType);
    }

    public void setShowNextButton(boolean show) {
        next.setVisible(show);
    }

    public void setCloseIcon(IconType iconType) {
        close.setIcon(iconType);
    }

    public void setShowCloseButton(boolean show) {
        close.setVisible(show);
    }

    public void setShowIndicator(boolean show) {
        indicator.setVisible(show);
    }

    public String getThumbnailHeight() {
        return thumbnailHeight;
    }

    public void setThumbnailHeight(String thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
    }

    public String getThumbnailWidth() {
        return thumbnailWidth;
    }

    public void setThumbnailWidth(String thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
    }

    @Override
    public void add(final Widget child) {
        if(child instanceof GalleryImage) {
            ((GalleryImage) child).addLoadHandler(new LoadHandler() {
                @Override
                public void onLoad(LoadEvent event) {
                    if(thumbnailWidth != null) {
                        child.setWidth(thumbnailWidth);
                    }
                    if(thumbnailHeight != null) {
                        child.setHeight(thumbnailHeight);
                    }
                }
            });

            super.add(child);
        } else {
            throw new IllegalArgumentException("Gallery can only contain GalleryImage's.");
        }
    }

    /**
     * Executed when the Gallery is initialized.
     */
    public HandlerRegistration addGalleryOpenHandler(final GalleryOpenHandler handler) {
        return addHandler(handler, GalleryOpenEvent.getType());
    }

    /**
     * Executed when the Gallery has been initialized
     * and the initialization transition has been completed.
     */
    public HandlerRegistration addGalleryOpenedHandler(final GalleryOpenedHandler handler) {
        return addHandler(handler, GalleryOpenedEvent.getType());
    }

    /**
     * Executed when the Gallery is about to be closed.
     */
    public HandlerRegistration addGalleryCloseHandler(final GalleryCloseHandler handler) {
        return addHandler(handler, GalleryCloseEvent.getType());
    }

    /**
     * Executed when the Gallery has been closed and the closing
     * transition has been completed.
     */
    public HandlerRegistration addGalleryClosedHandler(final GalleryClosedHandler handler) {
        return addHandler(handler, GalleryClosedEvent.getType());
    }

    /**
     * Executed on slide change.
     */
    public HandlerRegistration addGallerySlideHandler(final GallerySlideHandler handler) {
        return addHandler(handler, GallerySlideEvent.getType());
    }

    /**
     * Executed after the slide change transition.
     */
    public HandlerRegistration addGallerySlideEndHandler(final GallerySlideEndHandler handler) {
        return addHandler(handler, GallerySlideEndEvent.getType());
    }

    /**
     * Executed on slide content load.
     */
    public HandlerRegistration addGallerySlideCompleteHandler(final GallerySlideCompleteHandler handler) {
        return addHandler(handler, GallerySlideCompleteEvent.getType());
    }

    /**
     * Triggered when the gallery opens.
     *
     * @param event the event
     */
    private void onOpen(final Event event) {
        GalleryOpenEvent.fire(this, event);
    }

    /**
     * Triggered when the gallery is opened.
     *
     * @param event the event
     */
    private void onOpened(final Event event) {
        GalleryOpenedEvent.fire(this, event);
    }

    /**
     * Triggered when the gallery is closing.
     *
     * @param event the event
     */
    private void onClose(final Event event) {
        GalleryCloseEvent.fire(this, event);
    }

    /**
     * Triggered when the gallery is closed.
     *
     * @param event the event
     */
    private void onClosed(final Event event) {
        GalleryClosedEvent.fire(this, event);
    }

    /**
     * Triggered when the gallery is sliding.
     *
     * @param event the event
     */
    private void onSlide(final Event event, int index) {
        GallerySlideEvent.fire(this, event, index);
    }

    /**
     * Triggered when the gallery is slide ends.
     *
     * @param event the event
     */
    private void onSlideEnd(final Event event, int index) {
        GallerySlideEndEvent.fire(this, event, index);
    }

    /**
     * Triggered when the gallery is slide completes.
     *
     * @param event the event
     */
    private void onSlideComplete(final Event event, int index) {
        GallerySlideCompleteEvent.fire(this, event, index);
    }

    public void reconfigure() {
        if(galleryRoot != null) {
            destroy(galleryRoot.getElement());
            configure();
        }
    }

    private void setupRootGallery() {
        galleryRoot = new Div();
        galleryRoot.getElement().setId("blueimp-gallery");
        galleryRoot.getElement().setClassName("blueimp-gallery");
        galleryRoot.getElement().setAttribute("data-use-bootstrap-modal", "false");

        Div slides = new Div();
        slides.getElement().setClassName("slides");
        galleryRoot.add(slides);

        title = new Heading(HeadingSize.H3);
        title.getElement().setClassName("title");
        galleryRoot.add(title);

        prev = new Anchor("");
        prev.getElement().setClassName("prev");
        prev.setIcon(IconType.CARET_LEFT);
        galleryRoot.add(prev);

        next = new Anchor("");
        next.getElement().setClassName("next");
        next.setIcon(IconType.CARET_RIGHT);
        galleryRoot.add(next);

        close = new Anchor("");
        close.getElement().setClassName("close");
        close.setIcon(IconType.CLOSE);
        galleryRoot.add(close);

        indicator = new OrderedList();
        indicator.getElement().setClassName("indicator");
        galleryRoot.add(indicator);
    }

    @Override
    protected void onLoad() {
        if(galleryRoot != null) {
            if (!galleryRoot.isAttached()) {
                // Add the gallery to the root panel
                RootPanel.get().add(galleryRoot);
            }

            configure();
        }
    }

    @Override
    protected void onUnload() {
        if(galleryRoot != null) {
            destroy(galleryRoot.getElement());
        }
    }

    protected void configure() {
        if(galleryRoot != null) {
            configure(galleryRoot.getElement());
        }
    }

    private native void configure(Element e) /*-{
        var that = this;
        $wnd.jQuery(e)
            .on('open', function (e) {
                // Callback function executed when the Gallery is initialized.
                that.@org.gwtbootstrap3.extras.gallery.client.ui.Gallery::onOpen(Lcom/google/gwt/user/client/Event;)(e);
            })
            .on('opened', function (e) {
                // Callback function executed when the Gallery has been initialized
                // and the initialization transition has been completed.
                that.@org.gwtbootstrap3.extras.gallery.client.ui.Gallery::onOpened(Lcom/google/gwt/user/client/Event;)(e);
            })
            .on('close', function (e) {
                // Callback function executed when the Gallery is about to be closed.
                that.@org.gwtbootstrap3.extras.gallery.client.ui.Gallery::onClose(Lcom/google/gwt/user/client/Event;)(e);
            })
            .on('closed', function (e) {
                // Callback function executed when the Gallery has been closed
                // and the closing transition has been completed.
                that.@org.gwtbootstrap3.extras.gallery.client.ui.Gallery::onClosed(Lcom/google/gwt/user/client/Event;)(e);
            })
            .on('slide', function (e, index, slide) {
                // Callback function executed on slide change.
                that.@org.gwtbootstrap3.extras.gallery.client.ui.Gallery::onSlide(*)(e, index);
            })
            .on('slideend', function (e, index, slide) {
                // Callback function executed after the slide change transition.
                that.@org.gwtbootstrap3.extras.gallery.client.ui.Gallery::onSlideEnd(*)(e, index);
            })
            .on('slidecomplete', function (e, index, slide) {
                // Callback function executed on slide content load.
                that.@org.gwtbootstrap3.extras.gallery.client.ui.Gallery::onSlideComplete(*)(e, index);
            });
    }-*/;

    private native void destroy(Element e) /*-{
        $wnd.jQuery(e).off('open');
        $wnd.jQuery(e).off('opened');
        $wnd.jQuery(e).off('close');
        $wnd.jQuery(e).off('closed');
        $wnd.jQuery(e).off('slide');
        $wnd.jQuery(e).off('slideend');
        $wnd.jQuery(e).off('slidecomplete');
    }-*/;
}
