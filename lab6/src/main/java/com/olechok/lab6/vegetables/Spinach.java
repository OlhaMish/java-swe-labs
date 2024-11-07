package com.olechok.lab6.vegetables;

/**
 * Represents a specific type of vegetable: Spinach.
 */
public class Spinach extends Vegetable {
    /**
     * Constructor to create a spinach with the given weight.
     *
     * @param weight Weight of the spinach in grams
     */
    public Spinach(double weight) {
        super("Spinach", 28.9, 2.5, weight);
    }
}
