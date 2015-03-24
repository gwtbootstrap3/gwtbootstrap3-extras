package org.gwtbootstrap3.extras.datepicker.client.ui.base.constants;

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

/**
 * Boolean. Default: true
 * <p/>
 * Whether or not to force parsing of the input value when the picker is closed.
 * That is, when an invalid date is left in the input field by the user, the picker will forcibly parse
 * that value, and set the input's value to the new, valid date, conforming to the given format.
 *
 * @author Joshua Godi
 */
public interface HasForceParse {
    void setForceParse(boolean forceParse);
}
