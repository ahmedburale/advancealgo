package advancedalgo.algorithm.patternmatching;

import java.util.ArrayList;

/**
 * Brute Force Algorithm
 *
 * This service provides methods to search for a pattern in an array.
 * - If the pattern is found, the index of the first occurrence is returned.
 * - If no match is found, -1 is returned.
 * - Additionally, a method to find all occurrences of the pattern is provided.
 */
public class BruteForceService {

    /**
     * Searches for the first occurrence of the pattern in the array.
     *
     * @param array   The array to search in
     * @param pattern The pattern to search for
     * @return The index of the first occurrence of the pattern, or -1 if no match is found
     */
    public int firstMatch(char[] array, char[] pattern) {
        for (int i = 0; i <= array.length - pattern.length; i++) {
            int j;
            for (j = 0; j < pattern.length; j++) {
                if (array[i + j] != pattern[j]) {
                    break;
                }
            }
            if (j == pattern.length) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Searches for all occurrences of the pattern in the array.
     *
     * @param array   The array to search in
     * @param pattern The pattern to search for
     * @return An array of indices where the pattern is found
     */
    public int[] everyMatch(char[] array, char[] pattern) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i <= array.length - pattern.length; i++) {
            int j;
            for (j = 0; j < pattern.length; j++) {
                if (array[i + j] != pattern[j]) {
                    break;
                }
            }
            if (j == pattern.length) {
                indices.add(i);
            }
        }
        return indices.stream().mapToInt(Integer::intValue).toArray();
    }
}
