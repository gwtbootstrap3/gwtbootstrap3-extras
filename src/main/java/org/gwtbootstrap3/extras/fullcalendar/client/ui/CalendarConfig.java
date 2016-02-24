package org.gwtbootstrap3.extras.fullcalendar.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2015 GwtBootstrap3
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
 *
 * @author Jeff Isenhart
 */
public class CalendarConfig {

    private Language langauge;//http://arshaw.com/fullcalendar/docs/text/lang/

    private ClickAndHoverConfig clickHoverConfig;//http://arshaw.com/fullcalendar/docs/mouse/
    private SelectConfig selectConfig;//http://arshaw.com/fullcalendar/docs/selection/
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
    private String unselectCancel;
    private String selectContraint;
    private boolean selectable;
    private boolean selectHelper;
    private boolean unselectAuto = true;
    private boolean selectOverlap = true;

    public CalendarConfig() {
        this(null);
    }

    public CalendarConfig(final Header header) {
        if (header != null) {
            setGeneralDisplay(new GeneralDisplay(header));
        }
    }

    public boolean isSelectable() {
        return selectable;
    }

    public void setSelectable(final boolean selectable) {
        this.selectable = selectable;
    }

    public boolean isSelectHelper() {
        return selectHelper;
    }

    public void setSelectHelper(final boolean selectHelper) {
        this.selectHelper = selectHelper;
    }

    public void setButtonText(final ButtonText bt) {
        this.buttonText = bt;
    }

    public ButtonText getButtonText() {
        return buttonText;
    }

    public void setMonthNames(final MonthNames mn) {
        this.monthNames = mn;
    }

    public MonthNames getMonthNames() {
        return monthNames;
    }

    public void setDayNames(final DayNames dn) {
        this.dayNames = dn;
    }

    public DayNames getDayNames() {
        return dayNames;
    }

    public EventRenderConfig getRenderConfig() {
        return renderConfig;
    }

    public void setRenderHandler(final EventRenderConfig renderConfig) {
        this.renderConfig = renderConfig;
    }

    public ColumnFormat getColumnFormat() {
        return columnFormat;
    }

    public void setColumnFormat(final ColumnFormat columnFormat) {
        this.columnFormat = columnFormat;
    }

    public TimeFormat getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(final TimeFormat timeFormat) {
        this.timeFormat = timeFormat;
    }

    public TitleFormat getTitleFormat() {
        return titleFormat;
    }

    public void setTitleFormat(final TitleFormat titleFormat) {
        this.titleFormat = titleFormat;
    }

    public String getWeekNumberTitle() {
        return weekNumberTitle;
    }

    public void setWeekNumberTitle(final String weekNumberTitle) {
        this.weekNumberTitle = weekNumberTitle;
    }

    public AgendaOptions getAgendaOptions() {
        return agendaOptions;
    }

    public void setAgendaOptions(final AgendaOptions agendaOptions) {
        this.agendaOptions = agendaOptions;
    }

    public GeneralDisplay getGeneralDisplay() {
        return generalDisplay;
    }

    public void setGeneralDisplay(final GeneralDisplay generalDisplay) {
        this.generalDisplay = generalDisplay;
    }

    public EventDataConfig getEventConfig() {
        return eventConfig;
    }

    public void setEventConfig(final EventDataConfig eventConfig) {
        this.eventConfig = eventConfig;
    }

    public ClickAndHoverConfig getClickHoverConfig() {
        return clickHoverConfig;
    }

    public void setClickHoverConfig(final ClickAndHoverConfig clickHoverConfig) {
        this.clickHoverConfig = clickHoverConfig;
    }
    
    public SelectConfig getSelectConfig() {
        return selectConfig;
    }

    public void setSelectConfig(final SelectConfig selectConfig) {
        this.selectConfig = selectConfig;
    }

    public DragAndResizeConfig getDragResizeConfig() {
        return dragResizeConfig;
    }

    public void setDragResizeConfig(final DragAndResizeConfig dragResizeConfig) {
        this.dragResizeConfig = dragResizeConfig;
    }

    public Language getLangauge() {
        return langauge;
    }

    public void setLangauge(final Language langauge) {
        this.langauge = langauge;
    }

    public String getTimezone() {
        return timezone;
    }

    /**
     * 'local', 'UTC', a timezone string ('America/Chicago')
     *
     * @param timezone
     */
    public void setTimezone(final String timezone) {
        this.timezone = timezone;
    }
    public boolean isUnselectAuto() {
        return unselectAuto;
    }

    public void setUnselectAuto(final boolean unselectAuto) {
        this.unselectAuto = unselectAuto;
    }

    public String getUnselectCancel() {
        return unselectCancel;
    }

    public void setUnselectCancel(final String unselectCancel) {
        this.unselectCancel = unselectCancel;
    }

    public boolean isSelectOverlap() {
        return selectOverlap;
    }

    public void setSelectOverlap(final boolean selectOverlap) {
        this.selectOverlap = selectOverlap;
    }

    public String getSelectContraint() {
        return selectContraint;
    }

    public void setSelectContraint(final String selectContraint) {
        this.selectContraint = selectContraint;
    }
    
    public JsArray<JavaScriptObject> getJavaScriptParameters() {
        @SuppressWarnings("unchecked")
        final JsArray<JavaScriptObject> params = (JsArray<JavaScriptObject>) JsArray.createArray();
        setParameter(params, getGeneralDisplay());
        setParameter(params, getButtonText());
        setParameter(params, getMonthNames());
        setParameter(params, getDayNames());
        setParameter(params, getDragResizeConfig());
        setParameter(params, getClickHoverConfig());
        setParameter(params, getSelectConfig());
        setParameter(params, getEventConfig());
        setParameter(params, getColumnFormat());
        setParameter(params, getTimeFormat());
        setParameter(params, getTitleFormat());
        setParameter(params, getAgendaOptions());
        setParameter(params, getRenderConfig());
        return params;
    }

    private void setParameter(final JsArray<JavaScriptObject> params, final IsJavaScriptObject isJS) {
        if (isJS != null) {
            params.push(isJS.toJavaScript());
        }
    }
}
