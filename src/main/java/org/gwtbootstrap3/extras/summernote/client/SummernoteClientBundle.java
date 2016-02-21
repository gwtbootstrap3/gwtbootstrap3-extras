package org.gwtbootstrap3.extras.summernote.client;

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
 * @author godi
 */
public interface SummernoteClientBundle extends ClientBundle {

    public static final SummernoteClientBundle INSTANCE = GWT.create(SummernoteClientBundle.class);
    static final String VERSION = "0.8.1";
    static final String LOCALE_DIR = "resource/js/locales.cache." + VERSION + "/";

    @Source("resource/js/summernote-" + VERSION + ".min.cache.js")
    TextResource summernote();

    @Source(LOCALE_DIR + "summernote-ar-AR.js")
    TextResource ar_AR();

    @Source(LOCALE_DIR + "summernote-bg-BG.js")
    TextResource bg_BG();

    @Source(LOCALE_DIR + "summernote-ca-ES.js")
    TextResource ca_ES();

    @Source(LOCALE_DIR + "summernote-cs-CZ.js")
    TextResource cs_CZ();

    @Source(LOCALE_DIR + "summernote-da-DK.js")
    TextResource da_DK();

    @Source(LOCALE_DIR + "summernote-de-DE.js")
    TextResource de_DE();

    @Source(LOCALE_DIR + "summernote-es-ES.js")
    TextResource es_ES();

    @Source(LOCALE_DIR + "summernote-es-EU.js")
    TextResource es_EU();

    @Source(LOCALE_DIR + "summernote-fa-IR.js")
    TextResource fa_IR();

    @Source(LOCALE_DIR + "summernote-fi-FI.js")
    TextResource fi_FI();

    @Source(LOCALE_DIR + "summernote-fr-FR.js")
    TextResource fr_FR();

    @Source(LOCALE_DIR + "summernote-he-IL.js")
    TextResource he_IL();

    @Source(LOCALE_DIR + "summernote-hu-HU.js")
    TextResource hu_HU();

    @Source(LOCALE_DIR + "summernote-id-ID.js")
    TextResource id_ID();

    @Source(LOCALE_DIR + "summernote-it-IT.js")
    TextResource it_IT();

    @Source(LOCALE_DIR + "summernote-ja-JP.js")
    TextResource ja_JP();

    @Source(LOCALE_DIR + "summernote-ko-KR.js")
    TextResource ko_KR();

    @Source(LOCALE_DIR + "summernote-lt-LT.js")
    TextResource lt_LT();

    @Source(LOCALE_DIR + "summernote-nb-NO.js")
    TextResource nb_NO();

    @Source(LOCALE_DIR + "summernote-nl-NL.js")
    TextResource nl_NL();

    @Source(LOCALE_DIR + "summernote-pl-PL.js")
    TextResource pl_PL();

    @Source(LOCALE_DIR + "summernote-pt-BR.js")
    TextResource pt_BR();

    @Source(LOCALE_DIR + "summernote-pt-PT.js")
    TextResource pt_PT();

    @Source(LOCALE_DIR + "summernote-ro-RO.js")
    TextResource ro_RO();

    @Source(LOCALE_DIR + "summernote-ru-RU.js")
    TextResource ru_RU();

    @Source(LOCALE_DIR + "summernote-sk-SK.js")
    TextResource sk_SK();

    @Source(LOCALE_DIR + "summernote-sl-SI.js")
    TextResource sl_SI();

    @Source(LOCALE_DIR + "summernote-sr-RS.js")
    TextResource sr_RS();

    @Source(LOCALE_DIR + "summernote-sr-RS-Latin.js")
    TextResource sr_RS_Latin();

    @Source(LOCALE_DIR + "summernote-sv-SE.js")
    TextResource sv_SE();

    @Source(LOCALE_DIR + "summernote-th-TH.js")
    TextResource th_TH();

    @Source(LOCALE_DIR + "summernote-tr-TR.js")
    TextResource tr_TR();

    @Source(LOCALE_DIR + "summernote-uk-UA.js")
    TextResource uk_UA();

    @Source(LOCALE_DIR + "summernote-vi-VN.js")
    TextResource vi_VN();

    @Source(LOCALE_DIR + "summernote-zh-CN.js")
    TextResource zh_CN();

    @Source(LOCALE_DIR + "summernote-zh-TW.js")
    TextResource zh_TW();
}
