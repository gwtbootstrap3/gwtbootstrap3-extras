package org.gwtbootstrap3.extras.fullcalendar.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2014 GwtBootstrap3
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

import java.util.HashMap;
import java.util.Map;

/**
 * A super class to help model the view options
 *
 * @author Jeff Isenhart
 * @see http://arshaw.com/fullcalendar/docs/views/View_Option_Hash/
 * Currently, View Option Hashes only work for dragOpacity, titleFormat, columnFormat, and timeFormat.
 */
public abstract class AbstractViewOptionFormat {

    protected abstract void populateDefaultOptions(Map<ViewOptionHash, String> options);

    protected AbstractViewOptionFormat() {
    }

    protected Map<ViewOptionHash, String> getDefaultOptions() {
        final Map<ViewOptionHash, String> map = new HashMap<ViewOptionHash, String>();
        populateDefaultOptions(map);
        return map;
    }
}
