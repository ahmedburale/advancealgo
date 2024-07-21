package advancedalgo.algorithm.patternmatching;

public class KMPService {

    /**
     * This method returns the index for the first match of the pattern into the array.
     * It will return -1 in case it does not match.
     *
     * @param array
     * @param pattern
     * @return index of the first match or -1 if no match is found
     */
    public int search(char[] array, char[] pattern) {
        int[] lsp = computeLSPTable(pattern);
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            while (j > 0 && array[i] != pattern[j]) {
                j = lsp[j - 1];
            }
            if (array[i] == pattern[j]) {
                j++;
                if (j == pattern.length) {
                    return (i - (j - 1));
                }
            }
        }
        return -1;
    }

    /**
     * This computes the table of the longest suffix and longest prefix on the pattern.
     * This is to be used by Knuth-Morris-Pratt main method of the algorithm
     *
     * @param pattern
     * @return the LSP (Longest Suffix Prefix) table
     */
    public int[] computeLSPTable(char[] pattern) {
        int[] lsp = new int[pattern.length];
        int j = 0;
        for (int i = 1; i < pattern.length; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = lsp[j - 1];
            }
            if (pattern[i] == pattern[j]) {
                j++;
                lsp[i] = j;
            } else {
                lsp[i] = 0;
            }
        }
        return lsp;
    }
}

