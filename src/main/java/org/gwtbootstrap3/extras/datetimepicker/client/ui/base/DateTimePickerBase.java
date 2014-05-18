package org.gwtbootstrap3.extras.datetimepicker.client.ui.base;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 GwtBootstrap3
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

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.*;
import org.gwtbootstrap3.client.shared.event.HideEvent;
import org.gwtbootstrap3.client.shared.event.HideHandler;
import org.gwtbootstrap3.client.shared.event.ShowEvent;
import org.gwtbootstrap3.client.shared.event.ShowHandler;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.base.HasId;
import org.gwtbootstrap3.client.ui.base.HasPlaceholder;
import org.gwtbootstrap3.client.ui.base.HasResponsiveness;
import org.gwtbootstrap3.client.ui.base.ValueBoxBase;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.DeviceSize;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.*;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.events.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Joshua Godi
 */
public class DateTimePickerBase extends Widget implements HasEnabled, HasId, HasResponsiveness,
        HasVisibility, HasPlaceholder, HasAutoClose, HasDaysOfWeekDisabled, HasEndDate, HasForceParse,
        HasFormat, HasHighlightToday, HasKeyboardNavigation, HasMaxView, HasMinuteStep, HasMinView,
        HasShowMeridian, HasShowTodayButton, HasStartDate, HasStartView, HasViewSelect, HasWeekStart,
        HasDateTimePickerHandlers, HasLanguage, HasName, HasValue<Date> {


    private final TextBox textBox;
    private DateTimeFormat dateTimeFormat;
    private final DateTimeFormat startEndDateFormat = DateTimeFormat.getFormat("yyyy-MM-dd");

    /**
     * DEFAULT values
     */
    private String format = "mm/dd/yyyy HH:ii";
    private DateTimePickerDayOfWeek weekStart = DateTimePickerDayOfWeek.SUNDAY;
    private DateTimePickerDayOfWeek[] daysOfWeekDisabled = {};
    private boolean autoClose = false;
    private DateTimePickerView startView = DateTimePickerView.MONTH;
    private DateTimePickerView minView = DateTimePickerView.HOUR;
    private DateTimePickerView maxView = DateTimePickerView.DECADE;
    private boolean showTodayButton = false;
    private boolean highlightToday = false;
    private boolean keyboardNavigation = true;
    private boolean forceParse = true;
    private int minuteStep = 5;
    private DateTimePickerView viewSelect = DateTimePickerView.HOUR;
    private boolean showMeridian = false;
    private Widget container = null;
    private DateTimePickerLanguage language = DateTimePickerLanguage.EN;

    public DateTimePickerBase() {
        textBox = new TextBox();
        setElement((Element) textBox.getElement());
        setFormat(format);
        setValue(new Date());
    }

    public void setContainer(final Widget container) {
        this.container = container;
    }

    public Widget getContainer() {
        return container;
    }

    public TextBox getTextBox() {
        return textBox;
    }

    public void setAlignment(final ValueBoxBase.TextAlignment align) {
        textBox.setAlignment(align);
    }

    @Override
    public void setPlaceholder(final String placeHolder) {
        textBox.setPlaceholder(placeHolder);
    }

    @Override
    public String getPlaceholder() {
        return textBox.getPlaceholder();
    }

    public void setReadOnly(final boolean readOnly) {
        textBox.setReadOnly(readOnly);
    }

    public boolean isReadOnly() {
        return textBox.isReadOnly();
    }

    @Override
    public boolean isEnabled() {
        return textBox.isEnabled();
    }

    @Override
    public void setEnabled(final boolean enabled) {
        textBox.setEnabled(enabled);
    }

    @Override
    public void setId(final String id) {
        textBox.setId(id);
    }

    @Override
    public String getId() {
        return textBox.getId();
    }

    @Override
    public void setName(final String name) {
        textBox.setName(name);
    }

    @Override
    public String getName() {
        return textBox.getName();
    }

    @Override
    public void setVisibleOn(final DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    @Override
    public void setHiddenOn(final DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
    }

    @Override
    public void setLanguage(final DateTimePickerLanguage language) {
        this.language = language;

        // Inject the JS for the language
        if (language.getJs() != null) {
            ScriptInjector.fromString(language.getJs().getText())
                    .setWindow(ScriptInjector.TOP_WINDOW).inject();
        }
    }

    @Override
    public DateTimePickerLanguage getLanguage() {
        return language;
    }

    /**
     * Call this whenever changing any settings: minView, startView, format, etc. If you are changing
     * format and date value, the updates must take in such order:
     * <p/>
     * 1. DateTimePicker.reload()
     * 2. DateTimePicker.setValue(newDate); // Date newDate.
     * <p/>
     * Otherwise date value is not updated.
     */
    public void reload() {
        configure();
    }

    public void show() {
        show(getElement());
    }

    public void hide() {
        hide(getElement());
    }

    @Override
    public void setAutoClose(final boolean autoClose) {
        this.autoClose = autoClose;
    }

    @Override
    public void onShow(final Event e) {
        // On show we put focus on the textbox
        textBox.setFocus(true);

        fireEvent(new ShowEvent(e));
    }

    @Override
    public HandlerRegistration addShowHandler(final ShowHandler showHandler) {
        return addHandler(showHandler, ShowEvent.getType());
    }

    @Override
    public void onHide(final Event e) {
        // On hide we remove focus from the textbox
        textBox.setFocus(false);

        fireEvent(new HideEvent(e));
    }

    @Override
    public HandlerRegistration addHideHandler(final HideHandler hideHandler) {
        return addHandler(hideHandler, HideEvent.getType());
    }

    @Override
    public void onChangeDate(final Event e) {
        fireEvent(new ChangeDateEvent(e));
    }

    @Override
    public HandlerRegistration addChangeDateHandler(final ChangeDateHandler changeDateHandler) {
        return addHandler(changeDateHandler, ChangeDateEvent.getType());
    }

    @Override
    public void onChangeYear(final Event e) {
        fireEvent(new ChangeYearEvent(e));
    }

    @Override
    public HandlerRegistration addChangeYearHandler(final ChangeYearHandler changeYearHandler) {
        return addHandler(changeYearHandler, ChangeYearEvent.getType());
    }

    @Override
    public void onChangeMonth(final Event e) {
        fireEvent(new ChangeMonthEvent(e));
    }

    @Override
    public HandlerRegistration addChangeMonthHandler(final ChangeMonthHandler changeMonthHandler) {
        return addHandler(changeMonthHandler, ChangeMonthEvent.getType());
    }

    @Override
    public void onOutOfRange(final Event e) {
        fireEvent(new OutOfRangeEvent(e));
    }

    @Override
    public HandlerRegistration addOutOfRangeHandler(final OutOfRangeHandler outOfRangeHandler) {
        return addHandler(outOfRangeHandler, OutOfRangeEvent.getType());
    }

    @Override
    public void setDaysOfWeekDisabled(final DateTimePickerDayOfWeek... daysOfWeekDisabled) {
        setDaysOfWeekDisabled(getElement(), toDaysOfWeekDisabledString(daysOfWeekDisabled));
    }

    @Override
    public void setEndDate(final Date endDate) {
        // Has to be in the format YYYY-MM-DD
        setEndDate(startEndDateFormat.format(endDate));
    }

    @Override
    public void setEndDate(final String endDate) {
        // Has to be in the format YYYY-MM-DD
        setEndDate(getElement(), endDate);
    }

    @Override
    public void setForceParse(final boolean forceParse) {
        this.forceParse = forceParse;
    }

    @Override
    public void setHighlightToday(final boolean highlightToday) {
        this.highlightToday = highlightToday;
    }

    @Override
    public void setHasKeyboardNavigation(final boolean hasKeyboardNavigation) {
        this.keyboardNavigation = hasKeyboardNavigation;
    }

    @Override
    public void setMaxView(final DateTimePickerView dateTimePickerView) {
        this.maxView = dateTimePickerView;
    }

    @Override
    public void setMinView(final DateTimePickerView dateTimePickerView) {
        this.minView = dateTimePickerView;

        // We keep the view select the same as the min view
        if (viewSelect != minView) {
            setViewSelect(dateTimePickerView);
        }
    }

    @Override
    public void setMinuteStep(final int minuteStep) {
        this.minuteStep = minuteStep;
    }

    @Override
    public void setShowMeridian(final boolean showMeridian) {
        this.showMeridian = showMeridian;
    }

    @Override
    public void setShowTodayButton(final boolean showTodayButton) {
        this.showTodayButton = showTodayButton;
    }

    @Override
    public void setStartDate(final Date startDate) {
        // Has to be in the format YYYY-MM-DD
        setStartDate(startEndDateFormat.format(startDate));
    }

    @Override
    public void setStartDate(final String startDate) {
        // Has to be in the format YYYY-MM-DD
        setStartDate(getElement(), startDate);
    }

    @Override
    public void setStartView(final DateTimePickerView dateTimePickerView) {
        this.startView = dateTimePickerView;
    }

    @Override
    public void setViewSelect(final DateTimePickerView dateTimePickerView) {
        this.viewSelect = dateTimePickerView;

        // We keep the min view the same as the view select
        if (viewSelect != minView) {
            setMinView(dateTimePickerView);
        }
    }

    @Override
    public void setWeekStart(final DateTimePickerDayOfWeek weekStart) {
        this.weekStart = weekStart;
    }

    @Override
    public void setFormat(final String format) {
        this.format = format;

        // Get the old value
        final Date oldValue = getValue();

        // Make the new DateTimeFormat
        setDateTimeFormat(format);

        if (oldValue != null) {
            setValue(oldValue);
        }
    }

    private void setDateTimeFormat(final String format) {
        // Check http://www.gwtproject.org/javadoc/latest/com/google/gwt/i18n/client/DateTimeFormat.html
        // for more information on syntax
        final Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('h', 'H'); // 12/24 hours
            put('H', 'h'); // 12/24 hours
            put('m', 'M'); // months
            put('i', 'm'); // minutes
            put('p', 'a'); // meridian
            put('P', 'a'); // meridian
        }};

        final StringBuilder fb = new StringBuilder(format);
        for (int i = 0; i < fb.length(); i++) {
            if (map.containsKey(fb.charAt(i))) {
                fb.setCharAt(i, map.get(fb.charAt(i)));
            }
        }

        this.dateTimeFormat = DateTimeFormat.getFormat(fb.toString());
    }

    public Date getValue() {
        try {
            return dateTimeFormat != null && textBox.getValue() != null ? dateTimeFormat.parse(textBox.getValue()) : null;
        } catch (final Exception e) {
            return null;
        }
    }

    public String getBaseValue() {
        return textBox.getValue();
    }

    @Override
    public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<Date> dateValueChangeHandler) {
        return addHandler(dateValueChangeHandler, ValueChangeEvent.getType());
    }

    @Override
    public void setValue(final Date value) {
        setValue(value, false);
    }

    @Override
    public void setValue(final Date value, final boolean fireEvents) {
        // We schedule a fixed delay to that we can make sure the element is properly loaded
        // so that we can set the value on it
        Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand() {
            @Override
            public boolean execute() {
                if (DateTimePickerBase.this.isAttached()) {
                    textBox.setValue(value != null ? dateTimeFormat.format(value) : null);
                    update(textBox.getElement());

                    if (fireEvents) {
//                        ValueChangeEvent.fire(DateTimePickerBase.this, value);
                    }
                    return false;
                } else {
                    return true;
                }
            }
        }, 200);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onLoad() {
        super.onLoad();
        configure();
    }

    @Override
    protected void onUnload() {
        super.onUnload();
        remove(getElement());
    }

    protected void configure() {
        // If the user hasn't specified the container, default to the widget's parent
        // This makes sure the modal scroll with the content correctly
        if (container == null) {
            configure(this, this.getParent());
        } else {
            configure(this, container);
        }
    }

    protected void configure(final Widget w, final Widget container) {
        w.getElement().setAttribute("data-date-format", format);

        // If configuring not for the first time, datetimepicker must be removed first.
        this.remove(w.getElement());

        configure(w.getElement(), container.getElement(), format, weekStart.getValue(), toDaysOfWeekDisabledString(daysOfWeekDisabled), autoClose,
                startView.getValue(), minView.getValue(), maxView.getValue(), showTodayButton, highlightToday,
                keyboardNavigation, forceParse, minuteStep, viewSelect.getValue(), showMeridian, language.getCode());
    }

    protected void execute(final String cmd) {
        execute(getElement(), cmd);
    }

    private native void execute(Element e, String cmd) /*-{
        $wnd.jQuery(e).datetimepicker(cmd);
    }-*/;

    private native void remove(Element e) /*-{
        $wnd.jQuery(e).datetimepicker('remove');
        $wnd.jQuery(e).off('show');
        $wnd.jQuery(e).off('hide');
        $wnd.jQuery(e).off('changeDate');
        $wnd.jQuery(e).off('changeYear');
        $wnd.jQuery(e).off('changeMonth');
        $wnd.jQuery(e).off('outOfRange');
    }-*/;

    private native void show(Element e) /*-{
        $wnd.jQuery(e).datetimepicker('show');
    }-*/;

    private native void hide(Element e) /*-{
        $wnd.jQuery(e).datetimepicker('hide');
    }-*/;

    private native void update(Element e) /*-{
        $wnd.jQuery(e).datetimepicker('update');
    }-*/;

    private native void setStartDate(Element e, String startDate) /*-{
        $wnd.jQuery(e).datetimepicker('setStartDate', startDate);
    }-*/;

    private native void setEndDate(Element e, String endDate) /*-{
        $wnd.jQuery(e).datetimepicker('setEndDate', endDate);
    }-*/;

    private native void setDaysOfWeekDisabled(Element e, String daysOfWeekDisabled) /*-{
        $wnd.jQuery(e).datetimepicker('setDaysOfWeekDisabled', daysOfWeekDisabled);
    }-*/;

    protected native void configure(Element e, Element p, String format, int weekStart, String daysOfWeekDisabled,
                                    boolean autoClose, int startView, int minView,
                                    int maxView, boolean todayBtn, boolean highlightToday, boolean keyboardNavigation,
                                    boolean forceParse, int minuteStep, int viewSelect, boolean showMeridian, String language) /*-{
        var that = this;
        $wnd.jQuery(e).datetimepicker({
            format: format,
            language: language,
            weekStart: weekStart,
            daysOfWeekDisabled: daysOfWeekDisabled,
            autoclose: autoClose,
            startView: startView,
            minView: minView,
            maxView: maxView,
            todayBtn: todayBtn,
            todayHighlight: highlightToday,
            keyboardNavigation: keyboardNavigation,
            forceParse: forceParse,
            minuteStep: minuteStep,
            showMeridian: showMeridian,
            container: p
        })
            .on('show', function (e) {
                that.@org.gwtbootstrap3.extras.datetimepicker.client.ui.base.DateTimePickerBase::onShow(Lcom/google/gwt/user/client/Event;)(e);
            })
            .on("hide", function (e) {
                that.@org.gwtbootstrap3.extras.datetimepicker.client.ui.base.DateTimePickerBase::onHide(Lcom/google/gwt/user/client/Event;)(e);
            })
            .on("changeDate", function (e) {
                that.@org.gwtbootstrap3.extras.datetimepicker.client.ui.base.DateTimePickerBase::onChangeDate(Lcom/google/gwt/user/client/Event;)(e);
            })
            .on("changeYear", function (e) {
                that.@org.gwtbootstrap3.extras.datetimepicker.client.ui.base.DateTimePickerBase::onChangeYear(Lcom/google/gwt/user/client/Event;)(e);
            })
            .on("changeMonth", function (e) {
                that.@org.gwtbootstrap3.extras.datetimepicker.client.ui.base.DateTimePickerBase::onChangeMonth(Lcom/google/gwt/user/client/Event;)(e);
            })
            .on("outOfRange", function (e) {
                that.@org.gwtbootstrap3.extras.datetimepicker.client.ui.base.DateTimePickerBase::onOutOfRange(Lcom/google/gwt/user/client/Event;)(e);
            });
    }-*/;

    protected String toDaysOfWeekDisabledString(final DateTimePickerDayOfWeek... dateTimePickerDayOfWeeks) {
        this.daysOfWeekDisabled = dateTimePickerDayOfWeeks;

        final StringBuilder builder = new StringBuilder();

        if (dateTimePickerDayOfWeeks != null) {
            int i = 0;
            for (final DateTimePickerDayOfWeek dayOfWeek : dateTimePickerDayOfWeeks) {
                builder.append(dayOfWeek.getValue());

                i++;
                if (i < dateTimePickerDayOfWeeks.length) {
                    builder.append(",");
                }
            }
        }
        return builder.toString();
    }
}
