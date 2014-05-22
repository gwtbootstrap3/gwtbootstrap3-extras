package org.gwtbootstrap3.extras.growl.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface GrowlClientBundle extends ClientBundle {

    static final GrowlClientBundle INSTANCE = GWT.create(GrowlClientBundle.class);

    @Source("resource/js/bootstrap-growl.min.js")
    TextResource growlJS();
}
