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

/**
 * This enum represents Summernote toolbar buttons.
 *
 * @author Xiaodong SUN
 */
public enum ToolbarButton {

	/* Insert */
	PICTURE("picture"),
	LINK("link"),
	VIDEO("video"),
	TABLE("table"),
	HR("hr"),

	/* Font Style */
	FONT_NAME("fontname"),
	FONT_SIZE("fontsize"),
	COLOR("color"),
	BOLD("bold"),
	ITALIC("italic"),
	UNDERLINE("underline"),
	STRIKETHROUGH("strikethrough"),
	CLEAR("clear"),

	/* Paragraph Style */
	STYLE("style"),
	OL("ol"),
	UL("ul"),
	PARAGRAPH("paragraph"),
	HEIGHT("height"),

	/* Misc */
	FULL_SCREEN("fullscreen"),
	CODE_VIEW("codeview"),
	UNDO("undo"),
	REDO("redo"),
	HELP("help"),
	;

	private final String id;

	private ToolbarButton(String id) {
		this.id = id;
	}

	/**
	 *
	 * @return
	 */
	public String getId() {
		return id;
	}

}
