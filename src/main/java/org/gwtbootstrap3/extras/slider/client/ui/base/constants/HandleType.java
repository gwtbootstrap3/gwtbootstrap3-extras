package org.gwtbootstrap3.extras.slider.client.ui.base.constants;

import org.gwtbootstrap3.client.ui.constants.Type;

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

/**
 * Slider handle shape.
 *
 * @author Xiaodong SUN
 */
public enum HandleType implements Type {

    ROUND("round"),
    SQUARE("square"),
    TRIANGLE("triangle"),
    CUSTOM("custom"),
    ;

    private final String type;

    private HandleType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
