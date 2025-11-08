package test;

import static org.junit.Assert.*;

import adt.Pair;
import org.junit.Test;

public class TestPair {

    @Test
    public void testConstructorAndFields() {
        Pair<Integer, String> pair = new Pair<>(1, "one");
        assertEquals(Integer.valueOf(1), pair.first);
        assertEquals("one", pair.second);
    }

    @Test
    public void testEquals_SameValues() {
        Pair<Integer, String> pair1 = new Pair<>(1, "one");
        Pair<Integer, String> pair2 = new Pair<>(1, "one");
        assertEquals(pair1, pair2);
    }

    @Test
    public void testEquals_DifferentValues() {
        Pair<Integer, String> pair1 = new Pair<>(1, "one");
        Pair<Integer, String> pair2 = new Pair<>(2, "two");
        assertNotEquals(pair1, pair2);
    }

    @Test
    public void testEquals_DifferentTypes() {
        Pair<Integer, String> pair1 = new Pair<>(1, "one");
        Pair<Integer, Integer> pair2 = new Pair<>(1, 1);
        assertNotEquals(pair1, pair2);
    }

    @Test
    public void testEquals_Null() {
        Pair<Integer, String> pair = new Pair<>(1, "one");
        assertNotEquals(pair, null);
    }

    @Test
    public void testEquals_SameObject() {
        Pair<Integer, String> pair = new Pair<>(1, "one");
        assertEquals(pair, pair);
    }

    @Test
    public void testHashCode_SameValues() {
        Pair<Integer, String> pair1 = new Pair<>(1, "one");
        Pair<Integer, String> pair2 = new Pair<>(1, "one");
        assertEquals(pair1.hashCode(), pair2.hashCode());
    }

    @Test
    public void testHashCode_DifferentValues() {
        Pair<Integer, String> pair1 = new Pair<>(1, "one");
        Pair<Integer, String> pair2 = new Pair<>(2, "two");
        assertNotEquals(pair1.hashCode(), pair2.hashCode());
    }

    @Test
    public void testToString() {
        Pair<Integer, String> pair = new Pair<>(1, "one");
        assertEquals("1 - one", pair.toString());
    }

    @Test
    public void testNullValues() {
        Pair<Integer, String> pair = new Pair<>(null, null);
        assertNull(pair.first);
        assertNull(pair.second);

        Pair<Integer, String> pair2 = new Pair<>(null, "test");
        assertNull(pair2.first);
        assertEquals("test", pair2.second);
    }
}

