package com.olechok.lab1;


public class MatrixCalculator {
    float[][] firstMatrix;
    float[][] secondMatrix;

    MatrixCalculator(float[][] matrixA, float[][] matrixB){
        firstMatrix = matrixA;
        secondMatrix = matrixB;
    }

    public float[][] multiplyMatrices() throws IllegalArgumentException {
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

    public float calculateColumnSums(float[][] matrix) {
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
            // System.out.println("extremeValue: " + extremeValue);
            sum += extremeValue;
        }
        return sum;
    }


}
