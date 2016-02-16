package org.gwtbootstrap3.extras.summernote.client.ui.base;

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

import com.google.gwt.resources.client.TextResource;
import org.gwtbootstrap3.extras.summernote.client.SummernoteClientBundle;

/**
 * @author Michał Rybicki (based on DatePickerLanguage by Joshua Godi)
 */
public enum SummernoteLanguage {
    AR_AR("ar-AR", SummernoteClientBundle.INSTANCE.ar_AR()),
    BG_BG("bg-BG", SummernoteClientBundle.INSTANCE.bg_BG()),
    CA_ES("ca-ES", SummernoteClientBundle.INSTANCE.ca_ES()),
    CS_CZ("cs-CZ", SummernoteClientBundle.INSTANCE.cs_CZ()),
    DA_DK("da-DK", SummernoteClientBundle.INSTANCE.da_DK()),
    DE_DE("de-DE", SummernoteClientBundle.INSTANCE.de_DE()),
    ES_ES("es-ES", SummernoteClientBundle.INSTANCE.es_ES()),
    ES_EU("es-EU", SummernoteClientBundle.INSTANCE.es_EU()),
    FA_IR("fa-IR", SummernoteClientBundle.INSTANCE.fa_IR()),
    FI_FI("fi-FI", SummernoteClientBundle.INSTANCE.fi_FI()),
    FR_FR("fr-FR", SummernoteClientBundle.INSTANCE.fr_FR()),
    HE_IL("he-IL", SummernoteClientBundle.INSTANCE.he_IL()),
    HU_HU("hu-HU", SummernoteClientBundle.INSTANCE.hu_HU()),
    ID_ID("id-ID", SummernoteClientBundle.INSTANCE.id_ID()),
    IT_IT("it-IT", SummernoteClientBundle.INSTANCE.it_IT()),
    JA_JP("ja-JP", SummernoteClientBundle.INSTANCE.ja_JP()),
    KO_KR("ko-KR", SummernoteClientBundle.INSTANCE.ko_KR()),
    NB_NO("nb-NO", SummernoteClientBundle.INSTANCE.nb_NO()),
    NL_NL("nl-NL", SummernoteClientBundle.INSTANCE.nl_NL()),
    LT_LT("lt-LT", SummernoteClientBundle.INSTANCE.lt_LT()),
    PL_PL("pl-PL", SummernoteClientBundle.INSTANCE.pl_PL()),
    PT_BR("pt-BR", SummernoteClientBundle.INSTANCE.pt_BR()),
    PT_PT("pt-PT", SummernoteClientBundle.INSTANCE.pt_PT()),
    RO_RO("ro-RO", SummernoteClientBundle.INSTANCE.ro_RO()),
    RU_RU("ru-RU", SummernoteClientBundle.INSTANCE.ru_RU()),
    SK_SK("sk-SK", SummernoteClientBundle.INSTANCE.sk_SK()),
    SL_SL("sl-SI", SummernoteClientBundle.INSTANCE.sl_SI()),
    SR_RS("sr-RS", SummernoteClientBundle.INSTANCE.sr_RS()),
    SR_RS_LATIN("sr-RS-Latin", SummernoteClientBundle.INSTANCE.sr_RS_Latin()),
    SV_SE("sv-SE", SummernoteClientBundle.INSTANCE.sv_SE()),
    TH_TH("th-TH", SummernoteClientBundle.INSTANCE.th_TH()),
    TR_TR("tr-TR", SummernoteClientBundle.INSTANCE.tr_TR()),
    UK_UA("uk-UA", SummernoteClientBundle.INSTANCE.uk_UA()),
    VI_VN("vi-VN", SummernoteClientBundle.INSTANCE.vi_VN()),
    ZH_CN("zh-CN", SummernoteClientBundle.INSTANCE.zh_CN()),
    ZH_TW("zh-TW", SummernoteClientBundle.INSTANCE.zh_TW()),
    EN_US("en-US", null); // Base language, don't need another file
  
    private final String code;
    private final TextResource js;
  
    private SummernoteLanguage(final String code, final TextResource js) {
        this.code = code;
        this.js = js;
    }
  
    public String getCode() {
        return code;
    }
  
    public TextResource getJs() {
        return js;
    }
}