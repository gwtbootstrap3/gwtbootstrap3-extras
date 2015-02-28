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
import com.google.gwt.user.client.Event;

/**
 * This slider simply takes a numeric value.
 *
 * @author Xiaodong SUN
 */
public class Slider extends SliderBase<Float> {

    /**
     * Creates a numerical slider.
     */
    public Slider() {
        setRange(false);
    }

    /**
     * Creates a numerical slider with min, max, and value.
     *
     * @param min
     * @param max
     * @param value
     */
    public Slider(final float min, final float max, final float value) {
        this();
        setMin(min);
        setMax(max);
        setValue(value);
    }

    @Override
    protected native void setValue(Element e, Float value) /*-{
        var floatValue = value.@java.lang.Float::floatValue()();
        $wnd.jQuery(e).slider(@org.gwtbootstrap3.extras.slider.client.ui.base.SliderCommand::SET_VALUE, floatValue);
    }-*/;

    @Override
    protected native Float getValue(Element e) /*-{
        return $wnd.jQuery(e).slider(@org.gwtbootstrap3.extras.slider.client.ui.base.SliderCommand::GET_VALUE);
    }-*/;

    @Override
    protected Float convertValue(String value) {
        if (value == null || value.isEmpty())
            return null;
        return Float.valueOf(value);
    }

    @Override
    protected native void onSlide(Event event) /*-{
        this.@org.gwtbootstrap3.extras.slider.client.ui.Slider::fireSlideEvent(Ljava/lang/Float;)(event.value);
    }-*/;

    @Override
    protected native void onSlideStart(Event event) /*-{
        this.@org.gwtbootstrap3.extras.slider.client.ui.Slider::fireSlideStartEvent(Ljava/lang/Float;)(event.value);
    }-*/;

    @Override
    protected native void onSlideStop(Event event) /*-{
        this.@org.gwtbootstrap3.extras.slider.client.ui.Slider::fireSlideStopEvent(Ljava/lang/Float;)(event.value);
    }-*/;

    @Override
    protected native void onSlideChange(Event event) /*-{
        this.@org.gwtbootstrap3.extras.slider.client.ui.Slider::fireChangeEvent(Ljava/lang/Float;)(event.value.newValue);
    }-*/;

}
