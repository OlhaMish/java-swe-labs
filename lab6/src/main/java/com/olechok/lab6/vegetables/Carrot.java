package com.olechok.lab6.vegetables;

/**
 * Represents a specific type of vegetable: Carrot.
 */
public class Carrot extends Vegetable {
    /**
     * Constructor to create a carrot with the given weight.
     *
     * @param weight Weight of the carrot in grams
     */
    public Carrot(double weight) {
        super("Carrot", 35.2, 1, weight);
    }
}
