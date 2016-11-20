package org.gwtbootstrap3.extras.select.client.ui;

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
import org.gwtbootstrap3.extras.select.client.SelectClientBundle;

public enum SelectLanguage {

    AR("ar", SelectClientBundle.INSTANCE.ar()),
    BG("bg", SelectClientBundle.INSTANCE.bg()),
    CRO("cro", SelectClientBundle.INSTANCE.cro()),
    CS("cs", SelectClientBundle.INSTANCE.cs()),
    DA("da", SelectClientBundle.INSTANCE.da()),
    DE("de", SelectClientBundle.INSTANCE.de()),
    EN_US("en-US", SelectClientBundle.INSTANCE.en()),
    ES_CL("es-CL", SelectClientBundle.INSTANCE.es_CL()),
    ES_ES("es-ES", SelectClientBundle.INSTANCE.es_ES()),
    EU("eu", SelectClientBundle.INSTANCE.eu()),
    FA("fa", SelectClientBundle.INSTANCE.fa()),
    FI("fi", SelectClientBundle.INSTANCE.fi()),
    FR("fr", SelectClientBundle.INSTANCE.fr()),
    HU("hu", SelectClientBundle.INSTANCE.hu()),
    ID("id", SelectClientBundle.INSTANCE.id()),
    IT("it", SelectClientBundle.INSTANCE.it()),
    KO("ko", SelectClientBundle.INSTANCE.ko()),
    LT("lt", SelectClientBundle.INSTANCE.lt()),
    NB("nb", SelectClientBundle.INSTANCE.nb()),
    NL("nl", SelectClientBundle.INSTANCE.nl()),
    PL("pl", SelectClientBundle.INSTANCE.pl()),
    PT_BR("pt-BR", SelectClientBundle.INSTANCE.pt_BR()),
    PT_PT("pt-PT", SelectClientBundle.INSTANCE.pt_PT()),
    RO("ro", SelectClientBundle.INSTANCE.ro()),
    RU("ru", SelectClientBundle.INSTANCE.ru()),
    SK("sk", SelectClientBundle.INSTANCE.sk()),
    SL("sl", SelectClientBundle.INSTANCE.sl()),
    SV("sv", SelectClientBundle.INSTANCE.sv()),
    TR("tr", SelectClientBundle.INSTANCE.tr()),
    UA("ua", SelectClientBundle.INSTANCE.ua()),
    ZH_CN("zh-CN", SelectClientBundle.INSTANCE.zh_CN()),
    ZH_TW("zh-TW", SelectClientBundle.INSTANCE.zh_TW()),
    EN("en", null); 

    private final String code;
    private final TextResource js;

    private SelectLanguage(final String code, final TextResource js) {
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
