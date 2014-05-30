package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import com.google.gwt.core.client.JavaScriptObject;

public class Header {

	private JavaScriptObject header;
	
	public Header(){
		newInstance();
	}
	
	private native void newInstance() /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Header::header = {left:'',center:'',right:''};
	}-*/;
	
	public void addLeft(HeaderPlaceHolderOption option) {
		if( option != null ){
			addLeft(option.name());
		}
	}

	public native void addLeft( String prop ) /*-{
		var theInstance = this;
		var arr = theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Header::header.left.split(",");
		arr.push(prop);
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Header::header.left = arr.join(",");
	}-*/;
	
	
	public void addCenter(HeaderPlaceHolderOption option) {
		if( option != null ){
			addCenter(option.name());
		}
	}
	
	public native void addCenter( String prop ) /*-{
		var theInstance = this;
		var arr = theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Header::header.center.split(",");
		arr.push(prop);
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Header::header.center = arr.join(",");
	}-*/;

	public void addRight(HeaderPlaceHolderOption option) {
		if( option != null ){
			addRight(option.name());
		}
	}
	
	public native void addRight( String prop ) /*-{
		var theInstance = this;
		var arr = theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Header::header.right.split(",");
		arr.push(prop);
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.Header::header.right = arr.join(",");
	}-*/;

	public JavaScriptObject toJavaScript(){
		return header;
	}
}
