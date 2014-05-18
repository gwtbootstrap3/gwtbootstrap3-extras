package org.gwtbootstrap3.extras.slider.client.ui.base;

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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.*;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.base.HasId;
import org.gwtbootstrap3.client.ui.base.HasResponsiveness;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.DeviceSize;
import org.gwtbootstrap3.extras.slider.client.ui.base.constants.HandleType;
import org.gwtbootstrap3.extras.slider.client.ui.base.constants.OrientationType;
import org.gwtbootstrap3.extras.slider.client.ui.base.constants.SelectionType;
import org.gwtbootstrap3.extras.slider.client.ui.base.constants.TooltipType;

/**
 * @author Grant Slender
 */
public class SliderBase extends Widget implements HasValue<Double>, HasEnabled, HasValueChangeHandlers<Double>, HasVisibility,
        HasId, HasResponsiveness {

    /**
     * Orig source from https://github.com/seiyria/bootstrap-slider
     */
    private final TextBox textBox;
    private double min = 0;
    private double max = 10;
    private double step = 1;
    OrientationType orient = OrientationType.HORIZONTAL;
    SelectionType selection = SelectionType.BEFORE;
    TooltipType tooltip = TooltipType.SHOW;
    HandleType handle = HandleType.ROUND;
    boolean reversed = false;
    private FormatterCallback formatterCallback;

    public SliderBase() {
        textBox = new TextBox();
        // now remove the bootstrap styles
        textBox.removeStyleName(UIObject.getStyleName(textBox.getElement()));
        setElement((Element) textBox.getElement());
        setValue(5.0);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        final JavaScriptObject options = getOptions(getId(), getMin(), getMax(), getStep(), getOrientation().getType(), getValue(),
                getSelection().getType(), getTooltip().getType(), getHandle().getType(), isReversed(), isEnabled());
        sliderInit(getElement(), options);
    }

    @Override
    protected void onUnload() {
        super.onUnload();
        sliderCommand(getElement(), "destroy");
        unbindHandlers(getElement());
    }

    public void onChange(final double value) {
        ValueChangeEvent.fire(this, value);
    }

    @Override
    public void setVisibleOn(DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    @Override
    public void setHiddenOn(DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
    }

    @Override
    public void setId(final String id) {
        textBox.setId(id);
    }

    @Override
    public String getId() {
        return textBox.getId();
    }

    @Override
    public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<Double> handler) {
        return addHandler(handler, ValueChangeEvent.getType());
    }

    @Override
    public boolean isEnabled() {
        return textBox.isEnabled();
        // return isEnabled(getElement());
    }

    @Override
    public void setEnabled(final boolean enabled) {
        textBox.setEnabled(enabled);
        if (SliderBase.this.isAttached()) {
            if (enabled) {
                sliderCommand(getElement(), "enable");
            } else {
                sliderCommand(getElement(), "disable");
            }
        }
    }

    public double getMin() {
        return min;
    }

    public void setMin(final double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(final double max) {
        this.max = max;
    }

    public double getStep() {
        return step;
    }

    public void setStep(final double step) {
        this.step = step;
    }

    public OrientationType getOrientation() {
        return orient;
    }

    public void setOrientation(final OrientationType orient) {
        this.orient = orient;
    }

    public SelectionType getSelection() {
        return selection;
    }

    public void setSelection(final SelectionType selection) {
        this.selection = selection;
    }

    public TooltipType getTooltip() {
        return tooltip;
    }

    public void setTooltip(final TooltipType tooltip) {
        this.tooltip = tooltip;
    }

    public HandleType getHandle() {
        return handle;
    }

    public void setHandle(final HandleType handle) {
        this.handle = handle;
    }

    public boolean isReversed() {
        return reversed;
    }

    public void setReversed(final boolean reversed) {
        this.reversed = reversed;
    }

    @Override
    public Double getValue() {
        return Double.valueOf(textBox.getValue());
    }

    @Override
    public void setValue(final Double value) {
        textBox.setValue(value.toString());
        if (SliderBase.this.isAttached()) {
            setValue(value, false);
        }
    }

    @Override
    public void setValue(final Double value, final boolean fireEvents) {

        Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand() {
            @Override
            public boolean execute() {
                if (SliderBase.this.isAttached()) {
                    setValue(getElement(), value);

                    if (fireEvents) {
                        ValueChangeEvent.fire(SliderBase.this, value);
                    }
                    return false;
                } else {
                    return true;
                }
            }
        }, 100);
    }

    public void setFormatter(final FormatterCallback formatterCallback) {
        this.formatterCallback = formatterCallback;
    }

    private String formatter(final double value) {
        if (formatterCallback != null)
            return formatterCallback.toolTipMsg(value);
        return Double.toString(value);
    }

// @formatter:off

    private native double getValue(Element e) /*-{
        return $wnd.jQuery(e).slider('getValue');
    }-*/;

    private native boolean isEnabled(Element e) /*-{
        return $wnd.jQuery(e).slider('isEnabled');
    }-*/;

    private native void setValue(Element e, double value) /*-{
        $wnd.jQuery(e).slider('setValue', value);
    }-*/;

    private native void sliderInit(Element e, JavaScriptObject options) /*-{
        var me = this;
        $wnd.jQuery(e).slider(options)
            .on('slide', function (evt) {
                me.@org.gwtbootstrap3.extras.slider.client.ui.base.SliderBase::onChange(D)(evt.value);
            })
    }-*/;

    private native JavaScriptObject getOptions(String id, double min, double max, double step, String orient, double value, String selection, String tooltip, String handle, boolean reversed, boolean enabled) /*-{
        var me = this;
        var options = {
            id: id,
            min: min,
            max: max,
            step: step,
            orientation: orient,
            value: value,
            selection: selection,
            tooltip: tooltip,
            handle: handle,
            reversed: reversed,
            enabled: enabled
        };
        options.formater = function (val) {
            return me.@org.gwtbootstrap3.extras.slider.client.ui.base.SliderBase::formatter(D)(val);
        };
        return options;
    }-*/;

    private native void sliderCommand(Element e, String cmd) /*-{
        $wnd.jQuery(e).slider(cmd);
    }-*/;

    private native void unbindHandlers(Element e) /*-{
        $wnd.jQuery(e).off('slide');
    }-*/;
}
