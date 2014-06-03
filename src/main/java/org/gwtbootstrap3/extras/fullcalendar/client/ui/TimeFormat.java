package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;

public class TimeFormat extends AbstractViewOptionFormat implements IsJavaScriptObject {
	private JavaScriptObject format;
	public TimeFormat(){
		this("h(:mm)t",null);
	}

	public TimeFormat(String defaultValue,Map<ViewOptionHash,String> options){
		newInstance(defaultValue);
		if( options == null ){
			options = getDefaultOptions();
		}
		for (ViewOptionHash option : options.keySet()) {
			setFormat(option.name(), options.get(option));
		}
	}
	@Override
	/**
	 * @see http://arshaw.com/fullcalendar/docs/text/timeFormat/
	 */
	protected void populateDefaultOptions(Map<ViewOptionHash, String> options) {
		options.put(ViewOptionHash.agenda, "h:mm{ - h:mm}");
	}

	
	private native void newInstance(String defaultValue) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.TimeFormat::format = {
		    // for all other views
		    '': defaultValue
		};
	}-*/;
	
	
	private native void setFormat(String format, String viewOption) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.TimeFormat::format[viewOption] = format;
	}-*/;
	
	public JavaScriptObject toJavaScript(){
		return format;
	}

	
}
