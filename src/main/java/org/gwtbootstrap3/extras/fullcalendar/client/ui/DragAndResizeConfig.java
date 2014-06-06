package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * 
 * @author Jeff Iesnhart
 * @see http://arshaw.com/fullcalendar/docs/event_ui/
 */
public class DragAndResizeConfig implements IsJavaScriptObject {
	private JavaScriptObject script;
	
	public DragAndResizeConfig(DragAndResizeCallback handler){
		if( handler != null ){
			newInstance(handler);
		}
	}
	
	private native void newInstance(DragAndResizeCallback handler) /*-{
		var theInstance = this;
		var dragResizeHandler = handler;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeConfig::script = {};
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeConfig::script.eventDragStart = function(event,jsEvent,ui,view){
			if( event && jsEvent ){
				var originalEvent = null;
				if( jsEvent.originalEvent ){
					originalEvent = jsEvent.originalEvent;
				}
				dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeCallback::eventDragStart(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event,originalEvent);
			}
		}
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeConfig::script.eventDragStop = function(event,jsEvent,ui,view){
			if( event && jsEvent ){
				var originalEvent = null;
				if( jsEvent.originalEvent ){
					originalEvent = jsEvent.originalEvent;
				}
				dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeCallback::eventDragStop(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event,originalEvent);
			}
		}
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeConfig::script.eventDrop = function(event,revertFunc,jsEvent,ui,view){
			var originalEvent = null;
			if( jsEvent && jsEvent.originalEvent ){
				originalEvent = jsEvent.originalEvent;
			}
			dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeCallback::eventDrop(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event,revertFunc,originalEvent);
		}
		
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeConfig::script.eventResizeStart = function(event,jsEvent,ui,view){
			if( event && jsEvent ){
				var originalEvent = null;
				if( jsEvent.originalEvent ){
					originalEvent = jsEvent.originalEvent;
				}
				dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeCallback::eventResizeStart(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event,originalEvent);
			}
		}
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeConfig::script.eventResizeStop = function(event,jsEvent,ui,view){
			if( event && jsEvent ){
				var originalEvent = null;
				if( jsEvent.originalEvent ){
					originalEvent = jsEvent.originalEvent;
				}
				dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeCallback::eventResizeStop(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event,originalEvent);
			}
		}
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeConfig::script.eventResize = function(event,revertFunc,jsEvent,ui,view){
			var originalEvent = null;
			if( jsEvent && jsEvent.originalEvent ){
				originalEvent = jsEvent.originalEvent;
			}
			dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DragAndResizeCallback::eventResize(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event,revertFunc,originalEvent);
		}
	}-*/; 
	
	
	public JavaScriptObject toJavaScript(){
		return script;
	}
}
