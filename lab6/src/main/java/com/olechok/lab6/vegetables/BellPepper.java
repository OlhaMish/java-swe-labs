package com.olechok.lab6.vegetables;

/**
 * Represents a specific type of vegetable: Bell Pepper.
 */
public class BellPepper extends Vegetable {
    /**
     * Constructor to create a bell pepper with the given weight.
     *
     * @param weight Weight of the bell pepper in grams
     */
    public BellPepper(double weight) {
        super("Bell Pepper", 27, 1.3, weight);
    }
}
