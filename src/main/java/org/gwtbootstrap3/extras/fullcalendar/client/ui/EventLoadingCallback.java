package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Callback to receive the loading event
 * @author Jeff Isenhart
 * @see http://arshaw.com/fullcalendar/docs/event_data/loading/
 */
public interface EventLoadingCallback {
	public void isLoading(boolean isLoading,JavaScriptObject viewObject);
}
