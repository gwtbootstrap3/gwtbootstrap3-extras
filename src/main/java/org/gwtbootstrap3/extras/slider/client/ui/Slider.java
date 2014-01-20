package org.gwtbootstrap3.extras.slider.client.ui;

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

import org.gwtbootstrap3.extras.slider.client.ui.base.SliderBase;

/**
 * @author Grant Slender
 */
public class Slider extends SliderBase {

    public Slider() {
        super();
    }

    public Slider(float min, float max, float value) {
        super();
        setMin(min);
        setMax(max);
        setValue(value);
    }

    public Slider(int min, int max, int value) {
        this((float)min,(float)max,(float)value);
    }
}
