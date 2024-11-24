package com.danielblanco.algoritmosestructuras.arraysstringshashtables._04_zero_matrix;

/*
 * Dada una matriz, escribe un algoritmo para establecer ceros en la fila F y columna C si existe un
 * 0 en la celda F:C
 *
 * Ejemplo:
 *  Input: 2 1 3 0 2
 *         7 4 1 3 8
 *         4 0 1 2 1
 *         9 3 4 1 9
 *
 *  Output: 0 0 0 0 0
 *          7 0 1 0 8
 *          0 0 0 0 0
 *          9 0 4 0 9
 *
 * Temporal: O(F*C + z*(F+C))
 * Espacial O(F*C)  -> O(1)?
 *
 */
public class ZeroMatrix {

  public static void main(String[] args) {
    int[][] matrix2 = {{2, 0, 2}, {0, 2, 1}, {9, 3, 4}};
    ZeroMatrix t = new ZeroMatrix();
    t.zeroMatrix(matrix2);
  }

  public int[][] zeroMatrix(int[][] matrix) {

    boolean firstRowHasZero = hasFirstRowAnyZero(matrix);
    boolean firstColHasZero = hasFirstColAnyZero(matrix);

    checkForZeroes(matrix);

    processRows(matrix);
    processColumns(matrix);

    if (firstRowHasZero) {
      setRowToZero(matrix, 0);
    }

    if (firstColHasZero) {
      setColToZero(matrix, 0);
    }

    return matrix;
  }

  private boolean hasFirstRowAnyZero(int[][] matrix) {
    for (int i = 0; i < matrix[0].length; i++) {
      if (matrix[0][i] == 0) return true;
    }
    return false;
  }

  private boolean hasFirstColAnyZero(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] == 0) return true;
    }
    return false;
  }

  private void checkForZeroes(int[][] matrix) {

    for (int row = 1; row < matrix.length; row++) {

      for (int col = 1; col < matrix[0].length; col++) {

        if (matrix[row][col] == 0) {
          matrix[row][0] = 0;
          matrix[0][col] = 0;
        }

      }

    }

  }

  private void processRows(int[][] matrix) {
    for (int row = 0; row < matrix.length; row++) {
      if (matrix[row][0] == 0) {
        setRowToZero(matrix, row);
      }
    }
  }

  private void setRowToZero(int[][] matrix, int row) {
    for (int col = 0; col < matrix[0].length; col++) {
      matrix[row][col] = 0;
    }
  }

  private void processColumns(int[][] matrix) {
    for (int col = 0; col < matrix[0].length; col++) {
      if (matrix[0][col] == 0) {
        setColToZero(matrix, col);
      }
    }
  }

  private void setColToZero(int[][] matrix, int col) {
    for (int row = 0; row < matrix.length; row++) {
      matrix[row][col] = 0;
    }
  }

}
