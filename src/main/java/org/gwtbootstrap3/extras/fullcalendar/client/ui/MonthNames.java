package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.i18n.client.LocaleInfo;

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
	
	
	
//	public void localize(){
//		localized(LocaleInfo.getCurrentLocale().getDateTimeFormatInfo().monthsFull(),
//				LocaleInfo.getCurrentLocale().getDateTimeFormatInfo().monthsShort());
//	}
//	
//	public void localized(String[] longNames,String[] shortNames){
//		assert longNames != null && longNames.length == 12;
//		assert shortNames != null && shortNames.length == 12;
//		JsArrayString longOnes = (JsArrayString) JsArrayString.createArray();
//		for (String name : longNames) {
//			longOnes.push(name);
//		}
//		
//		JsArrayString shortOnes = (JsArrayString) JsArrayString.createArray();
//		for (String name : shortNames) {
//			shortOnes.push(name);
//		}
//		localized(longOnes, shortOnes);
//	}
//	
//	private native void localized( JsArrayString longNames,JsArrayString shortNames ) /*-{
//		var theInstance = this;
//		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.MonthNames::longNames = longNames;
//		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.MonthNames::shortNames = shortNames;
//	}-*/;
	
	public JavaScriptObject getLongNames(){
		return longNames;
	}
	
	public JavaScriptObject getShortNames(){
		return shortNames;
	}
}
