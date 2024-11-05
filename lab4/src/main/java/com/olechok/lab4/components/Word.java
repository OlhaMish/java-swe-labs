package com.olechok.lab4.components;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a word as a collection of letters.
 */
public class Word {
    private final List<Letter> letters;

    /**
     * Constructs a Word object from a string, parsing it into individual letters.
     *
     * @param word The word as a string.
     */
    public Word(String word) {
        letters = new ArrayList<>();
        for (char ch : word.toCharArray()) {
            letters.add(new Letter(ch));
        }
    }

    /**
     * Converts the word to a string representation.
     *
     * @return The string representation of the word.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Letter letter : letters) {
            result.append(letter.letter());
        }
        return result.toString();
    }
}
