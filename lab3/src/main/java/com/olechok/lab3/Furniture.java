package com.olechok.lab3;

import java.util.Objects;

/**
 * The Furniture class represents a furniture item with several attributes:
 * <ul>
 *     <li><b>name</b>: The name of the furniture item</li>
 *     <li><b>material</b>: The material used to make the furniture item</li>
 *     <li><b>color</b>: The color of the furniture item</li>
 *     <li><b>price</b>: The price of the furniture item</li>
 *     <li><b>amount</b>: The quantity of the furniture item in stock</li>
 * </ul>
 *
 * The class provides getters for each field, an equals method for comparison,
 * and a toString method for formatted output.
 */
public class Furniture {
    private String name;
    private String material;
    private String color;
    private double price;
    private int amount;

    /**
     * Constructs a Furniture object with specified attributes.
     *
     * @param name     The name of the furniture item.
     * @param material The material of the furniture item.
     * @param color    The color of the furniture item.
     * @param price    The price of the furniture item.
     * @param amount   The quantity of the furniture item in stock.
     */
    public Furniture(String name, String material, String color, double price, int amount) {
        this.name = name;
        this.material = material;
        this.color = color;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    /**
     * Indicates whether some other object is "equal to" this furniture.
     *
     * @param o The reference object with which to compare.
     * @return true if this furniture is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Furniture furniture = (Furniture) o;
        return Double.compare(furniture.price, price) == 0 &&
                amount == furniture.amount &&
                color.equals(furniture.color) &&
                name.equals(furniture.name) &&
                material.equals(furniture.material);
    }

    /**
     * Returns a hash code value for the object, useful in hash tables.
     *
     * @return A hash code value for this furniture.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, material, color, price, amount);
    }

    /**
     * Returns a string representation of the furniture item.
     *
     * @return A string representation of the furniture, including its attributes.
     */
    @Override
    public String toString() {
        return "Furniture{" +
                "name='" + name + '\'' +
                ", material='" + material + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
