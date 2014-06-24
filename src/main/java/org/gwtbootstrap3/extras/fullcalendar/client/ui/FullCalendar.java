package org.gwtbootstrap3.extras.fullcalendar.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2014 GwtBootstrap3
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsDate;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.dom.client.HasLoadHandlers;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * Wrapper around FullCalendar
 * @see http://arshaw.com/fullcalendar/
 * @author Jeff Isenhart
 *
 */
public class FullCalendar extends FlowPanel implements HasLoadHandlers{

	private ViewOption currentView;//http://arshaw.com/fullcalendar/docs/views/defaultView/
	private CalendarConfig config;//a bunch of options and events encapsulated in one place
	private boolean editable;//@see http://arshaw.com/fullcalendar/docs/event_ui/editable/
	private boolean loaded;
	private static Map<String,JavaScriptObject> languageScripts;
	
	public FullCalendar(String id, ViewOption defaultView,boolean editable ) {
		this(id,defaultView,null,editable);
	}
	
	public FullCalendar(String id,ViewOption defaultView,boolean editable, Header header) {
		this(id,defaultView,new CalendarConfig(header),editable);
	}
	
	public FullCalendar(String id,ViewOption defaultView, CalendarConfig config,boolean editable) {
		getElement().setId(id);
		this.currentView = defaultView == null ? ViewOption.month : defaultView;
		this.config = config;
		this.editable = editable;
		loaded = false;
		if( languageScripts == null ){
			languageScripts = new HashMap<String, JavaScriptObject>();
		}
	}

	/**
	 * This method is called immediately after a widget becomes attached to the
	 * browser's document.
	 */
	protected void onLoad() {
		super.onLoad();
		loaded = true;
		renderCalendar();
	}
	
	private void renderCalendar(){
		JsArray<JavaScriptObject> javascriptParams = null;
		String language = null;
		String timezone = null;
		String weekNumberTitle = null;
		if( config != null ){
			timezone = config.getTimezone();
			weekNumberTitle = config.getWeekNumberTitle();
			javascriptParams = config.getJavaScriptParameters();
			if( config.getLangauge() != null ){
				language = config.getLangauge().getCode();
				ensureInjected(config.getLangauge());
			}
		}
		addCalendar(getElement().getId(),
					currentView.name(),
					editable,
					language,
					timezone,
					weekNumberTitle,
					javascriptParams
		);
		//Let everyone know it is ok to add events and set properties on the instance
		DomEvent.fireNativeEvent(Document.get().createLoadEvent(), this);
	}
	
	public void changeLangauge( Language language ){
		if( language != null ){
			if( config == null ){
				config = new CalendarConfig();
			}
			config.setLangauge(language);
			destroy();
			renderCalendar();
		}
	}
	
	public void changeTimezone( String timezone ){
		if( timezone != null ){
			if( config == null ){
				config = new CalendarConfig();
			}
			config.setTimezone(timezone);
			destroy();
			renderCalendar();
		}
	}
	
	
	private void ensureInjected(Language language) {
		if( !languageScripts.isEmpty() ){
			for (JavaScriptObject script : languageScripts.values() ) {
				try {
					Element ele = (Element)script;
					ele.removeFromParent();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		JavaScriptObject scriptElement = ScriptInjector.fromString(language.getResource().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
		languageScripts.put(language.getCode(), scriptElement);
		
	}

	
	private native void addCalendar( String id, 
			String currentView, 
			boolean editable,
			String lang,
			String timezone,
			String weekNumberTitle,
			JsArray<JavaScriptObject> options
			) /*-{
		var fullCalendarParams = {
				defaultView: currentView,
				selectable: true,
				selectHelper: true,
				editable:editable
					
		};
		if( lang ){
			fullCalendarParams.lang = lang;
		}
		if( timezone ){
			fullCalendarParams.timezone = timezone;
		}
		if( weekNumberTitle ){
			fullCalendarParams.weekNumberTitle = weekNumberTitle;
		}
		if( options ){
			for (var i = 0; i < options.length; i++) {
			    $wnd.jQuery.extend(fullCalendarParams,options[i]);
			}
		}
		console.log(fullCalendarParams);
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
	
	public ViewOption getCurrentView(){
		return currentView;
	}
	

	private native void addEvent( String id, JavaScriptObject event ) /*-{
		$wnd.jQuery('#' + id).fullCalendar('renderEvent', event, true);
	}-*/;
	
	public void setView( ViewOption view ){
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
	
	public JsArray<JavaScriptObject> getEvent( String eventId ) {
		if( eventId != null ){
			return getEvent(getElement().getId(),eventId);
		}
		return null;
	}
	
	public native JsArray<JavaScriptObject> getEvent( String id,String eventId ) /*-{
		return $wnd.jQuery('#' + id).fullCalendar('clientEvents',eventId);
	}-*/;
	
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
		return $wnd.jQuery('#' + id).fullCalendar('getDate').toDate();
	}-*/;

	public void today() {
		today(getElement().getId());
	}
	
	private native void today( String id ) /*-{
		$wnd.jQuery('#' + id).fullCalendar('today');
	}-*/;
	
	public View getView(){
		return new View(getView(getElement().getId()));
	}
	
	private native JavaScriptObject getView( String id ) /*-{
		$wnd.jQuery('#' + id).fullCalendar('getView');
	}-*/;
	
	
	public void destroy(){
		destroy(getElement().getId());
	}
	
	private native void destroy( String id ) /*-{
		$wnd.jQuery('#' + id).fullCalendar('destroy');
	}-*/;
	
	public void render(){
		render(getElement().getId());
	}
	
	private native void render( String id ) /*-{
		$wnd.jQuery('#' + id).fullCalendar('render');
	}-*/;
	
	public void setHeight( int height ){
		if( height >=0 ){
			setHeight(getElement().getId(), height);
		}
	}
	private native void setHeight( String id, int height ) /*-{
		$wnd.jQuery('#' + id).fullCalendar('option','height',height);
	}-*/;
	
	public void setContentHeight( int height ){
		if( height >=0 ){
			setContentHeight(getElement().getId(), height);
		}
	}
	private native void setContentHeight( String id, int height ) /*-{
		$wnd.jQuery('#' + id).fullCalendar('option','contentHeight',height);
	}-*/;
	

	public void setAspectRatio( double ratio ){
		if( ratio > 0 ){
			setAspectRatio(getElement().getId(), ratio);
		}
	}
	private native void setAspectRatio( String id, double ratio ) /*-{
		$wnd.jQuery('#' + id).fullCalendar('option','aspectRatio',ratio);
	}-*/;
	
	/**
	 * Useful for callback cancel/revert functions
	 * @param revertFunction
	 */
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
