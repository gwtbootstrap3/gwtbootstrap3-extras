package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

public interface ViewRenderCallback {
	public void viewRender( JavaScriptObject view, Element element );
	public void viewDestroy( JavaScriptObject view, Element element );
	public void dayRender( JavaScriptObject moment, Element tdElement );
	public void windowResize( JavaScriptObject view );
}
