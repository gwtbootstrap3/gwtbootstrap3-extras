package org.gwtbootstrap3.extras.slider.client.ui.base.constants;

public enum SelectionType {
    BEFORE("before"),
    AFTER("after"),
    NONE("none");

    private final String type;

    private SelectionType(final String type) {
        this.type = type;
    }


    public String getType() {
        return type;
    }

}
