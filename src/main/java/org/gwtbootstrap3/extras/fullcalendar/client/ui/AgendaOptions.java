package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @see http://arshaw.com/fullcalendar/docs/agenda/
 * @author Jeff Isenhart
 *
 */
public class AgendaOptions implements IsJavaScriptObject{
	private JavaScriptObject options;
	
	public AgendaOptions(){
		newInstance();
	}
	
	/**
	 * Sets defaults
	 * @see http://arshaw.com/fullcalendar/docs/agenda/ 
	 */
	public native void newInstance() /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options = {
			allDaySlot: true,
			allDayText: "all-day",
			axisFormat: "h(:mm)tt",
			slotMinutes: 30,
			snapMinutes: 30,
			defaultEventMinutes: 120,
			firstHour: 6,
			minTime: 0,
			maxTime: 24,
			slotEventOverlap: true
			
		};
	}-*/; 
	
	/**
	 * @see http://arshaw.com/fullcalendar/docs/agenda/allDaySlot/
	 */
	public native void setAllDaySlot(boolean allDay) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.allDaySlot = allDay;
	}-*/; 
	
	/**
	 * @see http://arshaw.com/fullcalendar/docs/agenda/allDayText/
	 */
	public native void setAllDayText(String text) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.allDayText = text;
	}-*/; 
	
	
	/**
	 * @see http://arshaw.com/fullcalendar/docs/agenda/axisFormat/
	 */
	public native void setAxisFormat(String format) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.axisFormat = format;
	}-*/; 
	
	
	/**
	 * @see http://arshaw.com/fullcalendar/docs/agenda/slotMinutes/
	 */
	public native void setSlotMinutes(int minutes) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.slotMinutes = minutes;
	}-*/; 
	
	
	/**
	 * @see http://arshaw.com/fullcalendar/docs/agenda/snapMinutes/
	 */
	public native void setSnapMinutes(int minutes) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.snapMinutes = minutes;
	}-*/; 
	
	
	/**
	 * @see http://arshaw.com/fullcalendar/docs/agenda/defaultEventMinutes/
	 */
	public native void setDefaultEventMinutes(int minutes) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.defaultEventMinutes = minutes;
	}-*/; 
	
	
	/**
	 * @see http://arshaw.com/fullcalendar/docs/agenda/firstHour/
	 */
	public native void setFirstHour(int hour) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.firstHour = hour;
	}-*/; 
	
	
	/**
	 * @see http://arshaw.com/fullcalendar/docs/agenda/minTime/
	 */
	public native void setMinTime(int min) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.minTime = min;
	}-*/; 
	
	
	/**
	 * @see http://arshaw.com/fullcalendar/docs/agenda/maxTime/
	 */
	public native void setMaxTime(int max) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.maxTime = max;
	}-*/; 
	
	
	/**
	 * @see http://arshaw.com/fullcalendar/docs/agenda/slotEventOverlap/
	 */
	public native void setSlotEventOverlap(boolean overlap) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.slotEventOverlap = overlap;
	}-*/; 

	
	
	public JavaScriptObject toJavaScript(){
		return options;
	}

}
