package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.NativeEvent;

public interface DragAndResizeCallback {
	public void eventDragStart(JavaScriptObject calendarEvent, NativeEvent nativeEvent);
	public void eventDragStop(JavaScriptObject calendarEvent, NativeEvent nativeEvent);
	public void eventDrop(JavaScriptObject calendarEvent, JavaScriptObject revertFunction,NativeEvent nativeEvent);
	public void eventResizeStart(JavaScriptObject calendarEvent, NativeEvent nativeEvent);
	public void eventResizeStop(JavaScriptObject calendarEvent, NativeEvent nativeEvent);
	public void eventResize(JavaScriptObject calendarEvent, JavaScriptObject revertFunction,NativeEvent nativeEvent);
}
