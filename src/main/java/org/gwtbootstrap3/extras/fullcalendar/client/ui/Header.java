package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * http://arshaw.com/fullcalendar/docs/display/header/
 * 
 * Setting the header options to false will display no header. 
 * An object can be supplied with properties left, center, and right. 
 * These properties contain strings with comma/space separated values. 
 * Values separated by a comma will be displayed adjacently. 
 * Values separated by a space will be displayed with a small gap in between. 
 * Strings can contain any of the following values:
 * <code>
 * {
 *   left:   'title',
 *   center: '',
 *   right:  'today prev,next'
 * }
 * </code>
 * 
 * @author Jeff Isenhart
 *
 */
public class Header {

	private JavaScriptObject header;
	
	public Header(){
		newInstance();
	}
	
	private native void newInstance() /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Header::header = {left:'title',center:'',right:'today prev,next'};
	}-*/;
	
	public native void setNoHeader() /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Header::header = false;
	}-*/;

	public native void setLeft( String left ) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Header::header.left = left;
	}-*/;
	

	public native void setCenter( String center ) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Header::header.center = center;
	}-*/;

	
	public native void setRight( String right ) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Header::header.right = right;
	}-*/;

	public JavaScriptObject toJavaScript(){
		return header;
	}
}
