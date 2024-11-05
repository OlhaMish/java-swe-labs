package com.olechok.lab4.components;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a text composed of multiple sentences.
 */
public class Text {
    private final List<Sentence> sentences;

    /**
     * Constructs a Text object from a string, parsing it into sentences.
     *
     * @param text The text as a string.
     */
    public Text(String text) {
        sentences = new ArrayList<>();
        String[] sentencesArray = text.split("(?<=[.!?])\\s+");
        for (String sentence : sentencesArray) {
            sentences.add(new Sentence(sentence.trim()));
        }
    }

    /**
     * Converts the text to a string representation.
     *
     * @return The string representation of the text.
     */
    @Override
    public String toString() {
        List<String> parts = new ArrayList<>();

        for (Sentence sentence : sentences) {
            parts.add(sentence.toString());
        }

        return String.join(" ", parts).trim();
    }

    /**
     * Replaces words of the specified length in all sentences with a replacement string.
     *
     * @param length      The length of the words to replace.
     * @param replacement The replacement string.
     */
    public void replaceWordsOfLength(int length, String replacement) {
        for (Sentence sentence : sentences) {
            sentence.replaceWordsOfLengthInSentence(length, replacement);
        }
    }
}
