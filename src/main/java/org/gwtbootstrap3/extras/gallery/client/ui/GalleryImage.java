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

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasLoadHandlers;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.ui.base.ComplexWidget;
import org.gwtbootstrap3.client.ui.base.HasHref;

/**
 * Gallery Image
 *
 * @author Ben Dol
 */
public class GalleryImage extends ComplexWidget implements HasHref, HasLoadHandlers {

    private Image image;

    @UiConstructor
    public GalleryImage(String url) {
        setElement(Document.get().createAnchorElement());
        getElement().setAttribute("data-gallery", "data-gallery");
        getElement().getStyle().setDisplay(Display.INLINE_TABLE);

        setHref(url);

        image = new Image(url);
        add(image);
    }

    @Override
    public void add(final Widget child) {
        if(child instanceof Image) {
            if(image != null) {
                image.removeFromParent();
            }

            image = (Image) child;
            setHref(image.getUrl());

            super.add(image);
        } else if(child instanceof HasClickHandlers) {
            ((HasClickHandlers) child).addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    event.stopPropagation();
                }
            });

            Scheduler.get().scheduleDeferred(new Command() {
                @Override
                public void execute() {
                    Style style = child.getElement().getStyle();
                    style.setPosition(Position.RELATIVE);
                    style.setBottom((double) image.getHeight(), Unit.PX);
                    style.setLeft(4, Unit.PX);
                }
            });

            super.add(child);
        } else {
            super.add(child);
        }
    }

    @Override
    public void setHref(String href) {
        AnchorElement.as(getElement()).setHref(href);
    }

    @Override
    public String getHref() {
        return AnchorElement.as(getElement()).getHref();
    }

    @Override
    public void setWidth(String width) {
        super.setWidth(width);
        image.setWidth(width);
    }

    @Override
    public void setHeight(String height) {
        super.setHeight(height);
        image.setHeight(height);

        Scheduler.get().scheduleDeferred(new Command() {
            @Override
            public void execute() {
                for (Widget child : GalleryImage.this) {
                    if (child instanceof HasClickHandlers && !(child instanceof Image)) {
                        Style style = child.getElement().getStyle();
                        style.setBottom((double) image.getHeight(), Unit.PX);
                    }
                }
            }
        });
    }

    @Override
    public HandlerRegistration addLoadHandler(LoadHandler handler) {
        return image.addHandler(handler, LoadEvent.getType());
    }
}
