package org.gwtbootstrap3.extras.datepicker.client;

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
 * http://www.apache.org/licenses/LICENSE-2.0
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
public interface DatePickerClientBundle extends ClientBundle {

    static final DatePickerClientBundle INSTANCE = GWT.create(DatePickerClientBundle.class);

    static final String VERSION = "1.6.4";
    static final String LOCALES_DIR = "resource/js/locales.cache." + VERSION + "/";

    @Source("resource/js/bootstrap-datepicker-" + VERSION + ".min.cache.js")
    TextResource datePicker();

    @Source(LOCALES_DIR + "bootstrap-datepicker.ar.min.js")
    TextResource ar();

    @Source(LOCALES_DIR + "bootstrap-datepicker.az.min.js")
    TextResource az();

    @Source(LOCALES_DIR + "bootstrap-datepicker.bg.min.js")
    TextResource bg();

    @Source(LOCALES_DIR + "bootstrap-datepicker.bs.min.js")
    TextResource bs();

    @Source(LOCALES_DIR + "bootstrap-datepicker.ca.min.js")
    TextResource ca();

    @Source(LOCALES_DIR + "bootstrap-datepicker.cs.min.js")
    TextResource cs();

    @Source(LOCALES_DIR + "bootstrap-datepicker.cy.min.js")
    TextResource cy();

    @Source(LOCALES_DIR + "bootstrap-datepicker.da.min.js")
    TextResource da();

    @Source(LOCALES_DIR + "bootstrap-datepicker.de.min.js")
    TextResource de();

    @Source(LOCALES_DIR + "bootstrap-datepicker.el.min.js")
    TextResource el();

    @Source(LOCALES_DIR + "bootstrap-datepicker.en-GB.min.js")
    TextResource en_GB();

    @Source(LOCALES_DIR + "bootstrap-datepicker.eo.min.js")
    TextResource eo();

    @Source(LOCALES_DIR + "bootstrap-datepicker.es.min.js")
    TextResource es();

    @Source(LOCALES_DIR + "bootstrap-datepicker.et.min.js")
    TextResource et();

    @Source(LOCALES_DIR + "bootstrap-datepicker.eu.min.js")
    TextResource eu();

    @Source(LOCALES_DIR + "bootstrap-datepicker.fa.min.js")
    TextResource fa();

    @Source(LOCALES_DIR + "bootstrap-datepicker.fi.min.js")
    TextResource fi();

    @Source(LOCALES_DIR + "bootstrap-datepicker.fo.min.js")
    TextResource fo();

    @Source(LOCALES_DIR + "bootstrap-datepicker.fr.min.js")
    TextResource fr();

    @Source(LOCALES_DIR + "bootstrap-datepicker.fr-CH.min.js")
    TextResource fr_CH();

    @Source(LOCALES_DIR + "bootstrap-datepicker.gl.min.js")
    TextResource gl();

    @Source(LOCALES_DIR + "bootstrap-datepicker.he.min.js")
    TextResource he();

    @Source(LOCALES_DIR + "bootstrap-datepicker.hr.min.js")
    TextResource hr();

    @Source(LOCALES_DIR + "bootstrap-datepicker.hu.min.js")
    TextResource hu();

    @Source(LOCALES_DIR + "bootstrap-datepicker.hy.min.js")
    TextResource hy();

    @Source(LOCALES_DIR + "bootstrap-datepicker.id.min.js")
    TextResource id();

    @Source(LOCALES_DIR + "bootstrap-datepicker.is.min.js")
    TextResource is();

    @Source(LOCALES_DIR + "bootstrap-datepicker.it.min.js")
    TextResource it();

    @Source(LOCALES_DIR + "bootstrap-datepicker.it-CH.min.js")
    TextResource it_CH();

    @Source(LOCALES_DIR + "bootstrap-datepicker.ja.min.js")
    TextResource ja();

    @Source(LOCALES_DIR + "bootstrap-datepicker.ka.min.js")
    TextResource ka();

    @Source(LOCALES_DIR + "bootstrap-datepicker.kh.min.js")
    TextResource kh();

    @Source(LOCALES_DIR + "bootstrap-datepicker.kk.min.js")
    TextResource kk();

    @Source(LOCALES_DIR + "bootstrap-datepicker.ko.min.js")
    TextResource ko();

    @Source(LOCALES_DIR + "bootstrap-datepicker.kr.min.js")
    TextResource kr();

    @Source(LOCALES_DIR + "bootstrap-datepicker.lt.min.js")
    TextResource lt();

    @Source(LOCALES_DIR + "bootstrap-datepicker.lv.min.js")
    TextResource lv();

    @Source(LOCALES_DIR + "bootstrap-datepicker.me.min.js")
    TextResource me();

    @Source(LOCALES_DIR + "bootstrap-datepicker.mk.min.js")
    TextResource mk();

    @Source(LOCALES_DIR + "bootstrap-datepicker.mn.min.js")
    TextResource mn();

    @Source(LOCALES_DIR + "bootstrap-datepicker.ms.min.js")
    TextResource ms();

    @Source(LOCALES_DIR + "bootstrap-datepicker.nb.min.js")
    TextResource nb();

    @Source(LOCALES_DIR + "bootstrap-datepicker.nl.min.js")
    TextResource nl();

    @Source(LOCALES_DIR + "bootstrap-datepicker.nl-BE.min.js")
    TextResource nl_BE();

    @Source(LOCALES_DIR + "bootstrap-datepicker.no.min.js")
    TextResource no();

    @Source(LOCALES_DIR + "bootstrap-datepicker.pl.min.js")
    TextResource pl();

    @Source(LOCALES_DIR + "bootstrap-datepicker.pt.min.js")
    TextResource pt();

    @Source(LOCALES_DIR + "bootstrap-datepicker.pt-BR.min.js")
    TextResource pt_BR();

    @Source(LOCALES_DIR + "bootstrap-datepicker.ro.min.js")
    TextResource ro();

    @Source(LOCALES_DIR + "bootstrap-datepicker.rs.min.js")
    TextResource rs();

    @Source(LOCALES_DIR + "bootstrap-datepicker.rs-latin.min.js")
    TextResource rs_latin();

    @Source(LOCALES_DIR + "bootstrap-datepicker.ru.min.js")
    TextResource ru();

    @Source(LOCALES_DIR + "bootstrap-datepicker.sk.min.js")
    TextResource sk();

    @Source(LOCALES_DIR + "bootstrap-datepicker.sl.min.js")
    TextResource sl();

    @Source(LOCALES_DIR + "bootstrap-datepicker.sq.min.js")
    TextResource sq();

    @Source(LOCALES_DIR + "bootstrap-datepicker.sr.min.js")
    TextResource sr();

    @Source(LOCALES_DIR + "bootstrap-datepicker.sr-latin.min.js")
    TextResource sr_latin();

    @Source(LOCALES_DIR + "bootstrap-datepicker.sv.min.js")
    TextResource sv();

    @Source(LOCALES_DIR + "bootstrap-datepicker.sw.min.js")
    TextResource sw();

    @Source(LOCALES_DIR + "bootstrap-datepicker.th.min.js")
    TextResource th();

    @Source(LOCALES_DIR + "bootstrap-datepicker.tr.min.js")
    TextResource tr();

    @Source(LOCALES_DIR + "bootstrap-datepicker.uk.min.js")
    TextResource uk();

    @Source(LOCALES_DIR + "bootstrap-datepicker.vi.min.js")
    TextResource vi();

    @Source(LOCALES_DIR + "bootstrap-datepicker.zh-CN.min.js")
    TextResource zh_CN();

    @Source(LOCALES_DIR + "bootstrap-datepicker.zh-TW.min.js")
    TextResource zh_TW();
}
