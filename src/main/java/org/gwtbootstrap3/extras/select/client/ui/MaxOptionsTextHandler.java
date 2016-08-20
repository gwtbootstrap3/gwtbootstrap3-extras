package org.gwtbootstrap3.extras.select.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2016 GwtBootstrap3
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
 * Handler to set the text displayed when {@link SelectOptions#MAX_OPTIONS}
 * is enabled and the maximum number of options within the entire select or
 * an option group have been selected.
 *
 * @author Xiaodong Sun
 */
public interface MaxOptionsTextHandler {

    /**
     * Returns the text displayed when {@link SelectOptions#MAX_OPTIONS}
     * is enabled and the maximum number of options within the select
     * have been selected<br>
     * <br>
     * Defaults to <code>Limit reached ({n} item(s) max)</code>
     *
     * @param maxOptions maximum number of the select
     * @return the text displayed when the maximum number of
     *     options within the select have been selected
     */
    String getMaxSelectOptionsText(int maxSelectOptions);

    /**
     * Returns the text displayed when {@link SelectOptions#MAX_OPTIONS}
     * is enabled and the maximum number of options within an option
     * group have been selected<br>
     * <br>
     * Defaults to <code>Group limit reached ({n} item(s) max)</code>
     *
     * @param maxGroupOptions maximum number of an option group
     * @return the text displayed when the maximum number of options
     *     within an option group have been selected
     */
    String getMaxGroupOptionsText(int maxGroupOptions);

}
