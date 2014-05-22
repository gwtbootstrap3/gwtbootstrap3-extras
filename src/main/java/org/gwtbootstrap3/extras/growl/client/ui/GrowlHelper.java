package org.gwtbootstrap3.extras.growl.client.ui;

public class GrowlHelper {


	public static GrowlOptions getNewOptions(){
		GrowlOptions go = getNewNativeOptions();
		go.setPositionObject(getNewPosition());
		return go;
	}
	
	private static native GrowlOptions getNewNativeOptions() /*-{
	    var go = {};
	    go.ele = 'body';
	    go.allow_dismiss = true;
	    go.offset = 20;
	    go.spacing = 10;
	    go.z_index = 1031;
	    go.fade_in = 400;
	    go.delay = 5000;
	    go.type = null;
	    go.pause_on_mouseover = false;
	    return go;
	 }-*/;
	
	
	public static native GrowlPosition getNewPosition() /*-{
	    return {from:"top",align:"right"};
	 }-*/;
	
	public static native GrowlTemplate getNewTemplate() /*-{
	    return {icon_type: 'class'};//set icon_type to class by default, otherwise set to 'image' when appropirate 
	 }-*/;
}
