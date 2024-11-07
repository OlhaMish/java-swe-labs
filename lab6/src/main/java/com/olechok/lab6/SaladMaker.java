package com.olechok.lab6;
import com.olechok.lab6.vegetables.Vegetable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class responsible for managing the salad's ingredients.
 * Provides methods to add ingredients, calculate total calories, sort ingredients,
 * and find vegetables by their calorie range.
 */
public class SaladMaker {
    private final List<Vegetable> ingredients;

    /**
     * Constructor to initialize the list of ingredients.
     */
    public SaladMaker() {
        ingredients = new ArrayList<>();
    }

    /**
     * Gets the list of salad ingredients.
     *
     * @return List of vegetables in the salad
     */
    public List<Vegetable> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    /**
     * Calculates the total caloric content of the salad.
     *
     * @return The total calories of the salad
     */
    public double calculateSaladCaloricContent() {
        double result = 0;
        for (Vegetable ingredient : ingredients) {
            result += (ingredient.getCaloricContent() * ingredient.getWeight()) / 100;
        }
        return result;
    }

    /**
     * Sorts the ingredients by a given comparator.
     *
     * @param comparator The comparator used for sorting
     */
    public void sortIngredientsBy(Comparator<Vegetable> comparator) {
        ingredients.sort(comparator);
    }

    /**
     * Finds vegetables within a specified calorie range.
     *
     * @param min The minimum caloric content
     * @param max The maximum caloric content
     * @return A list of vegetables within the given range
     */
    public List<Vegetable> findVegetablesByCaloriesRange(double min, double max) {
        List<Vegetable> result = new ArrayList<>();
        for (Vegetable ingredient : ingredients) {
            if (ingredient.getCaloricContent() >= min && ingredient.getCaloricContent() <= max) {
                result.add(ingredient);
            }
        }
        return result;
    }

    /**
     * Adds an ingredient to the salad.
     *
     * @param ingredient The vegetable to add
     */
    public void addIngredient(Vegetable ingredient) {
        ingredients.add(ingredient);
    }

    /**
     * Returns a string representation of the salad's ingredients.
     *
     * @return String describing the ingredients
     */
    @Override
    public String toString() {
        return "Salad ingredients: " + ingredients;
    }

}
