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

import org.gwtbootstrap3.client.ui.HasId;
import org.gwtbootstrap3.client.ui.HasResponsiveness;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.extras.slider.client.ui.base.constants.HandleType;
import org.gwtbootstrap3.extras.slider.client.ui.base.constants.OrientationType;
import org.gwtbootstrap3.extras.slider.client.ui.base.constants.SelectionType;
import org.gwtbootstrap3.extras.slider.client.ui.base.constants.TooltipType;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasVisibility;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Grant Slender
 */
public class SliderBase extends Widget implements HasValue<Float>, HasEnabled, HasValueChangeHandlers<Float>, HasVisibility,
        HasChangeHandlers, HasId, HasResponsiveness {

    /**
     * Orig source from https://github.com/seiyria/bootstrap-slider
     */
    private final TextBox textBox;
    private float min = 0;
    private float max = 10;
    private float step = 1;
    OrientationType orient = OrientationType.HORIZONTAL;
    SelectionType selection = SelectionType.BEFORE;
    TooltipType tooltip = TooltipType.SHOW;
    HandleType handle = HandleType.ROUND;
    boolean reversed = false;

    public SliderBase() {
        textBox = new TextBox();
        // now remove the bootstrap styles
        textBox.removeStyleName(UIObject.getStyleName(textBox.getElement()));
        setElement(textBox.getElement());
        setValue(5f);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        JavaScriptObject options = getOptions(getId(), getMin(), getMax(), getStep(), getOrientation().getType(), getValue(),
                getSelection().getType(), getTooltip().getType(), getHandle().getType(), isReversed(), isEnabled());
        sliderInit(getElement(), options);
    }

    @Override
    protected void onUnload() {
        super.onUnload();
        sliderCommand(getElement(), "destroy");
    }

    public void onChange(final float value) {
        ValueChangeEvent.fire(this, value);
    }

    @Override
    public void setVisibleOn(final String deviceSizeString) {
        textBox.setVisibleOn(deviceSizeString);
    }

    @Override
    public void setHiddenOn(final String deviceSizeString) {
        textBox.setHiddenOn(deviceSizeString);
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
    public HandlerRegistration addChangeHandler(ChangeHandler handler) {
        return addHandler(handler, ChangeEvent.getType());
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Float> handler) {
        return addHandler(handler, ValueChangeEvent.getType());
    }

    @Override
    public boolean isEnabled() {
        return textBox.isEnabled();
        // return isEnabled(getElement());
    }

    @Override
    public void setEnabled(boolean enabled) {
        textBox.setEnabled(enabled);
        if (SliderBase.this.isAttached()) {
            if (enabled) {
                sliderCommand(getElement(), "enable");
            } else {
                sliderCommand(getElement(), "disable");
            }
        }
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public float getStep() {
        return step;
    }

    public void setStep(float step) {
        this.step = step;
    }

    public OrientationType getOrientation() {
        return orient;
    }

    public void setOrientation(OrientationType orient) {
        this.orient = orient;
    }

    public SelectionType getSelection() {
        return selection;
    }

    public void setSelection(SelectionType selection) {
        this.selection = selection;
    }

    public TooltipType getTooltip() {
        return tooltip;
    }

    public void setTooltip(TooltipType tooltip) {
        this.tooltip = tooltip;
    }

    public HandleType getHandle() {
        return handle;
    }

    public void setHandle(HandleType handle) {
        this.handle = handle;
    }

    public boolean isReversed() {
        return reversed;
    }

    public void setReversed(boolean reversed) {
        this.reversed = reversed;
    }

    @Override
    public Float getValue() {
        return Float.valueOf(textBox.getValue());
    }

    @Override
    public void setValue(Float value) {
        textBox.setValue(value.toString());
        if (SliderBase.this.isAttached()) {
            setValue(value, false);
        }
    }

    @Override
    public void setValue(final Float value, final boolean fireEvents) {

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
        }, 1000);

    }

    public String formatter(float value) {
        return Float.toString(value);
    }

// @formatter:off

    private native float getValue(Element e) /*-{
        return $wnd.jQuery(e).slider('getValue');
    }-*/;

    private native boolean isEnabled(Element e) /*-{
        return $wnd.jQuery(e).slider('isEnabled');
    }-*/;

    private native void setValue(Element e, float value) /*-{
        $wnd.jQuery(e).slider('setValue',value);
    }-*/;

    private native void sliderInit(Element e, JavaScriptObject options) /*-{
        var me = this;
        $wnd.jQuery(e).slider(options)
            .on('slide', function (evt) {
                me.@org.gwtbootstrap3.extras.slider.client.ui.base.SliderBase::onChange(F)(evt.value);
            })
    }-*/;

    private native JavaScriptObject getOptions(String id, float min, float max, float step, String orient, float value,String selection, String tooltip,String handle,boolean reversed,boolean enabled) /*-{
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
            return me.@org.gwtbootstrap3.extras.slider.client.ui.base.SliderBase::formatter(F)(val);
        };
        return options;
    }-*/;

    private native void sliderCommand(Element e, String cmd) /*-{
        $wnd.jQuery(e).slider(cmd);
    }-*/;

}
