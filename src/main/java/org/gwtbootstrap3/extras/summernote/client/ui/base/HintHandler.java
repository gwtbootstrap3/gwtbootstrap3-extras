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

import com.google.gwt.dom.client.Node;

/**
 * Handler interface for Summernote Hint (auto-completion) feature.
 *
 * @author Xiaodong Sun
 */
public interface HintHandler {

    /**
     * Returns the suggestion items for the matched keyword.<br>
     * <br>
     * <b>REQUIRED</b>: it must be implemented.
     *
     * @param keyword the matched keyword.
     * @return the suggestion items
     */
    String[] onSearch(String keyword);

    /**
     * Returns the suggestion item's template on suggestion pop-over.<br>
     * <br>
     * <b>OPTIONAL</b>: defaults to the suggestion item.
     *
     * @param item suggestion item
     * @return the item template (may be HTML)
     */
    String getTemplate(String item);

    /**
     * Returns the node to be inserted to the editor when selecting a
     * suggestion.<br>
     * <br>
     * <b>OPTIONAL</b>: defaults to simple text node for suggestion item.
     *
     * @param item selected suggestion item
     * @return the node to be inserted to the editor
     */
    Node getContent(String item);

}
