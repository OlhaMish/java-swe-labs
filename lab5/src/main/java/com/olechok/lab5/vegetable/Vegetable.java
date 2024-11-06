package com.olechok.lab5.vegetable;

import java.util.Objects;

/**
 * Represents a generic vegetable with properties like caloric content, protein content, and weight.
 */
public class Vegetable {
    String name;
    double caloricContentPer100Gram;
    double proteinContentPer100Gram;
    double weight;

    /**
     * Constructor to initialize vegetable properties.
     *
     * @param vegetableName Name of the vegetable
     * @param caloricContent Caloric content per 100 grams
     * @param proteinContent Protein content per 100 grams
     * @param weight Weight of the vegetable in grams
     */
    public Vegetable(String vegetableName, double caloricContent, double proteinContent, double weight) {
        this.name = vegetableName;
        this.caloricContentPer100Gram =caloricContent;
        this.proteinContentPer100Gram = proteinContent;
        this.weight = weight;
    }

    /**
     * Gets the caloric content of the vegetable.
     *
     * @return Caloric content per 100 grams
     */
    public double getCaloricContent() {
        return caloricContentPer100Gram;
    }

    /**
     * Gets the protein content of the vegetable.
     *
     * @return Protein content per 100 grams
     */
    public double getProteinContent() {
        return proteinContentPer100Gram;
    }

    /**
     * Gets the weight of the vegetable.
     *
     * @return Weight in grams
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns a string representation of the vegetable.
     *
     * @return A string with the vegetable's name, caloric content, protein content, and weight
     */
    @Override
    public String toString() {
        return name + ": " +
                "caloric content: " + caloricContentPer100Gram + ", " +
                "protein content: " + proteinContentPer100Gram  + ", " +
                "weight: " + weight;

    }

    /**
     * Compares this vegetable with another object.
     *
     * @param o The object to compare with
     * @return True if the objects are equal, otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vegetable vegetable = (Vegetable) o;
        return Double.compare(vegetable.caloricContentPer100Gram, caloricContentPer100Gram) == 0 &&
                Double.compare(vegetable.proteinContentPer100Gram, proteinContentPer100Gram) == 0 &&
                Double.compare(vegetable.weight, weight) == 0 &&
                Objects.equals(name, vegetable.name);
    }

    /**
     * Returns the hash code of the vegetable.
     *
     * @return The hash code of the vegetable
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, caloricContentPer100Gram, proteinContentPer100Gram, weight);
    }
}