package org.gwtbootstrap3.extras.fullcalendar.client.ui;

public class CalendarConfig {

	private ButtonText buttonText;
	private MonthNames monthNames;
	private DayNames dayNames;
	private boolean selectable;
	private boolean selectHelper;
	private boolean editable;
	private EventClickHandler clickHandler;
	private EventRenderHandler renderHandler;
	private EventLoadingHandler loadingHandler;

	public void setEventLoadingHandler( EventLoadingHandler loadingHandler ){
		this.loadingHandler = loadingHandler;
	}
	
	public EventLoadingHandler getEventLoadingHandler(){
		return loadingHandler;
	}
	
	public boolean isSelectable() {
		return selectable;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	public boolean isSelectHelper() {
		return selectHelper;
	}

	public void setSelectHelper(boolean selectHelper) {
		this.selectHelper = selectHelper;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public ButtonText getButtonText(){
		if( buttonText == null ){
			buttonText = new ButtonText();
		}
		return buttonText;
	}
	
	public MonthNames getMonthNames(){
		if( monthNames == null ){
			monthNames = new MonthNames();
		}
		return monthNames;
	}
	
	public DayNames getDayNames(){
		if( dayNames == null ){
			dayNames = new DayNames();
		}
		return dayNames;
	}

	public EventClickHandler getClickHandler() {
		return clickHandler;
	}

	public void setClickHandler(EventClickHandler clickHandler) {
		this.clickHandler = clickHandler;
	}

	public EventRenderHandler getRenderHandler() {
		return renderHandler;
	}

	public void setRenderHandler(EventRenderHandler renderHandler) {
		this.renderHandler = renderHandler;
	}
}
