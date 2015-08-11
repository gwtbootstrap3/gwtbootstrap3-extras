package org.gwtbootstrap3.extras.summernote.client;

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

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * @author godi
 */
public interface SummernoteClientBundle extends ClientBundle {

    public static final SummernoteClientBundle INSTANCE = GWT.create(SummernoteClientBundle.class);

	@Source("resources/js/summernote-0.6.16.min.cache.js")
    TextResource summernote();

	@Source("resources/js/locales.cache.0.6.16/summernote-ar-AR.js")
    TextResource ar_AR();

	@Source("resources/js/locales.cache.0.6.16/summernote-bg-BG.js")
    TextResource bg_BG();

	@Source("resources/js/locales.cache.0.6.16/summernote-ca-ES.js")
    TextResource ca_ES();

	@Source("resources/js/locales.cache.0.6.16/summernote-cs-CZ.js")
    TextResource cs_CZ();

	@Source("resources/js/locales.cache.0.6.16/summernote-da-DK.js")
    TextResource da_DK();

	@Source("resources/js/locales.cache.0.6.16/summernote-de-DE.js")
    TextResource de_DE();

	@Source("resources/js/locales.cache.0.6.16/summernote-es-ES.js")
    TextResource es_ES();

	@Source("resources/js/locales.cache.0.6.16/summernote-es-EU.js")
    TextResource es_EU();

	@Source("resources/js/locales.cache.0.6.16/summernote-fa-IR.js")
    TextResource fa_IR();

	@Source("resources/js/locales.cache.0.6.16/summernote-fi-FI.js")
    TextResource fi_FI();

	@Source("resources/js/locales.cache.0.6.16/summernote-fr-FR.js")
    TextResource fr_FR();

	@Source("resources/js/locales.cache.0.6.16/summernote-he-IL.js")
    TextResource he_IL();

	@Source("resources/js/locales.cache.0.6.16/summernote-hu-HU.js")
    TextResource hu_HU();

	@Source("resources/js/locales.cache.0.6.16/summernote-id-ID.js")
    TextResource id_ID();

	@Source("resources/js/locales.cache.0.6.16/summernote-it-IT.js")
    TextResource it_IT();

	@Source("resources/js/locales.cache.0.6.16/summernote-ja-JP.js")
    TextResource ja_JP();

	@Source("resources/js/locales.cache.0.6.16/summernote-ko-KR.js")
    TextResource ko_KR();

    @Source("resources/js/locales.cache.0.6.16/summernote-lt-LT.js")
    TextResource lt_LT();

	@Source("resources/js/locales.cache.0.6.16/summernote-nb-NO.js")
    TextResource nb_NO();

	@Source("resources/js/locales.cache.0.6.16/summernote-nl-NL.js")
    TextResource nl_NL();

	@Source("resources/js/locales.cache.0.6.16/summernote-pl-PL.js")
    TextResource pl_PL();

	@Source("resources/js/locales.cache.0.6.16/summernote-pt-BR.js")
    TextResource pt_BR();

	@Source("resources/js/locales.cache.0.6.16/summernote-pt-PT.js")
    TextResource pt_PT();

	@Source("resources/js/locales.cache.0.6.16/summernote-ro-RO.js")
    TextResource ro_RO();

	@Source("resources/js/locales.cache.0.6.16/summernote-ru-RU.js")
    TextResource ru_RU();

	@Source("resources/js/locales.cache.0.6.16/summernote-sk-SK.js")
    TextResource sk_SK();

	@Source("resources/js/locales.cache.0.6.16/summernote-sl-SI.js")
    TextResource sl_SI();

	@Source("resources/js/locales.cache.0.6.16/summernote-sr-RS.js")
    TextResource sr_RS();

	@Source("resources/js/locales.cache.0.6.16/summernote-sr-RS-Latin.js")
    TextResource sr_RS_Latin();

	@Source("resources/js/locales.cache.0.6.16/summernote-sv-SE.js")
    TextResource sv_SE();

	@Source("resources/js/locales.cache.0.6.16/summernote-th-TH.js")
    TextResource th_TH();

	@Source("resources/js/locales.cache.0.6.16/summernote-tr-TR.js")
    TextResource tr_TR();

	@Source("resources/js/locales.cache.0.6.16/summernote-uk-UA.js")
    TextResource uk_UA();

	@Source("resources/js/locales.cache.0.6.16/summernote-vi-VN.js")
    TextResource vi_VN();

	@Source("resources/js/locales.cache.0.6.16/summernote-zh-CN.js")
    TextResource zh_CN();

	@Source("resources/js/locales.cache.0.6.16/summernote-zh-TW.js")
    TextResource zh_TW();
}
