package advancedalgo.algorithm.patternmatching;

/**
 * Rabin-Karp Algorithm
 * It uses hashing to find a match between pattern and array of characters. It uses rolling hash function
 * to recalculate the hash on the subsequent possible matches.
 * It will return the index of the match in the array.
 * It will return -1 if there is no match.
 */
public class RabinKarpService {

    private final int prime = 101; // A prime number for hashing
    private final int d = 256; // Number of characters in the input alphabet (ASCII)

    public int search(char[] array, char[] pattern) {
        if (array == null || pattern == null) return -1;

        int n = array.length;
        int m = pattern.length;
        if (m > n) return -1;

        long patternHash = calculateHash(pattern, m);
        long arrayHash = calculateHash(array, m);

        for (int i = 0; i <= n - m; i++) {
            if (patternHash == arrayHash && match(array, pattern, i)) {
                return i;
            }

            if (i < n - m) {
                arrayHash = recalculateHash(arrayHash, array[i], array[i + m], m);
            }
        }
        return -1;
    }

    public boolean match(char[] array, char[] pattern, int index) {
        for (int i = 0; i < pattern.length; i++) {
            if (array[index + i] != pattern[i]) return false;
        }
        return true;
    }

    public long calculateHash(char[] text, int hashSize) {
        long hash = 0;
        for (int i = 0; i < hashSize; i++) {
            hash = (hash * d + text[i]) % prime;
        }
        return hash;
    }

    public long recalculateHash(long oldHash, char oldChar, char newChar, int hashSize) {
        long hash = oldHash - oldChar * pow(d, hashSize - 1) % prime;
        hash = (hash * d + newChar) % prime;
        if (hash < 0) {
            hash += prime;
        }
        return hash;
    }

    public long pow(long base, int exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result = (result * base) % prime;
        }
        return result;
    }

    public int charVal(char val) {
        return val;
    }
}
