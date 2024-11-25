package com.danielblanco.algoritmosestructuras.arraysstringshashtables._04_zero_matrix;

public class ZeroMatrizRefuerzo {

    public static void main(String[] args) {

        int[][] matrix = {
            {2, 5, 1, 8},
            {3, 7, 1, 9},
            {5, 3, 4, 0},
            {9, 8, 4, 1},
        };

        obtenerMatrizZero(matrix);
    }

    private static int[][] obtenerMatrizZero(int[][] matrix) {

        boolean isFirstRowZero = firstRowZero(matrix);
        System.out.println("El primer renglon tiene cero: " + isFirstRowZero);

        boolean isFirstColumnZero = firstColumnZero(matrix);
        System.out.println("La primera columna tiene cero: " + isFirstColumnZero);

        hasZeroMatriz(matrix);
        doRowZero(matrix);
        doColumnZero(matrix);

        if (isFirstRowZero) {
            hasRowZero(matrix, 0);
        }

        if (isFirstColumnZero) {
            hasColumnZero(matrix, 0);
        }

        return matrix;
    }

    private static boolean firstRowZero(int[][] matrix) {
        int renglon = 0;

        for (int columna = 0; columna < matrix.length; columna++) {
            if (matrix[renglon][columna] == 0) return true;
        }

        return false;
    }

    private static boolean firstColumnZero(int[][] matrix) {
        int columna = 0;

        for (int renglon = 0; renglon < matrix[0].length; renglon++) {
            if (matrix[renglon][columna] == 0) return true;
        }

        return false;
    }

    private static void hasZeroMatriz(int[][] matrix) {

        for (int renglon = 1; renglon < matrix.length; renglon++) {

            for (int columna = 1; columna < matrix[0].length; columna++) {

                if (matrix[renglon][columna] == 0) {
                    matrix[0][columna] = 0;
                    matrix[renglon][0] = 0;
                }

            }

        }

    }

    private static void doRowZero(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[i][0] == 0) {
                hasRowZero(matrix, i);
            }
        }
    }

    private static void doColumnZero(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                hasColumnZero(matrix, i);
            }
        }
    }

    private static void hasRowZero(int[][] matrix, int renglon) {
        for (int columna = 0; columna < matrix.length; columna++) {
            matrix[renglon][columna] = 0;
        }
    }

    private static void hasColumnZero(int[][] matrix, int columna) {
        for (int renglon = 0; renglon < matrix.length; renglon++) {
            matrix[renglon][columna] = 0;
        }
    }

}
