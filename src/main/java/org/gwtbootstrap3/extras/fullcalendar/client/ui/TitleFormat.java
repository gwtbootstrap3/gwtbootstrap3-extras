package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;

public class TitleFormat extends AbstractViewOptionFormat {
	private JavaScriptObject format;
	public TitleFormat(){
		this(null);
	}

	public TitleFormat(Map<ViewOptionHash,String> options){
		newInstance();
		if( options == null ){
			options = getDefaultOptions();
		}
		for (ViewOptionHash option : options.keySet()) {
			setFormat(option.name(), options.get(option));
		}
	}

	@Override
	/**
	 * @see http://arshaw.com/fullcalendar/docs/text/titleFormat/
	 */
	protected void populateDefaultOptions(Map<ViewOptionHash, String> options) {
		options.put(ViewOptionHash.month, "MMMM yyyy");
		options.put(ViewOptionHash.week, "MMM d[ yyyy]{ '&#8212;'[ MMM] d yyyy}");
		options.put(ViewOptionHash.day, "dddd, MMM d, yyyy");
	}
	
	
	
	private native void newInstance() /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.TitleFormat::format = {
		};
	}-*/;
	
	
	private native void setFormat(String format, String viewOption) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.TitleFormat::format[viewOption] = format;
	}-*/;
	
	public JavaScriptObject toJavaScript(){
		return format;
	}

	
}
