package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.NativeEvent;

public interface ClickAndHoverEventCallback {
	public void eventClick(JavaScriptObject calendarEvent,NativeEvent event,JavaScriptObject viewObject);
	public void dayClick(JavaScriptObject moment,NativeEvent event,JavaScriptObject viewObject);
	public void eventMouseover(JavaScriptObject calendarEvent,NativeEvent event,JavaScriptObject viewObject);
	public void eventMouseout(JavaScriptObject calendarEvent,NativeEvent event,JavaScriptObject viewObject);
}
