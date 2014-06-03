package org.gwtbootstrap3.extras.fullcalendar.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.TextResource;

public interface FullCalendarClientBundle extends ClientBundle {

    public static final FullCalendarClientBundle INSTANCE = GWT.create(FullCalendarClientBundle.class);

    @Source("resource/css/fullcalendar.css")
    @CssResource.NotStrict
    CssResource fullCalendarCss();
    
    @Source("resource/css/fullcalendar.print.css")
    @CssResource.NotStrict
    CssResource fullCalendarPrintCss();
    
    @Source("resource/js/fullcalendar.min.js")
    TextResource getFullCalendarJS();
    
    @Source("resource/js/gcal.js")
    TextResource getGoogleCalJS();
    
    @Source("resource/js/jquery-ui.custom.min.js")
    TextResource getCustomDragResizeJS();
    
    @Source("resource/js/moment.min.js")
    TextResource getMomentJS();
    
    //langauge files
    @Source("resource/js/lang/ar-ma.js")
    TextResource getArabicMorocan();
    @Source("resource/js/lang/ar.js")
    TextResource getArabic();
    @Source("resource/js/lang/bg.js")
    TextResource getBulgarian();
    @Source("resource/js/lang/ca.js")
    TextResource getCatalan();
    @Source("resource/js/lang/cs.js")
    TextResource getCzech();
    @Source("resource/js/lang/da.js")
    TextResource getDanish();
    @Source("resource/js/lang/de.js")
    TextResource getGerman();
    @Source("resource/js/lang/el.js")
    TextResource getGreek();
    @Source("resource/js/lang/en-au.js")
    TextResource getEnglishAustralian();
    @Source("resource/js/lang/en-ca.js")
    TextResource getEnglishCanadian();
    @Source("resource/js/lang/en-gb.js")
    TextResource getEnglishBritish();
    @Source("resource/js/lang/es.js")
    TextResource getSpanish();
    @Source("resource/js/lang/fa.js")
    TextResource getFarsi();
    @Source("resource/js/lang/fi.js")
    TextResource getFinnish();
    @Source("resource/js/lang/fr-ca.js")
    TextResource getFrenchCanadian();
    @Source("resource/js/lang/fr.js")
    TextResource getFrench();
    @Source("resource/js/lang/hi.js")
    TextResource getHindi();
    @Source("resource/js/lang/hr.js")
    TextResource getCroatian();
    @Source("resource/js/lang/hu.js")
    TextResource getHungarian();
    @Source("resource/js/lang/it.js")
    TextResource getItalian();
    @Source("resource/js/lang/ja.js")
    TextResource getJapanese();
    @Source("resource/js/lang/ko.js")
    TextResource getKorean();
    @Source("resource/js/lang/lt.js")
    TextResource getLithuanian();
    @Source("resource/js/lang/lv.js")
    TextResource getLatvian();
    @Source("resource/js/lang/nl.js")
    TextResource getDutch();
    @Source("resource/js/lang/pl.js")
    TextResource getPolish();
    @Source("resource/js/lang/pt-br.js")
    TextResource getPortugeseBrazil();
    @Source("resource/js/lang/pt.js")
    TextResource getPortugese();
    @Source("resource/js/lang/ro.js")
    TextResource getRomanian();
    @Source("resource/js/lang/ru.js")
    TextResource getRussian();
    @Source("resource/js/lang/sk.js")
    TextResource getSlovak();
    @Source("resource/js/lang/sl.js")
    TextResource getSlovenian();
    @Source("resource/js/lang/sr-cyr.js")
    TextResource getSerbianCyrillic();
    @Source("resource/js/lang/sr.js")
    TextResource getSerbian();
    @Source("resource/js/lang/sv.js")
    TextResource getSweedish();
    @Source("resource/js/lang/th.js")
    TextResource getThai();
    @Source("resource/js/lang/tr.js")
    TextResource getTurkish();
    @Source("resource/js/lang/uk.js")
    TextResource getUkrainian();
    @Source("resource/js/lang/vi.js")
    TextResource getVietnamese();
    @Source("resource/js/lang/zh-cn.js")
    TextResource getChineseChina();
    @Source("resource/js/lang/zh-tw.js")
    TextResource getChineseTaiwan();

}
