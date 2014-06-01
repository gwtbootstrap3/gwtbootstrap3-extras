package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.i18n.client.LocaleInfo;

/**
 * @see http://arshaw.com/fullcalendar/docs/text/monthNames/
 * @see http://arshaw.com/fullcalendar/docs/text/monthNamesShort/
 * @author Jeff Isenhart
 *
 */
public class MonthNames {
	private JavaScriptObject longNames;
	private JavaScriptObject shortNames;
	
	public MonthNames(){
		newInstance();
	}
	
	private native void newInstance( ) /*-{
		//default vals...
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.MonthNames::longNames = ['January', 'February', 'March', 'April', 'May', 'June', 'July','August', 'September', 'October', 'November', 'December'];
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.MonthNames::shortNames = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun','Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
	}-*/;
	
	
	
	public void localize(){
		localize(LocaleInfo.getCurrentLocale().getDateTimeFormatInfo().monthsFull(),
				LocaleInfo.getCurrentLocale().getDateTimeFormatInfo().monthsShort());
	}
	
	/**
	 * To pass in localized names directly
	 * @param longNames
	 * @param shortNames
	 */
	public void localize(String[] longNames,String[] shortNames){
		assert longNames != null && longNames.length == 12;
		assert shortNames != null && shortNames.length == 12;
		JsArrayString longOnes = (JsArrayString) JsArrayString.createArray();
		for (String name : longNames) {
			longOnes.push(name);
		}
		
		JsArrayString shortOnes = (JsArrayString) JsArrayString.createArray();
		for (String name : shortNames) {
			shortOnes.push(name);
		}
		localize(longOnes, shortOnes);
	}
	
	/**
	 * To pass in localized names directly
	 * @param longNames
	 * @param shortNames
	 */
	public native void localize( JsArrayString longNames,JsArrayString shortNames ) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.MonthNames::longNames = longNames;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.MonthNames::shortNames = shortNames;
	}-*/;
	
	public JavaScriptObject getLongNames(){
		return longNames;
	}
	
	public JavaScriptObject getShortNames(){
		return shortNames;
	}
}
