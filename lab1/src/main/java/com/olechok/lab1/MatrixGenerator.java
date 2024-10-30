package com.olechok.lab1;

import java.util.Random;


public class MatrixGenerator {
    float min = 0.0f;
    float max = 10.0f;

    public float[][] generateRandomFloatMatrix(int rows, int cols) {
        Random random = new Random();
        float[][] matrix = new float[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = min + random.nextFloat() * (max - min);
            }
        }
        return matrix;
    }
}

