package org.gwtbootstrap3.extras.fullcalendar.client.ui;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;

/**
 * @see http://arshaw.com/fullcalendar/docs/display/
 * @author Jeff Isenhart
 *
 */
public class GeneralDisplay implements IsJavaScriptObject{
	private JavaScriptObject general;
	
	public GeneralDisplay(){
		this(new Header());
	}
	
	public GeneralDisplay(Header header){
		newInstance();
		if( header != null ){
			setHeader(header.toJavaScript());
		}
	}

	private native void newInstance() /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.GeneralDisplay::general = {
			firstDay:0,
			isRTL:false,
			weekends:true,
			hiddenDays:[],
			weekMode:'fixed',
			weekNumbers:false,
			weekNumberCalculation:'local',
			aspectRatio:1.35,
			handleWindowResize:true	
		};
	}-*/; 

	public native void setViewRenderCallback(ViewRenderCallback callback) /*-{
		if( callback ){
			var theInstance = this;
			theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.GeneralDisplay::general.viewRender = function(view,element){
				callback.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ViewRenderCallback::viewRender(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/Element;)(view,element[0]); 
			};
			
			theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.GeneralDisplay::general.viewDestroy = function(view,element){
				callback.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ViewRenderCallback::viewDestroy(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/Element;)(view,element[0]); 
			};
			
			theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.GeneralDisplay::general.dayRender = function(date,cell){
				callback.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ViewRenderCallback::dayRender(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/dom/client/Element;)(date,cell); 
			};
			
			theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.GeneralDisplay::general.windowResize = function(view){
				callback.@org.gwtbootstrap3.extras.fullcalendar.client.ui.ViewRenderCallback::windowResize(Lcom/google/gwt/core/client/JavaScriptObject;)(view); 
			};
		}
	}-*/; 
	
	public native void setFirstDayOption(int firstDay) /*-{
		if( firstDay >=0 && firstDay <= 6 ){
			var theInstance = this;
			return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.GeneralDisplay::general.firstDay = firstDay;
		}
	}-*/; 
	
	public native void setIsRTL(boolean rtl) /*-{
		var theInstance = this;
		return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.GeneralDisplay::general.isRTL = rtl;
	}-*/; 
	
	public void setHeader( Header header ){
		setHeader(header == null ? null : header.toJavaScript());
	}
	
	private native void setHeader(JavaScriptObject header) /*-{
		var theInstance = this;
		return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.GeneralDisplay::general.header = header;
	}-*/; 
	
	public native void setWeekends(boolean weekends) /*-{
		var theInstance = this;
		return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.GeneralDisplay::general.weekends = weekends;
	}-*/; 
	
	public void setHiddenDays( int... days ){
		if( days != null ){
			JsArrayInteger intArr = (JsArrayInteger)JsArrayInteger.createArray(); 
			for (int i : days) {
				assert i <=0 && i >= 6;
				intArr.push(i);
			}
			setHiddenDays(intArr);
		}
	}
	public native void setHiddenDays(JsArrayInteger hiddenDays) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.GeneralDisplay::general.hiddenDays = hiddenDays;
	}-*/; 
	
	public native void setWeekMode(String mode) /*-{
		if( mode ){
			if( mode == 'fixed' || mode == 'liquid' || mode == 'variable' ){
				var theInstance = this;
				theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.GeneralDisplay::general.weekMode = mode;
			}
		}
		
	}-*/;
	
	public native void setWeekNumbers(boolean weekNumbers) /*-{
		var theInstance = this;
		return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.GeneralDisplay::general.weekNumbers = weekNumbers;
		
	}-*/;
	
	public native void setWeekNumberCaculation(String calculation) /*-{
		if( calculation ){
			if( calculation == 'local' || calculation == 'ISO' ){
				var theInstance = this;
				theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.GeneralDisplay::general.weekNumberCalculation = calculation;
			}
		}
		
	}-*/;
	
	public native void setWeekNumberCaculation(JavaScriptObject weekNumberFunction) /*-{
		if( weekNumberFunction ){
			var theInstance = this;
			theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.GeneralDisplay::general.weekNumberCalculation = weekNumberFunction;
		}
		
	}-*/;
	
	public native void setHeight(int height) /*-{
			var theInstance = this;
			theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.GeneralDisplay::general.height = height;
	}-*/;
	
	public native void setContentHeight(int contentHeight) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.GeneralDisplay::general.contentHeight = contentHeight;
	}-*/;
	
	public native void setAspectRatio(double aspectRatio) /*-{
		var theInstance = this;
		theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.GeneralDisplay::general.aspectRatio = aspectRatio;
	}-*/;
	
	public native void setHandleWindowResize(boolean handleWindowResize) /*-{
		var theInstance = this;
		return theInstance.@org.gwtbootstrap3.extras.fullcalendar.client.ui.GeneralDisplay::general.handleWindowResize = handleWindowResize;
	}-*/;
	
	public JavaScriptObject toJavaScript(){
		return general;
	}
}
