package org.gwtbootstrap3.extras.datetimepicker.client;

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

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * @author Sven Jacobs
 */
public interface DateTimePickerClientBundle extends ClientBundle {

    static final DateTimePickerClientBundle INSTANCE = GWT.create(DateTimePickerClientBundle.class);

    static final String VERSION = "2.4.4";
    static final String I18N_DIR = "resource/js/locales-" + VERSION + "/";

    @Source("resource/js/bootstrap-datetimepicker-" + VERSION + ".min.cache.js")
    TextResource dateTimePicker();

    @Source(I18N_DIR + "bootstrap-datetimepicker.ar.js")
    TextResource ar();

    @Source(I18N_DIR + "bootstrap-datetimepicker.az.js")
    TextResource az();

    @Source(I18N_DIR + "bootstrap-datetimepicker.bg.js")
    TextResource bg();

    @Source(I18N_DIR + "bootstrap-datetimepicker.bn.js")
    TextResource bn();

    @Source(I18N_DIR + "bootstrap-datetimepicker.ca.js")
    TextResource ca();

    @Source(I18N_DIR + "bootstrap-datetimepicker.cs.js")
    TextResource cs();

    @Source(I18N_DIR + "bootstrap-datetimepicker.da.js")
    TextResource da();

    @Source(I18N_DIR + "bootstrap-datetimepicker.de.js")
    TextResource de();

    @Source(I18N_DIR + "bootstrap-datetimepicker.ee.js")
    TextResource ee();

    @Source(I18N_DIR + "bootstrap-datetimepicker.el.js")
    TextResource el();

    @Source(I18N_DIR + "bootstrap-datetimepicker.es.js")
    TextResource es();

    @Source(I18N_DIR + "bootstrap-datetimepicker.fi.js")
    TextResource fi();

    @Source(I18N_DIR + "bootstrap-datetimepicker.fr.js")
    TextResource fr();

    @Source(I18N_DIR + "bootstrap-datetimepicker.he.js")
    TextResource he();

    @Source(I18N_DIR + "bootstrap-datetimepicker.hr.js")
    TextResource hr();

    @Source(I18N_DIR + "bootstrap-datetimepicker.hu.js")
    TextResource hu();

    @Source(I18N_DIR + "bootstrap-datetimepicker.id.js")
    TextResource id();

    @Source(I18N_DIR + "bootstrap-datetimepicker.is.js")
    TextResource is();

    @Source(I18N_DIR + "bootstrap-datetimepicker.it.js")
    TextResource it();

    @Source(I18N_DIR + "bootstrap-datetimepicker.ja.js")
    TextResource ja();

    @Source(I18N_DIR + "bootstrap-datetimepicker.ka.js")
    TextResource ka();

    @Source(I18N_DIR + "bootstrap-datetimepicker.ko.js")
    TextResource ko();

    @Source(I18N_DIR + "bootstrap-datetimepicker.lt.js")
    TextResource lt();

    @Source(I18N_DIR + "bootstrap-datetimepicker.lv.js")
    TextResource lv();

    @Source(I18N_DIR + "bootstrap-datetimepicker.ms.js")
    TextResource ms();

    @Source(I18N_DIR + "bootstrap-datetimepicker.nb.js")
    TextResource nb();

    @Source(I18N_DIR + "bootstrap-datetimepicker.nl.js")
    TextResource nl();

    @Source(I18N_DIR + "bootstrap-datetimepicker.no.js")
    TextResource no();

    @Source(I18N_DIR + "bootstrap-datetimepicker.pl.js")
    TextResource pl();

    @Source(I18N_DIR + "bootstrap-datetimepicker.pt-BR.js")
    TextResource pt_BR();

    @Source(I18N_DIR + "bootstrap-datetimepicker.pt.js")
    TextResource pt();

    @Source(I18N_DIR + "bootstrap-datetimepicker.ro.js")
    TextResource ro();

    @Source(I18N_DIR + "bootstrap-datetimepicker.rs-latin.js")
    TextResource rs_latin();

    @Source(I18N_DIR + "bootstrap-datetimepicker.rs.js")
    TextResource rs();

    @Source(I18N_DIR + "bootstrap-datetimepicker.ru.js")
    TextResource ru();

    @Source(I18N_DIR + "bootstrap-datetimepicker.sk.js")
    TextResource sk();

    @Source(I18N_DIR + "bootstrap-datetimepicker.sl.js")
    TextResource sl();

    @Source(I18N_DIR + "bootstrap-datetimepicker.sv.js")
    TextResource sv();

    @Source(I18N_DIR + "bootstrap-datetimepicker.sw.js")
    TextResource sw();

    @Source(I18N_DIR + "bootstrap-datetimepicker.th.js")
    TextResource th();

    @Source(I18N_DIR + "bootstrap-datetimepicker.tr.js")
    TextResource tr();

    @Source(I18N_DIR + "bootstrap-datetimepicker.ua.js")
    TextResource ua();

    @Source(I18N_DIR + "bootstrap-datetimepicker.uk.js")
    TextResource uk();

    @Source(I18N_DIR + "bootstrap-datetimepicker.zh-CN.js")
    TextResource zh_CN();

    @Source(I18N_DIR + "bootstrap-datetimepicker.zh-TW.js")
    TextResource zh_TW();
}
