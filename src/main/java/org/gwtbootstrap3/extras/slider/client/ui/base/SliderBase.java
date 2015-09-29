package org.gwtbootstrap3.extras.slider.client.ui.base;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2015 GwtBootstrap3
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.base.HasId;
import org.gwtbootstrap3.client.ui.base.HasResponsiveness;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.AttributeMixin;
import org.gwtbootstrap3.client.ui.constants.DeviceSize;
import org.gwtbootstrap3.extras.slider.client.ui.base.constants.HandleType;
import org.gwtbootstrap3.extras.slider.client.ui.base.constants.OrientationType;
import org.gwtbootstrap3.extras.slider.client.ui.base.constants.ScaleType;
import org.gwtbootstrap3.extras.slider.client.ui.base.constants.SelectionType;
import org.gwtbootstrap3.extras.slider.client.ui.base.constants.TooltipType;
import org.gwtbootstrap3.extras.slider.client.ui.base.event.HasAllSlideHandlers;
import org.gwtbootstrap3.extras.slider.client.ui.base.event.SlideDisabledEvent;
import org.gwtbootstrap3.extras.slider.client.ui.base.event.SlideDisabledHandler;
import org.gwtbootstrap3.extras.slider.client.ui.base.event.SlideEnabledEvent;
import org.gwtbootstrap3.extras.slider.client.ui.base.event.SlideEnabledHandler;
import org.gwtbootstrap3.extras.slider.client.ui.base.event.SlideEvent;
import org.gwtbootstrap3.extras.slider.client.ui.base.event.SlideHandler;
import org.gwtbootstrap3.extras.slider.client.ui.base.event.SlideStartEvent;
import org.gwtbootstrap3.extras.slider.client.ui.base.event.SlideStartHandler;
import org.gwtbootstrap3.extras.slider.client.ui.base.event.SlideStopEvent;
import org.gwtbootstrap3.extras.slider.client.ui.base.event.SlideStopHandler;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.dom.client.Element;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 *
 * @param <T> slider value type
 *
 * @see https://github.com/seiyria/bootstrap-slider
 * @author Xiaodong Sun
 */
public abstract class SliderBase<T> extends Widget implements
        HasValue<T>, IsEditor<LeafValueEditor<T>>, HasEnabled, HasId,
        HasResponsiveness, HasAllSlideHandlers<T> {

    private final TextBox textBox;
    private FormatterCallback<T> formatterCallback;
    private LeafValueEditor<T> editor;

    private final AttributeMixin<SliderBase<T>> attributeMixin = new AttributeMixin<SliderBase<T>>(this);

    protected SliderBase() {
        textBox = new TextBox();
        // now remove the bootstrap styles
        textBox.removeStyleName(UIObject.getStyleName(textBox.getElement()));
        setElement((Element) textBox.getElement());
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        final JavaScriptObject options = JavaScriptObject.createObject();
        if (formatterCallback != null) {
            setFormatterOption(options);
        }
        initSlider(getElement(), options);
        bindSliderEvents(getElement());
    }

    /**
     * Sets formatter option if defined when attaching to the DOM.
     *
     * @param options
     */
    protected abstract void setFormatterOption(JavaScriptObject options);

    @Override
    protected void onUnload() {
        super.onUnload();
        unbindSliderEvents(getElement());
        sliderCommand(getElement(), SliderCommand.DESTROY);
    }

    /**
     * Sets the id of the slider element when it's created.
     */
    @Override
    public void setId(final String id) {
        updateSlider(SliderOption.ID, id);
    }

    @Override
    public String getId() {
        return getStringAttribute(SliderOption.ID);
    }

    public double getMin() {
        return getDoubleAttribute(SliderOption.MIN, 0);
    }

    /**
     * Sets the minimum possible value.
     *
     * @param min
     */
    public void setMin(final double min) {
        updateSlider(SliderOption.MIN, min);
    }

    public double getMax() {
        return getDoubleAttribute(SliderOption.MAX, 10);
    }

    /**
     * Sets the maximum possible value.
     *
     * @param max
     */
    public void setMax(final double max) {
        updateSlider(SliderOption.MAX, max);
    }

    public double getStep() {
        return getDoubleAttribute(SliderOption.STEP, 1);
    }

    /**
     * Sets the increment step.
     *
     * @param step
     */
    public void setStep(final double step) {
        updateSlider(SliderOption.STEP, step);
    }

    public double getPrecision() {
        return getDoubleAttribute(SliderOption.PRECISION, 0);
    }

    /**
     * Sets the number of digits shown after the decimal.<br>
     * <br>
     * Defaults to the number of digits after the decimal of step value.
     *
     * @param precision
     */
    public void setPrecision(final double precision) {
        updateSlider(SliderOption.PRECISION, precision);
    }

    public OrientationType getOrientation() {
        return getEnumAttribute(SliderOption.ORIENTATION, OrientationType.class, OrientationType.HORIZONTAL);
    }

    /**
     * Sets the orientation.
     *
     * @param orientation
     * @see OrientationType
     */
    public void setOrientation(final OrientationType orientation) {
        updateSlider(SliderOption.ORIENTATION, orientation.getType());
    }

    protected boolean isRange() {
        return getBooleanAttribute(SliderOption.RANGE, false);
    }

    /**
     * Make range slider if set to <code>true</code>. If initial value is scalar,
     * max will be used for second value.
     *
     * @param range
     */
    protected void setRange(final boolean range) {
        updateSlider(SliderOption.RANGE, range);
    }

    public SelectionType getSelection() {
        return getEnumAttribute(SliderOption.SELECTION, SelectionType.class, SelectionType.BEFORE);
    }

    /**
     * Sets the selection type.
     *
     * @param selection
     * @see SelectionType
     */
    public void setSelection(final SelectionType selection) {
        updateSlider(SliderOption.SELECTION, selection.getType());
    }

    public TooltipType getTooltip() {
        return getEnumAttribute(SliderOption.TOOLTIP, TooltipType.class, TooltipType.SHOW);
    }

    /**
     * Sets the tool-tip type.
     *
     * @param tooltip
     * @see TooltipType
     */
    public void setTooltip(final TooltipType tooltip) {
        updateSlider(SliderOption.TOOLTIP, tooltip.getType());
    }

    public boolean isTooltipSplit() {
        return getBooleanAttribute(SliderOption.TOOLTIP_SPLIT, false);
    }

    /**
     * Show one too-tip if set to <code>false</code>, otherwise
     * show two tool-tips one for each handler.
     *
     * @param tooltipSplit
     */
    public void setTooltipSplit(final boolean tooltipSplit) {
        updateSlider(SliderOption.TOOLTIP_SPLIT, tooltipSplit);
    }

    public HandleType getHandle() {
        return getEnumAttribute(SliderOption.HANDLE, HandleType.class, HandleType.ROUND);
    }

    /**
     * Sets the handle shape.
     *
     * @param handle
     * @see HandleType
     */
    public void setHandle(final HandleType handle) {
        updateSlider(SliderOption.HANDLE, handle.getType());
    }

    public boolean isReversed() {
        return getBooleanAttribute(SliderOption.REVERSED, false);
    }

    /**
     * Sets whether or not the slider should be reversed.
     *
     * @param reversed
     */
    public void setReversed(final boolean reversed) {
        updateSlider(SliderOption.REVERSED, reversed);
    }

    @Override
    public boolean isEnabled() {
        if (isAttached()) {
            return isEnabled(getElement());
        }
        return getBooleanAttribute(SliderOption.ENABLED, true);
    }

    @Override
    public void setEnabled(final boolean enabled) {
        if (isAttached()) {
            if (enabled) {
                sliderCommand(getElement(), SliderCommand.ENABLE);
            } else {
                sliderCommand(getElement(), SliderCommand.DISABLE);
            }
        } else {
            updateSlider(SliderOption.ENABLED, enabled);
        }
    }

    /**
     * Sets the formatter callback.
     *
     * @param formatterCallback
     */
    public void setFormatter(final FormatterCallback<T> formatterCallback) {
        this.formatterCallback = formatterCallback;
        if (isAttached()) {
            setFormatter(getElement());
            refresh();
        }
    }

    /**
     * Sets the callback function of the {@link SliderOption#FORMATTER} attribute.
     *
     * @param element
     */
    protected abstract void setFormatter(Element element);

	protected String formatTooltip(final T value) {
        if (formatterCallback != null)
            return formatterCallback.formatTooltip(value);
        return convertToString(value);
    }

    /**
     * Converts the slider value to string value to be displayed
     * as tool-tip text.
     *
     * @param value
     * @return
     */
    protected abstract String convertToString(final T value);

    public boolean isNaturalArrowKeys() {
        return getBooleanAttribute(SliderOption.NATURAL_ARROW_KEYS, false);
    }

    /**
     * The natural order is used for the arrow keys. Arrow up select the
     * upper slider value for vertical sliders, arrow right the righter
     * slider value for a horizontal slider ; no matter if the slider
     * was reversed or not.<br>
     * <br>
     * By default the arrow keys are oriented by arrow up/right to the
     * higher slider value, arrow down/left to the lower slider value.
     *
     * @param naturalArrowKeys
     */
    public void setNaturalArrowKeys(final boolean naturalArrowKeys) {
        updateSlider(SliderOption.NATURAL_ARROW_KEYS, naturalArrowKeys);
    }

    public List<Double> getTicks() {
        return getNumberArrayAttribute(SliderOption.TICKS, Collections.<Double>emptyList());
    }

    /**
     * Sets the values of ticks. Tick marks are indicators to denote
     * special values in the range.<br>
     * <br>
     * This option overwrites min and max options.
     *
     * @param ticks
     */
    public void setTicks(final List<Double> ticks) {
        updateSliderForNumberArray(SliderOption.TICKS, ticks);
    }

    public List<String> getTicksLabels() {
        return getStringArrayAttribute(SliderOption.TICKS_LABELS, Collections.<String>emptyList());
    }

    /**
     * Sets the labels below the tick marks.<br>
     * <br>
     * Accepts HTML input.
     *
     * @param ticksLabels
     */
    public void setTicksLabels(final List<String> ticksLabels) {
        updateSliderForStringArray(SliderOption.TICKS_LABELS, ticksLabels);
    }

    public double getTicksSnapBounds() {
        return getDoubleAttribute(SliderOption.TICKS_SNAP_BOUNDS, 0);
    }

    /**
     * Sets the snap bounds of a tick. Snaps to the tick if value
     * is within these bounds.
     *
     * @param ticksSnapBounds
     */
    public void setTicksSnapBounds(final double ticksSnapBounds) {
        updateSlider(SliderOption.TICKS_SNAP_BOUNDS, ticksSnapBounds);
    }

    public ScaleType getScale() {
        return getEnumAttribute(SliderOption.SCALE, ScaleType.class, ScaleType.LINEAR);
    }

    /**
     * Sets the slider scale type.
     *
     * @param scale
     * @see ScaleType
     */
    public void setScale(final ScaleType scale) {
        updateSlider(SliderOption.SCALE, scale.getType());
    }

    @Override
    public void setVisible(final boolean visible) {
        if (isAttached()) {
            Element elem = getElement().getPreviousSiblingElement();
            if (elem != null) {
                setVisible(elem, visible);
                return;
            }
        }
        super.setVisible(visible);
    }

    @Override
    public boolean isVisible() {
        if (isAttached()) {
            Element elem = getElement().getPreviousSiblingElement();
            if (elem != null) {
                return isVisible(elem);
            }
        }
        return isVisible();
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
    public void setValue(final T value) {
        setValue(value, false);
    }

    @Override
    public void setValue(final T value, final boolean fireEvents) {

        T oldValue = fireEvents ? getValue() : null;

        if (isAttached()) {
            setValue(getElement(), value);
        } else {
            String attrVal = (value == null) ? null : value.toString();
            attributeMixin.setAttribute(SliderOption.VALUE.getDataAttribute(), attrVal);
        }

        if (fireEvents) {
            T newValue = getValue();
            ValueChangeEvent.fireIfNotEqual(this, oldValue, newValue);
        }
    }

    /**
     * Sets the given value to the slider. This method is only relevant if the
     * slider has been initialized and it will NOT fire the <b>slide</b> event.
     *
     * @param e
     * @param value
     */
    protected abstract void setValue(Element e, T value);

    @Override
    public T getValue() {
        if (isAttached()) {
            return getValue(getElement());
        }
        String attrVal = attributeMixin.getAttribute(SliderOption.VALUE.getDataAttribute());
        return convertValue(attrVal);
    }

    /**
     * Returns the value by invoking the JSNI <strong>getValue</strong> command.
     *
     * @param e
     * @return
     */
    protected abstract T getValue(Element e);

    /**
     * Converts the value of the {@link SliderOption#VALUE} attribute to the
     * slider value.
     *
     * @param value
     * @return
     */
    protected abstract T convertValue(String value);

    /**
     * Toggles the slider between enabled and disabled.
     */
    public void toggle() {
        if (isAttached()) {
            sliderCommand(getElement(), SliderCommand.TOGGLE);
        } else {
            setEnabled(!isEnabled());
        }
    }

    /**
     * Refreshes the current slider. This method does nothing if the slider has
     * not been initialized.
     */
    public void refresh() {
        if (isAttached()) {
            refreshWorkaround(getElement());
            sliderCommand(getElement(), SliderCommand.REFEESH);
        }
    }

    /**
     * Renders the tool-tip again, after initialization. Useful in situations
     * when the slider and tool-tip are initially hidden.
     */
    public void relayout() {
        if (isAttached()) {
            sliderCommand(getElement(), SliderCommand.RELAYOUT);
        }
    }

    @Override
    public LeafValueEditor<T> asEditor() {
        if (editor == null) {
            editor = TakesValueEditor.of(this);
        }
        return editor;
    }

    @Override
    public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<T> handler) {
        return addHandler(handler, ValueChangeEvent.getType());
    }

    @Override
    public HandlerRegistration addSlideHandler(final SlideHandler<T> handler) {
        return addHandler(handler, SlideEvent.getType());
    }

    @Override
    public HandlerRegistration addSlideStartHandler(final SlideStartHandler<T> handler) {
        return addHandler(handler, SlideStartEvent.getType());
    }

    @Override
    public HandlerRegistration addSlideStopHandler(final SlideStopHandler<T> handler) {
        return addHandler(handler, SlideStopEvent.getType());
    }

    @Override
    public HandlerRegistration addSlideEnabledHandler(final SlideEnabledHandler handler) {
        return addHandler(handler, SlideEnabledEvent.getType());
    }

    @Override
    public HandlerRegistration addSlideDisabledHandler(final SlideDisabledHandler handler) {
        return addHandler(handler, SlideDisabledEvent.getType());
    }

    private void updateSlider(SliderOption option, String value) {
        if (isAttached()) {
            setAttribute(getElement(), option.getName(), value);
            refresh();
        } else {
            attributeMixin.setAttribute(option.getDataAttribute(), value);
        }
    }

    private void updateSlider(SliderOption option, boolean value) {
        if (isAttached()) {
            setAttribute(getElement(), option.getName(), value);
            refresh();
        } else {
            attributeMixin.setAttribute(option.getDataAttribute(), Boolean.toString(value));
        }
    }

    private void updateSlider(SliderOption option, double value) {
        if (isAttached()) {
            setAttribute(getElement(), option.getName(), value);
            refresh();
        } else {
            attributeMixin.setAttribute(option.getDataAttribute(), Double.toString(value));
        }
    }

    private void updateSliderForNumberArray(SliderOption option, List<Double> value) {
        JsArrayNumber array = JavaScriptObject.createArray().cast();
        for (Double val : value) {
            array.push(val);
        }
        if (isAttached()) {
            setAttribute(getElement(), option.getName(), array);
            refresh();
        } else {
            String arrayStr = JsonUtils.stringify(array);
            attributeMixin.setAttribute(option.getDataAttribute(), arrayStr);
        }
    }

    private void updateSliderForStringArray(SliderOption option, List<String> value) {
        JsArrayString array = JavaScriptObject.createArray().cast();
        for (String val : value) {
            array.push(val);
        }
        if (isAttached()) {
            setAttribute(getElement(), option.getName(), array);
            refresh();
        } else {
            String arrayStr = JsonUtils.stringify(array);
            attributeMixin.setAttribute(option.getDataAttribute(), arrayStr);
        }
    }

    private String getStringAttribute(SliderOption option) {
        if (isAttached()) {
            return getStringAttribute(getElement(), option.getName());
        }
        return attributeMixin.getAttribute(option.getDataAttribute());
    }

    private boolean getBooleanAttribute(SliderOption option, boolean defaultValue) {
        if (isAttached()) {
            return getBooleanAttribute(getElement(), option.getName());
        }
        String value = attributeMixin.getAttribute(option.getDataAttribute());
        if (value != null && !value.isEmpty()) {
            return Boolean.valueOf(value);
        }
        return defaultValue;
    }

    private double getDoubleAttribute(SliderOption option, double defaultValue) {
        if (isAttached()) {
            return getDoubleAttribute(getElement(), option.getName());
        }
        String value = attributeMixin.getAttribute(option.getDataAttribute());
        if (value != null && !value.isEmpty()) {
            return Double.valueOf(value);
        }
        return defaultValue;
    }

    private <E extends Enum<E>> E getEnumAttribute(SliderOption option, Class<E> clazz, E defaultValue) {
        String value;
        if (isAttached()) {
            value = getStringAttribute(getElement(), option.getName());
        } else {
            value = attributeMixin.getAttribute(option.getDataAttribute());
        }
        try {
            return Enum.valueOf(clazz, value);
        } catch (Throwable e) {
            return defaultValue;
        }
    }

    private List<Double> getNumberArrayAttribute(SliderOption option, List<Double> defaultValue) {

        // Get array attribute
        JsArrayNumber array = null;
        if (isAttached()) {
            array = getNumberArrayAttribute(getElement(), option.getName());
        } else {
            String value = attributeMixin.getAttribute(option.getDataAttribute());
            if (value != null && !value.isEmpty()) {
                array = JsonUtils.safeEval(value);
            }
        }

        // Attribute not set
        if (array == null) {
            return defaultValue;
        }

        // Put array to list
        List<Double> list = new ArrayList<Double>(array.length());
        for (int i = 0; i < array.length(); i++) {
            list.add(array.get(i));
        }
        return list;
    }

    private List<String> getStringArrayAttribute(SliderOption option, List<String> defaultValue) {

        // Get array attribute
        JsArrayString array = null;
        if (isAttached()) {
            array = getStringArrayAttribute(getElement(), option.getName());
        } else {
            String value = attributeMixin.getAttribute(option.getDataAttribute());
            if (value != null && !value.isEmpty()) {
                array = JsonUtils.safeEval(value);
            }
        }

        // Attribute not set
        if (array == null) {
            return defaultValue;
        }

        // Put array to list
        List<String> list = new ArrayList<String>(array.length());
        for (int i = 0; i < array.length(); i++) {
            list.add(array.get(i));
        }
        return list;
    }

    private native void initSlider(Element e, JavaScriptObject options) /*-{
        $wnd.jQuery(e).slider(options);
    }-*/;

    /**
     * Called when a {@link SlideEvent} is fired.
     *
     * @param event the native event
     */
    protected abstract void onSlide(final Event event);

    /**
     * Fires a {@link SlideEvent} event.
     *
     * @param value the new slide value
     */
    protected void fireSlideEvent(final T value) {
        SlideEvent.fire(this, value);
    }

    /**
     * Called when a {@link SlideStartEvent} is fired.
     *
     * @param event the native event
     */
    protected abstract void onSlideStart(final Event event);

    /**
     * Fires a {@link SlideStartEvent} event.
     *
     * @param value the new slide value
     */
    protected void fireSlideStartEvent(final T value) {
        SlideStartEvent.fire(this, value);
    }

    /**
     * Called when a {@link SlideStopEvent} is fired.
     *
     * @param event the native event
     */
    protected abstract void onSlideStop(final Event event);

    /**
     * Fires a {@link SlideStopEvent} event.
     *
     * @param value the new slide value
     */
    protected void fireSlideStopEvent(final T value) {
        SlideStopEvent.fire(this, value);
    }

    /**
     * Called when a {@link ValueChangeEvent} is fired.
     *
     * @param event the native event
     */
    protected abstract void onSlideChange(final Event event);

    /**
     * Fires a {@link ValueChangeEvent} event.
     *
     * @param value the new slide value
     */
    protected void fireChangeEvent(final T value) {
        ValueChangeEvent.fire(this, value);
    }

    /**
     * Binds the slider events.
     *
     * @param e
     */
    private native void bindSliderEvents(Element e) /*-{
        var slider = this;
        $wnd.jQuery(e).on(@org.gwtbootstrap3.extras.slider.client.ui.base.event.HasAllSlideHandlers::SLIDE_EVENT, function(event) {
            slider.@org.gwtbootstrap3.extras.slider.client.ui.base.SliderBase::onSlide(Lcom/google/gwt/user/client/Event;)(event);
        });
        $wnd.jQuery(e).on(@org.gwtbootstrap3.extras.slider.client.ui.base.event.HasAllSlideHandlers::SLIDE_START_EVENT, function(event) {
            slider.@org.gwtbootstrap3.extras.slider.client.ui.base.SliderBase::onSlideStart(Lcom/google/gwt/user/client/Event;)(event);
        });
        $wnd.jQuery(e).on(@org.gwtbootstrap3.extras.slider.client.ui.base.event.HasAllSlideHandlers::SLIDE_STOP_EVENT, function(event) {
            slider.@org.gwtbootstrap3.extras.slider.client.ui.base.SliderBase::onSlideStop(Lcom/google/gwt/user/client/Event;)(event);
        });
        $wnd.jQuery(e).on(@org.gwtbootstrap3.extras.slider.client.ui.base.event.HasAllSlideHandlers::SLIDE_CHANGE_EVENT, function(event) {
            slider.@org.gwtbootstrap3.extras.slider.client.ui.base.SliderBase::onSlideChange(Lcom/google/gwt/user/client/Event;)(event);
        });
        $wnd.jQuery(e).on(@org.gwtbootstrap3.extras.slider.client.ui.base.event.HasAllSlideHandlers::SLIDE_ENABLED_EVENT, function(event) {
            @org.gwtbootstrap3.extras.slider.client.ui.base.event.SlideEnabledEvent::fire(Lorg/gwtbootstrap3/extras/slider/client/ui/base/event/HasSlideEnabledHandlers;)(slider);
        });
        $wnd.jQuery(e).on(@org.gwtbootstrap3.extras.slider.client.ui.base.event.HasAllSlideHandlers::SLIDE_DISABLED_EVENT, function(event) {
            @org.gwtbootstrap3.extras.slider.client.ui.base.event.SlideDisabledEvent::fire(Lorg/gwtbootstrap3/extras/slider/client/ui/base/event/HasSlideDisabledHandlers;)(slider);
        });
    }-*/;

    /**
     * Unbinds the slider events.
     *
     * @param e
     */
    private native void unbindSliderEvents(Element e) /*-{
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.slider.client.ui.base.event.HasAllSlideHandlers::SLIDE_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.slider.client.ui.base.event.HasAllSlideHandlers::SLIDE_START_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.slider.client.ui.base.event.HasAllSlideHandlers::SLIDE_STOP_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.slider.client.ui.base.event.HasAllSlideHandlers::SLIDE_CHANGE_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.slider.client.ui.base.event.HasAllSlideHandlers::SLIDE_ENABLED_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.slider.client.ui.base.event.HasAllSlideHandlers::SLIDE_DISABLED_EVENT);
    }-*/;

    private native boolean isEnabled(Element e) /*-{
        return $wnd.jQuery(e).slider(@org.gwtbootstrap3.extras.slider.client.ui.base.SliderCommand::IS_ENABLED);
    }-*/;

    /**
     * FIXME: This is a workaround for the refresh command, since it is buggy in
     * the current version (4.5.6). After executing this command, the slider
     * becomes consistently a range slider with 2 handles. This should be
     * removed once the bug is fixed in a future version.
     *
     * @see https://github.com/seiyria/bootstrap-slider/issues/306
     *
     * @param e
     */
    private native void refreshWorkaround(Element e) /*-{
        var value = $wnd.jQuery(e).slider(@org.gwtbootstrap3.extras.slider.client.ui.base.SliderCommand::GET_VALUE);
        var option = @org.gwtbootstrap3.extras.slider.client.ui.base.SliderOption::VALUE;
        var attr = option.@org.gwtbootstrap3.extras.slider.client.ui.base.SliderOption::getName()();
        $wnd.jQuery(e).slider(@org.gwtbootstrap3.extras.slider.client.ui.base.SliderCommand::SET_ATTRIBUTE, attr, value);
    }-*/;

    private native void sliderCommand(Element e, String cmd) /*-{
        $wnd.jQuery(e).slider(cmd);
    }-*/;

    private native void setAttribute(Element e, String attr, String value) /*-{
        $wnd.jQuery(e).slider(@org.gwtbootstrap3.extras.slider.client.ui.base.SliderCommand::SET_ATTRIBUTE, attr, value);
    }-*/;

    private native void setAttribute(Element e, String attr, boolean value) /*-{
        $wnd.jQuery(e).slider(@org.gwtbootstrap3.extras.slider.client.ui.base.SliderCommand::SET_ATTRIBUTE, attr, value);
    }-*/;

    private native void setAttribute(Element e, String attr, double value) /*-{
        $wnd.jQuery(e).slider(@org.gwtbootstrap3.extras.slider.client.ui.base.SliderCommand::SET_ATTRIBUTE, attr, value);
    }-*/;

    private native void setAttribute(Element e, String attr, JsArrayNumber value) /*-{
        $wnd.jQuery(e).slider(@org.gwtbootstrap3.extras.slider.client.ui.base.SliderCommand::SET_ATTRIBUTE, attr, value);
    }-*/;

    private native void setAttribute(Element e, String attr, JsArrayString value) /*-{
        $wnd.jQuery(e).slider(@org.gwtbootstrap3.extras.slider.client.ui.base.SliderCommand::SET_ATTRIBUTE, attr, value);
    }-*/;

    private native String getStringAttribute(Element e, String attr) /*-{
        return $wnd.jQuery(e).slider(@org.gwtbootstrap3.extras.slider.client.ui.base.SliderCommand::GET_ATTRIBUTE, attr);
    }-*/;

    private native boolean getBooleanAttribute(Element e, String attr) /*-{
        return $wnd.jQuery(e).slider(@org.gwtbootstrap3.extras.slider.client.ui.base.SliderCommand::GET_ATTRIBUTE, attr);
    }-*/;

    private native double getDoubleAttribute(Element e, String attr) /*-{
        return $wnd.jQuery(e).slider(@org.gwtbootstrap3.extras.slider.client.ui.base.SliderCommand::GET_ATTRIBUTE, attr);
    }-*/;

    private native JsArrayNumber getNumberArrayAttribute(Element e, String attr) /*-{
        return $wnd.jQuery(e).slider(@org.gwtbootstrap3.extras.slider.client.ui.base.SliderCommand::GET_ATTRIBUTE, attr);
    }-*/;

    private native JsArrayString getStringArrayAttribute(Element e, String attr) /*-{
        return $wnd.jQuery(e).slider(@org.gwtbootstrap3.extras.slider.client.ui.base.SliderCommand::GET_ATTRIBUTE, attr);
    }-*/;

}
