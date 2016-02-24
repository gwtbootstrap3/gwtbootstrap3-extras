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

    static final String VERSION = "1.10.0";
    static final String SELECT_JS = "js/bootstrap-select-" + VERSION + ".min.cache.js";
    static final String LOCALE_DIR = "resource/js/locales.cache." + VERSION + "/";

    @Source(LOCALE_DIR + "defaults-ar_AR.min.js")
    TextResource ar();

    @Source(LOCALE_DIR + "defaults-bg_BG.min.js")
    TextResource bg();

    @Source(LOCALE_DIR + "defaults-cro_CRO.min.js")
    TextResource cro();

    @Source(LOCALE_DIR + "defaults-cs_CZ.min.js")
    TextResource cs();

    @Source(LOCALE_DIR + "defaults-da_DK.min.js")
    TextResource da();

    @Source(LOCALE_DIR + "defaults-de_DE.min.js")
    TextResource de();

    @Source(LOCALE_DIR + "defaults-en_US.min.js")
    TextResource en();

    @Source(LOCALE_DIR + "defaults-es_CL.min.js")
    TextResource es();

    @Source(LOCALE_DIR + "defaults-eu.min.js")
    TextResource eu();

    @Source(LOCALE_DIR + "defaults-fa_IR.min.js")
    TextResource fa();

    @Source(LOCALE_DIR + "defaults-fi_FI.min.js")
    TextResource fi();

    @Source(LOCALE_DIR + "defaults-fr_FR.min.js")
    TextResource fr();

    @Source(LOCALE_DIR + "defaults-hu_HU.min.js")
    TextResource hu();

    @Source(LOCALE_DIR + "defaults-id_ID.min.js")
    TextResource id();

    @Source(LOCALE_DIR + "defaults-it_IT.min.js")
    TextResource it();

    @Source(LOCALE_DIR + "defaults-ko_KR.min.js")
    TextResource ko();

    @Source(LOCALE_DIR + "defaults-lt_LT.min.js")
    TextResource lt();

    @Source(LOCALE_DIR + "defaults-nb_NO.min.js")
    TextResource nb();

    @Source(LOCALE_DIR + "defaults-nl_NL.min.js")
    TextResource nl();

    @Source(LOCALE_DIR + "defaults-pl_PL.min.js")
    TextResource pl();

    @Source(LOCALE_DIR + "defaults-pt_BR.min.js")
    TextResource pt_BR();

    @Source(LOCALE_DIR + "defaults-pt_PT.min.js")
    TextResource pt_PT();

    @Source(LOCALE_DIR + "defaults-ro_RO.min.js")
    TextResource ro();

    @Source(LOCALE_DIR + "defaults-ru_RU.min.js")
    TextResource ru();

    @Source(LOCALE_DIR + "defaults-sk_SK.min.js")
    TextResource sk();

    @Source(LOCALE_DIR + "defaults-sl_SI.min.js")
    TextResource sl();

    @Source(LOCALE_DIR + "defaults-sv_SE.min.js")
    TextResource sv();

    @Source(LOCALE_DIR + "defaults-tr_TR.min.js")
    TextResource tr();

    @Source(LOCALE_DIR + "defaults-ua_UA.min.js")
    TextResource ua();

    @Source(LOCALE_DIR + "defaults-zh_CN.min.js")
    TextResource zh_CN();

    @Source(LOCALE_DIR + "defaults-zh_TW.min.js")
    TextResource zh_TW();
}
