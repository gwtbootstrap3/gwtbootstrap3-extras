package org.gwtbootstrap3.extras.fullcalendar.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2014 GwtBootstrap3
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Container class for all the javascript parameters to pass to <code>FullCalendar</code>
 * @author Jeff Isenhart
 *
 */
public class CalendarConfig {

	private Language langauge;//http://arshaw.com/fullcalendar/docs/text/lang/
	
	private ClickAndHoverConfig clickHoverConfig;//http://arshaw.com/fullcalendar/docs/mouse/
	private DragAndResizeConfig dragResizeConfig;//http://arshaw.com/fullcalendar/docs/event_ui/;
	private EventDataConfig eventConfig;//http://arshaw.com/fullcalendar/docs/event_data/
	private GeneralDisplay generalDisplay;//http://arshaw.com/fullcalendar/docs/display/
	private ButtonText buttonText;//http://arshaw.com/fullcalendar/docs/text/buttonText/
	private MonthNames monthNames;//http://arshaw.com/fullcalendar/docs/text/monthNames/
	private ColumnFormat columnFormat;//http://arshaw.com/fullcalendar/docs/text/columnFormat/
	private TimeFormat timeFormat;//http://arshaw.com/fullcalendar/docs/text/timeFormat/
	private TitleFormat titleFormat;//http://arshaw.com/fullcalendar/docs/text/titleFormat/
	private AgendaOptions agendaOptions;//http://arshaw.com/fullcalendar/docs/agenda/
	private DayNames dayNames;//http://arshaw.com/fullcalendar/docs/text/dayNames/
	private EventRenderConfig renderConfig;//http://arshaw.com/fullcalendar/docs/event_rendering/eventRender/
	
	private String weekNumberTitle;
	private String timezone;
	private boolean selectable;
	private boolean selectHelper;
	

	
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

	public void setButtonText(ButtonText bt ){
		this.buttonText = bt;
	}
	
	public ButtonText getButtonText(){
		return buttonText;
	}
	
	public void setMonthNames( MonthNames mn ){
		this.monthNames = mn;
	}
	
	public MonthNames getMonthNames(){
		return monthNames;
	}
	
	public void setDayNames( DayNames dn ){
		this.dayNames = dn;
	}
	
	public DayNames getDayNames(){
		return dayNames;
	}

	public EventRenderConfig getRenderConfig() {
		return renderConfig;
	}

	public void setRenderHandler(EventRenderConfig renderConfig) {
		this.renderConfig = renderConfig;
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

	public DragAndResizeConfig getDragResizeConfig() {
		return dragResizeConfig;
	}

	public void setDragResizeConfig(DragAndResizeConfig dragResizeConfig) {
		this.dragResizeConfig = dragResizeConfig;
	}

	public Language getLangauge() {
		return langauge;
	}

	public void setLangauge(Language langauge) {
		this.langauge = langauge;
	}

	public String getTimezone() {
		return timezone;
	}

	/**
	 * 'local', 'UTC', a timezone string ('America/Chicago')
	 * @param timezone
	 */
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	
	public JsArray<JavaScriptObject> getJavaScriptParameters(){
		JsArray<JavaScriptObject> params = (JsArray<JavaScriptObject>) JsArray.createArray();
		setParameter(params,getGeneralDisplay());
		setParameter(params,getButtonText());
		setParameter(params,getMonthNames());
		setParameter(params,getDayNames());
		setParameter(params,getDragResizeConfig());
		setParameter(params,getClickHoverConfig());
		setParameter(params,getEventConfig());
		setParameter(params,getColumnFormat());
		setParameter(params,getTimeFormat());
		setParameter(params,getTitleFormat());
		setParameter(params,getAgendaOptions());
		return params;
	}
	
	private void setParameter( JsArray<JavaScriptObject> params,IsJavaScriptObject isJS ){
		if( isJS != null ){
			params.push(isJS.toJavaScript());
		}
	}
}
