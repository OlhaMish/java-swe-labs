package com.olechok.lab1;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int rowsA = getIntInput(scanner, "Enter the number of rows for matrix A: ");
            int colsA = getIntInput(scanner, "Enter the number of columns for matrix A: ");

            int rowsB = getIntInput(scanner, "Enter the number of rows for matrix B: ");
            int colsB = getIntInput(scanner, "Enter the number of columns for matrix B: ");

            MatrixGenerator generator = new MatrixGenerator();
            float[][] matrixA = generator.generateRandomFloatMatrix(rowsA, colsA);
            float[][] matrixB = generator.generateRandomFloatMatrix(rowsB, colsB);

            System.out.println("Matrix A:");
            printMatrix(matrixA);
            System.out.println("Matrix B:");
            printMatrix(matrixB);

            MatrixCalculator calculator = new MatrixCalculator(matrixA, matrixB);
            try {
                float[][] resultMatrix = calculator.multiplyMatrices();
                System.out.println("Result of matrix multiplication (Matrix C):");
                printMatrix(resultMatrix);

                float sum = calculator.calculateColumnSums(resultMatrix);
                System.out.println("Sum of the largest and smallest elements in columns of matrix C: " + sum);

            } catch (IllegalArgumentException e) {
                System.err.println("Error during matrix calculation: " + e.getMessage());
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Input error: " + e.getMessage());
        }
    }

    private static int getIntInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            scanner.next();
            throw new IllegalArgumentException("Input must be an integer.");
        }
    }

    private static void printMatrix(float[][] matrix) {
        for (float[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
