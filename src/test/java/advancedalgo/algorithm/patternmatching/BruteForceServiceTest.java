package advancedalgo.algorithm.patternmatching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BruteForceServiceTest {

    private BruteForceService bruteForceService;
    private char[] array;

    @BeforeEach
    public void setUp() {
        bruteForceService = new BruteForceService();
        String s = "advancedalgorithmsareawesome";
        array = s.toCharArray();
    }

    @Test
@DisplayName("First match tests")
public void firstMatchTest() {
    System.out.println("Running firstMatchTest...");
    assertEquals(0, bruteForceService.firstMatch(array, new char[]{'a'}), "Test: First match of 'a' - Expected: 0");
    assertEquals(11, bruteForceService.firstMatch(array, new char[]{'g'}), "Test: First match of 'g' - Expected: 11");
    assertEquals(17, bruteForceService.firstMatch(array, new char[]{'a', 'r'}), "Test: First match of 'ar' - Expected: 17");
    assertEquals(21, bruteForceService.firstMatch(array, new char[]{'a', 'w', 'e'}), "Test: First match of 'awe' - Expected: 21");
    assertEquals(-1, bruteForceService.firstMatch(array, new char[]{'z','z'}), "Test: First match of 'zz' - Expected: -1");
}

    @Test
    @DisplayName("Every match tests")
    public void everyMatchTest() {
        System.out.println("Running everyMatchTest...");
        int[] expectedMatchesForA = {0, 7, 17, 21};
        int[] actualMatchesForA = bruteForceService.everyMatch(array, new char[]{'a'});
        assertEquals(expectedMatchesForA.length, actualMatchesForA.length, "Array lengths should be equal");
        for (int i = 0; i < expectedMatchesForA.length; i++) {
            assertEquals(expectedMatchesForA[i], actualMatchesForA[i], "Mismatch at index " + i);
        }

        int[] expectedMatchesForG = {8};
        int[] actualMatchesForG = bruteForceService.everyMatch(array, new char[]{'g'});
        assertEquals(expectedMatchesForG.length, actualMatchesForG.length, "Array lengths should be equal");
        for (int i = 0; i < expectedMatchesForG.length; i++) {
            assertEquals(expectedMatchesForG[i], actualMatchesForG[i], "Mismatch at index " + i);

        }

        int[] expectedMatchesForO = {10, 24};
        int[] actualMatchesForO = bruteForceService.everyMatch(array, new char[]{'o'});
        assertEquals(expectedMatchesForO.length, actualMatchesForO.length, "Array lengths should be equal");
        for (int i = 0; i < expectedMatchesForO.length; i++) {
            assertEquals(expectedMatchesForO[i], actualMatchesForO[i], "Mismatch at index " + i);
        }

        int[] expectedMatchesForT = {14};
        int[] actualMatchesForT = bruteForceService.everyMatch(array, new char[]{'t'});
        assertEquals(expectedMatchesForT.length, actualMatchesForT.length, "Array lengths should be equal");
        for (int i = 0; i < expectedMatchesForT.length; i++) {
            assertEquals(expectedMatchesForT[i], actualMatchesForT[i], "Mismatch at index " + i);
        }
    }
}
