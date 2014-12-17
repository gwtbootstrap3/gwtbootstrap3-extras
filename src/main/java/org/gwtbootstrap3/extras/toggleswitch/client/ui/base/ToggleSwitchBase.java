package org.gwtbootstrap3.extras.toggleswitch.client.ui.base;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 GwtBootstrap3
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
import com.google.gwt.dom.client.Element;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.*;
import org.gwtbootstrap3.client.ui.Icon;
import org.gwtbootstrap3.client.ui.base.HasId;
import org.gwtbootstrap3.client.ui.base.HasResponsiveness;
import org.gwtbootstrap3.client.ui.base.HasSize;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.IdMixin;
import org.gwtbootstrap3.client.ui.constants.DeviceSize;
import org.gwtbootstrap3.client.ui.constants.IconSize;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.extras.toggleswitch.client.ui.base.constants.ColorType;
import org.gwtbootstrap3.extras.toggleswitch.client.ui.base.constants.SizeType;

/**
 * @author Grant Slender
 */
public class ToggleSwitchBase extends Widget implements HasSize<SizeType>, HasValue<Boolean>, HasValueChangeHandlers<Boolean>,
        HasEnabled, HasVisibility, HasId, HasResponsiveness, IsEditor<LeafValueEditor<Boolean>> {

    /**
     * Orig source from http://www.bootstrap-switch.org/
     */
    private final SimpleCheckBox checkBox;
    private SizeType size = SizeType.REGULAR;
    private ColorType onColor = ColorType.DEFAULT;
    private ColorType offColor = ColorType.PRIMARY;
    private String onText = "ON";
    private String offText = "OFF";
    private String labelText = "&nbsp;";
    private boolean animated = true;
    private boolean enabled = true;
    private final IdMixin<ToggleSwitchBase> idMixin = new IdMixin<ToggleSwitchBase>(this);
    private LeafValueEditor<Boolean> editor;

    public ToggleSwitchBase() {
        checkBox = new SimpleCheckBox();
        // remove the gwt styles
        checkBox.removeStyleName(UIObject.getStyleName(checkBox.getElement()));
        setElement((Element) checkBox.getElement());
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        switchInit(getElement());
        setSize(size);
        setOnColor(onColor);
        setOffColor(offColor);
        setAnimated(animated);
        setOnText(onText);
        setOffText(offText);
        setLabelText(labelText);
        setEnabled(enabled);
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
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
        if (isAttached()) {
            switchCmd(getElement(), "disabled", !enabled);
        }
    }

    @Override
    public SizeType getSize() {
        return size;
    }

    @Override
    public void setSize(final SizeType size) {
        if (ToggleSwitchBase.this.isAttached())
            switchCmd(getElement(), "size", size.getType());
        this.size = size;
    }

    public ColorType getOnColor() {
        return onColor;
    }

    public void setOnColor(final ColorType onColor) {
        if (ToggleSwitchBase.this.isAttached())
            switchCmd(getElement(), "onColor", onColor.getType());
        this.onColor = onColor;
    }

    public ColorType getOffColor() {
        return offColor;
    }

    public void setOffColor(final ColorType offColor) {
        if (ToggleSwitchBase.this.isAttached())
            switchCmd(getElement(), "offColor", offColor.getType());
        this.offColor = offColor;
    }

    public boolean isAnimated() {
        return animated;
    }

    public void setAnimated(final boolean animated) {
        if (ToggleSwitchBase.this.isAttached())
            switchCmd(getElement(), "animate", animated);
        this.animated = animated;
    }

    public String getOnText() {
        return onText;
    }

    public void setOnText(final String onText) {
        if (ToggleSwitchBase.this.isAttached())
            switchCmd(getElement(), "onText", onText);
        this.onText = onText;
    }

    public void setOnIcon(final IconType iconType) {
        final Icon icon = new Icon(iconType);
        icon.setSize(IconSize.LARGE);
        setOnText(icon.getElement().getString());
    }

    public String getOffText() {
        return offText;
    }

    public void setOffText(final String offText) {
        if (ToggleSwitchBase.this.isAttached())
            switchCmd(getElement(), "offText", offText);
        this.offText = offText;
    }

    public void setOffIcon(final IconType iconType) {
        final Icon icon = new Icon(iconType);
        icon.setSize(IconSize.LARGE);
        setOffText(icon.getElement().getString());
    }

    public String getLabelText() {
        return labelText;
    }

    public void setLabelText(final String labelText) {
        if (ToggleSwitchBase.this.isAttached())
            switchCmd(getElement(), "labelText", labelText);
        this.labelText = labelText;
    }

    @Override
    public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<Boolean> handler) {
        return addHandler(handler, ValueChangeEvent.getType());
    }

    @Override
    public Boolean getValue() {
        return switchState(getElement());
    }

    @Override
    public void setValue(final Boolean value) {
        if (ToggleSwitchBase.this.isAttached()) {
            setValue(value, false);
        } else {
            checkBox.setValue(value);
        }
    }

    @Override
    public void setValue(final Boolean value, final boolean fireEvents) {

        Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand() {
            @Override
            public boolean execute() {
                if (ToggleSwitchBase.this.isAttached()) {
                    switchState(getElement(), value);

                    if (fireEvents) {
                        ValueChangeEvent.fire(ToggleSwitchBase.this, value);
                    }
                    return false;
                } else {
                    return true;
                }
            }
        }, 100);
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

    private native void switchInit(Element e) /*-{
        $wnd.jQuery(e).bootstrapSwitch();

        var me = this;
        $wnd.jQuery(e).on('switchChange', function (em, data) {
            me.@org.gwtbootstrap3.extras.toggleswitch.client.ui.base.ToggleSwitchBase::onChange(Z)(data.value);
        });

    }-*/;

    private native void switchDestroy(Element e) /*-{
        $wnd.jQuery(e).off('switchChange');
        $wnd.jQuery(e).bootstrapSwitch('destroy');
    }-*/;

    private native void switchCmd(Element e, String cmd, String value) /*-{
        $wnd.jQuery(e).bootstrapSwitch(cmd, value);
    }-*/;

    private native void switchCmd(Element e, String cmd, boolean value) /*-{
        $wnd.jQuery(e).bootstrapSwitch(cmd, value);
    }-*/;

    private native void switchState(Element e, boolean value) /*-{
        $wnd.jQuery(e).bootstrapSwitch('state', value);
    }-*/;

    private native boolean switchState(Element e) /*-{
        return $wnd.jQuery(e).bootstrapSwitch('state');
    }-*/;
}
