package org.gwtbootstrap3.extras.slider.client.ui.base.constants;

public enum HandleType {
    ROUND("round"),
    SQUARE("square"),
    TRIANGLE("triangle");

    private final String type;

    private HandleType(final String type) {
        this.type = type;
    }


    public String getType() {
        return type;
    }

}
