package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.i18n.client.LocaleInfo;

/**
 * @see http://arshaw.com/fullcalendar/docs/text/dayNames/
 * @see http://arshaw.com/fullcalendar/docs/text/dayNamesShort/
 * @author Jeff Isenhart
 *
 */
public class DayNames implements IsJavaScriptObject{
	private JavaScriptObject names;
	
	public DayNames(){
		newInstance();
	}
	
	private native void newInstance( ) /*-{
		//default vals...
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DayNames::names = {};
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DayNames::names.dayNames = ['Sunday', 'Monday', 'Tuesday', 'Wednesday','Thursday', 'Friday', 'Saturday'];
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DayNames::names.dayNamesShort = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
	}-*/;
	
	
	public void localize(){
		localized(LocaleInfo.getCurrentLocale().getDateTimeFormatInfo().weekdaysFull(),
				LocaleInfo.getCurrentLocale().getDateTimeFormatInfo().weekdaysShort());
	}
	
	/**
	 * pass in localized names directly
	 * @param longNames
	 * @param shortNames
	 */
	public void localized(String[] longNames,String[] shortNames){
		assert longNames != null && longNames.length == 7;
		assert shortNames != null && shortNames.length == 7;
		JsArrayString longOnes = (JsArrayString) JsArrayString.createArray();
		for (String name : longNames) {
			longOnes.push(name);
		}
		
		JsArrayString shortOnes = (JsArrayString) JsArrayString.createArray();
		for (String name : shortNames) {
			shortOnes.push(name);
		}
		localized(longOnes, shortOnes);
	}
	
	/**
	 * pass in localized names directly
	 * @param longNames
	 * @param shortNames
	 */
	public native void localized( JsArrayString longNames,JsArrayString shortNames ) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DayNames::names.dayNames = longNames;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.DayNames::names.dayNamesShort = shortNames;
	}-*/;
	

	@Override
	public JavaScriptObject toJavaScript() {
		return names;
	}
}
