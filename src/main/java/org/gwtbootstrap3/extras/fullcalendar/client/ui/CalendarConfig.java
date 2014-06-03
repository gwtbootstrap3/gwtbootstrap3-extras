package org.gwtbootstrap3.extras.fullcalendar.client.ui;

public class CalendarConfig {

	private ClickAndHoverConfig clickHoverConfig;//http://arshaw.com/fullcalendar/docs/mouse/
	private DragResizeConfig dragResizeConfig;//http://arshaw.com/fullcalendar/docs/event_ui/;
	private EventDataConfig eventConfig;//http://arshaw.com/fullcalendar/docs/event_data/
	private GeneralDisplay generalDisplay;//http://arshaw.com/fullcalendar/docs/display/
	private ButtonText buttonText;//http://arshaw.com/fullcalendar/docs/text/buttonText/
	private MonthNames monthNames;//http://arshaw.com/fullcalendar/docs/text/monthNames/
	private ColumnFormat columnFormat;//http://arshaw.com/fullcalendar/docs/text/columnFormat/
	private TimeFormat timeFormat;//http://arshaw.com/fullcalendar/docs/text/timeFormat/
	private TitleFormat titleFormat;//http://arshaw.com/fullcalendar/docs/text/titleFormat/
	private AgendaOptions agendaOptions;//http://arshaw.com/fullcalendar/docs/agenda/
	private DayNames dayNames;//http://arshaw.com/fullcalendar/docs/text/dayNames/
	private String weekNumberTitle;
	private boolean selectable;
	private boolean selectHelper;
	private EventRenderHandler renderHandler;//http://arshaw.com/fullcalendar/docs/event_rendering/eventRender/

	
	public CalendarConfig(){
		this(null);
	}
	
	public CalendarConfig( Header header ){
		if( header != null ){
			setGeneralDisplay(new GeneralDisplay(header));
		}
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

	public EventRenderHandler getRenderHandler() {
		return renderHandler;
	}

	public void setRenderHandler(EventRenderHandler renderHandler) {
		this.renderHandler = renderHandler;
	}

	public ColumnFormat getColumnFormat() {
		return columnFormat;
	}

	public void setColumnFormat(ColumnFormat columnFormat) {
		this.columnFormat = columnFormat;
	}

	public TimeFormat getTimeFormat() {
		return timeFormat;
	}

	public void setTimeFormat(TimeFormat timeFormat) {
		this.timeFormat = timeFormat;
	}

	public TitleFormat getTitleFormat() {
		return titleFormat;
	}

	public void setTitleFormat(TitleFormat titleFormat) {
		this.titleFormat = titleFormat;
	}

	public String getWeekNumberTitle() {
		return weekNumberTitle;
	}

	public void setWeekNumberTitle(String weekNumberTitle) {
		this.weekNumberTitle = weekNumberTitle;
	}

	public AgendaOptions getAgendaOptions() {
		return agendaOptions;
	}

	public void setAgendaOptions(AgendaOptions agendaOptions) {
		this.agendaOptions = agendaOptions;
	}

	public GeneralDisplay getGeneralDisplay() {
		return generalDisplay;
	}

	public void setGeneralDisplay(GeneralDisplay generalDisplay) {
		this.generalDisplay = generalDisplay;
	}

	public EventDataConfig getEventConfig() {
		return eventConfig;
	}

	public void setEventConfig(EventDataConfig eventConfig) {
		this.eventConfig = eventConfig;
	}

	public ClickAndHoverConfig getClickHoverConfig() {
		return clickHoverConfig;
	}

	public void setClickHoverConfig(ClickAndHoverConfig clickHoverConfig) {
		this.clickHoverConfig = clickHoverConfig;
	}

	public DragResizeConfig getDragResizeConfig() {
		return dragResizeConfig;
	}

	public void setDragResizeConfig(DragResizeConfig dragResizeConfig) {
		this.dragResizeConfig = dragResizeConfig;
	}
}
