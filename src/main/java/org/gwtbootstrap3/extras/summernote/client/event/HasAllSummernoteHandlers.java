package org.gwtbootstrap3.extras.summernote.client.event;

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
 * Convenience interface used to implement all summernote handlers at once.
 *
 * @author Xiaodong Sun
 */
public interface HasAllSummernoteHandlers extends HasSummernoteInitHandlers,
        HasSummernoteEnterHandlers, HasSummernoteFocusHandlers, HasSummernoteBlurHandlers,
        HasSummernoteKeyUpHandlers, HasSummernoteKeyDownHandlers, HasSummernotePasteHandlers,
        HasSummernoteImageUploadHandlers, HasSummernoteChangeHandlers {

    static final String SUMMERNOTE_PREFIX = "summernote.";

    /**
     * The {@link SummernoteInitEvent} name
     */
    static final String SUMMERNOTE_INIT_EVENT = SUMMERNOTE_PREFIX + "init";

    /**
     * The {@link SummernoteEnterEvent} name
     */
    static final String SUMMERNOTE_ENTER_EVENT = SUMMERNOTE_PREFIX + "enter";

    /**
     * The {@link SummernoteFocusEvent} name
     */
    static final String SUMMERNOTE_FOCUS_EVENT = SUMMERNOTE_PREFIX + "focus";

    /**
     * The {@link SummernoteBlurEvent} name
     */
    static final String SUMMERNOTE_BLUR_EVENT = SUMMERNOTE_PREFIX + "blur";

    /**
     * The {@link SummernoteKeyUpEvent} name
     */
    static final String SUMMERNOTE_KEYUP_EVENT = SUMMERNOTE_PREFIX + "keyup";

    /**
     * The {@link SummernoteKeyDownEvent} name
     */
    static final String SUMMERNOTE_KEYDOWN_EVENT = SUMMERNOTE_PREFIX + "keydown";

    /**
     * The {@link SummernotePasteEvent} name
     */
    static final String SUMMERNOTE_PASTE_EVENT = SUMMERNOTE_PREFIX + "paste";

    /**
     * The {@link SummernoteImageUploadEvent} name
     */
    static final String SUMMERNOTE_IMAGE_UPLOAD_EVENT = SUMMERNOTE_PREFIX + "image.upload";

    /**
     * The {@link SummernoteChangeEvent} name
     */
    static final String SUMMERNOTE_CHANGE_EVENT = SUMMERNOTE_PREFIX + "change";

}
