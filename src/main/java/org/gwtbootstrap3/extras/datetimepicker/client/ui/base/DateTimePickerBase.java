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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.gwtbootstrap3.client.ui.base.mixin.BlankValidatorMixin;
import org.gwtbootstrap3.client.ui.base.mixin.ErrorHandlerMixin;
import org.gwtbootstrap3.client.ui.constants.DeviceSize;
import org.gwtbootstrap3.client.ui.form.error.ErrorHandler;
import org.gwtbootstrap3.client.ui.form.error.ErrorHandlerType;
import org.gwtbootstrap3.client.ui.form.error.HasErrorHandler;
import org.gwtbootstrap3.client.ui.form.validator.HasBlankValidator;
import org.gwtbootstrap3.client.ui.form.validator.HasValidators;
import org.gwtbootstrap3.client.ui.form.validator.ValidationChangedEvent.ValidationChangedHandler;
import org.gwtbootstrap3.client.ui.form.validator.Validator;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.DateTimePickerDayOfWeek;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.DateTimePickerLanguage;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.DateTimePickerPosition;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.DateTimePickerView;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.HasAutoClose;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.HasDateTimePickerHandlers;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.HasDaysOfWeekDisabled;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.HasEndDate;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.HasForceParse;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.HasFormat;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.HasHighlightToday;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.HasKeyboardNavigation;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.HasLanguage;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.HasMaxView;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.HasMinView;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.HasMinuteStep;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.HasPosition;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.HasShowMeridian;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.HasShowTodayButton;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.HasStartDate;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.HasStartView;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.HasViewSelect;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants.HasWeekStart;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.events.ChangeDateEvent;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.events.ChangeDateHandler;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.events.ChangeMonthEvent;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.events.ChangeMonthHandler;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.events.ChangeYearEvent;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.events.ChangeYearHandler;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.events.OutOfRangeEvent;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.base.events.OutOfRangeHandler;

import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasVisibility;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Joshua Godi
 * @author Steven Jardine
 */
public class DateTimePickerBase extends Widget implements HasEnabled, HasId, HasResponsiveness, HasVisibility, HasPlaceholder,
        HasAutoClose, HasDaysOfWeekDisabled, HasEndDate, HasForceParse, HasFormat, HasHighlightToday, HasKeyboardNavigation,
        HasMaxView, HasMinuteStep, HasMinView, HasShowMeridian, HasShowTodayButton, HasStartDate, HasStartView, HasViewSelect,
        HasWeekStart, HasDateTimePickerHandlers, HasLanguage, HasName, HasValue<Date>, HasPosition, LeafValueEditor<Date>,
        HasEditorErrors<Date>, HasErrorHandler, HasValidators<Date>, HasBlankValidator<Date> {

    // Check http://www.gwtproject.org/javadoc/latest/com/google/gwt/i18n/client/DateTimeFormat.html
    // for more information on syntax
    private static final Map<Character, Character> DATE_TIME_FORMAT_MAP = new HashMap<Character, Character>();
    static {
        DATE_TIME_FORMAT_MAP.put('h', 'H'); // 12/24 hours
        DATE_TIME_FORMAT_MAP.put('H', 'h'); // 12/24 hours
        DATE_TIME_FORMAT_MAP.put('m', 'M'); // months
        DATE_TIME_FORMAT_MAP.put('i', 'm'); // minutes
        DATE_TIME_FORMAT_MAP.put('p', 'a'); // meridian
        DATE_TIME_FORMAT_MAP.put('P', 'a'); // meridian
    }

    private final TextBox textBox;
    private DateTimeFormat dateTimeFormat;
    private final DateTimeFormat startEndDateFormat = DateTimeFormat.getFormat("yyyy-MM-dd");
    private LeafValueEditor<Date> editor;
    private final ErrorHandlerMixin<Date> errorHandlerMixin = new ErrorHandlerMixin<Date>(this);
    private final BlankValidatorMixin<DateTimePickerBase, Date> validatorMixin = new BlankValidatorMixin<DateTimePickerBase, Date>(this,
        errorHandlerMixin.getErrorHandler());

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
    private DateTimePickerPosition position = DateTimePickerPosition.BOTTOM_RIGHT;

    public DateTimePickerBase() {
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

    /** {@inheritDoc} */
    @Override
    public void setPlaceholder(final String placeHolder) {
        textBox.setPlaceholder(placeHolder);
    }

    /** {@inheritDoc} */
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

    
    /** {@inheritDoc} */
    @Override
    public boolean isEnabled() {
        return textBox.isEnabled();
    }

    /** {@inheritDoc} */
    @Override
    public void setEnabled(final boolean enabled) {
        textBox.setEnabled(enabled);
    }

    /** {@inheritDoc} */
    @Override
    public void setId(final String id) {
        textBox.setId(id);
    }

    /** {@inheritDoc} */
    @Override
    public String getId() {
        return textBox.getId();
    }

    /** {@inheritDoc} */
    @Override
    public void setName(final String name) {
        textBox.setName(name);
    }

    /** {@inheritDoc} */
    @Override
    public String getName() {
        return textBox.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void setVisibleOn(final DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    /** {@inheritDoc} */
    @Override
    public void setHiddenOn(final DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
    }

    /** {@inheritDoc} */
    @Override
    public void setLanguage(final DateTimePickerLanguage language) {
        this.language = language;

        // Inject the JS for the language
        if (language.getJs() != null) {
            ScriptInjector.fromString(language.getJs().getText())
                    .setWindow(ScriptInjector.TOP_WINDOW).inject();
        }
    }

    /** {@inheritDoc} */
    @Override
    public DateTimePickerLanguage getLanguage() {
        return language;
    }

    /** {@inheritDoc} */
    @Override
    public void setPosition(final DateTimePickerPosition position) {
        this.position = position;
    }

    /** {@inheritDoc} */
    @Override
    public DateTimePickerPosition getPosition() {
        return position;
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

    /** {@inheritDoc} */
    @Override
    public void setAutoClose(final boolean autoClose) {
        this.autoClose = autoClose;
    }

    /** {@inheritDoc} */
    @Override
    public void onShow(final Event e) {
        if (!isReadOnly() && isEnabled()) {
            // On show we put focus on the textbox
            textBox.setFocus(true);
    
            fireEvent(new ShowEvent(e));
        } else {
            // Don't show when it's readonly or disabled
            hide();
        }
    }

    /** {@inheritDoc} */
    @Override
    public HandlerRegistration addShowHandler(final ShowHandler showHandler) {
        return addHandler(showHandler, ShowEvent.getType());
    }

    /** {@inheritDoc} */
    @Override
    public void onHide(final Event e) {
        // On hide we remove focus from the textbox
        textBox.setFocus(false);

        fireEvent(new HideEvent(e));
    }

    /** {@inheritDoc} */
    @Override
    public HandlerRegistration addHideHandler(final HideHandler hideHandler) {
        return addHandler(hideHandler, HideEvent.getType());
    }

    /** {@inheritDoc} */
    @Override
    public void onChangeDate(final Event e) {
        fireEvent(new ChangeDateEvent(e));
        ValueChangeEvent.fire(DateTimePickerBase.this, getValue());
        hide();
    }

    /** {@inheritDoc} */
    @Override
    public HandlerRegistration addChangeDateHandler(final ChangeDateHandler changeDateHandler) {
        return addHandler(changeDateHandler, ChangeDateEvent.getType());
    }

    /** {@inheritDoc} */
    @Override
    public void onChangeYear(final Event e) {
        fireEvent(new ChangeYearEvent(e));
    }

    /** {@inheritDoc} */
    @Override
    public HandlerRegistration addChangeYearHandler(final ChangeYearHandler changeYearHandler) {
        return addHandler(changeYearHandler, ChangeYearEvent.getType());
    }

    /** {@inheritDoc} */
    @Override
    public void onChangeMonth(final Event e) {
        fireEvent(new ChangeMonthEvent(e));
    }

    /** {@inheritDoc} */
    @Override
    public HandlerRegistration addChangeMonthHandler(final ChangeMonthHandler changeMonthHandler) {
        return addHandler(changeMonthHandler, ChangeMonthEvent.getType());
    }

    /** {@inheritDoc} */
    @Override
    public void onOutOfRange(final Event e) {
        fireEvent(new OutOfRangeEvent(e));
    }

    /** {@inheritDoc} */
    @Override
    public HandlerRegistration addOutOfRangeHandler(final OutOfRangeHandler outOfRangeHandler) {
        return addHandler(outOfRangeHandler, OutOfRangeEvent.getType());
    }

    /** {@inheritDoc} */
    @Override
    public void setDaysOfWeekDisabled(final DateTimePickerDayOfWeek... daysOfWeekDisabled) {
        setDaysOfWeekDisabled(getElement(), toDaysOfWeekDisabledString(daysOfWeekDisabled));
    }

    /** {@inheritDoc} */
    @Override
    public void setEndDate(final Date endDate) {
        // Has to be in the format YYYY-MM-DD
        setEndDate(startEndDateFormat.format(endDate));
    }

    /** {@inheritDoc} */
    @Override
    public void setEndDate(final String endDate) {
        // Has to be in the format YYYY-MM-DD
        setEndDate(getElement(), endDate);
    }

    /** {@inheritDoc} */
    @Override
    public void clearEndDate() {
        setStartDate(getElement(), null);
    }

    /** {@inheritDoc} */
    @Override
    public void setForceParse(final boolean forceParse) {
        this.forceParse = forceParse;
    }

    /** {@inheritDoc} */
    @Override
    public void setHighlightToday(final boolean highlightToday) {
        this.highlightToday = highlightToday;
    }

    /** {@inheritDoc} */
    @Override
    public void setHasKeyboardNavigation(final boolean hasKeyboardNavigation) {
        this.keyboardNavigation = hasKeyboardNavigation;
    }

    /** {@inheritDoc} */
    @Override
    public void setMaxView(final DateTimePickerView dateTimePickerView) {
        this.maxView = dateTimePickerView;
    }

    /** {@inheritDoc} */
    @Override
    public void setMinView(final DateTimePickerView dateTimePickerView) {
        this.minView = dateTimePickerView;

        // We keep the view select the same as the min view
        if (viewSelect != minView) {
            setViewSelect(dateTimePickerView);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setMinuteStep(final int minuteStep) {
        this.minuteStep = minuteStep;
    }

    /** {@inheritDoc} */
    @Override
    public void setShowMeridian(final boolean showMeridian) {
        this.showMeridian = showMeridian;
    }

    /** {@inheritDoc} */
    @Override
    public void setShowTodayButton(final boolean showTodayButton) {
        this.showTodayButton = showTodayButton;
    }

    /** {@inheritDoc} */
    @Override
    public void setStartDate(final Date startDate) {
        // Has to be in the format YYYY-MM-DD
        setStartDate(startEndDateFormat.format(startDate));
    }

    /** {@inheritDoc} */
    @Override
    public void setStartDate(final String startDate) {
        // Has to be in the format YYYY-MM-DD
        setStartDate(getElement(), startDate);
    }

    /** {@inheritDoc} */
    @Override
    public void clearStartDate() {
        setStartDate(getElement(), null);
    }

    /** {@inheritDoc} */
    @Override
    public void setStartView(final DateTimePickerView dateTimePickerView) {
        this.startView = dateTimePickerView;
    }

    /** {@inheritDoc} */
    @Override
    public void setViewSelect(final DateTimePickerView dateTimePickerView) {
        this.viewSelect = dateTimePickerView;

        // We keep the min view the same as the view select
        if (viewSelect != minView) {
            setMinView(dateTimePickerView);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setWeekStart(final DateTimePickerDayOfWeek weekStart) {
        this.weekStart = weekStart;
    }

    /** {@inheritDoc} */
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

    /** {@inheritDoc} */
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

    /** {@inheritDoc} */
    @Override
    public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<Date> dateValueChangeHandler) {
        textBox.addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> event) {
                ValueChangeEvent.fire(DateTimePickerBase.this, getValue());
            }
        });
        return addHandler(dateValueChangeHandler, ValueChangeEvent.getType());
    }

    /** {@inheritDoc} */
    @Override
    public void setValue(final Date value) {
        setValue(value, false);
    }

    /** {@inheritDoc} */
    @Override
    public void setValue(final Date value, final boolean fireEvents) {
        errorHandlerMixin.clearErrors();
        textBox.setValue(value != null ? dateTimeFormat.format(value) : null);
        update(textBox.getElement());

        if (fireEvents) {
            ValueChangeEvent.fire(DateTimePickerBase.this, value);
        }
    }


    /** {@inheritDoc} */
    @Override
    protected void onLoad() {
        super.onLoad();
        configure();

        // With the new update (2.3.1), the parent must have position: relative for positioning to work
        if (getElement().getParentElement() != null) {
            getElement().getParentElement().getStyle().setPosition(Style.Position.RELATIVE);
        }
    }

    /** {@inheritDoc} */
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
                keyboardNavigation, forceParse, minuteStep, viewSelect.getValue(), showMeridian, language.getCode(), position.getPosition());
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
                                    boolean forceParse, int minuteStep, int viewSelect, boolean showMeridian, String language,
                                    String position) /*-{
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
            pickerPosition: position,
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

    /** {@inheritDoc} */
    @Override
    public com.google.web.bindery.event.shared.HandlerRegistration addValidationChangedHandler(ValidationChangedHandler handler) {
        return validatorMixin.addValidationChangedHandler(handler);
    }

    /** {@inheritDoc} */
    @Override
    public boolean getAllowBlank() {
        return validatorMixin.getAllowBlank();
    }

    /** {@inheritDoc} */
    @Override
    public void setAllowBlank(boolean allowBlank) {
        validatorMixin.setAllowBlank(allowBlank);
    }

    /** {@inheritDoc} */
    @Override
    public void addValidator(Validator<Date> validator) {
        validatorMixin.addValidator(validator);
    }

    /** {@inheritDoc} */
    @Override
    public boolean getValidateOnBlur() {
        return validatorMixin.getValidateOnBlur();
    }

    /** {@inheritDoc} */
    @Override
    public boolean removeValidator(Validator<Date> validator) {
        return validatorMixin.removeValidator(validator);
    }

    /** {@inheritDoc} */
    @Override
    public void reset() {
        validatorMixin.reset();
    }

    /** {@inheritDoc} */
    @Override
    public void setValidateOnBlur(boolean validateOnBlur) {
        validatorMixin.setValidateOnBlur(validateOnBlur);
    }

    /** {@inheritDoc} */
    @Override
    public void setValidators(Validator<Date>... validators) {
        validatorMixin.setValidators(validators);
    }

    /** {@inheritDoc} */
    @Override
    public boolean validate() {
        return validatorMixin.validate();
    }

    /** {@inheritDoc} */
    @Override
    public boolean validate(boolean show) {
        return validatorMixin.validate(show);
    }

    /** {@inheritDoc} */
    @Override
    public ErrorHandler getErrorHandler() {
        return errorHandlerMixin.getErrorHandler();
    }

    /** {@inheritDoc} */
    @Override
    public void setErrorHandler(ErrorHandler errorHandler) {
        errorHandlerMixin.setErrorHandler(errorHandler);
    }

    /** {@inheritDoc} */
    @Override
    public ErrorHandlerType getErrorHandlerType() {
        return errorHandlerMixin.getErrorHandlerType();
    }

    /** {@inheritDoc} */
    @Override
    public void setErrorHandlerType(ErrorHandlerType errorHandlerType) {
        errorHandlerMixin.setErrorHandlerType(errorHandlerType);
    }

    /** {@inheritDoc} */
    @Override
    public void showErrors(List<EditorError> errors) {
        errorHandlerMixin.showErrors(errors);
    }

}
