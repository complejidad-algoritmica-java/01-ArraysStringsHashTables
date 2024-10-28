package com.danielblanco.algoritmosestructuras.arraysstringshashtables._02_two_sum;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Dado un array de números enteros y un target, retorna los índices de dos
 * números para los que la suma de ambos sea igual al target.
 *
 * Puedes asumir que hay solamente una solución.
 *
 * Ejemplo 1:
 *  Input: nums = [9,2,5,6], target = 7
 *  Output: [1,2]
 *  Explicación: nums[1] + nums[2] == 7, devolvemos [1, 2].
 *
 * Ejemplo 2:
 *  Input: nums = [9,2,5,6], target = 100
 *  Output: null
 *
 * [-2, 5, 2]
 *
 */
public class TwoSum {

  // Complejidad cuadratica O(N^2)
  public static int[] twoSum(int[] nums, int target) {

    for (int i = 0; i < nums.length; i++) {
      int numberI = nums[i];

      for (int j = 0; j < nums.length; j++) {
        int numberJ = nums[j];

        int suma = numberI + numberJ;

        if (suma == target) {
          return new int[]{i, j};
        }

      }

    }

    return null;
  }

  // Complejidad lineal O(N)
  public static int[] twoSumOptimo(int[] nums, int target) {

    if (nums == null || nums.length < 2) return null;

    Map<Integer, Integer> compMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int number = nums[i];
      if (compMap.containsKey(number)) return new int[] {i, compMap.get(number)};
      int complement = target - number;
      compMap.put(complement, i);
    }

    return null;
  }

  public static void main(String[] args) {
    int[] nums_1 = new int[] { 9,2,5,6 };
    int target_1 = 7;

    int[] posiciones = twoSumOptimo(nums_1, target_1);

    if (posiciones == null) {
      System.out.println("No contiene ningun elemento y es " + posiciones);
    } else {
      Arrays.stream(posiciones).forEach(System.out::println);
    }

  }

}
