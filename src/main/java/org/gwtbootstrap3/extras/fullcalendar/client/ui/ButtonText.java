package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import com.google.gwt.core.client.JavaScriptObject;

public class ButtonText implements IsJavaScriptObject{

	private JavaScriptObject text; 
	
	public ButtonText(){
		newInstance();
	}

	private native void newInstance( ) /*-{
		//default vals...
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ButtonText::text = 
		{
		    prev:     '&lsaquo;', // <
		    next:     '&rsaquo;', // >
		    prevYear: '&laquo;',  // <<
		    nextYear: '&raquo;',  // >>
		    today:    'today',
		    month:    'month',
		    week:     'week',
		    day:      'day'
		};
	}-*/;
	
	public native void setPrev( String previous ) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ButtonText::text.prev = previous;
	}-*/;
	
	public native void setNext( String next ) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ButtonText::text.next = next;
	}-*/;
	
	public native void setPrevYear( String previousYear ) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ButtonText::text.prevYear = previousYear;
	}-*/;
	
	public native void setNextYear( String nextYear ) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ButtonText::text.nextYear = nextYear;
	}-*/;
	
	public native void setToday( String today ) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ButtonText::text.today = today;
	}-*/;
	
	public native void setMonth( String month ) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ButtonText::text.month = month;
	}-*/;
	
	public native void setWeek( String week ) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ButtonText::text.week = week;
	}-*/;
	
	public native void setDay( String day ) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ButtonText::text.day = day;
	}-*/;
	
	public JavaScriptObject toJavaScript(){
		return text;
	}

}
