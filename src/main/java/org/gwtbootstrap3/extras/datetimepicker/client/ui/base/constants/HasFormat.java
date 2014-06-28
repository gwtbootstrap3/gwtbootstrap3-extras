package org.gwtbootstrap3.extras.datetimepicker.client.ui.base.constants;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 GwtBootstrap3
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
 * String. Default: 'mm/dd/yyyy'
 * <p/>
 * The date format, combination of p, P, h, hh, i, ii, s, ss, d, dd, m, mm, M, MM, yy, yyyy.
 * p : meridian in lower case ('am' or 'pm') - according to locale file
 * P : meridian in upper case ('AM' or 'PM') - according to locale file
 * s : seconds without leading zeros
 * ss : seconds, 2 digits with leading zeros
 * i : minutes without leading zeros
 * ii : minutes, 2 digits with leading zeros
 * h : hour without leading zeros - 24-hour format
 * hh : hour, 2 digits with leading zeros - 24-hour format
 * H : hour without leading zeros - 12-hour format
 * HH : hour, 2 digits with leading zeros - 12-hour format
 * d : day of the month without leading zeros
 * dd : day of the month, 2 digits with leading zeros
 * m : numeric representation of month without leading zeros
 * mm : numeric representation of the month, 2 digits with leading zeros
 * M : short textual representation of a month, three letters
 * MM : full textual representation of a month, such as January or March
 * yy : two digit representation of a year
 * yyyy : full numeric representation of a year, 4 digits
 *
 * @author Joshua Godi
 */
public interface HasFormat {
    void setFormat(String format);
}
