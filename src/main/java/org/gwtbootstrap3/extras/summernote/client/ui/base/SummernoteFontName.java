package org.gwtbootstrap3.extras.summernote.client.ui.base;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2016 GwtBootstrap3
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
 * Summernote font name
 *
 * @author Xiaodong Sun
 */
public class SummernoteFontName {

    // Built-in font names
    public static final SummernoteFontName ARIAL = new SummernoteFontName("Arial");
    public static final SummernoteFontName ARIAL_BLACK = new SummernoteFontName("Arial Black");
    public static final SummernoteFontName COMIC_SANS_MS = new SummernoteFontName("Comic Sans MS");
    public static final SummernoteFontName COURIER_NEW = new SummernoteFontName("Courier New");
    public static final SummernoteFontName HELVETICA_NEUE = new SummernoteFontName("Helvetica Neue");
    public static final SummernoteFontName HELVETICA = new SummernoteFontName("Helvetica");
    public static final SummernoteFontName IMPACT = new SummernoteFontName("Impact");
    public static final SummernoteFontName LUCIDA_GRANDE = new SummernoteFontName("Lucida Grande");
    public static final SummernoteFontName TAHOMA = new SummernoteFontName("Tahoma");
    public static final SummernoteFontName TIMES_NEW_ROMAN = new SummernoteFontName("Times New Roman");
    public static final SummernoteFontName VERDANA = new SummernoteFontName("Verdana");

    private final String name;

    /**
     * Creates a new font name.
     *
     * @param name
     */
    public SummernoteFontName(String name) {
        this.name = name;
    }

    /**
     * Returns the font name.
     *
     * @return the font name
     */
    public String getName() {
        return name;
    }

}
