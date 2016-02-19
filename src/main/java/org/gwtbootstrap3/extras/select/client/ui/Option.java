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

import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.CONTENT;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.DIVIDER;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.HIDDEN;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.ICON;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.SUBTEXT;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.TOKENS;

import org.gwtbootstrap3.client.ui.base.AbstractTextWidget;
import org.gwtbootstrap3.client.ui.base.mixin.AttributeMixin;
import org.gwtbootstrap3.client.ui.base.mixin.EnabledMixin;
import org.gwtbootstrap3.client.ui.constants.IconType;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.OptionElement;
import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasName;

/**
 * Select option widget.
 *
 * @author Xiaodong Sun
 */
public class Option extends AbstractTextWidget implements HasName, TakesValue<String>, HasEnabled {

    private final AttributeMixin<Option> attrMixin = new AttributeMixin<>(this);
    private final EnabledMixin<Option> enabledMixin = new EnabledMixin<>(this);

    private static final String NAME = "name";
    private static final String VALUE = "value";

    public Option() {
        super(Document.get().createOptionElement());
    }

    /**
     * Returns the {@link OptionElement}.
     *
     * @return the {@link OptionElement}.
     */
    public OptionElement getSelectElement() {
        return getElement().cast();
    }

    /**
     * Returns <code>true</code> if the option is selected.
     *
     * @return <code>true</code> if the option is selected
     */
    public boolean isSelected() {
        return isDivider() ? false : getSelectElement().isSelected();
    }

    /**
     * Selects/deselects the option.
     *
     * @param selected
     */
    public void setSelected(boolean selected) {
        getSelectElement().setSelected(isDivider() ? false : selected);
    }

    @Override
    public void setName(final String name) {
        if (name != null)
            attrMixin.setAttribute(NAME, name);
        else
            attrMixin.removeAttribute(NAME);
    }

    @Override
    public String getName() {
        String name = attrMixin.getAttribute(NAME);
        return name.isEmpty() ? null : name;
    }

    @Override
    public void setValue(final String value) {
        if (value != null)
            attrMixin.setAttribute(VALUE, value);
        else
            attrMixin.removeAttribute(VALUE);
    }

    /**
     * Returns the value of the option. If no value, fall-back
     * to the displayed option text.
     */
    @Override
    public String getValue() {
        String value = attrMixin.getAttribute(VALUE);
        return value.isEmpty() ? getText() : value;
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
     * Adds key words to improve the searchability.
     *
     * @param tokens
     */
    public void setTokens(final String tokens) {
        if (tokens != null)
            attrMixin.setAttribute(TOKENS, tokens);
        else
            attrMixin.removeAttribute(TOKENS);
    }

    /**
     * Returns the search key words.
     *
     * @return
     */
    public String getTokens() {
        String tokens = attrMixin.getAttribute(TOKENS);
        return tokens.isEmpty() ? null : tokens;
    }

    /**
     * Turns the option into a divider.
     *
     * @param divider
     */
    public void setDivider(final boolean divider) {
        if (divider)
            attrMixin.setAttribute(DIVIDER, Boolean.toString(true));
        else
            attrMixin.removeAttribute(DIVIDER);
    }

    /**
     * Returns <code>true</code> if the option is a divider.
     *
     * @return <code>true</code> if the option is a divider
     */
    public boolean isDivider() {
        return Boolean.parseBoolean(attrMixin.getAttribute(DIVIDER));
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
     * Inserts custom HTML into the option.
     *
     * @param content
     */
    public void setContent(final String content) {
        if (content != null)
            attrMixin.setAttribute(CONTENT, content);
        else
            attrMixin.removeAttribute(CONTENT);
    }

    /**
     * Returns the custom HTML content; may be <code>null</code>.
     *
     * @return the custom HTML content
     */
    public String getContent() {
        String content = attrMixin.getAttribute(CONTENT);
        return content.isEmpty() ? null : content;
    }

    /**
     * Hides the option if set to <code>true</code>.<br>
     * <br>
     * Defaults to <code>false</code>.
     *
     * @param hidden
     */
    public void setHidden(final boolean hidden) {
        if (hidden)
            attrMixin.setAttribute(HIDDEN, Boolean.toString(true));
        else
            attrMixin.removeAttribute(HIDDEN);
    }

    /**
     * Returns <code>true</code> if the option is hidden.
     *
     * @return <code>true</code> if the option is hidden
     */
    public boolean isHidden() {
        return Boolean.parseBoolean(attrMixin.getAttribute(HIDDEN));
    }
}
