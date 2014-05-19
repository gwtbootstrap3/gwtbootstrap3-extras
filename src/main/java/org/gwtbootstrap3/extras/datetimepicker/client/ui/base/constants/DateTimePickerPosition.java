package org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants;

/**
 * Position to display the DateTimePicker popup
 *
 * @author Joshua Godi
 */
public enum DateTimePickerPosition {
    TOP_LEFT("top-left"),
    TOP_RIGHT("top-right"),
    BOTTOM_LEFT("bottom-left"),
    BOTTOM_RIGHT("bottom-right");

    private final String position;

    DateTimePickerPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
}
