package org.gwtbootstrap3.extras.fullcalendar.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.StyleInjector;

public class FullCalendarEntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {
		StyleInjector.injectAtEnd(FullCalendarClientBundle.INSTANCE.fullCalendarCss().getText());
		StyleInjector.injectAtEnd("@media print {" + FullCalendarClientBundle.INSTANCE.fullCalendarPrintCss().getText() + "}");
		if( !isCalendarPresent() ){
          ScriptInjector.fromString(FullCalendarClientBundle.INSTANCE.getFullCalendarJS().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
          ScriptInjector.fromString(FullCalendarClientBundle.INSTANCE.getGoogleCalJS().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
		}
		
		if( !isDragAndResizePresent() ){
			ScriptInjector.fromString(FullCalendarClientBundle.INSTANCE.getCustomDragResizeJS().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
	    }
	}
	
	private native boolean isCalendarPresent() /*-{
		if( $wnd.jQuery && $wnd.jQuery.fullCalendar ){
			return true;
		}else{
			return false;
		}
	}-*/; 
	
	private native boolean isDragAndResizePresent() /*-{
		if( $wnd.jQuery && $wnd.jQuery.draggable && $wnd.jQuery.resizable ){
			return true;
		}else{
			return false;
		}
	}-*/; 

}
