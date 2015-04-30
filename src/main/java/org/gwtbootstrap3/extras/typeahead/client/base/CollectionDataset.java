package org.gwtbootstrap3.extras.typeahead.client.base;

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

import java.util.ArrayList;
import java.util.Collection;

/**
 * A Dataset operating on a collection of values.
 *
 * @author Florian Kremser <florian.kremser@sage.com>
 */
public class CollectionDataset<T> extends Dataset<T> {
    private Collection<T> data;

    public CollectionDataset(final Collection<T> data) {
        setData(data);
    }

    public Collection<T> getData() {
        return data;
    }

    public void setData(final Collection<T> data) {
        this.data = data;
    }

    /**
     * Return the (display) value associated with a particular datum. If the
     * given datum is selected from the suggestions, then value will be set as
     * text of the input.
     *
     * @param datum a datum instance from this {@link Dataset}
     * @return the text representing the data
     */
    public String getValue(final T datum) {
        return datum != null ? datum.toString() : "";
    }

    @Override
    public void findMatches(final String query, final SuggestionCallback<T> callback) {
        String queryLower = query.toLowerCase();
        Collection<Suggestion<T>> suggestions = new ArrayList<Suggestion<T>>();
        if (data != null) {
              for (T datum : data) {
                  String value = getValue(datum);
                      if (value.toLowerCase().contains(queryLower)) {
                          Suggestion<T> suggestion = Suggestion.create(value, datum, this);
                          suggestions.add(suggestion);
                      }
              }
        }
        callback.execute(suggestions);
    }
}
