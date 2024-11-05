package com.olechok.lab4.components;

/**
 * Represents a punctuation mark in a sentence.
 */
public class Punctuation {
    private final char punctuation;

    /**
     * Constructs a Punctuation object with the specified character.
     *
     * @param punctuation The punctuation character.
     */
    public Punctuation(char punctuation) {
        this.punctuation = punctuation;
    }

    /**
     * Converts the punctuation to a string representation.
     *
     * @return The string representation of the punctuation.
     */
    @Override
    public String toString() {
        return Character.toString(punctuation);
    }
}
