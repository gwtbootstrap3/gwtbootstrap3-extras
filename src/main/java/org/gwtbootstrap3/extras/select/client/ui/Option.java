package org.gwtbootstrap3.extras.select.client.ui;

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
import org.gwtbootstrap3.client.ui.base.AbstractTextWidget;
import org.gwtbootstrap3.client.ui.base.mixin.AttributeMixin;
import org.gwtbootstrap3.client.ui.constants.IconType;

import static org.gwtbootstrap3.extras.select.client.constants.DataAttributes.*;

/**
 * @author godi
 */
public class Option extends AbstractTextWidget {
    private final AttributeMixin<Option> attributeMixin = new AttributeMixin<Option>(this);

    public Option() {
        super(Document.get().createOptionElement());
    }

    public void setName(final String name) {
        attributeMixin.setAttribute(NAME, name);
    }

    public String getName() {
        return attributeMixin.getAttribute(NAME);
    }

    public void setValue(final String value) {
        attributeMixin.setAttribute(VALUE, value);
    }

    public String getValue() {
        return attributeMixin.getAttribute(VALUE);
    }

    public void setSubtext(final String subtext) {
        attributeMixin.setAttribute(DATA_SUBTEXT, subtext);
    }

    public String getSubtext() {
        return attributeMixin.getAttribute(DATA_SUBTEXT);
    }

    public void clearSubtext() {
        attributeMixin.removeAttribute(DATA_SUBTEXT);
    }

    public void setShowDivider(final boolean showDivider) {
        if (showDivider) {
            attributeMixin.setAttribute(DATA_DIVIDER, Boolean.toString(true));
        } else {
            attributeMixin.removeAttribute(DATA_DIVIDER);
        }
    }

    public boolean getShowDivider() {
        return attributeMixin.getAttribute(DATA_DIVIDER) != null;
    }

    public void setEnabled(final boolean enabled) {
        if (enabled) {
            attributeMixin.removeAttribute(DISABLED);
        } else {
            attributeMixin.setAttribute(DISABLED, DISABLED);
        }
    }

    public boolean isEnabled() {
        return attributeMixin.getAttribute(DISABLED) == null;
    }

    public void setIcon(final IconType iconType) {
        attributeMixin.setAttribute(DATA_ICON, iconType.getCssName());
    }

    public IconType getIcon() {
        return IconType.fromStyleName(attributeMixin.getAttribute(DATA_ICON));
    }
    
    public void setHidden(final boolean hidden) {
        if (hidden) {
            attributeMixin.setAttribute(DATA_HIDDEN, Boolean.toString(true));
        } else {
            attributeMixin.removeAttribute(DATA_HIDDEN);
        }
    }
    
    public boolean isHidden() {
        return attributeMixin.getAttribute(DATA_HIDDEN) != null;
    }
}
