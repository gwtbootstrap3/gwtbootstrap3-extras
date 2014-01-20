package org.gwtbootstrap3.extras.slider.client.ui.base.constants;

public enum TooltipType {
    SHOW("show"),
    HIDE("hide"),
    ALWAYS("always");

    private final String type;

    private TooltipType(final String type) {
        this.type = type;
    }


    public String getType() {
        return type;
    }

}
