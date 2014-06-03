package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;

public class ColumnFormat extends AbstractViewOptionFormat implements IsJavaScriptObject {
	private JavaScriptObject format;
	public ColumnFormat(){
		this(null);
	}

	public ColumnFormat(Map<ViewOptionHash,String> options){
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
	 * @see http://arshaw.com/fullcalendar/docs/text/columnFormat/
	 */
	protected void populateDefaultOptions(Map<ViewOptionHash, String> options) {
		options.put(ViewOptionHash.month, "ddd");
		options.put(ViewOptionHash.week, "ddd M/d");
		options.put(ViewOptionHash.day, "dddd M/d");
	}
	
	
	
	private native void newInstance() /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ColumnFormat::format = {
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
