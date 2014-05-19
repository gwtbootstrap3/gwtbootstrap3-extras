package org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants;

/**
 * Default: BOTTOM_RIGHT
 *
 * @author Joshua Godi
 */
public interface HasPosition {
    /**
     * Set the position of the date time picker
     *
     * @param position position
     */
    void setPosition(DateTimePickerPosition position);

    /**
     * Gets the position of the date time picker
     *
     * @return position
     */
    DateTimePickerPosition getPosition();
}
