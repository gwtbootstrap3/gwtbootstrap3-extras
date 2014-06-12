package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Callback to receive the eventDateTransform event
 * @author Jeff Isenhart
 * @see http://arshaw.com/fullcalendar/docs/event_data/eventDataTransform/
 */
public interface EventDataTransformCallback {
	public void eventData(JavaScriptObject data);
}
