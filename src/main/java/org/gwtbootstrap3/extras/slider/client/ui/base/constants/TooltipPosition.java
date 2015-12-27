package org.gwtbootstrap3.extras.slider.client.ui.base.constants;

import org.gwtbootstrap3.client.ui.constants.Type;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2015 GwtBootstrap3
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
 * Position of tooltip, relative to slider. Accepts {@link #TOP}
 * or {@link #BOTTOM} for horizontal sliders; and {@link #LEFT}
 * or {@link #RIGHT} for vertically orientated sliders.<br>
 * <br>
 * Default positions are {@link #TOP} for horizontal and {@link #RIGHT}
 * for vertical slider.
 *
 * @author Xiaodong SUN
 */
public enum TooltipPosition implements Type {

    TOP("top"),
    BOTTOM("bottom"),
    LEFT("left"),
    RIGHT("right"),
    ;

    private final String position;

    private TooltipPosition(final String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
}
