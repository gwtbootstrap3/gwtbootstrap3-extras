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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsonUtils;

/**
 * Slider range with a min value and a max value.
 */
public class Range {

    private double minValue;
    private double maxValue;

    protected Range() {
    }

    /**
     * Create a slider range with a min value and a max value.
     *
     * @param minValue
     * @param maxValue
     */
    public Range(final double minValue, final double maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    /**
     * Creates a slider range with a JavaScritp number array. <br>
     * <br>
     * This constructor is useful in JSNI calls.
     *
     * @param array
     */
    public Range(final JsArrayNumber array) {
        this(array.get(0), array.get(1));
    }

    /**
     * Returns the min value.
     *
     * @return the min value
     */
    public double getMinValue() {
        return minValue;
    }

    /**
     * Returns the max value.
     *
     * @return the max value
     */
    public double getMaxValue() {
        return maxValue;
    }

    /**
     * Converts the range to a JavaScript number array.
     *
     * @return a JavaScript number array
     */
    public JsArrayNumber toJsArray() {
        JsArrayNumber array = JavaScriptObject.createArray().cast();
        array.push(minValue);
        array.push(maxValue);
        return array;
    }

    /**
     * Converts the given string to a range instance.<br>
     * <br>
     * Useful when using UiBinder.
     *
     * @param value
     * @return
     */
    public static Range fromString(String value) {
        if (value == null || value.isEmpty())
            return null;
        JsArrayNumber array = JsonUtils.safeEval(value);
        return new Range(array);
    }

    @Override
    public String toString() {
        return new StringBuilder("[")
            .append(getMinValue()).append(", ")
            .append(getMaxValue())
            .append("]").toString();
    }

}
