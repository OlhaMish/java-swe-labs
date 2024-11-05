package com.olechok.lab4.components;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a sentence composed of words and punctuation.
 */
public class Sentence {
    private final List<Object> elements;

    /**
     * Constructs a Sentence object from a string, parsing it into words and punctuation.
     *
     * @param sentence The sentence as a string.
     */
    public Sentence(String sentence) {
        elements = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\p{L}+|\\p{N}++|\\p{Punct}");
        Matcher matcher = pattern.matcher(sentence);

        while (matcher.find()) {
            String element = matcher.group();

            if (Pattern.matches("\\p{L}+|\\p{N}+", element)) {
                elements.add(new Word(element));  // Add as a word
            } else {
                elements.add(new Punctuation(element.charAt(0)));  // Add as punctuation
            }
        }
    }

    /**
     * Converts the sentence to a string representation.
     *
     * @return The string representation of the sentence.
     */
    @Override
    public String toString() {
        List<String> parts = new ArrayList<>();

        for (Object element : elements) {
            if (element instanceof Word) {
                parts.add(" " + element);
            } else if (element instanceof Punctuation) {
                parts.add(element.toString());
            }
        }

        return String.join("", parts).trim();
    }

    /**
     * Replaces words of the specified length in the sentence with a replacement string.
     *
     * @param length      The length of the words to replace.
     * @param replacement The replacement string.
     */
    public void replaceWordsOfLengthInSentence(int length, String replacement) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) instanceof Word word) {
                if (word.toString().length() == length) {
                    elements.set(i, new Word(replacement));
                }
            }
        }
    }
}
