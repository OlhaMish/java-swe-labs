package com.olechok.lab3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * The Main class creates an array of Furniture objects and demonstrates sorting and searching within the array.
 * - Sorts the array of furniture items first by price (ascending) and then by material (descending).
 * - Searches for a specific Furniture object in the sorted array.
 */
public class Main {
    public static void main(String[] args) {

        // Create an array of Furniture objects
        Furniture[] furniture = new Furniture[5];
        furniture[0] = new Furniture("Royal Table",
                "Gold",
                "Golden",
                1000.90,
                2);

        furniture[1] = new Furniture("Crazy Sofa",
                "Velvet",
                "Purple",
                290.50,
                20);

        furniture[2] = new Furniture("Cute Chair",
                "Wood",
                "Green",
                50.00,
                110);

        furniture[3] = new Furniture("Majestic Cupboard",
                "Wood",
                "White",
                210.90,
                12);

        furniture[4] = new Furniture("Cozy Bed",
                "Wood",
                "Blue",
                290.50,
                12);

        // Sort the array by price in ascending order, then by material in descending order
        Arrays.sort(furniture,
                Comparator.comparing(Furniture::getPrice)
                .thenComparing(Comparator.comparing(Furniture::getMaterial).reversed()));

        // Display sorted furniture array
        System.out.println("Sorted Furniture Array:");
        for (Furniture oneFurniture : furniture) {
            System.out.println(oneFurniture);
        }

        // Create a Furniture object to search for within the sorted array
        Furniture furnitureToFind = new Furniture("Crazy Sofa",
                "Velvet",
                "Purple",
                290.50,
                20);

        // Check if the specified Furniture object exists in the array
        boolean found = Arrays.asList(furniture).contains(furnitureToFind);
        System.out.println("\nIs target furniture found? " + found);

    }
}
