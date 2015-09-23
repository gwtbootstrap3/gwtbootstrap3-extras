package org.gwtbootstrap3.extras.summernote.client.ui.base.mixin;

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

import com.google.web.bindery.event.shared.HandlerRegistration;
import org.gwtbootstrap3.client.ui.base.mixin.BlankValidatorMixin;
import org.gwtbootstrap3.client.ui.form.error.ErrorHandler;

import org.gwtbootstrap3.extras.summernote.client.event.SummernoteOnBlurEvent;
import org.gwtbootstrap3.extras.summernote.client.event.SummernoteOnBlurHandler;
import org.gwtbootstrap3.extras.summernote.client.ui.base.SummernoteBase;

/**
 * Summernote validator mixin. Contains all of the validation logic.
 * 
 * @author Ben Dol
 */
public class SummernoteValidatorMixin extends BlankValidatorMixin<SummernoteBase, String> {
    
    /**
     * Instantiates a new abstract validator mixin.
     *
     * @param summernote the summernote widget
     * @param errorHandler the error handler
     */
    public SummernoteValidatorMixin(SummernoteBase summernote, ErrorHandler errorHandler) {
        super(summernote, errorHandler);
    }

    @Override
    protected HandlerRegistration setupBlurValidation() {
        return getInputWidget().addBlurHandler(new SummernoteOnBlurHandler() {
            @Override
            public void onBlur(SummernoteOnBlurEvent event) {
                validate(getValidateOnBlur());
            }
        });
    }
}
