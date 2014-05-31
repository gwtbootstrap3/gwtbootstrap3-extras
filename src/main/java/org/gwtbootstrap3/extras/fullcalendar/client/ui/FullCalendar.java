package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.dom.client.HasLoadHandlers;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.FlowPanel;

public class FullCalendar extends FlowPanel implements HasLoadHandlers{

	private Header header;
	private View currentView;
	private boolean loaded;
	private CalendarConfig config;
	
	public FullCalendar(String id, View defaultView ) {
		this(id,defaultView,null);
	}
	
	public FullCalendar(String id,View defaultView, Header header) {
		this(id,defaultView,null,null);
	}
	
	public FullCalendar(String id,View defaultView, Header header,CalendarConfig config) {
		getElement().setId(id);
		this.currentView = defaultView;
		this.header = header;
		this.config = config;
		loaded = false;
	}

	/**
	 * This method is called immediately after a widget becomes attached to the
	 * browser's document.
	 */
	protected void onLoad() {
		super.onLoad();
		loaded = true;
		if( config == null ){
			addCalendar(getElement().getId(),currentView.name(),header == null ? null : header.toJavaScript());
		}else{
			addCalendar(getElement().getId(),
					currentView.name(),
					header == null ? null : header.toJavaScript(),
							config.getButtonText().toJavaScript(),
							config.getMonthNames().getLongNames(),
							config.getMonthNames().getShortNames(),
							config.getDayNames().getLongNames(),
							config.getDayNames().getShortNames(),
							config.getClickHandler(),
							config.getRenderHandler(),
							config.getEventLoadingHandler(),
							config.getDragResizeHandler()
					);
		}
		DomEvent.fireNativeEvent(Document.get().createLoadEvent(), this);
	}
	
	private native void addCalendar( String id, String currentView, JavaScriptObject defaultHeader ) /*-{
		$wnd.jQuery('#' + id).fullCalendar(
			{
				header: defaultHeader,
				defaultView: currentView,
				selectable: true,
				selectHelper: true,
				editable:true
				
			}
		);
	}-*/;
	
	private native void addCalendar( String id, 
			String currentView, 
			JavaScriptObject defaultHeader,
			JavaScriptObject buttonText,
			JavaScriptObject longMonthNames,
			JavaScriptObject shortMonthNames,
			JavaScriptObject longDayNames,
			JavaScriptObject shortDayNames,
			EventClickHandler clickHandler,
			EventRenderHandler renderHandler,
			EventLoadingHandler loadingHandler,
			EventDragAndResizeHandler dragResizeHandler
			) /*-{
		var clickFunction = function(calEvent, jsEvent, view){};
		var renderFunction = function(calEvent, element, view) {};
		var loadingFunction = function(loading) {};
		if( clickHandler ){
			clickFunction = function(calEvent, jsEvent, view) {
				
				clickHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventClickHandler::eventClicked(Lcom/google/gwt/core/client/JavaScriptObject;)(calEvent);
      		}
		}
		if( renderHandler ){
			renderFunction = function(calEvent, element, view) {
				var ele = element;
				if( !(element instanceof HTMLElement) ){
					ele = element[0];
				}
				renderHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventRenderHandler::render(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/Element;)(calEvent,ele);
      		}
		}
		if( loadingHandler ){
			loadingFunction = function(loading) {
				if( loading ){
					loadingHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventLoadingHandler::isLoading(Ljava/lang/Boolean;)(@java.lang.Boolean::TRUE);
				}else{
					loadingHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventLoadingHandler::isLoading(Ljava/lang/Boolean;)(@java.lang.Boolean::FALSE);
				}
				
			};
		}
		var fullCalendarParams = {
				header: defaultHeader,
				defaultView: currentView,
				selectable: true,
				selectHelper: true,
				editable:true,
				buttonText:buttonText,
				monthNames: longMonthNames,
				monthNamesShort:shortMonthNames,
				dayNames:longDayNames,
				dayNamesShort:shortDayNames,
				eventRender: renderFunction,
				eventClick: clickFunction,
				loading: loadingFunction
				
		};
		if( dragResizeHandler ){
			fullCalendarParams.eventDragStart = function(event,jsEvent,ui,view){
				if( event && jsEvent ){
					var originalEvent = null;
					if( jsEvent.originalEvent ){
						originalEvent = jsEvent.originalEvent;
					}
					dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventDragAndResizeHandler::eventDragStart(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event,originalEvent);
				}
			}
			fullCalendarParams.eventDragStop = function(event,jsEvent,ui,view){
				if( event && jsEvent ){
					var originalEvent = null;
					if( jsEvent.originalEvent ){
						originalEvent = jsEvent.originalEvent;
					}
					dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventDragAndResizeHandler::eventDragStop(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event,originalEvent);
				}
			}
			fullCalendarParams.eventDrop = function(event,dayDelta,minuteDelta,allDay,revertFunc,jsEvent,ui,view){
				var originalEvent = null;
				if( jsEvent && jsEvent.originalEvent ){
					originalEvent = jsEvent.originalEvent;
				}
				dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventDragAndResizeHandler::eventDrop(Lcom/google/gwt/core/client/JavaScriptObject;IIZLcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event,dayDelta,minuteDelta,allDay,revertFunc,originalEvent);
			}
			
			fullCalendarParams.eventResizeStart = function(event,jsEvent,ui,view){
				if( event && jsEvent ){
					var originalEvent = null;
					if( jsEvent.originalEvent ){
						originalEvent = jsEvent.originalEvent;
					}
					dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventDragAndResizeHandler::eventResizeStart(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event,originalEvent);
				}
			}
			fullCalendarParams.eventResizeStop = function(event,jsEvent,ui,view){
				if( event && jsEvent ){
					var originalEvent = null;
					if( jsEvent.originalEvent ){
						originalEvent = jsEvent.originalEvent;
					}
					dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventDragAndResizeHandler::eventResizeStop(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event,originalEvent);
				}
			}
			fullCalendarParams.eventResize = function(event,dayDelta,minuteDelta,revertFunc,jsEvent,ui,view){
				var originalEvent = null;
				if( jsEvent && jsEvent.originalEvent ){
					originalEvent = jsEvent.originalEvent;
				}
				dragResizeHandler.@org.gwtbootstrap3.extras.fullcalendar.client.ui.EventDragAndResizeHandler::eventResize(Lcom/google/gwt/core/client/JavaScriptObject;IILcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/NativeEvent;)(event,dayDelta,minuteDelta,revertFunc,originalEvent);
			}
		}
		
		$wnd.jQuery('#' + id).fullCalendar(fullCalendarParams);
	}-*/;
	
	
	public void addEvent( Event event){
		if( loaded && event != null ){
			addEvent(getElement().getId(),event.toJavaScript());
		}
	}
	
	
	
	public void addEvents( List<Event> events){
		if( loaded && events != null && !events.isEmpty() ){
		    for (Event evt : events) {
		    	addEvent(getElement().getId(),evt.toJavaScript());
		    }
		}
	}
	
	public View getCurrentView(){
		return currentView;
	}
	

	private native void addEvent( String id, JavaScriptObject event ) /*-{
		$wnd.jQuery('#' + id).fullCalendar('renderEvent', event, true);
	}-*/;
	
	public void setView( View view ){
		if( view != null ){
			currentView = view;
			setView(getElement().getId(),view.name());
		}
	}
	private native void setView( String id, String viewName ) /*-{
		$wnd.jQuery('#' + id).fullCalendar('changeView',viewName);
	}-*/;
	
	public void goToDate( Date d ){
		if( d != null ){
			goToDate(getElement().getId(), d.getYear(), d.getMonth(), d.getDate());
		}
	}
	
	
	private native void goToDate( String id, int year, int month, int date ) /*-{
		$wnd.jQuery('#' + id).fullCalendar('goToDate',year,month,date);
	}-*/;

	@Override
	public HandlerRegistration addLoadHandler(LoadHandler handler) {
		return super.addDomHandler(handler, LoadEvent.getType());
	}
	
	public void removeEvent( String eventId ) {
		if( eventId != null ){
			removeEvent(getElement().getId(),eventId);
		}
	}
	
	public native void removeEvent( String id,String eventId ) /*-{
		$wnd.jQuery('#' + id).fullCalendar('removeEvents',eventId);
	}-*/;
	
	public void updateEvent( Event evt ) {
		if( evt != null && evt.getId() != null ){
			updateEvent(getElement().getId(),evt.toJavaScript());
		}
	}
	
	public native void updateEvent( String id,JavaScriptObject event ) /*-{
		$wnd.jQuery('#' + id).fullCalendar('updateEvent',event);
	}-*/;
	
	public void addEventSource(EventSource eventSource){
		if( eventSource != null ){
			addEventSource(getElement().getId(),eventSource.toJavaScript());
		}
	}
	private native void addEventSource( String id,JavaScriptObject eventSource ) /*-{
		$wnd.jQuery('#' + id).fullCalendar('addEventSource',eventSource);
	}-*/;
	
	public void removeEventSource(EventSource eventSource){
		if( eventSource != null ){
			removeEventSource(getElement().getId(),eventSource.toJavaScript());
		}
	}
	private native void removeEventSource( String id,JavaScriptObject eventSource ) /*-{
		$wnd.jQuery('#' + id).fullCalendar('removeEventSource',eventSource);
	}-*/;
	
	public void previous(){
		previous(getElement().getId());
	}
	private native void previous( String id ) /*-{
		$wnd.jQuery('#' + id).fullCalendar('prev');
	}-*/;
	
	public void next(){
		next(getElement().getId());
	}
	private native void next( String id ) /*-{
		$wnd.jQuery('#' + id).fullCalendar('next');
	}-*/;
	
	public Date getDate(){
		JsDate jsDate = getDate(getElement().getId());
		long time = (long)jsDate.getTime();
		return new Date(time);
	}
	private native JsDate getDate( String id ) /*-{
		return $wnd.jQuery('#' + id).fullCalendar('getDate');
	}-*/;

	public void today() {
		today(getElement().getId());
	}
	
	private native void today( String id ) /*-{
		$wnd.jQuery('#' + id).fullCalendar('today');
	}-*/;
	
	public native void excecuteFunction( JavaScriptObject revertFunction )/*-{
		try {
			var a = revertFunction;
			a();
		}
		catch(err) {
		    console.log(err);
		}
	}-*/;
	

}
