package org.gwtbootstrap3.extras.growl.client.ui;

import com.google.gwt.core.client.JavaScriptObject;

public class GrowlOptions extends JavaScriptObject {

	protected GrowlOptions() {
	}

	public final void setPositionObject(JavaScriptObject pos) {
		if (pos != null && pos instanceof GrowlPosition) {
			setPosition(pos);
		}
	}

	private final native void setPosition(JavaScriptObject pos) /*-{
		this.position = pos;
	}-*/;

	public final native void setAllowDismiss(boolean allowDismiss) /*-{
		this.allow_dismiss = allowDismiss;
	}-*/;

	public final native void setOffset(int off) /*-{
		this.offset = off;
	}-*/;

	public final native void setSpacing(int space) /*-{
		this.spacing = space;
	}-*/;

	public final native void setZIndex(int zIndex) /*-{
		this.z_index = zIndex;
	}-*/;

	public final native void setFadeIn(int mFade) /*-{
		this.fade_in = mFade;
	}-*/;

	public final native void setDelay(int mDelay) /*-{
		this.delay = mDelay;
	}-*/;

	public final native void pauseOnMouseOver(boolean pauseOnMouseOver) /*-{
		this.pause_on_mouseover = pauseOnMouseOver;
	}-*/;

	public final void setTemplateObject(JavaScriptObject temp) {
		if (temp != null && temp instanceof GrowlTemplate) {
			setTemplate(temp);
		}
	}

	private final native void setTemplate(JavaScriptObject temp) /*-{
		this.template = temp;
	}-*/;

	public final void setGrowlDefaultOptions(JavaScriptObject go) {
		if (go != null && go instanceof GrowlOptions) {
			setDefaultOptions(go);
		}
	}

	private final native void setDefaultOptions(JavaScriptObject go) /*-{
		console.log(go);
		$wnd.jQuery.growl.default_options = go;
	}-*/;

	public final native void setNullType() /*-{
		this.type = null;
	}-*/;

	public final native void setInfoType() /*-{
		this.type = 'info';
	}-*/;

	public final native void setSuccessType() /*-{
		this.type = 'success';
	}-*/;

	public final native void setDangerType() /*-{
		this.type = 'danger';
	}-*/;

	public final native void setWarningType() /*-{
		this.type = 'warning';
	}-*/;
}
