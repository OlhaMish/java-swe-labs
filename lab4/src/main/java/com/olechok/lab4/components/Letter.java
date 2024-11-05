package com.olechok.lab4.components;

/**
 * Represents a single character in a word.
 */
public record Letter(char letter) {

    /**
     * Converts the letter to a string representation.
     *
     * @return The string representation of the letter.
     */
    @Override
    public String toString() {
        return Character.toString(letter);
    }
}
