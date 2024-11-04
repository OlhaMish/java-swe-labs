package com.olechok.lab3;


import java.util.Objects;

/**
 * The Furniture class represents a furniture item with several attributes:
 * - name: The name of the furniture item
 * - material: The material used to make the furniture item
 * - color: The color of the furniture item
 * - price: The price of the furniture item
 * - amount: The quantity of the furniture item in stock
 *
 * The class provides getters for each field, an equals method for comparison,
 * and a toString method for formatted output.
 */
public class Furniture {
    String name;
    String material;
    String color;
    double price;
    int amount;

    /**
     * Constructs a Furniture object with specified attributes.
     *
     * @param name The name of the furniture item
     * @param material The material of the furniture item
     * @param color The color of the furniture item
     * @param price The price of the furniture item
     * @param amount The amount of the furniture item in stock
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

    @Override
    public int hashCode() {
        return Objects.hash(name, material, color, price, amount);
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "name='" + name + '\'' +
                ", material='" + material + '\'' +
                ", color=" + color +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }

}
