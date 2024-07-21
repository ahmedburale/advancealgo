package advancedalgo.algorithm.patternmatching;

/**
 * Euclid's algorithm calculates the greatest common divisor between two numbers.

 * This implementation includes:
// * - Handling of negative numbers by converting them to their absolute values.
 * - Edge cases such as zero values.
 * - Big-O analysis.
 * - Example usage.

 * Big-O Analysis:
 * - Time complexity: O(log(min(a, b))) where a and b are the input numbers.
 * - Space complexity: O(1) since we use a constant amount of extra space.

 * Example:
 * EuclidService service = new EuclidService();
 * int result = service.gcd(54, 24);
 * System.out.println(result); // Output: 6

 * Edge Cases:
 * - gcd(0, 0) should return 0.
 * - gcd(-5, 5) should handle negative numbers and return 5.
 * - gcd(1, 0) should return 1.
 * - gcd(0, 1) should return 1.
 * - gcd(0, 10) should return 10.
 * - gcd(-5, -5) should return 5.

 * @ author Burale
 */
public class EuclidService {

    /**
     * Computes the greatest common divisor (GCD) of two integers using Euclid's algorithm.
     *
     * @param number The first number
     * @param divisor The second number
     * @return The GCD of the two numbers
     */
    public int gcd(int number, int divisor) {
        // Handle negative numbers by taking their absolute value
        number = Math.abs(number);
        divisor = Math.abs(divisor);

        // Base case: if the divisor is 0, return the number
        if (divisor == 0) {
            return number;
        }

        // Recursive case: compute the GCD of divisor and the remainder of number divided by divisor
        return gcd(divisor, number % divisor);
    }
}
