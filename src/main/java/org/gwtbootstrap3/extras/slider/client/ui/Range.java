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

/**
 * Slider range with a min value and a max value.
 */
public class Range {

    private float minValue;
    private float maxValue;

    protected Range() {
    }

    /**
     * Create a slider range with a min value and a max value.
     *
     * @param minValue
     * @param maxValue
     */
    public Range(final float minValue, final float maxValue) {
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
        this(new Float(array.get(0)), new Float(array.get(1)));
    }

    /**
     * Returns the min value.
     *
     * @return the min value
     */
    public float getMinValue() {
        return minValue;
    }

    /**
     * Returns the max value.
     *
     * @return the max value
     */
    public float getMaxValue() {
        return maxValue;
    }

    public JsArrayNumber toJsArray() {
        JsArrayNumber array = JavaScriptObject.createArray().cast();
        array.push(minValue);
        array.push(maxValue);
        return array;
    }

    @Override
    public String toString() {
        return new StringBuilder("Range [")
            .append("minValue=").append(getMinValue()).append(", ")
            .append("maxValue=").append(getMaxValue())
            .append("]").toString();
    }

}
