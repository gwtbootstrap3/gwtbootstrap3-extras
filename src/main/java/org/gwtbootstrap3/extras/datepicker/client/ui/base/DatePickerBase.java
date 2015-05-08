package org.gwtbootstrap3.extras.datepicker.client.ui.base;

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

import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
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
import org.gwtbootstrap3.extras.datepicker.client.ui.base.constants.*;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.events.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Joshua Godi
 */
public class DatePickerBase extends Widget
        implements HasEnabled, HasId, HasResponsiveness, HasVisibility, HasPlaceholder, HasAutoClose, HasDaysOfWeekDisabled, HasEndDate, HasForceParse,
        HasFormat, HasHighlightToday, HasKeyboardNavigation, HasMinView, HasShowTodayButton, HasStartDate, HasStartView, HasViewSelect, HasWeekStart,
        HasDateTimePickerHandlers, HasLanguage, HasName, HasValue<Date>, HasPosition, IsEditor<LeafValueEditor<Date>> {

    // Check http://www.gwtproject.org/javadoc/latest/com/google/gwt/i18n/client/DateTimeFormat.html
    // for more information on syntax
    private static final Map<Character, Character> DATE_TIME_FORMAT_MAP = new HashMap<Character, Character>();

    static {
        DATE_TIME_FORMAT_MAP.put('m', 'M'); // months
    }

    private final TextBox textBox;
    private DateTimeFormat dateTimeFormat;
    private final DateTimeFormat startEndDateFormat = DateTimeFormat.getFormat("MM-dd-yyyy");
    private LeafValueEditor<Date> editor;

    /**
     * DEFAULT values
     */
    private String format = "mm/dd/yyyy";
    private DatePickerDayOfWeek weekStart = DatePickerDayOfWeek.SUNDAY;
    private DatePickerDayOfWeek[] daysOfWeekDisabled = {};
    private boolean autoClose = false;
    private DatePickerMinView startView = DatePickerMinView.DAY;
    private DatePickerMinView minView = DatePickerMinView.DAY;

    private boolean showTodayButton = false;
    private boolean highlightToday = false;
    private boolean keyboardNavigation = true;
    private boolean forceParse = true;

    private DatePickerMinView viewSelect = DatePickerMinView.DAY;

    private Widget container = null;
    private DatePickerLanguage language = DatePickerLanguage.EN;
    private DatePickerPosition position = DatePickerPosition.TOP_LEFT;

    public DatePickerBase() {
        textBox = new TextBox();
        setElement((Element) textBox.getElement());
        setFormat(format);
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
    public void setLanguage(final DatePickerLanguage language) {
        this.language = language;

        // Inject the JS for the language
        if (language.getJs() != null) {
            ScriptInjector.fromString(language.getJs().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        }
    }

    @Override
    public DatePickerLanguage getLanguage() {
        return language;
    }

    @Override
    public void setPosition(final DatePickerPosition position) {
        this.position = position;
    }

    @Override
    public DatePickerPosition getPosition() {
        return position;
    }

    /**
     * Call this whenever changing any settings: minView, startView, format, etc. If you are changing
     * format and date value, the updates must take in such order:
     * <p/>
     * locales.cache.1.4.0. DateTimePicker.reload()
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
    public void onClearDate(final Event e) {
        fireEvent(new ClearDateEvent(e));
    }

    @Override
    public HandlerRegistration addClearDateHandler(final ClearDateHandler clearDateHandler) {
        return addHandler(clearDateHandler, ClearDateEvent.getType());
    }

    @Override
    public void setDaysOfWeekDisabled(final DatePickerDayOfWeek... daysOfWeekDisabled) {
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
    public void clearEndDate() {
        setStartDate(getElement(), null);
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
    public void setMinView(final DatePickerMinView datePickerMinView) {
        this.minView = datePickerMinView;

        // We keep the view select the same as the min view
        if (viewSelect != minView) {
            setViewSelect(datePickerMinView);
        }
    }

    @Override
    public void setShowTodayButton(final boolean showTodayButton) {
        this.showTodayButton = showTodayButton;
    }

    @Override
    public void setStartDate(final Date startDate) {
        // Has to be in the format DD-MM-YYYY
        setStartDate(startEndDateFormat.format(startDate));
    }

    @Override
    public void setStartDate(final String startDate) {
        // Has to be in the format DD-MM-YYYY
        setStartDate(getElement(), startDate);
    }

    @Override
    public void clearStartDate() {
        setStartDate(getElement(), null);
    }

    @Override
    public void setStartView(final DatePickerMinView datePickerMinView) {
        this.startView = datePickerMinView;
    }

    @Override
    public void setViewSelect(final DatePickerMinView datePickerMinView) {
        this.viewSelect = datePickerMinView;

        // We keep the min view the same as the view select
        if (viewSelect != minView) {
            setMinView(datePickerMinView);
        }
    }

    @Override
    public void setWeekStart(final DatePickerDayOfWeek weekStart) {
        this.weekStart = weekStart;
    }

    /**
     * Convert GWT date format to bootstrap date format
     * 
     * @param format date format using GWT notation
     * @return date format using bootstrap notation
     */
    private static String toBootstrapDateFormat(final String format) {
        String bootstrap_format = format;
        
        // Replace long day name "EEEE" with "DD"
        bootstrap_format = bootstrap_format.replace("EEEE", "DD");
        // Replace short day name "EE" with "DD"
        bootstrap_format = bootstrap_format.replaceAll("E{1,3}", "D");
        // If there are at least 3 Ms there is month name in wording
        if (bootstrap_format.contains("MMM")) {
            // Replace long date month "MMMM" with "MM"
            bootstrap_format = bootstrap_format.replace("MMMM", "MM");
            // Replace month name "MMM" with "M"
            bootstrap_format = bootstrap_format.replace("MMM", "M");
        }
        else {
            // Replace month number with leading 0 "MM" with "mm"
            bootstrap_format = bootstrap_format.replace("MM", "mm");
            // Replace month number "M" with "m"
            bootstrap_format = bootstrap_format.replace("M", "m");
        }
        if (!bootstrap_format.contains("yy")) {
            // Replace full year format "y" with "yyyy"
            bootstrap_format = bootstrap_format.replace("y", "yyyy");
        }
        
        return bootstrap_format;
    }

    /**
     * Sets format of the date using GWT notation
     * 
     * @param format date format in GWT notation
     */
    public void setGWTFormat(final String format) {
        this.format = toBootstrapDateFormat(format);

        // Get the old value
        final Date oldValue = getValue();

        // Make the new DateTimeFormat
        this.dateTimeFormat = DateTimeFormat.getFormat(format);

        if (oldValue != null) {
            setValue(oldValue);
        }
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
        final StringBuilder fb = new StringBuilder(format);
        for (int i = 0; i < fb.length(); i++) {
            if (DATE_TIME_FORMAT_MAP.containsKey(fb.charAt(i))) {
                fb.setCharAt(i, DATE_TIME_FORMAT_MAP.get(fb.charAt(i)));
            }
        }

        this.dateTimeFormat = DateTimeFormat.getFormat(fb.toString());
    }

    @Override
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
        textBox.setValue(value != null ? dateTimeFormat.format(value) : null);
        update(textBox.getElement());

        if (fireEvents) {
            ValueChangeEvent.fire(DatePickerBase.this, value);
        }
    }

    @Override
    public LeafValueEditor<Date> asEditor() {
        if (editor == null) {
            editor = TakesValueEditor.of(this);
        }
        return editor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onLoad() {
        super.onLoad();
        configure();

        // With the new update the parent must have position: relative for positioning to work
        if (getElement().getParentElement() != null) {
            getElement().getParentElement().getStyle().setPosition(Style.Position.RELATIVE);
        }
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

        // If configuring not for the first time, datepicker must be removed first.
        this.remove(w.getElement());

        configure(w.getElement(), container.getElement(), format, weekStart.getValue(), toDaysOfWeekDisabledString(daysOfWeekDisabled), autoClose,
                startView.getValue(), minView.getValue(), showTodayButton, highlightToday, keyboardNavigation, forceParse, viewSelect.getValue(),
                language.getCode(), position.getPosition());
    }

    protected void execute(final String cmd) {
        execute(getElement(), cmd);
    }

    private native void execute(Element e, String cmd) /*-{
        $wnd.jQuery(e).datepicker(cmd);
    }-*/;

    private native void remove(Element e) /*-{
        $wnd.jQuery(e).datepicker('remove');
        $wnd.jQuery(e).off('show');
        $wnd.jQuery(e).off('hide');
        $wnd.jQuery(e).off('changeDate');
        $wnd.jQuery(e).off('changeYear');
        $wnd.jQuery(e).off('changeMonth');
        $wnd.jQuery(e).off('clearDate');
    }-*/;

    private native void show(Element e) /*-{
        $wnd.jQuery(e).datepicker('show');
    }-*/;

    private native void hide(Element e) /*-{
        $wnd.jQuery(e).datepicker('hide');
    }-*/;

    private native void update(Element e) /*-{
        $wnd.jQuery(e).datepicker('update');
    }-*/;

    private native void setStartDate(Element e, String startDate) /*-{
        $wnd.jQuery(e).datepicker('setStartDate', startDate);
    }-*/;

    private native void setEndDate(Element e, String endDate) /*-{
        $wnd.jQuery(e).datepicker('setEndDate', endDate);
    }-*/;

    private native void setDaysOfWeekDisabled(Element e, String daysOfWeekDisabled) /*-{
        $wnd.jQuery(e).datepicker('setDaysOfWeekDisabled', daysOfWeekDisabled);
    }-*/;

    protected native void configure(Element e, Element p, String format, int weekStart, String daysOfWeekDisabled, boolean autoClose, int startView,
                                    int minViewMode, boolean todayBtn, boolean highlightToday, boolean keyboardNavigation, boolean forceParse, int viewSelect, String language,
                                    String orientation) /*-{

        if (todayBtn) {
            todayBtn = "linked";
        }

        var that = this;
        $wnd.jQuery(e).datepicker({
            format: format,
            language: language,
            weekStart: weekStart,
            daysOfWeekDisabled: daysOfWeekDisabled,
            autoclose: autoClose,
            startView: startView,
            minViewMode: minViewMode,
            todayBtn: todayBtn,
            todayHighlight: highlightToday,
            keyboardNavigation: keyboardNavigation,
            forceParse: forceParse,
            orientation: orientation,
            container: p
        })
            .on('show', function (e) {
                that.@org.gwtbootstrap3.extras.datepicker.client.ui.base.DatePickerBase::onShow(Lcom/google/gwt/user/client/Event;)(e);
            })
            .on("hide", function (e) {
                that.@org.gwtbootstrap3.extras.datepicker.client.ui.base.DatePickerBase::onHide(Lcom/google/gwt/user/client/Event;)(e);
            })
            .on("changeDate", function (e) {
                that.@org.gwtbootstrap3.extras.datepicker.client.ui.base.DatePickerBase::onChangeDate(Lcom/google/gwt/user/client/Event;)(e);
            })
            .on("changeYear", function (e) {
                that.@org.gwtbootstrap3.extras.datepicker.client.ui.base.DatePickerBase::onChangeYear(Lcom/google/gwt/user/client/Event;)(e);
            })
            .on("changeMonth", function (e) {
                that.@org.gwtbootstrap3.extras.datepicker.client.ui.base.DatePickerBase::onChangeMonth(Lcom/google/gwt/user/client/Event;)(e);
            })
            .on("clearDate", function (e) {
                that.@org.gwtbootstrap3.extras.datepicker.client.ui.base.DatePickerBase::onClearDate(Lcom/google/gwt/user/client/Event;)(e);
            });
    }-*/;

    protected String toDaysOfWeekDisabledString(final DatePickerDayOfWeek... datePickerDayOfWeeks) {
        this.daysOfWeekDisabled = datePickerDayOfWeeks;

        final StringBuilder builder = new StringBuilder();

        if (datePickerDayOfWeeks != null) {
            int i = 0;
            for (final DatePickerDayOfWeek dayOfWeek : datePickerDayOfWeeks) {
                builder.append(dayOfWeek.getValue());

                i++;
                if (i < datePickerDayOfWeeks.length) {
                    builder.append(",");
                }
            }
        }
        return builder.toString();
    }
}
