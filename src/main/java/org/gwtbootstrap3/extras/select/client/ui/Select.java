package org.gwtbootstrap3.extras.select.client.ui;

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

import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.OptionElement;
import com.google.gwt.dom.client.SelectElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasName;

import org.gwtbootstrap3.client.ui.base.ComplexWidget;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.AttributeMixin;
import org.gwtbootstrap3.client.ui.base.mixin.EnabledMixin;
import org.gwtbootstrap3.client.ui.base.mixin.FocusableMixin;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.extras.select.client.constants.Styles;
import org.gwtbootstrap3.extras.select.client.constants.SelectLanguage;
import org.gwtbootstrap3.extras.select.client.ui.interfaces.HasLanguage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.gwtbootstrap3.extras.select.client.constants.DataAttributes.*;

/**
 * @author godi
 */
public class Select extends ComplexWidget implements Focusable, HasEnabled, HasLanguage, HasName {
    private static final String REFRESH = "refresh";
    private static final String RENDER = "render";
    private static final String SHOW = "show";
    private static final String HIDE = "hide";
    private static final String SELECT_ALL = "selectAll";
    private static final String DESELECT_ALL = "deselectAll";
    private static final String TRUE = "true";
    private SelectLanguage language = SelectLanguage.EN;

    private final SelectElement selectElement;
    private final AttributeMixin<Select> attributeMixin = new AttributeMixin<Select>(this);
    private final FocusableMixin<Select> focusableMixin = new FocusableMixin<Select>(this);
    private final EnabledMixin<Select> enabledMixin = new EnabledMixin<Select>(this);

    public Select() {
        selectElement = Document.get().createSelectElement();
        setElement(selectElement);
        setStyleName(Styles.BOOTSTRAP_SELECT);
        addStyleName(org.gwtbootstrap3.client.ui.constants.Styles.FORM_CONTROL);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        initialize();
    }

    public HandlerRegistration addChangeHandler(final ChangeHandler handler) {
        return addDomHandler(handler, ChangeEvent.getType());
    }

    public void setHeader(final String header) {
        attributeMixin.setAttribute(DATA_HEADER, header);
    }

    public String getHeader() {
        return attributeMixin.getAttribute(DATA_HEADER);
    }

    public void clearHeader() {
        attributeMixin.removeAttribute(DATA_HEADER);
    }

    public void setShowSubtext(final boolean showSubtext) {
        if (showSubtext) {
            attributeMixin.setAttribute(DATA_SHOW_SUBTEXT, Boolean.toString(true));
        } else {
            attributeMixin.removeAttribute(DATA_SHOW_SUBTEXT);
        }
    }

    public boolean getShowSubtext() {
        return attributeMixin.getAttribute(DATA_SHOW_SUBTEXT) != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEnabled(final boolean enabled) {
        enabledMixin.setEnabled(enabled);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEnabled() {
        return enabledMixin.isEnabled();
    }

    @Override
    public void setLanguage(final SelectLanguage language) {
        this.language = language;

        // Inject the JS for the language
        if (language.getJs() != null) {
            ScriptInjector.fromString(language.getJs().getText())
                    .setWindow(ScriptInjector.TOP_WINDOW).inject();
        }
    }

    @Override
    public SelectLanguage getLanguage() {
        return language;
    }

    /**
     * Sets the number of lines to show before scrolling
     * <p/>
     * Values:
     * <p/>
     * (1) auto - (default) shows them all
     * (2) x - shows x number of entries before scrolling
     *
     * @param size String visible size
     */
    public void setVisibleSize(final String size) {
        attributeMixin.setAttribute(DATA_SIZE, size);
    }

    public String getVisibleSize() {
        return attributeMixin.getAttribute(DATA_SIZE);
    }

    public void clearVisibleSize() {
        attributeMixin.removeAttribute(DATA_SIZE);
    }

    /**
     * Sets the width of the select
     * <p/>
     * !! use 'auto' to automatically adjust the width of the select to its widest option, or just use
     * specific values (50px, 50%, etc...)
     */
    @Override
    public void setWidth(final String width) {
        attributeMixin.setAttribute(DATA_WIDTH, width);
    }

    public String getWidth() {
        return attributeMixin.getAttribute(DATA_WIDTH);
    }

        /**
     * Sets the Max Number of selectable option of the select
     * <p/>
     */
    public void setMaxOption(final String maxOption) {
        attributeMixin.setAttribute(DATA_MAX_OPTION, maxOption);
    }

    public String getMaxOption() {
        return attributeMixin.getAttribute(DATA_MAX_OPTION);
    }

    public void setShowMenuArrow(final boolean showMenuArrow) {
        if (showMenuArrow) {
            addStyleName(Styles.SHOW_MENU_ARROW);
        } else {
            removeStyleName(Styles.SHOW_MENU_ARROW);
        }
    }

    public boolean getShowMenuArrow() {
        return StyleHelper.containsStyle(getStyleName(), Styles.SHOW_MENU_ARROW);
    }

    public void setShowTick(final boolean showTick) {
        if (showTick) {
            addStyleName(Styles.SHOW_TICK);
        } else {
            removeStyleName(Styles.SHOW_TICK);
        }
    }

    public boolean getShowTick() {
        return StyleHelper.containsStyle(getStyleName(), Styles.SHOW_TICK);
    }

    /**
     * Supported Values:
     * <p/>
     * (1) values - default, comma delimited list
     * (2) count - If one item is selected, then the value is shown, if more than one is selected then the number of selected items is displayed, eg 2 of 6 selected
     * (3) count greater than x - Where X is the number of items selected when the display format changes from values to count
     *
     * @param format selected text format
     */
    public void setSelectedTextFormat(final String format) {
        attributeMixin.setAttribute(DATA_SELECTED_TEXT_FORMAT, format);
    }

    public String getSelectedTextFormat() {
        return attributeMixin.getAttribute(DATA_SELECTED_TEXT_FORMAT);
    }

    public void clearSelectedTextFormat() {
        attributeMixin.removeAttribute(DATA_SELECTED_TEXT_FORMAT);
    }

    public void setMultiple(final boolean multiple) {
        if (multiple) {
            attributeMixin.setAttribute(MULTIPLE, "");
        } else {
            attributeMixin.removeAttribute(MULTIPLE);
        }
    }

    public boolean isMultiple() {
        return attributeMixin.hasAttribute(MULTIPLE);
    }

  public void setMobile(final boolean mobile) {
        if (mobile) {
            attributeMixin.setAttribute(DATA_MOBILE, Boolean.toString(true));
        } else {
            attributeMixin.removeAttribute(DATA_MOBILE);
        }
    }

    public boolean isMobile() {
        return attributeMixin.hasAttribute(DATA_MOBILE);
    }

    public void setLiveSearch(final boolean liveSearch) {
        if (liveSearch) {
            attributeMixin.setAttribute(DATA_LIVE_SEARCH, Boolean.toString(true));
        } else {
            attributeMixin.removeAttribute(DATA_LIVE_SEARCH);
        }
    }

    public boolean isLiveSearch() {
        return !attributeMixin.getAttribute(DATA_LIVE_SEARCH).isEmpty() || attributeMixin.getAttribute(DATA_LIVE_SEARCH).equals(TRUE);
    }

    public void setStyle(final ButtonType style) {
        attributeMixin.setAttribute(DATA_STYLE, style.getCssName());
    }

    public void clearStyle() {
        attributeMixin.removeAttribute(DATA_STYLE);
    }

    public String getStyle() {
        return attributeMixin.getAttribute(DATA_STYLE);
    }

    public void setValue(final String value) {
        // Need to defer the setValue to make sure the element is actually in the DOM to manipulate
        Scheduler.get().scheduleDeferred(new Command() {
            @Override
            public void execute() {
                setValue(getElement(), value);
            }
        });
    }

    public void setValues(final String... values) {
        final JsArrayString array = JavaScriptObject.createArray().cast();

        for (final String value : values) {
            array.push(value);
        }

        // Need to defer the setValue to make sure the element is actually in the DOM to manipulate
        Scheduler.get().scheduleDeferred(new Command() {
            @Override
            public void execute() {
                setValue(getElement(), array);
            }
        });
    }

    public void setValue(final Option opt) {
        setValue(opt.getText());
    }

    public void setValues(final Option... opts) {
        final String[] values = new String[opts.length];
        for (int i = 0; i < opts.length; i++) {
            values[i] = opts[i].getText();
        }
        setValues(values);
    }

    /**
     * @return the selected value, if multiple it will return the first selected item see {@link #isItemSelected(int)}
     * and {@link #getValueByIndex(int)} for getting all the values selected or {@link #getAllSelectedValues()}
     */
    public String getSelectedValue() {
        int selectedIndex = getSelectElement().getSelectedIndex();
        return selectedIndex == -1 ? null : getSelectElement().getOptions().getItem(selectedIndex).getValue();
    }

    public List<String> getAllSelectedValues() {
        final List<String> allSelected = new ArrayList<String>();

        for (int i = 0; i < getItemCount(); i++) {
            if (isItemSelected(i)) {
                allSelected.add(getValueByIndex(i));
            }
        }
        return allSelected;
    }

    public List<OptionElement> getAllSelectedOptions() {
        final List<OptionElement> allSelected = new ArrayList<OptionElement>();

        for (int i = 0; i < getItemCount(); i++) {
            if (isItemSelected(i)) {
                allSelected.add(getOption(i));
            }
        }
        return allSelected;
    }

    public boolean isItemSelected(final int index) {
        checkIndex(index);
        return getSelectElement().getOptions().getItem(index).isSelected();
    }

    public String getValueByIndex(final int index) {
        checkIndex(index);
        return getSelectElement().getOptions().getItem(index).getValue();
    }

    public OptionElement getOption(final int index) {
        checkIndex(index);
        return getSelectElement().getOptions().getItem(index);
    }

    /**
     * Manually select list options by value.
     */
    public void selectValues(final String... values) {
        List<String> selectedValues = new ArrayList<String>();

        if(values != null && values.length > 0) {
            selectedValues.addAll(Arrays.asList(values));
        }

        if(selectedValues.size() > 0) {
            if (isMultiple()) {
                selectedValues.addAll(getAllSelectedValues());
                setValues(selectedValues.toArray(new String[selectedValues.size()]));
            } else {
                // setValues won't work on a non-multiple Select
                setValue(selectedValues.get(0));
            }
        }
    }

    public void selectAll() {
        command(getElement(), SELECT_ALL);
    }

    public void deselectAll() {
        command(getElement(), DESELECT_ALL);
    }

    public void render() {
        command(getElement(), RENDER);
    }

    /**
     * WHEN CHANGING ANY SETTINGS CALL REFRESH AFTER!!
     */
    public void refresh() {
        command(getElement(), REFRESH);
    }

    public void hide() {
        command(getElement(), HIDE);
    }

    public void show() {
        command(getElement(), SHOW);
    }

    private void initialize() {
        initialize(getElement());
    }

    private void checkIndex(final int index) {
        if (index < 0 || index >= getItemCount()) {
            throw new IndexOutOfBoundsException();
        }
    }

    protected SelectElement getSelectElement() {
        return getElement().cast();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getTabIndex() {
        return focusableMixin.getTabIndex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAccessKey(final char c) {
        focusableMixin.setAccessKey(c);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFocus(final boolean b) {
        focusableMixin.setFocus(b);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTabIndex(final int i) {
        focusableMixin.setTabIndex(i);
    }

    @Override
    public void setName(String name) {
        selectElement.setName(name);
    }

    @Override
    public String getName() {
        return selectElement.getName();
    }

    /**
     * Gets the number of items present in the list box.
     *
     * @return the number of items
     */
    public int getItemCount() {
        return getSelectElement().getOptions().getLength();
    }

    private native void initialize(Element e) /*-{
        $wnd.jQuery(e).selectpicker({
            iconBase: 'fa',
            tickIcon: 'fa-check'
        });
    }-*/;

    private native void setValue(Element e, JsArrayString value) /*-{
        $wnd.jQuery(e).selectpicker('val', value);
    }-*/;

    private native void setValue(Element e, String value) /*-{
        $wnd.jQuery(e).selectpicker('val', value);
    }-*/;

    private native void command(Element e, String command) /*-{
        $wnd.jQuery(e).selectpicker(command);
    }-*/;
}