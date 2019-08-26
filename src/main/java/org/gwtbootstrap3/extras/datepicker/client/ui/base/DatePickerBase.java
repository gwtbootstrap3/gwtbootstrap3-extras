package org.gwtbootstrap3.extras.datepicker.client.ui.base;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2016 GwtBootstrap3
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
import org.gwtbootstrap3.extras.datepicker.client.ui.base.constants.DatePickerDayOfWeek;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.constants.DatePickerLanguage;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.constants.DatePickerMinView;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.constants.DatePickerPosition;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.constants.HasAutoClose;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.constants.HasDateTimePickerHandlers;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.constants.HasDaysOfWeekDisabled;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.constants.HasEndDate;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.constants.HasForceParse;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.constants.HasFormat;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.constants.HasHighlightToday;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.constants.HasKeyboardNavigation;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.constants.HasLanguage;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.constants.HasMinView;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.constants.HasPosition;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.constants.HasShowTodayButton;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.constants.HasShowClearButton;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.constants.HasStartDate;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.constants.HasStartView;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.constants.HasViewSelect;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.constants.HasWeekStart;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.events.ChangeDateEvent;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.events.ChangeDateHandler;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.events.ChangeMonthEvent;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.events.ChangeMonthHandler;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.events.ChangeYearEvent;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.events.ChangeYearHandler;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.events.ClearDateEvent;
import org.gwtbootstrap3.extras.datepicker.client.ui.base.events.ClearDateHandler;

import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
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
public class DatePickerBase extends Widget implements HasEnabled, HasId, HasResponsiveness, HasVisibility, HasPlaceholder,
        HasAutoClose, HasDaysOfWeekDisabled, HasEndDate, HasForceParse, HasFormat, HasHighlightToday, HasKeyboardNavigation,
        HasMinView, HasShowTodayButton, HasShowClearButton, HasStartDate, HasStartView, HasViewSelect, HasWeekStart, HasDateTimePickerHandlers,
        HasLanguage, HasName, HasValue<Date>, HasPosition, LeafValueEditor<Date>, HasEditorErrors<Date>, HasErrorHandler,
        HasValidators<Date>, HasBlankValidator<Date> {

    static class DatePickerValidatorMixin extends BlankValidatorMixin<DatePickerBase, Date> {

        private boolean showing = false;

        public void setShowing(boolean showing) {
            this.showing = showing;
        }

        public DatePickerValidatorMixin(DatePickerBase inputWidget, ErrorHandler errorHandler) {
            super(inputWidget, errorHandler);
        }

        @Override
        protected com.google.web.bindery.event.shared.HandlerRegistration setupBlurValidation() {
            return getInputWidget().addDomHandler(new BlurHandler() {
                @Override
                public void onBlur(BlurEvent event) {
                    getInputWidget().validate(!showing && getValidateOnBlur());
                }
            }, BlurEvent.getType());
        }

    }

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
    private final ErrorHandlerMixin<Date> errorHandlerMixin = new ErrorHandlerMixin<Date>(this);
    private final DatePickerValidatorMixin validatorMixin = new DatePickerValidatorMixin(this,
            errorHandlerMixin.getErrorHandler());

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
    private boolean showClearButton = false;
    private boolean highlightToday = false;
    private boolean keyboardNavigation = true;
    private boolean forceParse = true;

    private DatePickerMinView viewSelect = DatePickerMinView.DAY;

    private Widget container = null;
    private DatePickerLanguage language = DatePickerLanguage.EN;
    private DatePickerPosition position = DatePickerPosition.AUTO;

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
    public void setLanguage(final DatePickerLanguage language) {
        this.language = language;

        // Inject the JS for the language
        if (language.getJs() != null) {
            ScriptInjector.fromString(language.getJs().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        }
    }

    /** {@inheritDoc} */
    @Override
    public DatePickerLanguage getLanguage() {
        return language;
    }

    /** {@inheritDoc} */
    @Override
    public void setPosition(final DatePickerPosition position) {
        this.position = position;
    }

    /** {@inheritDoc} */
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

    /** {@inheritDoc} */
    @Override
    public void setAutoClose(final boolean autoClose) {
        this.autoClose = autoClose;
    }

    /** {@inheritDoc} */
    @Override
    public void onShow(final Event e) {
        validatorMixin.setShowing(true);
        fireEvent(new ShowEvent(e));
    }

    /** {@inheritDoc} */
    @Override
    public HandlerRegistration addShowHandler(final ShowHandler showHandler) {
        return addHandler(showHandler, ShowEvent.getType());
    }

    /** {@inheritDoc} */
    @Override
    public void onHide(final Event e) {
        validatorMixin.setShowing(false);
        validate(getValidateOnBlur());
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
    public void onClearDate(final Event e) {
        fireEvent(new ClearDateEvent(e));
    }

    /** {@inheritDoc} */
    @Override
    public HandlerRegistration addClearDateHandler(final ClearDateHandler clearDateHandler) {
        return addHandler(clearDateHandler, ClearDateEvent.getType());
    }

    /** {@inheritDoc} */
    @Override
    public void setDaysOfWeekDisabled(final DatePickerDayOfWeek... daysOfWeekDisabled) {
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
    public void setMinView(final DatePickerMinView datePickerMinView) {
        this.minView = datePickerMinView;

        // We keep the view select the same as the min view
        if (viewSelect != minView) {
            setViewSelect(datePickerMinView);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setShowTodayButton(final boolean showTodayButton) {
        this.showTodayButton = showTodayButton;
    }

    /** {@inheritDoc} */
    @Override
    public void setShowClearButton(boolean showClearbutton) {
        this.showClearButton = showClearbutton;
    }

    /** {@inheritDoc} */
    @Override
    public void setStartDate(final Date startDate) {
        // Has to be in the format DD-MM-YYYY
        setStartDate(startEndDateFormat.format(startDate));
    }

    /** {@inheritDoc} */
    @Override
    public void setStartDate(final String startDate) {
        // Has to be in the format DD-MM-YYYY
        setStartDate(getElement(), startDate);
    }

    /** {@inheritDoc} */
    @Override
    public void clearStartDate() {
        setStartDate(getElement(), null);
    }

    /** {@inheritDoc} */
    @Override
    public void setStartView(final DatePickerMinView datePickerMinView) {
        this.startView = datePickerMinView;
    }

    /** {@inheritDoc} */
    @Override
    public void setViewSelect(final DatePickerMinView datePickerMinView) {
        this.viewSelect = datePickerMinView;

        // We keep the min view the same as the view select
        if (viewSelect != minView) {
            setMinView(datePickerMinView);
        }
    }

    /** {@inheritDoc} */
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
                ValueChangeEvent.fire(DatePickerBase.this, getValue());
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
            ValueChangeEvent.fire(DatePickerBase.this, value);
        }
    }

    /** {@inheritDoc} */
    @Override
    protected void onLoad() {
        super.onLoad();
        configure();

        // With the new update the parent must have position: relative for positioning to work
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

        // If configuring not for the first time, datepicker must be removed first.
        this.remove(w.getElement());

        configure(w.getElement(), container.getElement(), format, weekStart.getValue(), toDaysOfWeekDisabledString(daysOfWeekDisabled), autoClose,
                startView.getValue(), minView.getValue(), showTodayButton, showClearButton, highlightToday, keyboardNavigation, forceParse, viewSelect.getValue(),
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
                                    int minViewMode, boolean todayBtn, boolean clearBtn, boolean highlightToday, boolean keyboardNavigation, boolean forceParse, int viewSelect, String language,
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
            clearBtn: clearBtn,
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
    @SuppressWarnings("unchecked")
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
        validatorMixin.setErrorHandler(errorHandler);
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
