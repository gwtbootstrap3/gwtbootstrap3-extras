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
			axisFormat: "h(:mm)a",
			slotDuration: '00:30.00',
			scrollTime: '06:00:00',
			minTime: '00:00:00',
			maxTime: '24:00:00',
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
	
	public void setSlotDuration( int minutes ){
		assert minutes >=0 && minutes <= 60;
		if( minutes < 10 ){
			setSlotDuration("00:0" + minutes + ":00");
		}else{
			setSlotDuration("00:" + minutes + ":00");
		}
	}
	/**
	 * @see http://arshaw.com/fullcalendar/docs/agenda/slotDuration/
	 */
	public native void setSlotDuration(String timeString) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.slotDuration = timeString;
	}-*/; 
	
	public void setSnapDuration( int minutes ){
		assert minutes >=0 && minutes <= 60;
		if( minutes < 10 ){
			setSnapDuration("00:0" + minutes + ":00");
		}else{
			setSnapDuration("00:" + minutes + ":00");
		}
	}
	
	/**
	 * @see http://arshaw.com/fullcalendar/docs/agenda/snapDuration/
	 */
	public native void setSnapDuration(String timeString) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.snapDuration = timeString;
	}-*/; 
	
	/**
	 * @see http://arshaw.com/fullcalendar/docs/agenda/scrollTime/
	 */
	public native void setScrollTime(String timeString) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.scrollTime = timeString;
	}-*/; 
	
	
	
	/**
	 * @see http://arshaw.com/fullcalendar/docs/agenda/minTime/
	 */
	public native void setMinTime(String timeString) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.minTime = timeString;
	}-*/; 
	
	
	/**
	 * @see http://arshaw.com/fullcalendar/docs/agenda/maxTime/
	 */
	public native void setMaxTime(String timeString) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.AgendaOptions::options.maxTime = timeString;
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
