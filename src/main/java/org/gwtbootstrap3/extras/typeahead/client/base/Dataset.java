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


/**
 * A Dataset represents a collection of suggestion objects for a Typeahead.
 * A Typeahead is composed of one or more Datasets. When an end-user modifies
 * the value of a Typeahead, each Dataset will attempt to render suggestions
 * for the new value.
 *
 * @author Florian Kremser <florian.kremser@sage.com>
 */
public abstract class Dataset<T> {
    private static long nextId = 0;
    private String name;
    private Template emptyTemplate;
    private Template footerTemplate;
    private Template headerTemplate;
    private SuggestionTemplate<T> suggestionTemplate;

    protected Dataset() {
        this.name = "dataset" + nextId++;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Rendered when 0 suggestions are available for the given query.
     *
     * @return a template to render in case of 0 results
     */
    public Template getEmptyTemplate() {
        return emptyTemplate;
    }

    public void setEmptyTemplate(final Template emptyTemplate) {
        this.emptyTemplate = emptyTemplate;
    }

    /**
     * Rendered at the bottom of the dataset.
     *
     * @return a template to render at the bottom of the dataset
     */
    public Template getFooterTemplate() {
        return footerTemplate;
    }

    public void setFooterTemplate(final Template footerTemplate) {
        this.footerTemplate = footerTemplate;
    }

    /**
     * Rendered at the top of the dataset.
     *
     * @return a template to render at the top of the dataset
     */
    public Template getHeaderTemplate() {
        return headerTemplate;
    }

    public void setHeaderTemplate(final Template headerTemplate) {
        this.headerTemplate = headerTemplate;
    }

    /**
     * Renders a single suggestion.
     *
     * @return a template for rendering suggestions
     */
    public SuggestionTemplate<T> getSuggestionTemplate() {
        return suggestionTemplate;
    }

    public void setSuggestionTemplate(final SuggestionTemplate<T> suggestionTemplate) {
        this.suggestionTemplate = suggestionTemplate;
    }

    /**
     * Find all Suggestions matching a search query and pass them to the callback.
     *
     * @param query    the user input
     * @param callback callback for suggestions
     */
    public abstract void findMatches(final String query, final SuggestionCallback<T> callback);

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dataset<?> dataset = (Dataset<?>) o;
        if (name != null ? !name.equals(dataset.name) : dataset.name != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
