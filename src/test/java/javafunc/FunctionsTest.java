package javafunc;

import static org.junit.Assert.*;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class FunctionsTest extends Functions {

    //Tests for zipWith

    @Test
    public void test_zipWith() {
        List<String> l1 = Arrays.asList("a", "b", "c");
        List<Integer> l2 = Arrays.asList(new Integer(1), new Integer(2), new Integer(3));
        BiFunction<String, Integer, String> f = FunctionsTest::repeat;
        List<String> zipped = Functions._zipWith(f, l1, l2);

        assertNotNull(zipped);
        assertEquals(3, zipped.size());
        assertEquals("a", zipped.get(0));
        assertEquals("bb", zipped.get(1));
        assertEquals("ccc", zipped.get(2));
    }

    private static String repeat(String str, Integer n) {
        return IntStream.range(0, n).mapToObj(i -> str).collect(Collectors.joining());
    }

    @Test
    public void test_zipWith2() {
        List<String> l1 = Arrays.asList("a", "b", "c");
        List<Integer> l2 = Arrays.asList(new Integer(1), new Integer(2), new Integer(3), new Integer(4));
        BiFunction<String, Integer, String> f = FunctionsTest::repeat;
        List<String> zipped = Functions._zipWith(f, l1, l2);

        assertNotNull(zipped);
        assertEquals(3, zipped.size());
        assertEquals("a", zipped.get(0));
        assertEquals("bb", zipped.get(1));
        assertEquals("ccc", zipped.get(2));
    }

    @Test
    public void test_zipWith3() {
        List<String> l1 = Arrays.asList("a", "b", "c", "d");
        List<Integer> l2 = Arrays.asList(new Integer(1), new Integer(2), new Integer(3));
        BiFunction<String, Integer, String> f = FunctionsTest::repeat;
        List<String> zipped = Functions._zipWith(f, l1, l2);

        assertNotNull(zipped);
        assertEquals(3, zipped.size());
        assertEquals("a", zipped.get(0));
        assertEquals("bb", zipped.get(1));
        assertEquals("ccc", zipped.get(2));
    }

    @Test
    public void test_zipWith4() {
        List<String> l1 = Arrays.asList();
        List<Integer> l2 = Arrays.asList(new Integer(1), new Integer(2), new Integer(3));
        BiFunction<String, Integer, String> f = FunctionsTest::repeat;
        List<String> zipped = Functions._zipWith(f, l1, l2);

        assertNotNull(zipped);
        assertEquals(0, zipped.size());
    }

    @Test
    public void test_zipWith5() {
        List<Integer> l2 = Arrays.asList(new Integer(1), new Integer(2), new Integer(3));
        BiFunction<String, Integer, String> f = FunctionsTest::repeat;
        List<String> zipped = Functions._zipWith(f, null, l2);

        assertNotNull(zipped);
        assertEquals(0, zipped.size());
    }

    @Test
    public void test_zipWith6() {
        List<String> l1 = Arrays.asList("a", "b", "c");
        List<Integer> l2 = Arrays.asList();
        BiFunction<String, Integer, String> f = FunctionsTest::repeat;
        List<String> zipped = Functions._zipWith(f, l1, l2);

        assertNotNull(zipped);
        assertEquals(0, zipped.size());
    }

    @Test
    public void test_zipWith7() {
        List<String> l1 = Arrays.asList("a", "b", "c");
        BiFunction<String, Integer, String> f = FunctionsTest::repeat;
        List<String> zipped = Functions._zipWith(f, l1, null);

        assertNotNull(zipped);
        assertEquals(0, zipped.size());
    }

    @Test
    public void testZipWith() {
        List<String> l1 = Arrays.asList("a", "b", "c");
        List<Integer> l2 = Arrays.asList(new Integer(1), new Integer(2), new Integer(3));
        BiFunction<String, Integer, String> f = FunctionsTest::repeat;
        List<String> zipped = Functions.zipWith(f, l1, l2);

        assertNotNull(zipped);
        assertEquals(3, zipped.size());
        assertEquals("a", zipped.get(0));
        assertEquals("bb", zipped.get(1));
        assertEquals("ccc", zipped.get(2));
    }

    @Test
    public void testZip() {
        List<String> l1 = Arrays.asList("a", "b", "c");
        List<Integer> l2 = Arrays.asList(new Integer(1), new Integer(2), new Integer(3));
        List<SimpleEntry<String, Integer>> zipped = Functions.zip(l1, l2);

        assertNotNull(zipped);
        assertEquals(3, zipped.size());
        assertEquals("a", zipped.get(0).getKey());
        assertEquals(new Integer(1), zipped.get(0).getValue());
        assertEquals("b", zipped.get(1).getKey());
        assertEquals(new Integer(2), zipped.get(1).getValue());
        assertEquals("c", zipped.get(2).getKey());
        assertEquals(new Integer(3), zipped.get(2).getValue());
    }

}
