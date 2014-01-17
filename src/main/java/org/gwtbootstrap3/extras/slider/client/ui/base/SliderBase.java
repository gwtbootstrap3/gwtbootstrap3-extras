package org.gwtbootstrap3.extras.slider.client.ui.base;

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

import org.gwtbootstrap3.client.shared.event.HideHandler;
import org.gwtbootstrap3.client.shared.event.ShowHandler;
import org.gwtbootstrap3.client.ui.HasId;
import org.gwtbootstrap3.client.ui.HasResponsiveness;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.HasVisibleHandlers;

import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasVisibility;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Grant Slender
 */
public class SliderBase extends Widget implements HasValue<Float>, HasEnabled, HasValueChangeHandlers<Float>,
        HasVisibility, HasChangeHandlers, HasVisibleHandlers, HasId, HasResponsiveness {

    /**
     * Orig source from https://github.com/seiyria/bootstrap-slider
     */


    public SliderBase() {
    }

    @Override
    public void setVisibleOn(String deviceSizeString) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setHiddenOn(String deviceSizeString) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setId(String id) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public HandlerRegistration addChangeHandler(ChangeHandler handler) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Float> handler) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setEnabled(boolean enabled) {
        // TODO Auto-generated method stub

    }

    @Override
    public Float getValue() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setValue(Float value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setValue(Float value, boolean fireEvents) {
        // TODO Auto-generated method stub

    }

    @Override
    public HandlerRegistration addHideHandler(HideHandler handler) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public HandlerRegistration addShowHandler(ShowHandler handler) {
        // TODO Auto-generated method stub
        return null;
    }

}
