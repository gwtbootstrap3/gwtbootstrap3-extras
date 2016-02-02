package org.gwtbootstrap3.extras.summernote.client.ui.base;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2015 GwtBootstrap3
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

import org.gwtbootstrap3.client.ui.html.Text;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Node;

/**
 * This hint handler provides a default implementation of
 * the template and content options.
 *
 * @author Xiaodong Sun
 */
public abstract class DefaultHintHandler implements HintHandler {

    @Override
    public String getTemplate(String item) {
        return item;
    }

    @Override
    public Node getContent(String item) {new Text(item);
        return Document.get().createTextNode(item);
    }

}
