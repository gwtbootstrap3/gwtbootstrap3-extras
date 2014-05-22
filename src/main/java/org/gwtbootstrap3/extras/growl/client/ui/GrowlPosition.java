package org.gwtbootstrap3.extras.growl.client.ui;

import com.google.gwt.core.client.JavaScriptObject;

public class GrowlPosition extends JavaScriptObject {

	protected GrowlPosition(){
	}

	public final native void setTop(boolean top) /*-{
		if( top ){
			this.from = "top";
		}else{
			this.from = "bottom";
		}
	}-*/;
	
	
	public final native void setLeft() /*-{
		this.align = "left";
	}-*/;
	
	public final native void setCenter() /*-{
		this.align = "center";
	}-*/;
	
	public final native void setRight() /*-{
		this.align = "right";
	}-*/;
	
}
