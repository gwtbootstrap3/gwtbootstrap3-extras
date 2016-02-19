package org.gwtbootstrap3.extras.select.client;

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
public interface SelectClientBundle extends ClientBundle {

    static final SelectClientBundle INSTANCE = GWT.create(SelectClientBundle.class);

    @Source("resource/js/bootstrap-select-1.10.0.min.cache.js")
    TextResource selectJs();

    @Source("resource/js/locales.cache.1.10.0/defaults-ar_AR.min.js")
    TextResource ar();

    @Source("resource/js/locales.cache.1.10.0/defaults-bg_BG.min.js")
    TextResource bg();

    @Source("resource/js/locales.cache.1.10.0/defaults-cro_CRO.min.js")
    TextResource cro();

    @Source("resource/js/locales.cache.1.10.0/defaults-cs_CZ.min.js")
    TextResource cs();

    @Source("resource/js/locales.cache.1.10.0/defaults-da_DK.min.js")
    TextResource da();

    @Source("resource/js/locales.cache.1.10.0/defaults-de_DE.min.js")
    TextResource de();

    @Source("resource/js/locales.cache.1.10.0/defaults-en_US.min.js")
    TextResource en();

    @Source("resource/js/locales.cache.1.10.0/defaults-es_CL.min.js")
    TextResource es();

    @Source("resource/js/locales.cache.1.10.0/defaults-eu.min.js")
    TextResource eu();

    @Source("resource/js/locales.cache.1.10.0/defaults-fa_IR.min.js")
    TextResource fa();

    @Source("resource/js/locales.cache.1.10.0/defaults-fi_FI.min.js")
    TextResource fi();

    @Source("resource/js/locales.cache.1.10.0/defaults-fr_FR.min.js")
    TextResource fr();

    @Source("resource/js/locales.cache.1.10.0/defaults-hu_HU.min.js")
    TextResource hu();

    @Source("resource/js/locales.cache.1.10.0/defaults-id_ID.min.js")
    TextResource id();

    @Source("resource/js/locales.cache.1.10.0/defaults-it_IT.min.js")
    TextResource it();

    @Source("resource/js/locales.cache.1.10.0/defaults-ko_KR.min.js")
    TextResource ko();

    @Source("resource/js/locales.cache.1.10.0/defaults-lt_LT.min.js")
    TextResource lt();

    @Source("resource/js/locales.cache.1.10.0/defaults-nb_NO.min.js")
    TextResource nb();

    @Source("resource/js/locales.cache.1.10.0/defaults-nl_NL.min.js")
    TextResource nl();

    @Source("resource/js/locales.cache.1.10.0/defaults-pl_PL.min.js")
    TextResource pl();

    @Source("resource/js/locales.cache.1.10.0/defaults-pt_BR.min.js")
    TextResource pt_BR();

    @Source("resource/js/locales.cache.1.10.0/defaults-pt_PT.min.js")
    TextResource pt_PT();

    @Source("resource/js/locales.cache.1.10.0/defaults-ro_RO.min.js")
    TextResource ro();

    @Source("resource/js/locales.cache.1.10.0/defaults-ru_RU.min.js")
    TextResource ru();

    @Source("resource/js/locales.cache.1.10.0/defaults-sk_SK.min.js")
    TextResource sk();

    @Source("resource/js/locales.cache.1.10.0/defaults-sl_SI.min.js")
    TextResource sl();

    @Source("resource/js/locales.cache.1.10.0/defaults-sv_SE.min.js")
    TextResource sv();

    @Source("resource/js/locales.cache.1.10.0/defaults-tr_TR.min.js")
    TextResource tr();

    @Source("resource/js/locales.cache.1.10.0/defaults-ua_UA.min.js")
    TextResource ua();

    @Source("resource/js/locales.cache.1.10.0/defaults-zh_CN.min.js")
    TextResource zh_CN();

    @Source("resource/js/locales.cache.1.10.0/defaults-zh_TW.min.js")
    TextResource zh_TW();
}
