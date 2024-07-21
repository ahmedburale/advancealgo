package advancedalgo.algorithm.patternmatching;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EuclidServiceTest {

    private EuclidService euclidService;

    @BeforeAll
    public void setUp() {
        euclidService = new EuclidService();
    }

    @Test
    @DisplayName("GCD of 22 and 6 should be 2")
    public void testGcd_22_6() {
        int result = euclidService.gcd(22, 6);
        System.out.println("Test: GCD of 22 and 6\nExpected: 2\nActual: " + result);
        assertEquals(2, result);
    }

    @Test
    @DisplayName("GCD of 54 and 24 should be 6")
    public void testGcd_54_24() {
        int result = euclidService.gcd(54, 24);
        System.out.println("Test: GCD of 54 and 24\nExpected: 6\nActual: " + result);
        assertEquals(6, result);
    }

    @Test
    @DisplayName("GCD of 17 and 13 should be 1")
    public void testGcd_17_13() {
        int result = euclidService.gcd(17, 13);
        System.out.println("Test: GCD of 17 and 13\nExpected: 1\nActual: " + result);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("GCD of 100 and 10 should be 10")
    public void testGcd_100_10() {
        int result = euclidService.gcd(100, 10);
        System.out.println("Test: GCD of 100 and 10\nExpected: 10\nActual: " + result);
        assertEquals(10, result);
    }

    @Test
    @DisplayName("GCD of 1 and 0 should be 1")
    public void testGcd_1_0() {
        int result = euclidService.gcd(1, 0);
        System.out.println("Test: GCD of 1 and 0\nExpected: 1\nActual: " + result);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("GCD of 0 and 0 should be 0")
    public void testGcd_0_0() {
        int result = euclidService.gcd(0, 0);
        System.out.println("Test: GCD of 0 and 0\nExpected: 0\nActual: " + result);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("GCD of -5 and 5 should be 5")
    public void testGcd_neg5_5() {
        int result = euclidService.gcd(-5, 5);
        System.out.println("Test: GCD of -5 and 5\nExpected: 5\nActual: " + result);
        assertEquals(5, result);
    }

    @Test
    @DisplayName("GCD of 5 and -5 should be 5")
    public void testGcd_5_neg5() {
        int result = euclidService.gcd(5, -5);
        System.out.println("Test: GCD of 5 and -5\nExpected: 5\nActual: " + result);
        assertEquals(5, result);
    }

    @Test
    @DisplayName("GCD of -5 and -5 should be 5")
    public void testGcd_neg5_neg5() {
        int result = euclidService.gcd(-5, -5);
        System.out.println("Test: GCD of -5 and -5\nExpected: 5\nActual: " + result);
        assertEquals(5, result);
    }
}
