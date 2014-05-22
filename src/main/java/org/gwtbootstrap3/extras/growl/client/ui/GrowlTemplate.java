package org.gwtbootstrap3.extras.growl.client.ui;

import com.google.gwt.core.client.JavaScriptObject;

public class GrowlTemplate extends JavaScriptObject {
	protected GrowlTemplate() {
	}

	public final native void setIconType(String iconType) /*-{
		this.icon_type = iconType;
	}-*/;

	public final native void setContainer(String containterHtml) /*-{
		this.container = containterHtml;
	}-*/;

	public final native void setDismiss(String dismissHtml) /*-{
		this.dismiss = dismissHtml;
	}-*/;

	public final native void setTitle(String titleTextOrHtml) /*-{
		this.title = titleTextOrHtml;
	}-*/;

	public final native void setTitleDivider(String titleDividerTextOrHtml) /*-{
		this.title_divider = titleDividerTextOrHtml;
	}-*/;

	public final native void setMessage(String messageTextOrHtml) /*-{
		this.message = messageTextOrHtml;
	}-*/;

}
