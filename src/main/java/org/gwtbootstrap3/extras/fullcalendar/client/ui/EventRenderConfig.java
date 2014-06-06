package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import com.google.gwt.core.client.JavaScriptObject;

public class EventRenderConfig implements IsJavaScriptObject {

	private JavaScriptObject config;
	
	public EventRenderConfig(EventRenderHandler callback){
		newInstance(callback);
	}
	
	private native void newInstance(EventRenderHandler callback) /*-{
		var theInstance = this;
		var theCallback = callback;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventRenderConfig::config = {};
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventRenderConfig::config.eventRender = function(calEvent, element, view) {
			theCallback.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventRenderHandler::render(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/Element;)(calEvent,element[0]);
  		}
	}-*/;
	@Override
	public JavaScriptObject toJavaScript() {
		return config;
	}

}
