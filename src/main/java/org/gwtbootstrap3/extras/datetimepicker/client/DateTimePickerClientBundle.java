package org.gwtbootstrap3.extras.datetimepicker.client;

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


import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * @author Sven Jacobs
 */
public interface DateTimePickerClientBundle extends ClientBundle {

    static final DateTimePickerClientBundle INSTANCE = GWT.create(DateTimePickerClientBundle.class);

    @Source("resource/js/bootstrap-datetimepicker.min.js")
    TextResource dateTimePicker();

    @Source("resource/js/locales/bootstrap-datetimepicker.bg.js")
    TextResource bg();

    @Source("resource/js/locales/bootstrap-datetimepicker.ca.js")
    TextResource ca();

    @Source("resource/js/locales/bootstrap-datetimepicker.cs.js")
    TextResource cs();

    @Source("resource/js/locales/bootstrap-datetimepicker.da.js")
    TextResource da();

    @Source("resource/js/locales/bootstrap-datetimepicker.de.js")
    TextResource de();

    @Source("resource/js/locales/bootstrap-datetimepicker.el.js")
    TextResource el();

    @Source("resource/js/locales/bootstrap-datetimepicker.es.js")
    TextResource es();

    @Source("resource/js/locales/bootstrap-datetimepicker.fi.js")
    TextResource fi();

    @Source("resource/js/locales/bootstrap-datetimepicker.fr.js")
    TextResource fr();

    @Source("resource/js/locales/bootstrap-datetimepicker.he.js")
    TextResource he();

    @Source("resource/js/locales/bootstrap-datetimepicker.hr.js")
    TextResource hr();

    @Source("resource/js/locales/bootstrap-datetimepicker.hu.js")
    TextResource hu();

    @Source("resource/js/locales/bootstrap-datetimepicker.id.js")
    TextResource id();

    @Source("resource/js/locales/bootstrap-datetimepicker.is.js")
    TextResource is();

    @Source("resource/js/locales/bootstrap-datetimepicker.it.js")
    TextResource it();

    @Source("resource/js/locales/bootstrap-datetimepicker.ja.js")
    TextResource ja();

    @Source("resource/js/locales/bootstrap-datetimepicker.kr.js")
    TextResource kr();

    @Source("resource/js/locales/bootstrap-datetimepicker.lt.js")
    TextResource lt();

    @Source("resource/js/locales/bootstrap-datetimepicker.lv.js")
    TextResource lv();

    @Source("resource/js/locales/bootstrap-datetimepicker.ms.js")
    TextResource ms();

    @Source("resource/js/locales/bootstrap-datetimepicker.nb.js")
    TextResource nb();

    @Source("resource/js/locales/bootstrap-datetimepicker.nl.js")
    TextResource nl();

    @Source("resource/js/locales/bootstrap-datetimepicker.no.js")
    TextResource no();

    @Source("resource/js/locales/bootstrap-datetimepicker.pl.js")
    TextResource pl();

    @Source("resource/js/locales/bootstrap-datetimepicker.pt-BR.js")
    TextResource pt_BR();

    @Source("resource/js/locales/bootstrap-datetimepicker.pt.js")
    TextResource pt();

    @Source("resource/js/locales/bootstrap-datetimepicker.ro.js")
    TextResource ro();

    @Source("resource/js/locales/bootstrap-datetimepicker.rs-latin.js")
    TextResource rs_latin();

    @Source("resource/js/locales/bootstrap-datetimepicker.rs.js")
    TextResource rs();

    @Source("resource/js/locales/bootstrap-datetimepicker.ru.js")
    TextResource ru();

    @Source("resource/js/locales/bootstrap-datetimepicker.sk.js")
    TextResource sk();

    @Source("resource/js/locales/bootstrap-datetimepicker.sl.js")
    TextResource sl();

    @Source("resource/js/locales/bootstrap-datetimepicker.sv.js")
    TextResource sv();

    @Source("resource/js/locales/bootstrap-datetimepicker.sw.js")
    TextResource sw();

    @Source("resource/js/locales/bootstrap-datetimepicker.th.js")
    TextResource th();

    @Source("resource/js/locales/bootstrap-datetimepicker.tr.js")
    TextResource tr();

    @Source("resource/js/locales/bootstrap-datetimepicker.ua.js")
    TextResource ua();

    @Source("resource/js/locales/bootstrap-datetimepicker.uk.js")
    TextResource uk();

    @Source("resource/js/locales/bootstrap-datetimepicker.zh-CN.js")
    TextResource zh_CN();

    @Source("resource/js/locales/bootstrap-datetimepicker.zh-TW.js")
    TextResource zh_TW();
}
