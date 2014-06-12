package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * Callback to receive the eventRender event
 * @author Jeff Isenhart
 * @see http://arshaw.com/fullcalendar/docs/event_rendering/eventRender/
 */
public interface EventRenderHandler {
	public void render(JavaScriptObject evt, Element ele);
}
