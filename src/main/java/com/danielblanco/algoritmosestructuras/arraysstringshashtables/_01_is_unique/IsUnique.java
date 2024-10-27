package com.danielblanco.algoritmosestructuras.arraysstringshashtables._01_is_unique;

import java.util.HashSet;
import java.util.Set;

/*
 * Dado un método que recibe una String, comprobar si todos los caracteres son únicos o no.
 *
 * isUnique("abcde") => true;
 * isUnique("abcded") => false;
 *
 * Complejidad O(n^2)
 * a: b c d e
 * b: c d e
 *
 * Usar tabla Hash
 * a b c d e
 *
 * for O(n)
 * Consulta el tabla O(1)
 *
 * -----
 * O(1) complejidad constante
 */
public class IsUnique {

  // Complejidad cuadratica O(n^2)
  public static boolean isUnique(String s) {

    boolean esUnique = true;

    for (int i = 0; i < s.length(); i++) {
      char characterTemporal = s.charAt(i);

      for (int j = 0; j < s.length(); j++) {
        if (i == j) continue;
        if (characterTemporal == s.charAt(j)) return false;
      }

    }

    return esUnique;
  }

  // O(1) complejidad constante porque sabemos el numero determinado de elementos en ASCII
  private static int NUMBER_OF_CHARS = 128;

  // Complejidad lineal O(N)
  public static boolean isUniqueOptimo(String s) {
    if (s.length() > NUMBER_OF_CHARS) return false; // Si es mayor es que hay repetidos

    Set<Character> characters = new HashSet<>();
    for (Character c : s.toCharArray()) {
      if (characters.contains(c)) return false;
      characters.add(c);
    }

    return true;
  }

  public static void main(String[] args) {
    boolean esUnique1 = isUnique("abcde");
    System.out.println("esUnique1: " + esUnique1);
    boolean esUnique2 = isUnique("abcded");
    System.out.println("esUnique2: " + esUnique2);
  }

}
