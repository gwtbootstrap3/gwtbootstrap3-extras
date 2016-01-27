package org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants;

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

import com.google.gwt.resources.client.TextResource;
import org.gwtbootstrap3.extras.datetimepicker.client.DateTimePickerClientBundle;

/**
 * @author Joshua Godi
 */
public enum DateTimePickerLanguage {
    AR("ar", DateTimePickerClientBundle.INSTANCE.ar()),
    BG("bg", DateTimePickerClientBundle.INSTANCE.bg()),
    CA("ca", DateTimePickerClientBundle.INSTANCE.ca()),
    CS("cs", DateTimePickerClientBundle.INSTANCE.cs()),
    DA("da", DateTimePickerClientBundle.INSTANCE.da()),
    DE("de", DateTimePickerClientBundle.INSTANCE.de()),
    EE("ee", DateTimePickerClientBundle.INSTANCE.ee()),
    EL("el", DateTimePickerClientBundle.INSTANCE.el()),
    ES("es", DateTimePickerClientBundle.INSTANCE.es()),
    FI("fi", DateTimePickerClientBundle.INSTANCE.fi()),
    FR("fr", DateTimePickerClientBundle.INSTANCE.fr()),
    HE("he", DateTimePickerClientBundle.INSTANCE.he()),
    HR("hr", DateTimePickerClientBundle.INSTANCE.hr()),
    HU("hu", DateTimePickerClientBundle.INSTANCE.hu()),
    ID("id", DateTimePickerClientBundle.INSTANCE.id()),
    IS("is", DateTimePickerClientBundle.INSTANCE.is()),
    IT("it", DateTimePickerClientBundle.INSTANCE.it()),
    JA("ja", DateTimePickerClientBundle.INSTANCE.ja()),
    KA("ka", DateTimePickerClientBundle.INSTANCE.ka()),
    KO("ko", DateTimePickerClientBundle.INSTANCE.ko()),
    LT("lt", DateTimePickerClientBundle.INSTANCE.lt()),
    LV("lv", DateTimePickerClientBundle.INSTANCE.lv()),
    MS("ms", DateTimePickerClientBundle.INSTANCE.ms()),
    NB("nb", DateTimePickerClientBundle.INSTANCE.nb()),
    NL("nl", DateTimePickerClientBundle.INSTANCE.nl()),
    NO("no", DateTimePickerClientBundle.INSTANCE.no()),
    PL("pl", DateTimePickerClientBundle.INSTANCE.pl()),
    PT_BR("pt-BR", DateTimePickerClientBundle.INSTANCE.pt_BR()),
    PT("pt", DateTimePickerClientBundle.INSTANCE.pt()),
    RO("ro", DateTimePickerClientBundle.INSTANCE.ro()),
    RS_LATIN("rs-latin", DateTimePickerClientBundle.INSTANCE.rs_latin()),
    RS("rs", DateTimePickerClientBundle.INSTANCE.rs()),
    RU("ru", DateTimePickerClientBundle.INSTANCE.ru()),
    SK("sk", DateTimePickerClientBundle.INSTANCE.sk()),
    SL("sl", DateTimePickerClientBundle.INSTANCE.sl()),
    SV("sv", DateTimePickerClientBundle.INSTANCE.sv()),
    SW("sw", DateTimePickerClientBundle.INSTANCE.sw()),
    TH("th", DateTimePickerClientBundle.INSTANCE.th()),
    TR("tr", DateTimePickerClientBundle.INSTANCE.tr()),
    UA("ua", DateTimePickerClientBundle.INSTANCE.ua()),
    UK("uk", DateTimePickerClientBundle.INSTANCE.uk()),
    ZH_CN("zh-CN", DateTimePickerClientBundle.INSTANCE.zh_CN()),
    ZH_TW("zh-TW", DateTimePickerClientBundle.INSTANCE.zh_TW()),
    EN("en", null); // Base language, don't need another file

    private final String code;
    private final TextResource js;

    private DateTimePickerLanguage(final String code, final TextResource js) {
        this.js = js;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public TextResource getJs() {
        return js;
    }
}
