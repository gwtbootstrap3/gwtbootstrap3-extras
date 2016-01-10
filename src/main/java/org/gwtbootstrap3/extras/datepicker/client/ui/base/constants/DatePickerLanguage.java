package org.gwtbootstrap3.extras.datepicker.client.ui.base.constants;

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

import org.gwtbootstrap3.extras.datepicker.client.DatePickerClientBundle;

import com.google.gwt.resources.client.TextResource;

/**
 * @author Joshua Godi
 */
public enum DatePickerLanguage {
    AR("ar", DatePickerClientBundle.INSTANCE.ar()),
    AZ("az", DatePickerClientBundle.INSTANCE.az()),
    BG("bg", DatePickerClientBundle.INSTANCE.bg()),
    BS("bs", DatePickerClientBundle.INSTANCE.bs()),
    CA("ca", DatePickerClientBundle.INSTANCE.ca()),
    CS("cs", DatePickerClientBundle.INSTANCE.cs()),
    CY("cy", DatePickerClientBundle.INSTANCE.cy()),
    DA("da", DatePickerClientBundle.INSTANCE.da()),
    DE("de", DatePickerClientBundle.INSTANCE.de()),
    EL("el", DatePickerClientBundle.INSTANCE.el()),
    EN_GB("en-GB", DatePickerClientBundle.INSTANCE.en_GB()),
    EO("eo", DatePickerClientBundle.INSTANCE.eo()),
    ES("es", DatePickerClientBundle.INSTANCE.es()),
    ET("et", DatePickerClientBundle.INSTANCE.et()),
    EU("eu", DatePickerClientBundle.INSTANCE.eu()),
    FA("fa", DatePickerClientBundle.INSTANCE.fa()),
    FI("fi", DatePickerClientBundle.INSTANCE.fi()),
    FO("fo", DatePickerClientBundle.INSTANCE.fo()),
    FR("fr", DatePickerClientBundle.INSTANCE.fr()),
    FR_CH("fr-CH", DatePickerClientBundle.INSTANCE.fr_CH()),
    GL("gl", DatePickerClientBundle.INSTANCE.gl()),
    HE("he", DatePickerClientBundle.INSTANCE.he()),
    HR("hr", DatePickerClientBundle.INSTANCE.hr()),
    HU("hu", DatePickerClientBundle.INSTANCE.hu()),
    HY("hy", DatePickerClientBundle.INSTANCE.hy()),
    ID("id", DatePickerClientBundle.INSTANCE.id()),
    IS("is", DatePickerClientBundle.INSTANCE.is()),
    IT("it", DatePickerClientBundle.INSTANCE.it()),
    IT_CH("it-CH", DatePickerClientBundle.INSTANCE.it_CH()),
    JA("ja", DatePickerClientBundle.INSTANCE.ja()),
    KA("ka", DatePickerClientBundle.INSTANCE.ka()),
    KH("kh", DatePickerClientBundle.INSTANCE.kh()),
    KK("kk", DatePickerClientBundle.INSTANCE.kk()),
    KO("ko", DatePickerClientBundle.INSTANCE.ko()),
    KR("kr", DatePickerClientBundle.INSTANCE.kr()),
    LT("lt", DatePickerClientBundle.INSTANCE.lt()),
    LV("lv", DatePickerClientBundle.INSTANCE.lv()),
    ME("me", DatePickerClientBundle.INSTANCE.me()),
    MK("mk", DatePickerClientBundle.INSTANCE.mk()),
    MN("mn", DatePickerClientBundle.INSTANCE.mn()),
    MS("ms", DatePickerClientBundle.INSTANCE.ms()),
    NB("nb", DatePickerClientBundle.INSTANCE.nb()),
    NL("nl", DatePickerClientBundle.INSTANCE.nl()),
    NL_BE("nl-BE", DatePickerClientBundle.INSTANCE.nl_BE()),
    NO("no", DatePickerClientBundle.INSTANCE.no()),
    PL("pl", DatePickerClientBundle.INSTANCE.pl()),
    PT("pt", DatePickerClientBundle.INSTANCE.pt()),
    PT_BR("pt-BR", DatePickerClientBundle.INSTANCE.pt_BR()),
    RO("ro", DatePickerClientBundle.INSTANCE.ro()),
    RS("rs", DatePickerClientBundle.INSTANCE.rs()),
    RS_LATIN("rs-latin", DatePickerClientBundle.INSTANCE.rs_latin()),
    RU("ru", DatePickerClientBundle.INSTANCE.ru()),
    SK("sk", DatePickerClientBundle.INSTANCE.sk()),
    SL("sl", DatePickerClientBundle.INSTANCE.sl()),
    SQ("sq", DatePickerClientBundle.INSTANCE.sq()),
    SR("sr", DatePickerClientBundle.INSTANCE.sr()),
    SR_LATIN("sr-latin", DatePickerClientBundle.INSTANCE.sr_latin()),
    SV("sv", DatePickerClientBundle.INSTANCE.sv()),
    SW("sw", DatePickerClientBundle.INSTANCE.sw()),
    TH("th", DatePickerClientBundle.INSTANCE.th()),
    TR("tr", DatePickerClientBundle.INSTANCE.tr()),
    UK("uk", DatePickerClientBundle.INSTANCE.uk()),
    VI("vi", DatePickerClientBundle.INSTANCE.vi()),
    ZH_CN("zh-CN", DatePickerClientBundle.INSTANCE.zh_CN()),
    ZH_TW("zh-TW", DatePickerClientBundle.INSTANCE.zh_TW()),
    EN("en", null); // Base language, don't need another file

    private final String code;
    private final TextResource js;

    private DatePickerLanguage(final String code, final TextResource js) {
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
