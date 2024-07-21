package advancedalgo.algorithm.patternmatching;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KMPServiceTest {

    KMPService kmp;

    @Before
    public void init() {
        kmp = new KMPService();
    }

    @Test
    public void searchTest() {
        String array = "abazacabababac";
        String pattern = "ababac";
        int index = kmp.search(array.toCharArray(), pattern.toCharArray());
        System.out.println("Test Case 1: Index = " + index);
        Assert.assertEquals(8, index);

        array = "aabaaabacaz";
        pattern = "aabacaz";
        index = kmp.search(array.toCharArray(), pattern.toCharArray());
        System.out.println("Test Case 2: Index = " + index);
        Assert.assertEquals(4, index);

        array = "this is a test";
        pattern = "is a";
        index = kmp.search(array.toCharArray(), pattern.toCharArray());
        System.out.println("Test Case 3: Index = " + index);
        Assert.assertEquals(5, index);

        array = "cantfindtheindex";
        pattern = "foo";
        index = kmp.search(array.toCharArray(), pattern.toCharArray());
        System.out.println("Test Case 4: Index = " + index);
        Assert.assertEquals(-1, index);

        array = "cantfindtheindex";
        pattern = "index";
        index = kmp.search(array.toCharArray(), pattern.toCharArray());
        System.out.println("Test Case 5: Index = " + index);
        Assert.assertEquals(11, index); // Corrected expected index to 11
    }

    @Test
    public void computeLSPTableTest() {
        int[] actual = kmp.computeLSPTable(new char[]{'a', 'b', 'a', 'b', 'a', 'c'});
        int[] expect = new int[]{0, 0, 1, 2, 3, 0};
        Assert.assertArrayEquals(expect, actual);

        actual = kmp.computeLSPTable(new char[]{'a', 'a', 'b', 'a', 'c'});
        expect = new int[]{0, 1, 0, 1, 0};
        Assert.assertArrayEquals(expect, actual);

        actual = kmp.computeLSPTable(new char[]{'a', 'b', 'c', 'd', 'a', 'b', 'c', 'a'});
        expect = new int[]{0, 0, 0, 0, 1, 2, 3, 1};
        Assert.assertArrayEquals(expect, actual);

        actual = kmp.computeLSPTable(new char[]{'c', 'f', 'g', 'c', 'f', 'a'});
        expect = new int[]{0, 0, 0, 1, 2, 0};
        Assert.assertArrayEquals(expect, actual);

        actual = kmp.computeLSPTable(new char[]{'a', 'a', 'b', 'a', 'c', 'a', 'z'});
        expect = new int[]{0, 1, 0, 1, 0, 1, 0};
        Assert.assertArrayEquals(expect, actual);

        actual = kmp.computeLSPTable(new char[]{'a'});
        expect = new int[]{0};
        Assert.assertArrayEquals(expect, actual);

        actual = kmp.computeLSPTable(new char[]{'a', 'a'});
        expect = new int[]{0, 1};
        Assert.assertArrayEquals(expect, actual);

        actual = kmp.computeLSPTable(new char[]{'a', 'b'});
        expect = new int[]{0, 0};
        Assert.assertArrayEquals(expect, actual);
    }
}
