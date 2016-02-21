package org.gwtbootstrap3.extras.select.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2016 GwtBootstrap3
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

import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.ACTION_BOX;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.MAX_OPTIONS;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.MULTIPLE_SEPARATOR;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.NONE_SELECTED_TEXT;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.SELECTED_TEXT_FORMAT;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.gwtbootstrap3.extras.select.client.ui.constants.SelectedTextFormat;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.OptionElement;

/**
 * Multiple select box.
 *
 * @author Xiaodong Sun
 */
public class MultipleSelect extends SelectBase<List<String>> {

    private static final String MULTIPLE = "multiple";

    public MultipleSelect() {
        attrMixin.setAttribute(MULTIPLE, "");
    }

    @Override
    public final boolean isMultiple() {
        return true;
    }

    /**
     * When set to <code>true</code>, adds two buttons to the top of
     * the drop-down menu (<b>Select All</b> & <b>Deselect All</b>).<br>
     * <br>
     * Defaults to <code>false</code>.
     *
     * @param showActionsBox
     */
    public void setShowActionsBox(final boolean showActionsBox) {
        if (showActionsBox)
            attrMixin.setAttribute(ACTION_BOX, Boolean.toString(true));
        else
            attrMixin.removeAttribute(ACTION_BOX);
    }

    /**
     * When set to a positive value and in a multi-select, the
     * number of selected options cannot exceed the given value.
     * When set to a strict negative value (less than zero), this
     * options will be deactivated.
     *
     * @param maxOptions
     */
    public void setMaxOptions(final int maxOptions) {
        attrMixin.setAttribute(MAX_OPTIONS, Integer.toString(maxOptions));
    }

    /**
     * Sets the character displayed in the button that separates
     * selected options.<br>
     * <br>
     * Defaults to <code>, </code>.
     *
     * @param multipleSeparator
     */
    public void setMultipleSeparator(final String multipleSeparator) {
        if (multipleSeparator != null)
            attrMixin.setAttribute(MULTIPLE_SEPARATOR, multipleSeparator);
        else
            attrMixin.removeAttribute(MULTIPLE_SEPARATOR);
    }

    /**
     * Sets the text that is displayed when a multiple select
     * has no selected options.<br>
     * <br>
     * Defaults to <code>Nothing Selected</code>.
     *
     * @param noneSelectedText
     */
    public void setNoneSelectedText(final String noneSelectedText) {
        if (noneSelectedText != null)
            attrMixin.setAttribute(NONE_SELECTED_TEXT, noneSelectedText);
        else
            attrMixin.removeAttribute(NONE_SELECTED_TEXT);
    }

    /**
     * Specifies how the selection is displayed with a multiple select.<br>
     * <br>
     * Defaults to {@link SelectedTextFormat#VALUES}.
     *
     * @param format
     * @see SelectedTextFormat
     */
    public void setSelectedTextFormat(final SelectedTextFormat format) {
        if (format != null)
            attrMixin.setAttribute(SELECTED_TEXT_FORMAT, format.getFormat());
        else
            attrMixin.removeAttribute(SELECTED_TEXT_FORMAT);
    }

    /**
     * Specifies the minimum count of the <code>count > #</code> selection
     * format with a multiple select.
     *
     * @param minCount
     * @see SelectedTextFormat#getFormat(int)
     */
    public void setCountSelectedTextFormat(final int minCount) {
        attrMixin.setAttribute(SELECTED_TEXT_FORMAT, SelectedTextFormat.COUNT.getFormat(minCount));
    }

    @Override
    public List<String> getValue() {
        if (isAttached()) {
            JsArrayString arr = getValue(getElement());
            List<String> result = new ArrayList<>(arr.length());
            for (int i = 0; i < arr.length(); i++) {
                result.add(arr.get(i));
            }
            return result;
        }
        return getSelectedValues();
    }

    private List<String> getSelectedValues() {
        final List<String> allSelected = new ArrayList<>(0);
        for (Entry<OptionElement, Option> entry : itemMap.entrySet()) {
            Option opt = entry.getValue();
            if (opt.isSelected())
                allSelected.add(opt.getValue());
        }
        return allSelected;
    }

    @Override
    protected void setSelectedValue(List<String> value) {
        if (isAttached()) {
            final JsArrayString arr = JavaScriptObject.createArray().cast();
            for (final String val : value) {
                arr.push(val);
            }
            setValue(getElement(), arr);
        } else {
            for (Entry<OptionElement, Option> entry : itemMap.entrySet()) {
                Option opt = entry.getValue();
                boolean selected = value.contains(opt.getValue());
                opt.setSelected(selected);
            }
        }
    }

    /**
     * Returns the selected items list. If no item is selected, this method
     * returns an empty list.
     *
     * @return the selected items list
     */
    public List<Option> getSelectedItems() {
        final List<Option> items = new ArrayList<>(0);
        for (Entry<OptionElement, Option> entry : itemMap.entrySet()) {
            Option opt = entry.getValue();
            if (opt.isSelected())
                items.add(opt);
        }
        return items;
    }

    /**
     * Select all items in a multi-select.
     */
    public void selectAll() {
        setSelectAll(true);
    }

    /**
     * Deselect all items in a multi-select.
     */
    public void deselectAll() {
        setSelectAll(false);
    }

    private void setSelectAll(boolean selected) {
        if (isAttached()) {
            String cmd = selected ? SelectCommand.SELECT_ALL : SelectCommand.DESELECT_ALL;
            command(getElement(), cmd);
        } else {
            for (Entry<OptionElement, Option> entry : itemMap.entrySet()) {
                entry.getValue().setSelected(selected);
            }
        }
    }

    private native JsArrayString getValue(Element e) /*-{
        var value = $wnd.jQuery(e).selectpicker('val');
        return value || [];
    }-*/;

    private native void setValue(Element e, JsArrayString value) /*-{
        $wnd.jQuery(e).selectpicker('val', value);
    }-*/;

}
