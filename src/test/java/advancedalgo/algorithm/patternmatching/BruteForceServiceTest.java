package advancedalgo.algorithm.patternmatching;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BruteForceServiceTest {

    BruteForceService b;
    char[] array;

    @Before
    public void init() {
        b = new BruteForceService();
        array = "advanced algorithm pattern matching".toCharArray();
    }

    @Test
    public void firstMatchTest() {
        Assert.assertEquals(0, b.firstMatch(array, "a".toCharArray()));
        Assert.assertEquals(9, b.firstMatch(array, "algorithm".toCharArray()));
        Assert.assertEquals(17, b.firstMatch(array, "pattern".toCharArray()));
        Assert.assertEquals(26, b.firstMatch(array, "matching".toCharArray()));
        Assert.assertEquals(-1, b.firstMatch(array, "z".toCharArray()));
    }

    @Test
    public void everyMatchTest() {
        int[] expect = new int[]{0, 3, 10, 20, 24};
        int[] found = b.everyMatch(array, "a".toCharArray());
        Assert.assertArrayEquals(expect, found);

        expect = new int[]{8, 16, 24};
        found = b.everyMatch(array, " ".toCharArray());
        Assert.assertArrayEquals(expect, found);

        expect = new int[]{9};
        found = b.everyMatch(array, "algorithm".toCharArray());
        Assert.assertArrayEquals(expect, found);

        expect = new int[]{17};
        found = b.everyMatch(array, "pattern".toCharArray());
        Assert.assertArrayEquals(expect, found);

        expect = new int[]{};
        found = b.everyMatch(array, "z".toCharArray());
        Assert.assertArrayEquals(expect, found);
    }
}
