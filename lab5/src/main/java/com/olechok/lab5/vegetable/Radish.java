package com.olechok.lab5.vegetable;

/**
 * Represents a specific type of vegetable: Radish.
 */
public class Radish extends Vegetable {
    /**
     * Constructor to create a radish with the given weight.
     *
     * @param weight Weight of the radish in grams
     */
    public Radish(double weight) {
        super("Radish", 24.1, 1.09, weight);
    }
}
