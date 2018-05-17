/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.cognitiveservices;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for Kind.
 */
public final class Kind {
    /** Static value Academic for Kind. */
    public static final Kind ACADEMIC = new Kind("Academic");

    /** Static value Bing.Autosuggest for Kind. */
    public static final Kind BING_AUTOSUGGEST = new Kind("Bing.Autosuggest");

    /** Static value Bing.Search for Kind. */
    public static final Kind BING_SEARCH = new Kind("Bing.Search");

    /** Static value Bing.Speech for Kind. */
    public static final Kind BING_SPEECH = new Kind("Bing.Speech");

    /** Static value Bing.SpellCheck for Kind. */
    public static final Kind BING_SPELL_CHECK = new Kind("Bing.SpellCheck");

    /** Static value ComputerVision for Kind. */
    public static final Kind COMPUTER_VISION = new Kind("ComputerVision");

    /** Static value ContentModerator for Kind. */
    public static final Kind CONTENT_MODERATOR = new Kind("ContentModerator");

    /** Static value CustomSpeech for Kind. */
    public static final Kind CUSTOM_SPEECH = new Kind("CustomSpeech");

    /** Static value Emotion for Kind. */
    public static final Kind EMOTION = new Kind("Emotion");

    /** Static value Face for Kind. */
    public static final Kind FACE = new Kind("Face");

    /** Static value LUIS for Kind. */
    public static final Kind LUIS = new Kind("LUIS");

    /** Static value Recommendations for Kind. */
    public static final Kind RECOMMENDATIONS = new Kind("Recommendations");

    /** Static value SpeakerRecognition for Kind. */
    public static final Kind SPEAKER_RECOGNITION = new Kind("SpeakerRecognition");

    /** Static value Speech for Kind. */
    public static final Kind SPEECH = new Kind("Speech");

    /** Static value SpeechTranslation for Kind. */
    public static final Kind SPEECH_TRANSLATION = new Kind("SpeechTranslation");

    /** Static value TextAnalytics for Kind. */
    public static final Kind TEXT_ANALYTICS = new Kind("TextAnalytics");

    /** Static value TextTranslation for Kind. */
    public static final Kind TEXT_TRANSLATION = new Kind("TextTranslation");

    /** Static value WebLM for Kind. */
    public static final Kind WEB_LM = new Kind("WebLM");

    private String value;

    /**
     * Creates a custom value for Kind.
     * @param value the custom value
     */
    public Kind(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Kind)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Kind rhs = (Kind) obj;
        if (value == null) {
            return rhs.value == null;
        } else {
            return value.equals(rhs.value);
        }
    }
}