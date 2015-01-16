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

import org.gwtbootstrap3.extras.animate.client.ui.constants.Animation;

/**
 * This class represent basic Growl`s options, that you can use to customize display of each Growl.
 * <p/>
 * You can also set current state as default for all new Growls.
 *
 * @author jeffisenhart
 * @author Sven Jacobs
 * @author Joshua Godi
 * @author Pavel Zlámal
 * @see #makeDefault()
 */
public class GrowlOptions {

    /**
     * Set element name or class or ID to append Growl to. Default is 'body'.
     *
     * @param element Name, class or ID
     */
    public final native void setElement(String element) /*-{
        this.element = element;
    }-*/;

    /**
     * Set position of Growl on screen. Default position is TOP_RIGHT.
     *
     * @param position Growl`s position.
     * @see org.gwtbootstrap3.extras.growl.client.ui.GrowlPosition
     */
    public final void setPosition(final GrowlPosition position) {

        if (position != null) {
            setGrowlPosition(position.getPosition().split("-")[0],
                    position.getPosition().split("-")[1]);
        } else {
            setPosition(GrowlPosition.TOP_RIGHT);
        }

    }

    /**
     * Set native property of Growl`s position.
     *
     * @param vertical 'top' or 'bottom'
     * @param horizontal 'left', 'center' or 'right'
     */
    private native void setGrowlPosition(String vertical, String horizontal) /*-{
        this.placement = { from: vertical, align: horizontal };
    }-*/;

    /**
     * Allow display of dismiss button [X] in top right corner of Growl. Default is TRUE.
     *
     * @param allowDismiss TRUE = display dismiss button / FALSE = hide dismiss button
     */
    public final native void setAllowDismiss(boolean allowDismiss) /*-{
        this.allow_dismiss = allowDismiss;
    }-*/;

    /**
     * Set offset (space between Growl and screen/browser edges) for each axis. Default is 20 PX for both.
     *
     * @param offX Offset for X axis in PX
     * @param offY Offset for Y axis in PX
     */
    public final native void setOffset(int offX, int offY) /*-{
        this.offset = { x: offX, y: offY };
    }-*/;

    /**
     * Set custom spacing between two Growls. Default is 10 PX.
     *
     * @param space Spacing in PX
     */
    public final native void setSpacing(int space) /*-{
        this.spacing = space;
    }-*/;

    /**
     * Set custom Z-index. Default is 1031.
     *
     * @param zIndex Z-index
     */
    public final native void setZIndex(int zIndex) /*-{
        this.z_index = zIndex;
    }-*/;

    /**
     * Set delay, how long Growl stays on screen. Default is 5000 ms.
     * Set to zero for unlimited time.
     *
     * @param mDelay Delay in milliseconds or zero for unlimited
     */
    public final native void setDelay(int mDelay) /*-{
        this.delay = mDelay;
    }-*/;

    /**
     * Set timer. It's value is removed from remaining 'delay' on each 'timer' period.
     * This way you can speed up hiding of Growl. If timer > remaining delay, Growl is
     * hidden after delay runs out (ignoring timer).
     *
     * @param timer Time in milliseconds
     * @see #setDelay(int)
     */
    public final native void setTimer(int timer) /*-{
        this.timer = timer;
    }-*/;

    /**
     * Set custom URL target. Default is "_blank".
     * <p/>
     * See http://www.w3schools.com/tags/att_a_target.asp for possible values.
     *
     * @param urlTarget URL target
     */
    public final native void setUrlTarget(String urlTarget) /*-{
        this.url_target = urlTarget;
    }-*/;

    /**
     * Pause countdown of display timeout when mouse is hovering above the Growl.
     * Countdown continues (not restarted) if mouse leaves the Growl.
     *
     * @param pauseOnMouseOver TRUE = pause / FALSE = not pause
     */
    public final native void setPause(boolean pauseOnMouseOver) /*-{
        if (pauseOnMouseOver) {
            this.mouse_over = 'pause'
        } else {
            this.mouse_over = false;
        }
    }-*/;


    /**
     * Set Animation to Growl when it enters and exit the screen.
     *
     * Default is enter = Animation.FADE_IN_DOWN, exit = Animation.FADE_OUT_UP
     *
     * @see org.gwtbootstrap3.extras.animate.client.ui.constants.Animation
     *
     * @param enter animation style when Growl enters the screen
     * @param exit  animation style when Growl exists the screen
     */
    public final void setAnimation(Animation enter, Animation exit) {
        setAnimation((enter != null) ? enter.getCssName() : Animation.NO_ANIMATION.getCssName(),
                (exit != null) ? exit.getCssName() : Animation.NO_ANIMATION.getCssName());
    }

    /**
     * Set custom CSS style for animations of Growl when it enters and exits the screen.
     * You must write your own CSS animation definition.
     *
     * @param enter animation style when Growl enters the screen
     * @param exit  animation style when Growl exists the screen
     */
    public final native void setAnimation(String enter, String exit) /*-{
        this.animate = { enter: enter, exit: exit };
    }-*/;

    /**
     * Set type of icon you will use for Growl. Default is 'class', which
     * allows to use iconic fonts like FontAwesome.
     * If you want to use images instead of class, set value to "image".
     *
     * @param iconType "class" or "image"
     */
    public final native void setIconType(String iconType) /*-{
        this.icon_type = iconType;
    }-*/;

    /**
     * Set custom HTML Template of Growl. Default value is:
     * <p/>
     *
     * &lt;div data-growl="container" class="alert" role="alert"&gt;<br/>
     * &nbsp;&nbsp;&lt;button type="button" class="close" data-growl="dismiss"&gt;<br/>
     * &nbsp;&nbsp;&nbsp;&nbsp;&lt;span aria-hidden="true"&gt;×&lt;/span&gt;<br/>
     * &nbsp;&nbsp;&nbsp;&nbsp;&lt;span class="sr-only"&gt;Close&lt;/span&gt;<br/>
     * &nbsp;&nbsp;&lt;/button&gt;<br/>
     * &nbsp;&nbsp;&lt;span data-growl="icon"&gt;&lt;/span&gt;<br/>
     * &nbsp;&nbsp;&lt;span data-growl="title"&gt;&lt;/span&gt;<br/>
     * &nbsp;&nbsp;&lt;span data-growl="message"&gt;&lt;/span&gt;<br/>
     * &nbsp;&nbsp;&lt;a href="#" data-growl="url"&gt;&lt;/a&gt;<br/>
     * &lt;/div&gt;
     *
     * <p/>
     * See documentation at: http://bootstrap-growl.remabledesigns.com/
     *
     * @param html Custom HTML template
     */
    public final native void setTemplate(String html) /*-{
        this.template = html;
    }-*/;

    /**
     * Make this GrowlOptions setting as default for all new Growls.
     * <p/>
     * Values set to this GrowlOptions overrides original default values.
     * If value for some property is not set, original default value is kept.
     */
    public final native void makeDefault() /*-{
        $wnd.jQuery.growl(false, this);
    }-*/;

    /**
     * Set type of Growl (CSS style class name). Default is INFO.
     *
     * @param type one of INFO, WARNING, DANGER, SUCCESS
     * @see org.gwtbootstrap3.extras.growl.client.ui.GrowlType
     */
    public final void setType(final GrowlType type) {
        if (type != null) {
            setType(type.getCssName());
        }
    }

    /**
     * Set custom style name to Growl. Resulting class name is "alert-[customType]".
     *
     * @param customType Style name to set
     */
    public final native void setType(String customType) /*-{
        this.type = customType;
    }-*/;

}