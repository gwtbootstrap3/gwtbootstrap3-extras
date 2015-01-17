package org.gwtbootstrap3.extras.growl.client.ui;

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
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.Styles;

/**
 * This class represent instance of displayed Growl.
 * <p/>
 * You can display new Growl using static methods, e.g.:
 * {@see #growl(String)},
 * {@see #growl(String, GrowlType)},
 * {@see #growl(String, GrowlOptions)} and others
 * <p/>
 * To further configure Growl before displaying see:
 * {@see org.gwtbootstrap3.extras.growl.client.ui.GrowlOptions}
 * <p/>
 * You can update displayed Growl by:
 * {@see #updateTitle(String)},
 * {@see #updateMessage(String)},
 * {@see #updateIcon(String)},
 * {@see #updateType(GrowlType)},
 * <p/>
 * You can hide displayed Growl:
 * {@see #hide()},
 * {@see #hideAll()},
 * {@see #hideAll(GrowlPosition)}
 *
 * @author jeffisenhart
 * @author Sven Jacobs
 * @author Joshua Godi
 * @author Pavel Zlámal
 */
public class Growl extends JavaScriptObject {

    protected Growl() {
    }

    /**
     * Display Growl with custom message and default settings.
     *
     * @param message Message to set
     * @return Displayed Growl for update or hiding.
     */
    public static final native Growl growl(final String message) /*-{
        return $wnd.jQuery.growl({ message: message }, null);
    }-*/;

    /**
     * Display Growl with custom title, message and default settings.
     *
     * @param title   Title to set
     * @param message Message to set
     * @return Displayed Growl for update or hiding.
     */
    public static final native Growl growl(final String title, final String message) /*-{
        return $wnd.jQuery.growl({ title: title, message: message }, null);
    }-*/;

    /**
     * Display Growl with custom title, message, icon and default settings.
     *
     * @param title   Title to set
     * @param message Message to set
     * @param icon    Icon to set
     * @return Displayed Growl for update or hiding.
     */
    public static final native Growl growl(final String title, final String message, final String icon) /*-{
        return $wnd.jQuery.growl({ title: title, message: message, icon: icon }, null);
    }-*/;

    /**
     * Display Growl with custom title, message, icon and default settings.
     *
     * @param title    Title to set
     * @param message  Message to set
     * @param iconType IconType to set
     * @return Displayed Growl for update or hiding.
     */
    public static final Growl growl(final String title, final String message, final IconType iconType) {
        return Growl.growl(title, message, Styles.FONT_AWESOME_BASE + " " + iconType.getCssName());
    }

    /**
     * Display Growl with custom title, message, icon and default settings.
     *
     * @param title   Title to set
     * @param message Message to set
     * @param icon    IconType to set
     * @param url     Url to set
     * @return Displayed Growl for update or hiding.
     */
    public static final native Growl growl(final String title, final String message, final String icon, final String url) /*-{
        return $wnd.jQuery.growl({ title: title, message: message, icon: icon, url: url }, null);
    }-*/;

    /**
     * Display Growl with custom title, message, icon, url and default settings.
     *
     * @param title    Title to set
     * @param message  Message to set
     * @param iconType IconType to set
     * @param url      Url to set
     * @return Displayed Growl for update or hiding.
     */
    public static final Growl growl(final String title, final String message, final IconType iconType, final String url) {
        return Growl.growl(title, message, Styles.FONT_AWESOME_BASE + " " + iconType.getCssName(), url);
    }

    /**
     * Display Growl with custom message, type and default settings.
     *
     * @param message Message to set
     * @param type    GrowlType
     * @return Displayed Growl for update or hiding.
     * @see org.gwtbootstrap3.extras.growl.client.ui.GrowlType
     */
    public static final native Growl growl(final String message, final GrowlType type) /*-{
        return $wnd.jQuery.growl({ message: message }, { type: type.@org.gwtbootstrap3.extras.growl.client.ui.GrowlType::getCssName()() });
    }-*/;

    /**
     * Display Growl with custom title, message, type and default settings.
     *
     * @param title   Title to set
     * @param message Message to set
     * @param type    GrowlType
     * @return Displayed Growl for update or hiding.
     * @see org.gwtbootstrap3.extras.growl.client.ui.GrowlType
     */
    public static final native Growl growl(final String title, final String message, final GrowlType type) /*-{
        return $wnd.jQuery.growl({ title: title, message: message }, { type: type.@org.gwtbootstrap3.extras.growl.client.ui.GrowlType::getCssName()() });
    }-*/;

    /**
     * Display Growl with custom title, message, icon, type and default settings.
     *
     * @param title   Title to set
     * @param message Message to set
     * @param icon    Icon to set
     * @param type    GrowlType
     * @return Displayed Growl for update or hiding.
     * @see org.gwtbootstrap3.extras.growl.client.ui.GrowlType
     */
    public static final native Growl growl(final String title, final String message, final String icon, final GrowlType type) /*-{
        return $wnd.jQuery.growl({ title: title, message: message, icon: icon }, { type: type.@org.gwtbootstrap3.extras.growl.client.ui.GrowlType::getCssName()() });
    }-*/;

    /**
     * Display Growl with custom title, message, icon, type and default settings.
     *
     * @param title    Title to set
     * @param message  Message to set
     * @param iconType IconType to set (css name of icon form FONT AWESOME)
     * @param type     GrowlType
     * @return Displayed Growl for update or hiding.
     * @see org.gwtbootstrap3.extras.growl.client.ui.GrowlType
     */
    public static final Growl growl(final String title, final String message, final IconType iconType, final GrowlType type) {
        return Growl.growl(title, message, Styles.FONT_AWESOME_BASE + " " + iconType.getCssName(), type);
    }

    /**
     * Display Growl with custom title, message, icon, url, type and default settings.
     *
     * @param title   Title to set
     * @param message Message to set
     * @param icon    Icon to set
     * @param url     Url to set
     * @param type    GrowlType
     * @return Displayed Growl for update or hiding.
     * @see org.gwtbootstrap3.extras.growl.client.ui.GrowlType
     */
    public static final native Growl growl(final String title, final String message, final String icon, final String url, final GrowlType type) /*-{
        return $wnd.jQuery.growl({ title: title, message: message, icon: icon, url: url }, { type: type.@org.gwtbootstrap3.extras.growl.client.ui.GrowlType::getCssName()() });
    }-*/;

    /**
     * Display Growl with custom title, message, icon, url, type and default settings.
     *
     * @param title    Title to set
     * @param message  Message to set
     * @param iconType IconType to set (css name of icon form FONT AWESOME)
     * @param url      Url to set
     * @param type     GrowlType
     * @return Displayed Growl for update or hiding.
     * @see org.gwtbootstrap3.extras.growl.client.ui.GrowlType
     */
    public static final Growl growl(final String title, final String message, final IconType iconType, final String url, final GrowlType type) {
        return Growl.growl(title, message, Styles.FONT_AWESOME_BASE + " " + iconType.getCssName(), url, type);
    }

    /**
     * Display Growl with custom message and custom settings.
     *
     * @param message Message to set
     * @param options custom options
     * @return Displayed Growl for update or hiding.
     * @see org.gwtbootstrap3.extras.growl.client.ui.GrowlOptions
     */
    public static final native Growl growl(final String message, final GrowlOptions options) /*-{
        console.log(options);
        return $wnd.jQuery.growl({ message: message }, options);
    }-*/;

    /**
     * Display Growl with custom title, message and custom settings.
     *
     * @param title   Title to set
     * @param message Message to set
     * @param options custom options
     * @return Displayed Growl for update or hiding.
     * @see org.gwtbootstrap3.extras.growl.client.ui.GrowlOptions
     */
    public static final native Growl growl(final String title, final String message, final GrowlOptions options) /*-{
        return $wnd.jQuery.growl({ title: title, message: message }, options);
    }-*/;

    /**
     * Display Growl with custom title, message, icon and custom settings.
     *
     * @param title   Title to set
     * @param message Message to set
     * @param icon    Icon to set
     * @param options custom options
     * @return Displayed Growl for update or hiding.
     * @see org.gwtbootstrap3.extras.growl.client.ui.GrowlOptions
     */
    public static final native Growl growl(final String title, final String message, final String icon, final GrowlOptions options) /*-{
        return $wnd.jQuery.growl({ title: title, message: message, icon: icon }, options);
    }-*/;

    /**
     * Display Growl with custom title, message, icon and custom settings.
     *
     * @param title    Title to set
     * @param message  Message to set
     * @param iconType IconType to set (css name of icon form FONT AWESOME)
     * @param options  custom options
     * @return Displayed Growl for update or hiding.
     * @see org.gwtbootstrap3.extras.growl.client.ui.GrowlOptions
     */
    public static final Growl growl(final String title, final String message, final IconType iconType, final GrowlOptions options) {
        return Growl.growl(title, message, Styles.FONT_AWESOME_BASE + " " + iconType.getCssName(), options);
    }

    /**
     * Display Growl with custom title, message, icon, URL and custom settings.
     *
     * @param title   Title to set
     * @param message Message to set
     * @param icon    Icon to set
     * @param url     Url to set
     * @param options custom options
     * @return Displayed Growl for update or hiding.
     * @see org.gwtbootstrap3.extras.growl.client.ui.GrowlOptions
     */
    public static final native Growl growl(final String title, final String message, final String icon, final String url, final GrowlOptions options) /*-{
        return $wnd.jQuery.growl({ title: title, message: message, icon: icon, url: url}, options);
    }-*/;

    /**
     * Display Growl with custom title, message, icon, URL and custom settings.
     *
     * @param title    Title to set
     * @param message  Message to set
     * @param iconType IconType to set
     * @param url      Url to set
     * @param options  custom options
     * @return Displayed Growl for update or hiding.
     * @see org.gwtbootstrap3.extras.growl.client.ui.GrowlOptions
     */
    public static final Growl growl(final String title, final String message, final IconType iconType, final String url, final GrowlOptions options) {
        return Growl.growl(title, message, Styles.FONT_AWESOME_BASE + " " + iconType.getCssName(), url, options);
    }

    /**
     * Hide all displayed Growls.
     */
    public static final void hideAll() {
        hideAllGrowls(null);
    }

    /**
     * Hide all displayed Growls on specific screen location.
     *
     * @param position Growls position on screen.
     * @see org.gwtbootstrap3.extras.growl.client.ui.GrowlPosition
     */
    public static final void hideAll(GrowlPosition position) {
        if (position != null) {
            hideAllGrowls(position.getPosition());
        }
    }

    /**
     * Hide all displayed Growls, optionally only on specified position.
     *
     * @param position
     */
    private static final native void hideAllGrowls(String position) /*-{

        if (position !== null) {
            $wnd.jQuery.growl(false, {
                command: 'closeAll',
                position: position
            });
        } else {
            $wnd.jQuery.growl(false, {
                command: 'closeAll'
            });
        }

    }-*/;

    /**
     * Updates title parameter of once displayed Growl.
     *
     * @param title Title to set
     */
    public final native void updateTitle(String title) /*-{
        this.update('title', title);
    }-*/;

    /**
     * Updates message parameter of once displayed Growl.
     *
     * @param message Message to set
     */
    public final native void updateMessage(String message) /*-{
        this.update('message', message);
    }-*/;

    /**
     * Updates Icon parameter of once displayed Growl.
     *
     * @param icon Icon to set
     */
    public final native void updateIcon(String icon) /*-{
        this.update('icon', icon);
    }-*/;

    /**
     * Updates Icon parameter of once displayed Growl.
     * This method is shortcut when using FONT AWESOME iconic font.
     *
     * @param type IconType to get CSS class name to set
     */
    public final void updateIcon(final IconType type) {
        if (type != null) updateIcon(Styles.FONT_AWESOME_BASE + " " + type.getCssName());
    }

    /**
     * Update type of once displayed Growl (CSS style class name).
     *
     * @param type one of INFO, WARNING, DANGER, SUCCESS
     * @see org.gwtbootstrap3.extras.growl.client.ui.GrowlType
     */
    public final void updateType(final GrowlType type) {
        if (type != null) {
            updateType(type.getCssName());
        }
    }

    /**
     * Update type of once displayed Growl (CSS style class name).
     * Resulting class name to use is "alert-[type]".
     *
     * @param type CSS class name to set
     */
    private final native void updateType(String type) /*-{
        this.update('type', type);
    }-*/;

    /**
     * Hide this Growl.
     */
    public final native void hide() /*-{
        this.close();
    }-*/;

}