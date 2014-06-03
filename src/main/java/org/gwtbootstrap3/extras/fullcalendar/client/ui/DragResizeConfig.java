package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import com.google.gwt.core.client.JavaScriptObject;

public class DragResizeConfig {
	private JavaScriptObject script;
	
	public DragResizeConfig(EventDragAndResizeHandler handler){
		if( handler != null ){
			newInstance(handler);
		}
	}
	
	private native void newInstance(EventDragAndResizeHandler handler) /*-{
		var theInstance = this;
		var dragResizeHandler = handler;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragResizeConfig::script = {};
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragResizeConfig::script.eventDragStart = function(event,jsEvent,ui,view){
			if( event && jsEvent ){
				var originalEvent = null;
				if( jsEvent.originalEvent ){
					originalEvent = jsEvent.originalEvent;
				}
				dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventDragAndResizeHandler::eventDragStart(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event,originalEvent);
			}
		}
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragResizeConfig::script.eventDragStop = function(event,jsEvent,ui,view){
			if( event && jsEvent ){
				var originalEvent = null;
				if( jsEvent.originalEvent ){
					originalEvent = jsEvent.originalEvent;
				}
				dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventDragAndResizeHandler::eventDragStop(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event,originalEvent);
			}
		}
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragResizeConfig::script.eventDrop = function(event,revertFunc,jsEvent,ui,view){
			var originalEvent = null;
			if( jsEvent && jsEvent.originalEvent ){
				originalEvent = jsEvent.originalEvent;
			}
			dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventDragAndResizeHandler::eventDrop(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event,revertFunc,originalEvent);
		}
		
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragResizeConfig::script.eventResizeStart = function(event,jsEvent,ui,view){
			if( event && jsEvent ){
				var originalEvent = null;
				if( jsEvent.originalEvent ){
					originalEvent = jsEvent.originalEvent;
				}
				dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventDragAndResizeHandler::eventResizeStart(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event,originalEvent);
			}
		}
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragResizeConfig::script.eventResizeStop = function(event,jsEvent,ui,view){
			if( event && jsEvent ){
				var originalEvent = null;
				if( jsEvent.originalEvent ){
					originalEvent = jsEvent.originalEvent;
				}
				dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventDragAndResizeHandler::eventResizeStop(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event,originalEvent);
			}
		}
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragResizeConfig::script.eventResize = function(event,revertFunc,jsEvent,ui,view){
			var originalEvent = null;
			if( jsEvent && jsEvent.originalEvent ){
				originalEvent = jsEvent.originalEvent;
			}
			dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventDragAndResizeHandler::eventResize(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event,revertFunc,originalEvent);
		}
	}-*/; 
	
	
	public JavaScriptObject toJavaScript(){
		return script;
	}
}
