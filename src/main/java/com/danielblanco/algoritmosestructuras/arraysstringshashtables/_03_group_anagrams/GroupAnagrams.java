package com.danielblanco.algoritmosestructuras.arraysstringshashtables._03_group_anagrams;

import java.util.*;

/*
 * Un anagrama es una palabra creada a partir de la reordenación de las letras de otra palabra. Ej: saco - caso
 * Dado un array de strings, devuelve los anagramas agrupados. Cualquier orden es válido.
 *
 * Ejemplo:
 *  Input: words = ["saco", "arresto", "programa", "rastreo", "caso"].
 *  Output: [["saco", "caso"], ["arresto", "rastreo"], ["programa"]].
 *
 * Complejidad cuadratica si recorremos la palabra y de la palabra los caracters
 * O(N^2)
 *
 * [1, 0, 1, 0..., 1, 0..,1, 0,0,0]
 * C => caracteres, es mejor que la de O(N^2)
 * Complejidad O(N) * O(C)
 *
 */
public class GroupAnagrams {

  public static List<List<String>> groupAnagrams(String[] words) {
    if (words == null || words.length == 0) return Collections.emptyList();

    Map<String, List<String>> anagramMap = buildAnagramMap(words);
    return new ArrayList<>(anagramMap.values());
  }

  private static Map<String, List<String>> buildAnagramMap(String[] words) {
    Map<String, List<String>> map = new HashMap<>();

    for (String word: words) {
      String hash = getAnagramHash(word);
      if (!map.containsKey(hash)) {
        map.put(hash, new ArrayList<>());
      }

      map.get(hash).add(word);
    }

    return map;
  }

  private static String getAnagramHash(String s) {
    int[] letterCount = new int[26]; // 26 => porque evitamos la ñ en el Abecedario

    for (int c : s.toCharArray()) {
      letterCount[c - 'a']++; // ASCII a = 97
    }

    return Arrays.toString(letterCount);
  }

  public static void main(String[] args) {
    String[] words = new String[] { "saco", "arresto", "programa", "rastreo", "caso" };
    List<List<String>> anagramas = groupAnagrams(words);

    anagramas.forEach(System.out::println);
  }

}
