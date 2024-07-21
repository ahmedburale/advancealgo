package advancedalgo.algorithm.patternmatching;


import java.util.ArrayList;
import java.util.List;

/**
 * Brute Force Algorithm
 * It will search for a pattern in an array and if the pattern is found it will
 * return the index of the array where the first letter of the pattern was found.
 * If no match is found, it will return -1.
 */
public class BruteForceService {

    /**
     * This method searches for the pattern in an array and returns the index of the first char that matches.
     * If no match is found, -1 is returned.
     *
     * @param array
     * @param pattern
     * @return
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
     * This method searches for a pattern in an array and returns an array of int with the indexes of
     * the elements found.
     *
     * @param array
     * @param pattern
     * @return
     */
    public int[] everyMatch(char[] array, char[] pattern) {
        List<Integer> found = new ArrayList<>();
        for (int i = 0; i <= array.length - pattern.length; i++) {
            int j;
            for (j = 0; j < pattern.length; j++) {
                if (array[i + j] != pattern[j]) {
                    break;
                }
            }
            if (j == pattern.length) {
                found.add(i);
            }
        }
        return found.stream().mapToInt(i -> i).toArray();
    }
}

