package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Models the configuration of an <code>Event</code> object
 * @author Jeff Isenhart
 * @see http://arshaw.com/fullcalendar/docs/event_data/
 */
public class EventDataConfig implements IsJavaScriptObject {
	private JavaScriptObject config;
	
	public EventDataConfig(){
		newInstance();
	}
	
	private native void newInstance() /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventDataConfig::config = {
			allDayDefault:null,
			startParam:'start',
			endParam:'end',
			timezoneParam:'timezone',
			lazyFetching:true,
			defaultTimedEventDuration:'02:00:00',
			defaultAllDayEventDuration:{days: 1},
			forceEventDuration:false	
		};
	}-*/; 
	
	public void addEventDataTransformCallback(EventDataTransformCallback callback){
		if( callback != null ){
			addTransformCallback(callback);
		}
	}
	
	private native void addTransformCallback(EventDataTransformCallback callback) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventDataConfig::config.eventDataTransform = function(eventData){
			callback.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventDataTransformCallback::eventData(Lcom/google/gwt/core/client/JavaScriptObject;)(eventData);
		}
	}-*/; 
	
	public void addEventLoadingCallback(EventLoadingCallback callback){
		if( callback != null ){
			addLoadingCallback(callback);
		}
	}
	private native void addLoadingCallback(EventLoadingCallback callback) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventDataConfig::config.loading = function(loading,view){
			callback.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventLoadingCallback::isLoading(ZLcom/google/gwt/core/client/JavaScriptObject;)(loading,view);
		}
	}-*/;
	
	public JavaScriptObject toJavaScript(){
		return config;
	}
}
