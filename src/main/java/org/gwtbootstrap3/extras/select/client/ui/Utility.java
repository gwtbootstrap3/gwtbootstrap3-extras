package org.gwtbootstrap3.extras.select.client.ui;
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
 * 
 * @author Gianluca Pellegrini
 */
public class Utility
{
	private static final char[]	CHARS	= "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

	/**
	 * Generate a RFC4122, version 4 ID. Example: "92329D39-6F5C-4520-ABFC-AAB64544E172"
	 */
	public static String uuid()
	{
		char[] uuid = new char[36];
		int r;
		// rfc4122 requires these characters
		uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
		uuid[14] = '4';
		// Fill in random data. At i==19 set the high bits of clock sequence as
		// per rfc4122, sec. 4.1.5
		for (int i = 0; i < 36; i++)
		{
			if (uuid[i] == 0)
			{
				r = (int) (Math.random() * 16);
				uuid[i] = Utility.CHARS[(i == 19) ? (r & 0x3) | 0x8 : r & 0xf];
			}
		}
		return new String(uuid);
	}
}
