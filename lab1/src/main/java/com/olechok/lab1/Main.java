package com.olechok.lab1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Main {
    private float[][] firstMatrix;
    private float[][] secondMatrix;

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }

    private void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            int rowsA = getIntInput(scanner, "Enter the number of rows for matrix A: ");
            int colsA = getIntInput(scanner, "Enter the number of columns for matrix A: ");

            int rowsB = getIntInput(scanner, "Enter the number of rows for matrix B: ");
            int colsB = getIntInput(scanner, "Enter the number of columns for matrix B: ");

            float[][] matrixA = generateRandomFloatMatrix(rowsA, colsA);
            float[][] matrixB = generateRandomFloatMatrix(rowsB, colsB);

            System.out.println("Matrix A:");
            printMatrix(matrixA);
            System.out.println("Matrix B:");
            printMatrix(matrixB);

            this.firstMatrix = matrixA;
            this.secondMatrix = matrixB;

            try {
                float[][] resultMatrix = multiplyMatrices();
                System.out.println("Result of matrix multiplication (Matrix C):");
                printMatrix(resultMatrix);

                float sum = calculateColumnSums(resultMatrix);
                System.out.println("Sum of the largest and smallest elements in columns of matrix C: " + sum);

            } catch (IllegalArgumentException e) {
                System.err.println("Error during matrix calculation: " + e.getMessage());
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Input error: " + e.getMessage());
        }
    }

    private float[][] generateRandomFloatMatrix(int rows, int cols) {
        Random random = new Random();
        float[][] matrix = new float[rows][cols];
        float min = 0.0f;
        float max = 10.0f;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = min + random.nextFloat() * (max - min);
            }
        }
        return matrix;
    }

    private float[][] multiplyMatrices() throws IllegalArgumentException {
        int rowsA = firstMatrix.length;
        int colsA = firstMatrix[0].length;
        int rowsB = secondMatrix.length;
        int colsB = secondMatrix[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException(
                    "The number of columns of the first matrix must be equal " +
                            "to the number of rows of the second matrix.");
        }

        float[][] result = new float[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return result;
    }

    private float calculateColumnSums(float[][] matrix) {
        float sum = 0;
        int cols = matrix[0].length;

        for (int j = 0; j < cols; j++) {
            float extremeValue = (j % 2 == 0) ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;

            for (float[] floats : matrix) {
                if (j % 2 == 0) {
                    // Find maximum for even columns
                    if (floats[j] > extremeValue) {
                        extremeValue = floats[j];
                    }
                } else {
                    // Find minimum for odd columns
                    if (floats[j] < extremeValue) {
                        extremeValue = floats[j];
                    }
                }
            }
            sum += extremeValue;
        }
        return sum;
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
