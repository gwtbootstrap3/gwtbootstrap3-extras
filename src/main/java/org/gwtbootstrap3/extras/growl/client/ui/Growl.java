package org.gwtbootstrap3.extras.growl.client.ui;


public class Growl {
	public static void growl(String message){
		show(message);
	}
	
	public static void growl(String title, String message){
		show(title,message);
	}
	
	public static void growl(String title, String message, String iconStyle){
		show(title,message,iconStyle);
	}
	
	public static void growl(String title, String message, String iconStyle, GrowlOptions options){
		if( options == null ){
			show(title,message,iconStyle);
		}else{
			show(title,message,iconStyle,options);
		}
		
	}
	
	private static native void show(String message) /*-{
		$wnd.jQuery.growl(message);
	}-*/;
	
	private static native void show(String title,String message) /*-{
		$wnd.jQuery.growl({title: title, message: message});
	}-*/;
	
	private static native void show(String title,String message, String iconStyle) /*-{
		$wnd.jQuery.growl({title: title, message: message, icon: iconStyle});
	}-*/;
	
	private static native void show(String title,
			String message, 
			String iconStyle,
			GrowlOptions options) /*-{
	    var parm1 = {title: title, message: message, icon: iconStyle};
		$wnd.jQuery.growl(parm1,options);
	}-*/;
}
