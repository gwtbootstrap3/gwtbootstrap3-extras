package org.gwtbootstrap3.extras.summernote.client.ui.base;

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

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JsArrayMixed;

/**
 * Wrapper for the Summernote WYSIWYG Editor
 * <p/>
 * See: http://summernote.org/
 *
 * @author Xiaodong Sun
 */
public class Toolbar {

    private static final String GROUP_PREFIX = "group_";
    private static int GROUP_INDEX = 0;
    private List<JsArrayMixed> groups = new ArrayList<>(0);

    /**
     * Add a new toolbar group with the specified buttons.
     *
     * @param buttons the toolbar buttons to be added
     * @return {@link Toolbar}
     */
    public Toolbar addGroup(ToolbarButton... buttons) {
        groups.add(SummernoteOptions.newToolbarGroup(GROUP_PREFIX + GROUP_INDEX++, buttons));
        return this;
    }

    JsArrayMixed build() {
        return SummernoteOptions.buildToolbar(groups.toArray(new JsArrayMixed[0]));
    }
}

