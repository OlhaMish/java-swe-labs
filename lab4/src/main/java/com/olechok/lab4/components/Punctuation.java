package com.olechok.lab4.components;

public class Punctuation {
    private final char punctuation;

    public Punctuation(char punctuation) {
        this.punctuation = punctuation;
    }

    @Override
    public String toString() {
        return Character.toString(punctuation);
    }
}
