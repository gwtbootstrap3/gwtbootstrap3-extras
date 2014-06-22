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
import com.google.gwt.user.client.ui.HasEnabled;
import org.gwtbootstrap3.client.ui.base.ComplexWidget;
import org.gwtbootstrap3.client.ui.base.mixin.AttributeMixin;
import org.gwtbootstrap3.client.ui.base.mixin.EnabledMixin;
import org.gwtbootstrap3.client.ui.constants.IconType;

import static org.gwtbootstrap3.extras.select.client.constants.DataAttributes.DATA_ICON;

/**
 * @author godi
 */
public class OptGroup extends ComplexWidget implements HasEnabled {
    public static final String OPT_GROUP = "optgroup";
    public static final String LABEL = "label";

    private final EnabledMixin<OptGroup> enabledMixin = new EnabledMixin<OptGroup>(this);
    private final AttributeMixin<OptGroup> attributeMixin = new AttributeMixin<OptGroup>(this);

    public OptGroup() {
        setElement(Document.get().createElement(OPT_GROUP));
    }

    public void setLabel(final String label) {
        getElement().setAttribute(LABEL, label);
    }

    public String getLabel() {
        return getElement().getAttribute(LABEL);
    }

    @Override
    public void setEnabled(final boolean enabled) {
        enabledMixin.setEnabled(enabled);
    }

    @Override
    public boolean isEnabled() {
        return enabledMixin.isEnabled();
    }

    public void setIcon(final IconType iconType) {
        attributeMixin.setAttribute(DATA_ICON, "fa " + iconType.getCssName());
    }

    public IconType getIcon() {
        return IconType.fromStyleName(attributeMixin.getAttribute(DATA_ICON));
    }
}
