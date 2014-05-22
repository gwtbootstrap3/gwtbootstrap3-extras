package org.gwtbootstrap3.extras.growl.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.ScriptInjector;

public class GrowlEntryPoint implements EntryPoint {

    @Override
    public void onModuleLoad() {
    	if( !isGrowlPresent() ){
          ScriptInjector.fromString(GrowlClientBundle.INSTANCE.growlJS().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
		}

    }

	private native boolean isGrowlPresent() /*-{
		if( $wnd.jQuery && $wnd.jQuery.growl ){
			return true;
		}else{
			return false;
		}
	}-*/; 
    
}
