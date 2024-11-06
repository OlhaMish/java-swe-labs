package com.olechok.lab5.vegetables;

/**
 * Represents a specific type of vegetable: Tomato.
 */
public class Tomato extends Vegetable {
    /**
     * Constructor to create a tomato with the given weight.
     *
     * @param weight Weight of the tomato in grams
     */
    public Tomato(double weight) {
        super("Tomato", 20, 0.9, weight);
    }
}
