package com.olechok.lab5;

import com.olechok.lab5.vegetables.*;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class that handles user interaction and salad operations.
 * The user can calculate the total caloric content, sort ingredients by various parameters,
 * and find vegetables in a specific calorie range.
 */
public class Main {
    /**
     * Main method to run the program and interact with the user.
     * The program offers a menu for different operations on the salad.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SaladMaker salad = new SaladMaker();

        salad.addIngredient(new Lettuce(40));
        salad.addIngredient(new Spinach(50));
        salad.addIngredient(new Tomato(100));
        salad.addIngredient(new BellPepper(80));
        salad.addIngredient(new Radish(50));
        salad.addIngredient(new Carrot(150));

        while (true) {
            printMenu();
            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> calculateSaladCalories(salad);
                    case 2 -> sortSaladIngredients(salad, scanner);
                    case 3 -> findVegetablesInCaloriesRange(salad, scanner);
                    case 4 -> {
                        System.out.println("Exiting program.");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    /**
     * Displays the menu of available actions for the user.
     */
    public static void printMenu(){
        System.out.println("\nChoose an action:");
        System.out.println("1. Calculate Total Salad Calories");
        System.out.println("2. Sort Ingredients by Parameter");
        System.out.println("3. Find Vegetables in Calorie Range");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Calculates and displays the total caloric content of the salad.
     *
     * @param salad The salad object containing the ingredients
     */
    public static void calculateSaladCalories(SaladMaker salad) {
        double totalCalories = salad.calculateSaladCaloricContent();
        System.out.println("Total caloric content of the salad: " + totalCalories);
    }

    /**
     * Sorts the salad ingredients based on user-selected criteria.
     *
     * @param salad The salad object containing the ingredients
     * @param scanner Scanner to read user input
     */
    public static void sortSaladIngredients(SaladMaker salad, Scanner scanner) {
        System.out.println("Sort by:");
        System.out.println("1. Protein Content\n2. Caloric Content\n3. Weight");
        System.out.print("Enter the number of your choice: ");
        int sortChoice = scanner.nextInt();

        switch (sortChoice) {
            case 1 -> salad.sortIngredientsBy(Comparator.comparingDouble(Vegetable::getProteinContent));
            case 2 -> salad.sortIngredientsBy(Comparator.comparingDouble(Vegetable::getCaloricContent));
            case 3 -> salad.sortIngredientsBy(Comparator.comparingDouble(Vegetable::getWeight));
            default -> System.out.println("Invalid choice. Sorting not applied.");
        }
        System.out.println("\nSorted salad ingredients:");
        salad.getIngredients().forEach(System.out::println);
    }

    /**
     * Finds and displays the vegetables in the salad that are within the specified calorie range.
     *
     * @param salad The salad object containing the ingredients
     * @param scanner Scanner to read user input
     */
    public static void findVegetablesInCaloriesRange(SaladMaker salad, Scanner scanner) {
        System.out.print("\nEnter minimum and maximum caloric content to find vegetables in that range.\nMinimum: ");
        double minCalories = scanner.nextDouble();
        System.out.print("Maximum: ");
        double maxCalories = scanner.nextDouble();

        System.out.println("\nVegetables within the specified caloric range:");
        var foundVegetables = salad.findVegetablesByCaloriesRange(minCalories, maxCalories);
        if (foundVegetables != null && !foundVegetables.isEmpty()) {
            foundVegetables.forEach(System.out::println);
        } else {
            System.out.println("Vegetables not found.");
        }
    }
}
