package org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants;

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

import org.gwtbootstrap3.extras.datetimepicker.client.DateTimePickerClientBundle;

/**
 * @author Joshua Godi
 */
public enum DateTimePickerLanguage {
    BG("bg", DateTimePickerClientBundle.INSTANCE.bg().getText()),
    CA("ca", DateTimePickerClientBundle.INSTANCE.ca().getText()),
    CS("cs", DateTimePickerClientBundle.INSTANCE.cs().getText()),
    DA("da", DateTimePickerClientBundle.INSTANCE.da().getText()),
    DE("de", DateTimePickerClientBundle.INSTANCE.de().getText()),
    EL("el", DateTimePickerClientBundle.INSTANCE.el().getText()),
    ES("es", DateTimePickerClientBundle.INSTANCE.es().getText()),
    FI("fi", DateTimePickerClientBundle.INSTANCE.fi().getText()),
    FR("fr", DateTimePickerClientBundle.INSTANCE.fr().getText()),
    HE("he", DateTimePickerClientBundle.INSTANCE.he().getText()),
    HR("hr", DateTimePickerClientBundle.INSTANCE.hr().getText()),
    HU("hu", DateTimePickerClientBundle.INSTANCE.hu().getText()),
    ID("id", DateTimePickerClientBundle.INSTANCE.id().getText()),
    IS("is", DateTimePickerClientBundle.INSTANCE.is().getText()),
    IT("it", DateTimePickerClientBundle.INSTANCE.it().getText()),
    JA("ja", DateTimePickerClientBundle.INSTANCE.ja().getText()),
    KR("kr", DateTimePickerClientBundle.INSTANCE.kr().getText()),
    LT("lt", DateTimePickerClientBundle.INSTANCE.lt().getText()),
    LV("lv", DateTimePickerClientBundle.INSTANCE.lv().getText()),
    MS("ms", DateTimePickerClientBundle.INSTANCE.ms().getText()),
    NB("nb", DateTimePickerClientBundle.INSTANCE.nb().getText()),
    NL("nl", DateTimePickerClientBundle.INSTANCE.nl().getText()),
    NO("no", DateTimePickerClientBundle.INSTANCE.no().getText()),
    PL("pl", DateTimePickerClientBundle.INSTANCE.pl().getText()),
    PT_BR("pt-BR", DateTimePickerClientBundle.INSTANCE.pt_BR().getText()),
    PT("pt", DateTimePickerClientBundle.INSTANCE.pt().getText()),
    RO("ro", DateTimePickerClientBundle.INSTANCE.ro().getText()),
    RS_LATIN("rs-latin", DateTimePickerClientBundle.INSTANCE.rs_latin().getText()),
    RS("rs", DateTimePickerClientBundle.INSTANCE.rs().getText()),
    RU("ru", DateTimePickerClientBundle.INSTANCE.ru().getText()),
    SK("sk", DateTimePickerClientBundle.INSTANCE.sk().getText()),
    SL("sl", DateTimePickerClientBundle.INSTANCE.sl().getText()),
    SV("sv", DateTimePickerClientBundle.INSTANCE.sv().getText()),
    SW("sw", DateTimePickerClientBundle.INSTANCE.sw().getText()),
    TH("th", DateTimePickerClientBundle.INSTANCE.th().getText()),
    TR("tr", DateTimePickerClientBundle.INSTANCE.tr().getText()),
    UA("ua", DateTimePickerClientBundle.INSTANCE.ua().getText()),
    UK("uk", DateTimePickerClientBundle.INSTANCE.uk().getText()),
    ZH_CN("zh-CN", DateTimePickerClientBundle.INSTANCE.zh_CN().getText()),
    ZH_TW("zh-TW", DateTimePickerClientBundle.INSTANCE.zh_TW().getText()),
    EN("en", ""); // Base language, don't need another file

    private final String code;
    private final String js;

    private DateTimePickerLanguage(final String code, final String js) {
        this.js = js;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getJs() {
        return js;
    }
}
