package org.gwtbootstrap3.extras.fullcalendar.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.TextResource;

public interface FullCalendarClientBundle extends ClientBundle {

    static final FullCalendarClientBundle INSTANCE = GWT.create(FullCalendarClientBundle.class);

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
}
