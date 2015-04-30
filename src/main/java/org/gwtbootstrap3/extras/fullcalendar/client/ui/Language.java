package org.gwtbootstrap3.extras.fullcalendar.client.ui;

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
import org.gwtbootstrap3.extras.fullcalendar.client.FullCalendarClientBundle;

/**
 * Convenient encapsulation of all language options for <code>FullCalendar</code>
 *
 * @author Jeff Isenhart
 * @see http://arshaw.com/fullcalendar/docs/text/lang/
 */

public enum Language {
    ArabicMorocan("ar-ma", FullCalendarClientBundle.INSTANCE.getArabicMorocan()),
    Arabic("ar", FullCalendarClientBundle.INSTANCE.getArabic()),
    Bulgarian("bg", FullCalendarClientBundle.INSTANCE.getBulgarian()),
    Catalan("ca", FullCalendarClientBundle.INSTANCE.getCatalan()),
    Czech("cs", FullCalendarClientBundle.INSTANCE.getCzech()),
    Danish("da", FullCalendarClientBundle.INSTANCE.getDanish()),
    German("de", FullCalendarClientBundle.INSTANCE.getGerman()),
    Greek("el", FullCalendarClientBundle.INSTANCE.getGreek()),
    EnglishAustralian("en-au", FullCalendarClientBundle.INSTANCE.getEnglishAustralian()),
    EnglishCanadian("en-ca", FullCalendarClientBundle.INSTANCE.getEnglishCanadian()),
    EnglishBritish("en-gb", FullCalendarClientBundle.INSTANCE.getEnglishBritish()),
    Spanish("es", FullCalendarClientBundle.INSTANCE.getSpanish()),
    Farsi("fa", FullCalendarClientBundle.INSTANCE.getFarsi()),
    Finnish("fi", FullCalendarClientBundle.INSTANCE.getFinnish()),
    FrenchCanadian("fr-ca", FullCalendarClientBundle.INSTANCE.getFrenchCanadian()),
    French("fr", FullCalendarClientBundle.INSTANCE.getFrench()),
    Hindi("hi", FullCalendarClientBundle.INSTANCE.getHindi()),
    Croatian("hr", FullCalendarClientBundle.INSTANCE.getCroatian()),
    Hungarian("hu", FullCalendarClientBundle.INSTANCE.getHungarian()),
    Indonesian("id", FullCalendarClientBundle.INSTANCE.getIndonesian()),
    Islandic("is", FullCalendarClientBundle.INSTANCE.getIslandic()),
    Italian("it", FullCalendarClientBundle.INSTANCE.getItalian()),
    Japanese("ja", FullCalendarClientBundle.INSTANCE.getJapanese()),
    Korean("ko", FullCalendarClientBundle.INSTANCE.getKorean()),
    Lithuanian("lt", FullCalendarClientBundle.INSTANCE.getLithuanian()),
    Latvian("lv", FullCalendarClientBundle.INSTANCE.getLatvian()),
    Dutch("nl", FullCalendarClientBundle.INSTANCE.getDutch()),
    NowegianBokmal("no", FullCalendarClientBundle.INSTANCE.getNowegianBokmal()),
    Polish("pl", FullCalendarClientBundle.INSTANCE.getPolish()),
    PortugeseBrazil("pt-br", FullCalendarClientBundle.INSTANCE.getPortugeseBrazil()),
    Portugese("pt", FullCalendarClientBundle.INSTANCE.getPortugese()),
    Romanian("ro", FullCalendarClientBundle.INSTANCE.getRomanian()),
    Russian("ru", FullCalendarClientBundle.INSTANCE.getRussian()),
    Slovak("sk", FullCalendarClientBundle.INSTANCE.getSlovak()),
    Slovenian("sl", FullCalendarClientBundle.INSTANCE.getSlovenian()),
    SerbianCyrillic("sr-cyr", FullCalendarClientBundle.INSTANCE.getSerbianCyrillic()),
    Serbian("sr", FullCalendarClientBundle.INSTANCE.getSerbian()),
    Sweedish("sv", FullCalendarClientBundle.INSTANCE.getSweedish()),
    Thai("th", FullCalendarClientBundle.INSTANCE.getThai()),
    Turkish("tr", FullCalendarClientBundle.INSTANCE.getTurkish()),
    Ukrainian("uk", FullCalendarClientBundle.INSTANCE.getUkrainian()),
    Vietnamese("vi", FullCalendarClientBundle.INSTANCE.getVietnamese()),
    ChineseChina("zh-cn", FullCalendarClientBundle.INSTANCE.getChineseChina()),
    ChineseTaiwan("zh-tw", FullCalendarClientBundle.INSTANCE.getChineseTaiwan());

    private final String code;
    private final TextResource resource;

    private Language(final String code, final TextResource resource) {
        this.code = code;
        this.resource = resource;
    }

    public String getCode() {
        return code;
    }

    public TextResource getResource() {
        return resource;
    }

}
