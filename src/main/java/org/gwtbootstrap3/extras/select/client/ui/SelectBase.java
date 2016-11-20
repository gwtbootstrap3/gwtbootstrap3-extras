package org.gwtbootstrap3.extras.select.client.ui;

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
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.CONTAINER;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.DROPDOWN_ALIGN_RIGHT;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.DROPUP_AUTO;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.HEADER;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.HIDE_DISABLED;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.LIVE_SEARCH;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.LIVE_SEARCH_NORMALIZE;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.LIVE_SEARCH_PLACEHOLDER;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.LIVE_SEARCH_STYLE;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.MOBILE;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.SELECT_ON_TAB;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.SHOW_CONTENT;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.SHOW_ICON;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.SHOW_SUBTEXT;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.SIZE;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.STYLE;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.WIDTH;
import static org.gwtbootstrap3.extras.select.client.ui.SelectOptions.WINDOW_PADDING;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.gwtbootstrap3.client.ui.base.ComplexWidget;
import org.gwtbootstrap3.client.ui.base.HasSize;
import org.gwtbootstrap3.client.ui.base.HasType;
import org.gwtbootstrap3.client.ui.base.mixin.AttributeMixin;
import org.gwtbootstrap3.client.ui.base.mixin.EnabledMixin;
import org.gwtbootstrap3.client.ui.constants.ButtonSize;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.extras.select.client.ui.constants.DropdownAlignRight;
import org.gwtbootstrap3.extras.select.client.ui.constants.LiveSearchStyle;
import org.gwtbootstrap3.extras.select.client.ui.constants.MenuSize;
import org.gwtbootstrap3.extras.select.client.ui.constants.SelectStyles;
import org.gwtbootstrap3.extras.select.client.ui.constants.SelectWidth;
import org.gwtbootstrap3.extras.select.client.ui.event.HasAllSelectHandlers;
import org.gwtbootstrap3.extras.select.client.ui.event.HiddenEvent;
import org.gwtbootstrap3.extras.select.client.ui.event.HiddenHandler;
import org.gwtbootstrap3.extras.select.client.ui.event.HideEvent;
import org.gwtbootstrap3.extras.select.client.ui.event.HideHandler;
import org.gwtbootstrap3.extras.select.client.ui.event.LoadedEvent;
import org.gwtbootstrap3.extras.select.client.ui.event.LoadedHandler;
import org.gwtbootstrap3.extras.select.client.ui.event.RefreshedEvent;
import org.gwtbootstrap3.extras.select.client.ui.event.RefreshedHandler;
import org.gwtbootstrap3.extras.select.client.ui.event.RenderedEvent;
import org.gwtbootstrap3.extras.select.client.ui.event.RenderedHandler;
import org.gwtbootstrap3.extras.select.client.ui.event.ShowEvent;
import org.gwtbootstrap3.extras.select.client.ui.event.ShowHandler;
import org.gwtbootstrap3.extras.select.client.ui.event.ShownEvent;
import org.gwtbootstrap3.extras.select.client.ui.event.ShownHandler;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.dom.client.OptionElement;
import com.google.gwt.dom.client.SelectElement;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.impl.FocusImpl;

/**
 * Bootstrap select widget base
 *
 * @param <T> select value type
 *
 * @see http://silviomoreto.github.io/bootstrap-select/
 * @author Xiaodong Sun
 */
public abstract class SelectBase<T> extends ComplexWidget implements HasValue<T>, HasEnabled, Focusable,
        HasType<ButtonType>, HasSize<ButtonSize>, IsEditor<LeafValueEditor<T>>, HasAllSelectHandlers<T> {

    private LeafValueEditor<T> editor;
    private ButtonType type;
    private ButtonSize size;

    /**
     * Default language: {@link SelectLanguage#EN}
     */
    private static final SelectLanguage DEFAULT_LANGUAGE = SelectLanguage.EN;

    /**
     * Language; defaults to {@value #DEFAULT_LANGUAGE}
     */
    private SelectLanguage language = DEFAULT_LANGUAGE;

    protected final SelectElement selectElement;
    protected final Map<OptionElement, Option> itemMap = new HashMap<>(0);
    protected final AttributeMixin<SelectBase<T>> attrMixin = new AttributeMixin<>(this);
    private final EnabledMixin<SelectBase<T>> enabledMixin = new EnabledMixin<>(this);
    private final FocusImpl focusImpl = FocusImpl.getFocusImplForWidget();

    /**
     * Initialize options
     */
    protected SelectOptions options = SelectOptions.newOptions();

    protected SelectBase() {
        this.selectElement = Document.get().createSelectElement();
        setElement(selectElement);
        setStyleName(SelectStyles.SELECT_PICKER);
        addStyleName(Styles.FORM_CONTROL);
    }

    /**
     * Returns <code>true</code> if multiple selection is allowed.
     *
     * @return <code>true</code> if multiple selection is allowed
     */
    public abstract boolean isMultiple();

    @Override
    protected void onLoad() {
        super.onLoad();
        // Inject the language JS is necessary
        if (language.getJs() != null) {
            ScriptInjector.fromString(language.getJs().getText())
                .setWindow(ScriptInjector.TOP_WINDOW).inject();
        }
        initialize(getElement(), options);
        bindSelectEvents(getElement());
    }

    @Override
    protected void onUnload() {
        super.onUnload();
        unbindSelectEvents(getElement());
        command(getElement(), SelectCommand.DESTROY);
    }

    @Override
    public void add(Widget child) {
        super.add(child);
        updateItemMap(child, true);
    }

    @Override
    public void insert(Widget child, int beforeIndex) {
        super.insert(child, beforeIndex);
        updateItemMap(child, true);
    }

    @Override
    public boolean remove(Widget w) {
        boolean removed = super.remove(w);
        if (removed) {
            updateItemMap(w, false);
        }
        return removed;
    }

    void updateItemMap(Widget widget, boolean toAdd) {
        // Option ==> update with this option
        if (widget instanceof Option) {
            Option option = (Option) widget;
            if (toAdd)
                itemMap.put(option.getSelectElement(), option);
            else
                itemMap.remove(option.getSelectElement());
        } else if (widget instanceof OptGroup) {
            // OptGroup ==> update with all optGroup options
            OptGroup optGroup = (OptGroup) widget;
            if (toAdd)
                itemMap.putAll(optGroup.getItemMap());
            else
                for (Entry<OptionElement, Option> entry : optGroup.getItemMap().entrySet()) {
                    OptionElement optElem = entry.getKey();
                    itemMap.remove(optElem);
                }
        }
    }

    /**
     * Set the select language.
     *
     * @param language
     */
    public void setLanguage(final SelectLanguage language) {
        this.language = (language == null) ? DEFAULT_LANGUAGE : language;
    }

    /**
     * Returns the select language.
     *
     * @return
     */
    public SelectLanguage getLanguage() {
        return language;
    }

    /**
     * Sets a container to which the select will be appended.
     *
     * @param container specific element or selector, e.g., "body", ".my-container"
     */
    public void setContainer(final String container) {
        if (container != null)
            attrMixin.setAttribute(CONTAINER, container);
        else
            attrMixin.removeAttribute(CONTAINER);
    }

    /**
     * Sets the handler to get the text displayed when selectedTextFormat
     * is <code>count</code> or <code>count > #</code>, or <code>null</code>
     * to use the default text: <code>X of Y selected</code>.
     *
     * @param handler
     */
    public void setCountSelectedTextHandler(final CountSelectedTextHandler handler) {
        options.setCountSelectedTextHandler(handler);
    }

    /**
     * Sets the drop-down menu right alignment.<br>
     * <br>
     * Defaults to {@link DropdownAlignRight#FALSE}.
     *
     * @param dropdownAlignRight
     * @see DropdownAlignRight
     */
    public void setDropdownAlignRight(final DropdownAlignRight dropdownAlignRight) {
        if (dropdownAlignRight != null)
            attrMixin.setAttribute(DROPDOWN_ALIGN_RIGHT, dropdownAlignRight.getValue());
        else
            attrMixin.removeAttribute(DROPDOWN_ALIGN_RIGHT);
    }

    /**
     * Checks to see which has more room, above or below.
     * If the drop-up has enough room to fully open normally,
     * but there is more room above, the drop-up still opens
     * normally. Otherwise, it becomes a drop-up.
     * If dropupAuto is set to <code>false</code>, drop-ups
     * must be called manually.<br>
     * <br>
     * Defaults to <code>true</code>.
     *
     * @param dropupAuto
     */
    public void setDropupAuto(final boolean dropupAuto) {
        if (!dropupAuto)
            attrMixin.setAttribute(DROPUP_AUTO, Boolean.toString(false));
        else
            attrMixin.removeAttribute(DROPUP_AUTO);
    }

    /**
     * If drop-up auto is set to <code>false</code>, force to make
     * the select a drop-up menu if set to <code>true</code>.
     *
     * @param forceDropup
     * @see #setDropupAuto(boolean)
     */
    public void setForceDropup(final boolean forceDropup) {
        if (forceDropup) {
            addStyleName(SelectStyles.DROPUP);
        } else {
            removeStyleName(SelectStyles.DROPUP);
        }
    }

    /**
     * Adds a header to the top of the menu; includes
     * a close button by default.<br>
     * <br>
     * No header by default.
     *
     * @param header
     */
    public void setHeader(final String header) {
        if (header != null)
            attrMixin.setAttribute(HEADER, header);
        else
            attrMixin.removeAttribute(HEADER);
    }

    /**
     * Removes disabled options and optgroups from the menu<br>
     * <br>
     * Defaults to <code>false</code>.
     *
     * @param hideDisabled
     */
    public void setHideDisabled(final boolean hideDisabled) {
        if (hideDisabled)
            attrMixin.setAttribute(HIDE_DISABLED, Boolean.toString(true));
        else
            attrMixin.removeAttribute(HIDE_DISABLED);
    }

    /**
     * When set to <code>true</code>, adds a search box to the
     * top of the select picker drop-down.<br>
     * <br>
     * Defaults to <code>false</code>.
     *
     * @param liveSearch
     */
    public void setLiveSearch(final boolean liveSearch) {
        if (liveSearch)
            attrMixin.setAttribute(LIVE_SEARCH, Boolean.toString(true));
        else
            attrMixin.removeAttribute(LIVE_SEARCH);
    }

    /**
     * Setting liveSearchNormalize to <code>true</code> allows for
     * accent-insensitive searching.<br>
     * <br>
     * Defaults to <code>false</code>.
     *
     * @param liveSearchNormalize
     */
    public void setLiveSearchNormalize(final boolean liveSearchNormalize) {
        if (liveSearchNormalize)
            attrMixin.setAttribute(LIVE_SEARCH_NORMALIZE, Boolean.toString(true));
        else
            attrMixin.removeAttribute(LIVE_SEARCH_NORMALIZE);
    }

    /**
     * Set live search style.<br>
     * <br>
     * Defaults to {@link LiveSearchStyle#CONTAINS}.
     *
     * @param liveSearchStyle
     * @see LiveSearchStyle
     */
    public void setLiveSearchStyle(final LiveSearchStyle liveSearchStyle) {
        if (liveSearchStyle != null)
            attrMixin.setAttribute(LIVE_SEARCH_STYLE, liveSearchStyle.getValue());
        else
            attrMixin.removeAttribute(LIVE_SEARCH_STYLE);
    }

    /**
     * Set a placeholder to the live search input.<br>
     * <br>
     * Defaults to <code>null</code>.
     *
     * @param liveSearchPlaceholder
     */
    public void setLiveSearchPlaceholder(final String liveSearchPlaceholder) {
        if (liveSearchPlaceholder != null)
            attrMixin.setAttribute(LIVE_SEARCH_PLACEHOLDER, liveSearchPlaceholder);
        else
            attrMixin.removeAttribute(LIVE_SEARCH_PLACEHOLDER);
    }

    /**
     * When set to <code>true</code>, enables the device's native
     * menu for select menus.<br>
     * <br>
     * Defaults to <code>false</code>.
     *
     * @param mobile
     */
    public void setMobile(final boolean mobile) {
        if (mobile)
            attrMixin.setAttribute(MOBILE, Boolean.toString(true));
        else
            attrMixin.removeAttribute(MOBILE);
    }

    /**
     * When set to <code>true</code>, treats the tab character like the
     * <code>enter</code> or <code>Space</code> characters within the
     * select picker drop-down.<br>
     * <br>
     * Defaults to <code>false</code>.
     *
     * @param selectOnTab
     */
    public void setSelectOnTab(final boolean selectOnTab) {
        if (selectOnTab)
            attrMixin.setAttribute(SELECT_ON_TAB, Boolean.toString(true));
        else
            attrMixin.removeAttribute(SELECT_ON_TAB);
    }

    /**
     * When set to <code>true</code>, display custom HTML associated with
     * selected option(s) in the button. When set to <code>false</code>,
     * the option value will be displayed instead.<br>
     * <br>
     * Defaults to <code>true</code>.
     *
     * @param showContent
     */
    public void setShowContent(final boolean showContent) {
        if (!showContent)
            attrMixin.setAttribute(SHOW_CONTENT, Boolean.toString(false));
        else
            attrMixin.removeAttribute(SHOW_CONTENT);
    }

    /**
     * When set to <code>true</code>, display icon(s) associated with
     * selected option(s) in the button.<br>
     * <br>
     * Defaults to <code>true</code>.
     *
     * @param showIcon
     */
    public void setShowIcon(final boolean showIcon) {
        if (!showIcon)
            attrMixin.setAttribute(SHOW_ICON, Boolean.toString(false));
        else
            attrMixin.removeAttribute(SHOW_ICON);
    }

    /**
     * When set to <code>true</code>, display sub-text associated with a
     * selected option in the button.<br>
     * <br>
     * Defaults to <code>false</code>.
     *
     * @param showSubtext
     */
    public void setShowSubtext(final boolean showSubtext) {
        if (showSubtext)
            attrMixin.setAttribute(SHOW_SUBTEXT, Boolean.toString(true));
        else
            attrMixin.removeAttribute(SHOW_SUBTEXT);
    }

    /**
     * Specifies the number of visible menu items.<br>
     * <br>
     * Defaults to {@link MenuSize#AUTO}.
     *
     * @param size
     * @see MenuSize
     */
    public void setMenuSize(final MenuSize size) {
        if (size != null)
            attrMixin.setAttribute(SIZE, size.getValue());
        else
            attrMixin.removeAttribute(SIZE);
    }

    /**
     * The menu will show the given number of items, even if
     * the drop-down is cut off.<br>
     * <br>
     * Defaults to {@link MenuSize#AUTO}.
     *
     * @param size
     */
    public void setFixedMenuSize(final int size) {
        attrMixin.setAttribute(SIZE, Integer.toString(size));
    }

    /**
     * Sets the {@link ButtonType} of the select.<br>
     * <br>
     * <b>IMPORTANT</b>: This method will override the style set by
     * {@link #setStyle(String)}.
     */
    @Override
    public void setType(final ButtonType type) {
        this.type = type;
        updateStyle();
    }

    /**
     * Returns the {@link ButtonType} of the select; may be <code>null</code>.
     *
     * @return the {@link ButtonType} of the select
     */
    @Override
    public ButtonType getType() {
        return type;
    }

    /**
     * Sets the {@link ButtonSize} of the select.<br>
     * <br>
     * <b>IMPORTANT</b>: This method will override the style set by
     * {@link #setStyle(String)}.
     */
    @Override
    public void setSize(final ButtonSize size) {
        this.size = size;
        updateStyle();
    }

    /**
     * Returns the {@link ButtonSize} of the select; may be <code>null</code>.
     *
     * @return the {@link ButtonSize} of the select
     */
    @Override
    public ButtonSize getSize() {
        return size;
    }

    private void updateStyle() {
        StringBuilder sb = new StringBuilder();
        if (type != null) {
            sb.append(type.getCssName());
        }
        if (size != null) {
            if (!sb.toString().isEmpty()) {
                sb.append(" ");
            }
            sb.append(size.getCssName());
        }
        setStyle(sb.toString());
    }

    /**
     * Set the customized style name to the select.<br>
     * <br>
     * Defaults to <code>null</code>.<br>
     * <br>
     * <b>IMPORTANT</b>: This method will override the style set by
     * {@link #setType(ButtonType)} and/or {@link #setSize(ButtonSize)}.
     *
     * @param styleName
     */
    public void setStyle(final String styleName) {
        if (styleName != null)
            attrMixin.setAttribute(STYLE, styleName);
        else
            attrMixin.removeAttribute(STYLE);
    }

    /**
     * Returns the style name applied to the select.
     *
     * @return
     */
    public String getStyle() {
        return attrMixin.getAttribute(STYLE);
    }

    /**
     * Set the default placeholder text when nothing is selected.
     * This works for both multiple and standard select boxes.<br>
     * <br>
     * Defaults to <code>null</code>.
     *
     * @param title
     * @see #setTitle(String)
     */
    public void setPlaceholder(final String placeholder) {
        setTitle(placeholder);
    }

    /**
     * Set the specified width to the select.<br>
     * <br>
     * Defaults to {@link SelectWidth#NONE}.
     *
     * @param width
     * @see #setWidth(String)
     * @see SelectWidth
     */
    public void setSelectWidth(final SelectWidth width) {
        setWidth((width != null) ? width.getValue() : null);
    }

    /**
     * Set the select width witch is forced inline to the given value.
     *
     * @param cssWidth a CSS width with units, e.g. 100px
     */
    @Override
    public void setWidth(final String cssWidth) {
        if (cssWidth != null)
            attrMixin.setAttribute(WIDTH, cssWidth);
        else
            attrMixin.removeAttribute(WIDTH);
    }

    /**
     * Sets the window padding to all sides. This is useful in cases where
     * the window has areas that the drop-down menu should not cover - for
     * instance a fixed header.
     *
     * @param padding
     */
    public void setWindowPadding(final int padding) {
        attrMixin.setAttribute(WINDOW_PADDING, Integer.toString(padding));
    }

    /**
     * Sets the window padding to top, right, bottom, and right sides. This
     * is useful in cases where the window has areas that the drop-down menu
     * should not cover - for instance a fixed header.
     *
     * @param top
     * @param right
     * @param bottom
     * @param left
     */
    public void setWindowPaddingTopRightBottomLeft(final int top, final int right,
            final int bottom, final int left) {
        JsArrayNumber array = JavaScriptObject.createArray(4).cast();
        array.push(top);
        array.push(right);
        array.push(bottom);
        array.push(left);
        attrMixin.setAttribute(WINDOW_PADDING, JsonUtils.stringify(array));
    }

    /**
     * Set to <code>true</code> to add the Bootstrap menu arrow.
     *
     * @param showMenuArrow
     */
    public void setShowMenuArrow(final boolean showMenuArrow) {
        if (showMenuArrow) {
            addStyleName(SelectStyles.SHOW_MENU_ARROW);
        } else {
            removeStyleName(SelectStyles.SHOW_MENU_ARROW);
        }
    }

    @Override
    public LeafValueEditor<T> asEditor() {
        if (editor == null) {
            editor = TakesValueEditor.of(this);
        }
        return editor;
    }

    @Override
    public void setValue(final T value) {
        setValue(value, false);
    }

    @Override
    public void setValue(final T value, final boolean fireEvents) {

        T oldValue = fireEvents ? getValue() : null;

        setSelectedValue(value);

        if (fireEvents) {
            T newValue = getValue();
            ValueChangeEvent.fireIfNotEqual(this, oldValue, newValue);
        }
    }

    /**
     * Fires {@link ValueChangeEvent} with the current value.
     */
    private void onValueChange() {
        T newValue = getValue();
        ValueChangeEvent.fire(this, newValue);
    }

    /**
     * Selects the given value. If the value is <code>null</code>
     * or does not match any option, no option will be selected.
     *
     * @param value
     */
    protected abstract void setSelectedValue(final T value);

    @Override
    public void setEnabled(boolean enabled) {
        enabledMixin.setEnabled(enabled);
        refresh();
    }

    @Override
    public boolean isEnabled() {
        return enabledMixin.isEnabled();
    }

    @Override
    public int getTabIndex() {
        return focusImpl.getTabIndex(getFocusElement());
    }

    @Override
    public void setAccessKey(char key) {
        focusImpl.setAccessKey(getFocusElement(), key);
    }

    @Override
    public void setFocus(boolean focused) {
        if (focused) {
            focusImpl.focus(getFocusElement());
        } else {
            focusImpl.blur(getFocusElement());
        }
    }

    @Override
    public void setTabIndex(int index) {
        focusImpl.setTabIndex(getFocusElement(), index);
    }

    private Element getFocusElement() {
        if (!isAttached()) {
            return selectElement;
        }
        return getElement().getParentElement().getFirstChildElement();
    }

    /**
     * Returns the number of items present in the select.
     *
     * @return the number of items
     */
    public int getItemCount() {
        return selectElement.getOptions().getLength();
    }

    /**
     * Returns the item list.
     *
     * @return the item list
     */
    public List<Option> getItems() {
        List<Option> selectedItems = new ArrayList<>(0);
        NodeList<OptionElement> items = selectElement.getOptions();
        for (int i = 0; i < items.getLength(); i++) {
            OptionElement item = items.getItem(i);
            Option option = itemMap.get(item);
            if (option != null)
                selectedItems.add(option);
        }
        return selectedItems;
    }

    /**
     * Returns <code>true</code> if the item at the given index is selected.<br>
     * <br>
     * <b>Note</b>: if the item at the given index is a divider, this method
     * always returns <code>false</code>.
     *
     * @param index
     * @return
     */
    public boolean isItemSelected(final int index) {
        checkIndex(index);
        OptionElement item = selectElement.getOptions().getItem(index);
        Option option = itemMap.get(item);
        return option != null && option.isSelected();
    }

    /**
     * Returns the {@link Option} at the given index.
     *
     * @param index
     * @return
     */
    public Option getItem(final int index) {
        checkIndex(index);
        OptionElement item = selectElement.getOptions().getItem(index);
        return itemMap.get(item);
    }

    private void checkIndex(final int index) {
        int max = getItemCount();
        if (index < 0 || index >= max) {
            throw new IndexOutOfBoundsException("Index should be in [0, " + max + "]");
        }
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<T> handler) {
        return addHandler(handler, ValueChangeEvent.getType());
    }

    @Override
    public HandlerRegistration addLoadedHandler(LoadedHandler handler) {
        return addHandler(handler, LoadedEvent.getType());
    }

    @Override
    public HandlerRegistration addShowHandler(ShowHandler handler) {
        return addHandler(handler, ShowEvent.getType());
    }

    @Override
    public HandlerRegistration addShownHandler(ShownHandler handler) {
        return addHandler(handler, ShownEvent.getType());
    }

    @Override
    public HandlerRegistration addHideHandler(HideHandler handler) {
        return addHandler(handler, HideEvent.getType());
    }

    @Override
    public HandlerRegistration addHiddenHandler(HiddenHandler handler) {
        return addHandler(handler, HiddenEvent.getType());
    }

    @Override
    public HandlerRegistration addRenderedHandler(RenderedHandler handler) {
        return addHandler(handler, RenderedEvent.getType());
    }

    @Override
    public HandlerRegistration addRefreshedHandler(RefreshedHandler handler) {
        return addHandler(handler, RefreshedEvent.getType());
    }

    /**
     * Force a re-render of the bootstrap-select UI. This is useful if you programmatically
     * change any underlying values that affect the layout of the element.
     */
    public void render() {
        if (isAttached())
            command(getElement(), SelectCommand.RENDER);
    }

    /**
     * Toggles the select menu open/closed.
     */
    public void toggle() {
        if (isAttached())
            command(getElement(), SelectCommand.TOGGLE);
    }

    /**
     * Enables the device's native menu for select menus.
     */
    public void mobile() {
        if (isAttached())
            command(getElement(), SelectCommand.MOBILE);
    }

    /**
     * WHEN CHANGING ANY SETTINGS CALL REFRESH AFTER!!
     */
    public void refresh() {
        if (isAttached())
            command(getElement(), SelectCommand.REFRESH);
    }

    /**
     * Shows the select. This only affects the visibility of
     * the select itself.
     */
    public void show() {
        if (isAttached())
            command(getElement(), SelectCommand.SHOW);
        else
            super.setVisible(true);
    }

    /**
     * Hides the select. This only affects the visibility of
     * the select itself.
     */
    public void hide() {
        if (isAttached())
            command(getElement(), SelectCommand.HIDE);
        else
            super.setVisible(false);
    }

    @Override
    public void setVisible(boolean visible) {
        if (visible)
            show();
        else
            hide();
    }

    @Override
    public boolean isVisible() {
        if (isAttached()) {
            return isVisible(selectElement.getParentElement());
        }
        return super.isVisible();
    }

    private native void initialize(Element e, SelectOptions options) /*-{
        $wnd.jQuery(e).selectpicker(options);
    }-*/;

    /**
     * Binds the select events.
     *
     * @param e
     */
    private native void bindSelectEvents(Element e) /*-{
        var select = this;
        $wnd.jQuery(e).on(@org.gwtbootstrap3.extras.select.client.ui.event.HasAllSelectHandlers::LOADED_EVENT, function(event) {
            @org.gwtbootstrap3.extras.select.client.ui.event.LoadedEvent::fire(Lorg/gwtbootstrap3/extras/select/client/ui/event/HasLoadedHandlers;)(select);
        });
        $wnd.jQuery(e).on(@org.gwtbootstrap3.extras.select.client.ui.event.HasAllSelectHandlers::CHANGED_EVENT, function(event, clickedIndex, newValue, oldValue) {
            select.@org.gwtbootstrap3.extras.select.client.ui.SelectBase::onValueChange()();
        });
        $wnd.jQuery(e).on(@org.gwtbootstrap3.extras.select.client.ui.event.HasAllSelectHandlers::SHOW_EVENT, function(event) {
            @org.gwtbootstrap3.extras.select.client.ui.event.ShowEvent::fire(Lorg/gwtbootstrap3/extras/select/client/ui/event/HasShowHandlers;)(select);
        });
        $wnd.jQuery(e).on(@org.gwtbootstrap3.extras.select.client.ui.event.HasAllSelectHandlers::SHOWN_EVENT, function(event) {
            @org.gwtbootstrap3.extras.select.client.ui.event.ShownEvent::fire(Lorg/gwtbootstrap3/extras/select/client/ui/event/HasShownHandlers;)(select);
        });
        $wnd.jQuery(e).on(@org.gwtbootstrap3.extras.select.client.ui.event.HasAllSelectHandlers::HIDE_EVENT, function(event) {
            @org.gwtbootstrap3.extras.select.client.ui.event.HideEvent::fire(Lorg/gwtbootstrap3/extras/select/client/ui/event/HasHideHandlers;)(select);
        });
        $wnd.jQuery(e).on(@org.gwtbootstrap3.extras.select.client.ui.event.HasAllSelectHandlers::HIDDEN_EVENT, function(event) {
            @org.gwtbootstrap3.extras.select.client.ui.event.HiddenEvent::fire(Lorg/gwtbootstrap3/extras/select/client/ui/event/HasHiddenHandlers;)(select);
        });
        $wnd.jQuery(e).on(@org.gwtbootstrap3.extras.select.client.ui.event.HasAllSelectHandlers::RENDERED_EVENT, function(event) {
            @org.gwtbootstrap3.extras.select.client.ui.event.RenderedEvent::fire(Lorg/gwtbootstrap3/extras/select/client/ui/event/HasRenderedHandlers;)(select);
        });
        $wnd.jQuery(e).on(@org.gwtbootstrap3.extras.select.client.ui.event.HasAllSelectHandlers::REFRESHED_EVENT, function(event) {
            @org.gwtbootstrap3.extras.select.client.ui.event.RefreshedEvent::fire(Lorg/gwtbootstrap3/extras/select/client/ui/event/HasRefreshedHandlers;)(select);
        });
    }-*/;

    /**
     * Unbinds the select events.
     *
     * @param e
     */
    private native void unbindSelectEvents(Element e) /*-{
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.select.client.ui.event.HasAllSelectHandlers::LOADED_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.select.client.ui.event.HasAllSelectHandlers::CHANGED_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.select.client.ui.event.HasAllSelectHandlers::SHOW_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.select.client.ui.event.HasAllSelectHandlers::SHOWN_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.select.client.ui.event.HasAllSelectHandlers::HIDE_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.select.client.ui.event.HasAllSelectHandlers::HIDDEN_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.select.client.ui.event.HasAllSelectHandlers::RENDERED_EVENT);
        $wnd.jQuery(e).off(@org.gwtbootstrap3.extras.select.client.ui.event.HasAllSelectHandlers::REFRESHED_EVENT);
    }-*/;

    protected native void command(Element e, String command) /*-{
        $wnd.jQuery(e).selectpicker(command);
    }-*/;
}
