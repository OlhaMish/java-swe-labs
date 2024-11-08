package com.olechok.lab6;

import com.olechok.lab6.vegetables.*;
import java.util.*;

/**
 * Main class that provides an interface for performing operations on a salad.
 * Users can calculate the total calorie content, sort ingredients by various attributes,
 * and find vegetables within a specified calorie range.
 */
public class Main {
    /**
     * Entry point of the program. Creates a salad with a list of vegetables and
     * demonstrates available operations, including calorie calculation, sorting,
     * and filtering by calorie range.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        Vegetable lettuce = new Lettuce(40);
        Vegetable spinach = new Spinach(50);
        Vegetable tomato = new Tomato(100);
        Vegetable bellPepper = new BellPepper(80);
        Vegetable radish = new Radish(50);
        Vegetable carrot = new Carrot(150);

        VegetableList vegetableList = new VegetableList(
                Arrays.asList(lettuce, spinach, tomato, bellPepper, radish, carrot));

        SaladMaker salad = new SaladMaker(vegetableList);

        calculateSaladCalories(salad);
        System.out.println("Vegetable: " + salad.getIngredients());

        sortSaladIngredients(salad);
        findVegetablesInCaloriesRange(salad);
    }

    /**
     * Calculates and prints the total caloric content of the given salad.
     *
     * @param salad The SaladMaker object containing the salad ingredients
     */
    public static void calculateSaladCalories(SaladMaker salad) {
        System.out.println("Total caloric content of the salad: " +
                            salad.calculateSaladCaloricContent());
    }

    /**
     * Sorts and displays the salad ingredients based on different properties
     * (protein content, caloric content, and weight).
     *
     * @param salad The SaladMaker object containing the salad ingredients
     */
    public static void sortSaladIngredients(SaladMaker salad) {
        salad.sortIngredientsBy(Comparator.comparingDouble(Vegetable::getProteinContent));
        System.out.println("\nSorted salad ingredients by protein content:");
        salad.getIngredients().forEach(System.out::println);

        salad.sortIngredientsBy(Comparator.comparingDouble(Vegetable::getCaloricContent));
        System.out.println("\nSorted salad ingredients by caloric content:");
        salad.getIngredients().forEach(System.out::println);

        salad.sortIngredientsBy(Comparator.comparingDouble(Vegetable::getWeight));
        System.out.println("\nSorted salad ingredients by weight.:");
        salad.getIngredients().forEach(System.out::println);
    }

    /**
     * Finds and displays vegetables in the salad that fall within a specified calorie range.
     *
     * @param salad The SaladMaker object containing the salad ingredients
     */
    public static void findVegetablesInCaloriesRange(SaladMaker salad) {
        double minCalories = 10;
        double maxCalories = 20;

        System.out.println("\nVegetables within the specified caloric range:");
        var foundVegetables = salad.findVegetablesByCaloriesRange(minCalories, maxCalories);
        if (foundVegetables != null && !foundVegetables.isEmpty()) {
            foundVegetables.forEach(System.out::println);
        } else {
            System.out.println("Vegetables not found.");
        }
    }
}
