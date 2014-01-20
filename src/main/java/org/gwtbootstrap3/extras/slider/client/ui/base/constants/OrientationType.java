package org.gwtbootstrap3.extras.slider.client.ui.base.constants;

public enum OrientationType {
    HORIZONTAL("horizontal"),
    VERTICAL("vertical");

    private final String type;

    private OrientationType(final String type) {
        this.type = type;
    }


    public String getType() {
        return type;
    }
}
