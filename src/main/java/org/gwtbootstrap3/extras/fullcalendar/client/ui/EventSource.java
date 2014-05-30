package org.gwtbootstrap3.extras.fullcalendar.client.ui;


import com.google.gwt.core.client.JavaScriptObject;

public class EventSource {

	private JavaScriptObject eventSource;

	
	public EventSource( JavaScriptObject jso ){
		eventSource = jso;
	}
	
	public EventSource( String url,
			String color,
			String backgroundColor,
			String textColor,
			String borderColor,
			String className, 
			boolean isEditable, 
			boolean isStartEditable, 
			boolean isDurationEditable, 
			boolean allDayDefault,
			boolean ignoreTimeZone
			){
		newEvent(url,color,backgroundColor,textColor,borderColor,className,isEditable,isStartEditable,isDurationEditable,allDayDefault,ignoreTimeZone);
	}
	
	private native void newEvent( String url,
			String color,
			String backgroundColor,
			String textColor,
			String borderColor,
			String className, 
			boolean isEditable, 
			boolean isStartEditable, 
			boolean isDurationEditable, 
			boolean allDayDefault,
			boolean ignoreTimeZone
			) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource = {
			url: url,
			color: color, 
			backgroundColor:backgroundColor, 
			textColor: textColor,
			borderColor:borderColor,
			className: className,
			editable: isEditable,
			startEditable:isStartEditable,
			durationEditable:isDurationEditable,
			allDayDefault:allDayDefault,
			ignoreTimeZone:ignoreTimeZone
			};
	}-*/;
	
	public native void setEventDataTransform( EventDataTransform callback ) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.eventTransform = function(eventData){
			if( callback ){
				callback.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventDataTransform::eventData(Lcom/google/gwt/core/client/JavaScriptObject;)(eventData);
			}
		}
	}-*/; 
	
	public native String getUrl() /*-{
		var theInstance = this;
		return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.url;
	}-*/; 
	
	public native String getColor() /*-{
		var theInstance = this;
		return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.color;
	}-*/; 
	
	public native String getBackgroundColor() /*-{
		var theInstance = this;
		return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.backgroundColor;
	}-*/; 
	
	public native String getTextColor() /*-{
		var theInstance = this;
		return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.textColor;
	}-*/; 
	
	public native String getBorderColor() /*-{
		var theInstance = this;
		return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.borderColor;
	}-*/; 
	
	
	public native String getClassName() /*-{
		var theInstance = this;
		return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.className;
	}-*/; 
	
	public native boolean getIsEditable() /*-{
		var theInstance = this;
		return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.editable;
	}-*/; 
	
	public native boolean getStartEditable() /*-{
		var theInstance = this;
		return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.startEditable;
	}-*/; 

	
	public native boolean getDurationEditable() /*-{
		var theInstance = this;
		if( theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.durationEditable ){
			return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.durationEditable; 
		}
		return false;
	}-*/;
	
	public native boolean isAllDayDefault() /*-{
		var theInstance = this;
		return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.allDayDefault;
	}-*/; 
	
	public native boolean ignoreTimeZone() /*-{
		var theInstance = this;
		return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventSource::eventSource.ignoreTimeZone;
	}-*/; 
	

	public JavaScriptObject toJavaScript(){
		return this.eventSource;
	}
	

}
