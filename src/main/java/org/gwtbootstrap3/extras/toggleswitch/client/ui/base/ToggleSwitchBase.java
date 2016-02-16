package org.gwtbootstrap3.extras.toggleswitch.client.ui.base;

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

import org.gwtbootstrap3.client.ui.Icon;
import org.gwtbootstrap3.client.ui.base.HasId;
import org.gwtbootstrap3.client.ui.base.HasReadOnly;
import org.gwtbootstrap3.client.ui.base.HasResponsiveness;
import org.gwtbootstrap3.client.ui.base.HasSize;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.AttributeMixin;
import org.gwtbootstrap3.client.ui.base.mixin.IdMixin;
import org.gwtbootstrap3.client.ui.constants.DeviceSize;
import org.gwtbootstrap3.client.ui.constants.IconSize;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.extras.toggleswitch.client.ui.base.constants.ColorType;
import org.gwtbootstrap3.extras.toggleswitch.client.ui.base.constants.SizeType;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasVisibility;
import com.google.gwt.user.client.ui.Widget;

/**
 * Original source from http://www.bootstrap-switch.org/
 *
 * @author Grant Slender
 * @author Steven Jardine
 */
public class ToggleSwitchBase extends Widget implements HasSize<SizeType>, HasValue<Boolean>, HasValueChangeHandlers<Boolean>,
        HasEnabled, HasVisibility, HasId, HasName, HasReadOnly, HasResponsiveness, IsEditor<LeafValueEditor<Boolean>> {

    private final InputElement element;
    private SizeType size = SizeType.REGULAR;
    private ColorType onColor = ColorType.DEFAULT;
    private ColorType offColor = ColorType.PRIMARY;
    private final IdMixin<ToggleSwitchBase> idMixin = new IdMixin<ToggleSwitchBase>(this);
    private final AttributeMixin<ToggleSwitchBase> attributeMixin = new AttributeMixin<ToggleSwitchBase>(this);
    private LeafValueEditor<Boolean> editor;

    protected ToggleSwitchBase(InputElement element) {
        this.element = element;
        setElement(element);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        switchInit(getElement());
    }

    @Override
    protected void onUnload() {
        super.onUnload();
        switchDestroy(getElement());
    }

    @Override
    public void setVisibleOn(final DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    @Override
    public void setHiddenOn(final DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
    }

    @Override
    public void setId(final String id) {
        idMixin.setId(id);
    }

    @Override
    public String getId() {
        return idMixin.getId();
    }

    @Override
    public void setName(String name) {
        element.setName(name);
    }

    @Override
    public String getName() {
        return element.getName();
    }

    @Override
    public boolean isEnabled() {
        return !getBooleanAttribute(Option.DISABLED);
    }

    @Override
    public void setEnabled(final boolean enabled) {
        updateSwitch(Option.DISABLED, !enabled);
    }

    @Override
    public SizeType getSize() {
        return size;
    }

    @Override
    public void setSize(final SizeType size) {
        this.size = size;
        updateSwitch(Option.SIZE, size.getType());
    }

    public ColorType getOnColor() {
        return onColor;
    }

    public void setOnColor(final ColorType onColor) {
        this.onColor = onColor;
        updateSwitch(Option.ON_COLOR, onColor.getType());
    }

    public ColorType getOffColor() {
        return offColor;
    }

    public void setOffColor(final ColorType offColor) {
        this.offColor = offColor;
        updateSwitch(Option.OFF_COLOR, offColor.getType());
    }

    public boolean isAnimate() {
        return getBooleanAttribute(Option.ANIMATE);
    }

    public void setAnimate(final boolean animate) {
        updateSwitch(Option.ANIMATE, animate);
    }

    public String getOnText() {
        return getStringAttribute(Option.ON_TEXT);
    }

    public void setOnText(final String onText) {
        updateSwitch(Option.ON_TEXT, onText);
    }

    public void setOnIcon(final IconType iconType) {
        String text = createIconHtml(iconType);
        setOnText(text);
    }

    public String getOffText() {
        return getStringAttribute(Option.OFF_TEXT);
    }

    public void setOffText(final String offText) {
        updateSwitch(Option.OFF_TEXT, offText);
    }

    public void setOffIcon(final IconType iconType) {
        String text = createIconHtml(iconType);
        setOffText(text);
    }

    public String getLabelText() {
        return getStringAttribute(Option.LABEL_TEXT);
    }

    public void setLabelText(final String labelText) {
        updateSwitch(Option.LABEL_TEXT, labelText);
    }

    @Override
    public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<Boolean> handler) {
        return addHandler(handler, ValueChangeEvent.getType());
    }

    @Override
    public Boolean getValue() {
        if (isAttached()) {
            return switchState(getElement());
        }
        return element.isChecked();
    }

    @Override
    public void setValue(final Boolean value) {
        setValue(value, false);
    }

    @Override
    public void setValue(final Boolean value, final boolean fireEvents) {
        Boolean oldValue = getValue();
        if (isAttached()) {
            switchState(getElement(), value, true);
        } else {
            element.setChecked(value);
        }
        if (fireEvents) {
            ValueChangeEvent.fireIfNotEqual(ToggleSwitchBase.this, oldValue, value);
        }
    }

    public void onChange(final boolean value) {
        ValueChangeEvent.fire(this, value);
    }

    @Override
    public LeafValueEditor<Boolean> asEditor() {
        if (editor == null) {
            editor = TakesValueEditor.of(this);
        }
        return editor;
    }

    @Override
    public boolean isReadOnly() {
        return getBooleanAttribute(Option.READONLY);
    }

    @Override
    public void setReadOnly(boolean readOnly) {
        updateSwitch(Option.READONLY, readOnly);
    }

    public boolean isIndeterminate() {
        return getBooleanAttribute(Option.INDETERMINATE);
    }

    /**
     * Indeterminate state.
     */
    public void setIndeterminate(boolean indeterminate) {
        updateSwitch(Option.INDETERMINATE, indeterminate);
    }

    public boolean isInverse() {
        return getBooleanAttribute(Option.INVERSE);
    }

    /**
     * Inverse switch direction.
     */
    public void setInverse(boolean inverse) {
        updateSwitch(Option.INVERSE, inverse);
    }

    public boolean isRadioAllOff() {
        return getBooleanAttribute(Option.RADIO_ALL_OFF);
    }

    /**
     * Allow this radio button to be unchecked by the user.
     */
    public void setRadioAllOff(boolean radioAllOff) {
        updateSwitch(Option.RADIO_ALL_OFF, radioAllOff);
    }

    /**
     * Sets the handle's width.
     * @param labelWidth - set to "auto" (default) for automatic sizing, integer otherwise
     */
    public void setHandleWidth(String handleWidth) {
        updateSwitch(Option.HANDLE_WIDTH, handleWidth);
    }

    /**
     * Sets the label's width (the space between handles).
     * @param labelWidth - set to "auto" (default) for automatic sizing, integer otherwise
     */
    public void setLabelWidth(String labelWidth) {
        updateSwitch(Option.LABEL_WIDTH, labelWidth);
    }

    @Override
    public void setVisible(boolean visible) {
        if (isAttached()) {
            setVisible(getElement().getParentElement().getParentElement(), visible);
        } else {
            super.setVisible(visible);
        }
    }

    @Override
    public boolean isVisible() {
        if (isAttached()) {
            return isVisible(getElement().getParentElement().getParentElement());
        }
        return super.isVisible();
    }

    private String createIconHtml(IconType iconType) {
        // Fix incorrect handle width when using icons
        setHandleWidth("30");
        final Icon icon = new Icon(iconType);
        icon.setSize(IconSize.LARGE);
        return icon.getElement().getString();
    }

    private void updateSwitch(Option option, String value) {
        if (isAttached()) {
            switchCmd(getElement(), option.getCommand(), value);
        } else {
            attributeMixin.setAttribute(option.getAttribute(), value);
        }
    }

    private void updateSwitch(Option option, boolean value) {
        if (isAttached()) {
            switchCmd(getElement(), option.getCommand(), value);
        } else {
            attributeMixin.setAttribute(option.getAttribute(), Boolean.toString(value));
        }
    }

    private String getStringAttribute(Option option) {
        if (isAttached()) {
            return getCommandStringValue(getElement(), option.getCommand());
        } else {
            return attributeMixin.getAttribute(option.getAttribute());
        }
    }

    private boolean getBooleanAttribute(Option option) {
        if (isAttached()) {
            return getCommandBooleanValue(getElement(), option.getCommand());
        } else {
            String value = attributeMixin.getAttribute(option.getAttribute());
            if (value != null && !value.isEmpty()) {
                return Boolean.valueOf(value);
            } else {
                return false;
            }
        }
    }

    private native void switchInit(Element e) /*-{
        $wnd.jQuery(e).bootstrapSwitch();

        var me = this;
        $wnd.jQuery(e).on('switchChange.bootstrapSwitch', function (em, state) {
            me.@org.gwtbootstrap3.extras.toggleswitch.client.ui.base.ToggleSwitchBase::onChange(Z)(state);
        });
    }-*/;

    private native void switchDestroy(Element e) /*-{
        $wnd.jQuery(e).off('switchChange.bootstrapSwitch');
        $wnd.jQuery(e).bootstrapSwitch('destroy');
    }-*/;

    private native void switchCmd(Element e, String cmd, String value) /*-{
        $wnd.jQuery(e).bootstrapSwitch(cmd, value);
    }-*/;

    private native void switchCmd(Element e, String cmd, boolean value) /*-{
        $wnd.jQuery(e).bootstrapSwitch(cmd, value);
    }-*/;

    private native String getCommandStringValue(Element e, String cmd) /*-{
        return $wnd.jQuery(e).bootstrapSwitch(cmd);
    }-*/;

    private native boolean getCommandBooleanValue(Element e, String cmd) /*-{
        return $wnd.jQuery(e).bootstrapSwitch(cmd);
    }-*/;

    private native void switchState(Element e, boolean value, boolean skip) /*-{
        $wnd.jQuery(e).bootstrapSwitch('state', value, skip);
    }-*/;

    private native boolean switchState(Element e) /*-{
        return $wnd.jQuery(e).bootstrapSwitch('state');
    }-*/;
}
