package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;

/**
 * 
 * @author Jeff 
 * @see http://arshaw.com/fullcalendar/docs/views/View_Object/
 */
public class View {

	private JavaScriptObject view;
	
	/**
	 * 
	 * @param jso
	 */
	public View( JavaScriptObject jso ){
		view = jso;
	}
	
	public native String getName() /*-{
		var theInstance = this;
		return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.View::view.name;
	}-*/; 
	
	public native String getTitle() /*-{
		var theInstance = this;
		return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.View::view.title;
	}-*/; 
	
	public native JsDate getStart() /*-{
		var theInstance = this;
		var returnVal = theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.View::view.start;
		if( returnVal ){
			return returnVal.toDate();
		}
		return null;
	}-*/; 
	
	
	public native JsDate getEnd() /*-{
		var theInstance = this;
		var returnVal = theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.View::view.end;
		if( returnVal ){
			return returnVal.toDate();
		}
		return null;
	}-*/; 
	
	

	public native JsDate getIntervalStart() /*-{
		var theInstance = this;
		var returnVal = theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.View::view.intervalStart;
		if( returnVal ){
			return returnVal.toDate();
		}
		return null;
	}-*/; 
	

	public native JsDate getIntervalEnd() /*-{
		var theInstance = this;
		var returnVal = theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.View::view.intervalEnd;
		if( returnVal ){
			return returnVal.toDate();
		}
		return null;
	}-*/; 
	
	
	public JavaScriptObject toJavaScript(){
		return this.view;
	}
	

}
