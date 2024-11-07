package com.olechok.lab6.vegetables;

/**
 * Represents a specific type of vegetable: Lettuce.
 */
public class Lettuce extends Vegetable {
    /**
     * Constructor to create a lettuce with the given weight.
     *
     * @param weight Weight of the lettuce in grams
     */
    public Lettuce(double weight) {
        super("Lettuce", 16.5, 1.2, weight);
    }
}
