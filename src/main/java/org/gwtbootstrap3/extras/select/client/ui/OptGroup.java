package org.gwtbootstrap3.extras.select.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2016 GwtBootstrap3
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

import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.ICON;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.MAX_OPTIONS;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.SUBTEXT;

import java.util.HashMap;
import java.util.Map;

import org.gwtbootstrap3.client.ui.base.ComplexWidget;
import org.gwtbootstrap3.client.ui.base.mixin.AttributeMixin;
import org.gwtbootstrap3.client.ui.base.mixin.EnabledMixin;
import org.gwtbootstrap3.client.ui.constants.IconType;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.OptionElement;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.Widget;

/**
 * Select option group widget.
 *
 * @author Xiaodong Sun
 */
public class OptGroup extends ComplexWidget implements HasEnabled {

    private final Map<OptionElement, Option> itemMap = new HashMap<>(0);
    private final AttributeMixin<OptGroup> attrMixin = new AttributeMixin<>(this);
    private final EnabledMixin<OptGroup> enabledMixin = new EnabledMixin<>(this);

    private static final String LABEL = "label";

    public OptGroup() {
        setElement(Document.get().createOptGroupElement());
    }

    /**
     * Set the label of the option group.
     *
     * @param label
     */
    public void setLabel(final String label) {
        if (label != null)
            attrMixin.setAttribute(LABEL, label);
        else
            attrMixin.removeAttribute(LABEL);
    }

    /**
     * Returns the label of the option group; may be <code>null</code>.
     *
     * @return the label of the option group
     */
    public String getLabel() {
        String label = attrMixin.getAttribute(LABEL);
        return label.isEmpty() ? null : label;
    }

    @Override
    public boolean isEnabled() {
        return enabledMixin.isEnabled();
    }

    @Override
    public void setEnabled(final boolean enabled) {
        enabledMixin.setEnabled(enabled);
    }

    /**
     * Set the specified sub-text to the option.
     *
     * @param subtext
     */
    public void setSubtext(final String subtext) {
        if (subtext != null)
            attrMixin.setAttribute(SUBTEXT, subtext);
        else
            attrMixin.removeAttribute(SUBTEXT);
    }

    /**
     * Returns the sub-text of the option.
     *
     * @return
     */
    public String getSubtext() {
        String subtext = attrMixin.getAttribute(SUBTEXT);
        return subtext.isEmpty() ? null : subtext;
    }

    /**
     * Add an icon to the option.
     *
     * @param iconType
     */
    public void setIcon(final IconType iconType) {
        if (iconType != null)
            attrMixin.setAttribute(ICON, iconType.getCssName());
        else
            attrMixin.removeAttribute(ICON);
    }

    /**
     * Returns the icon of the option; may be <code>null</code>.
     *
     * @return
     */
    public IconType getIcon() {
        return IconType.fromStyleName(attrMixin.getAttribute(ICON));
    }

    /**
     * When set to a positive value and in a multi-select, the
     * number of selected options cannot exceed the given value.
     * When set to a strict negative value (less than zero), this
     * options will be deactivated.
     *
     * @param maxOptions
     */
    public void setMaxOptions(final int maxOptions) {
        attrMixin.setAttribute(MAX_OPTIONS, Integer.toString(maxOptions));
    }

    @Override
    public void add(Widget child) {
        super.add(child);
        updateItemMap(child, true);
    }

    @Override
    public void insert(Widget child, int beforeIndex) {
        super.insert(child, beforeIndex);
        updateItemMap(child, true);
    }

    @Override
    public boolean remove(Widget w) {
        boolean removed = super.remove(w);
        if (removed) {
            updateItemMap(w, false);
        }
        return removed;
    }

    private void updateItemMap(Widget widget, boolean toAdd) {

        // Not option element ==> ignore it
        if (!(widget instanceof Option))
            return;

        // Update item map
        Option option = (Option) widget;
        if (toAdd) {
            itemMap.put(option.getSelectElement(), option);
        } else {
            itemMap.remove(option.getSelectElement());
        }

        // Update select item map
        Widget parent = getParent();
        if (parent != null && parent instanceof SelectBase) {
            SelectBase<?> select = (SelectBase<?>) parent;
            select.updateItemMap(option, toAdd);
        }
    }

    Map<OptionElement, Option> getItemMap() {
        return itemMap;
    }
}
