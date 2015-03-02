package org.gwtbootstrap3.extras.slider.client.ui;

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

import org.gwtbootstrap3.extras.slider.client.ui.base.SliderBase;

import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.Event;

/**
 * This slider takes as value a range with a min value and a max value.
 *
 * @author Xiaodong SUN
 */
public class RangeSlider extends SliderBase<Range> {

    /**
     * Creates a range slider.
     */
    public RangeSlider() {
        setRange(true);
    }

    /**
     * Creates a range slider with min, max, and range value.
     *
     * @param min
     * @param max
     * @param range
     */
    public RangeSlider(final double min, final double max, final Range range) {
        this();
        setMin(min);
        setMax(max);
        setValue(range);
    }

    /**
     * Creates a range slider with min, max, and range value.<br>
     * <br>
     * Useful for UiBinder.
     *
     * @param min
     * @param max
     * @param value
     */
    @UiConstructor
    public RangeSlider(final double min, final double max, final String value) {
		this(min, max, Range.fromString(value));
    }

    @Override
    protected native void setValue(Element e, Range value) /*-{
        var range = value.@org.gwtbootstrap3.extras.slider.client.ui.Range::toJsArray()();
        $wnd.jQuery(e).slider(@org.gwtbootstrap3.extras.slider.client.ui.base.SliderCommand::SET_VALUE, range);
    }-*/;

    @Override
    protected native Range getValue(Element e) /*-{
        var range = $wnd.jQuery(e).slider(@org.gwtbootstrap3.extras.slider.client.ui.base.SliderCommand::GET_VALUE);
        return @org.gwtbootstrap3.extras.slider.client.ui.Range::new(Lcom/google/gwt/core/client/JsArrayNumber;)(range);
    }-*/;

    @Override
    protected Range convertValue(String value) {
        return Range.fromString(value);
    }

    @Override
    protected native void onSlide(Event event) /*-{
        var range = @org.gwtbootstrap3.extras.slider.client.ui.Range::new(Lcom/google/gwt/core/client/JsArrayNumber;)(event.value);
        this.@org.gwtbootstrap3.extras.slider.client.ui.RangeSlider::fireSlideEvent(Lorg/gwtbootstrap3/extras/slider/client/ui/Range;)(range);
    }-*/;

    @Override
    protected native void onSlideStart(Event event) /*-{
        var range = @org.gwtbootstrap3.extras.slider.client.ui.Range::new(Lcom/google/gwt/core/client/JsArrayNumber;)(event.value);
        this.@org.gwtbootstrap3.extras.slider.client.ui.RangeSlider::fireSlideStartEvent(Lorg/gwtbootstrap3/extras/slider/client/ui/Range;)(range);
    }-*/;

    @Override
    protected native void onSlideStop(Event event) /*-{
        var range = @org.gwtbootstrap3.extras.slider.client.ui.Range::new(Lcom/google/gwt/core/client/JsArrayNumber;)(event.value);
        this.@org.gwtbootstrap3.extras.slider.client.ui.RangeSlider::fireSlideStopEvent(Lorg/gwtbootstrap3/extras/slider/client/ui/Range;)(range);
    }-*/;

    @Override
    protected native void onSlideChange(Event event) /*-{
        var range = @org.gwtbootstrap3.extras.slider.client.ui.Range::new(Lcom/google/gwt/core/client/JsArrayNumber;)(event.value.newValue);
        this.@org.gwtbootstrap3.extras.slider.client.ui.RangeSlider::fireChangeEvent(Lorg/gwtbootstrap3/extras/slider/client/ui/Range;)(range);
    }-*/;

}
