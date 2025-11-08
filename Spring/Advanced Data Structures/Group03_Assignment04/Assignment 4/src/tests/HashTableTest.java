package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adt.HashTable;

public class HashTableTest {

    private HashTable<Integer, String> hashTable;

    @BeforeEach
    void setUp() {
        hashTable = new HashTable<>();
    }

    @Test
    void testPutAndGetSingleElement() {
        hashTable.put(1, "One");
        assertEquals("One", hashTable.get(1));
    }

    @Test
    void testUpdateValueForExistingKey() {
        hashTable.put(1, "One");
        hashTable.put(1, "Uno");
        assertEquals("Uno", hashTable.get(1));
        assertEquals(1, hashTable.size());
    }

    @Test
    void testRemoveExistingKey() {
        hashTable.put(42, "Answer");
        String removed = hashTable.remove(42);
        assertEquals("Answer", removed);
        assertNull(hashTable.get(42));
        assertEquals(0, hashTable.size());
    }

    @Test
    void testRemoveNonExistentKey() {
        assertNull(hashTable.remove(999));
    }

    @Test
    void testGetFromEmptyTable() {
        assertNull(hashTable.get(123));
    }

    @Test
    void testCollisionHandling() {
        for (int i = 0; i < 100; i += 16) { // likely same bucket in small capacity
            hashTable.put(i, "Val" + i);
        }

        for (int i = 0; i < 100; i += 16) {
            assertEquals("Val" + i, hashTable.get(i));
        }
    }

    @Test
    void testResize() {
        for (int i = 0; i < 20; i++) {
            hashTable.put(i, "V" + i);
        }

        assertTrue(hashTable.capacity() > 16); // resized
        for (int i = 0; i < 20; i++) {
            assertEquals("V" + i, hashTable.get(i));
        }
    }

    @Test
    void testNullKeyHandling() {
        hashTable.put(null, "NULL");
        assertEquals("NULL", hashTable.get(null));

        hashTable.put(null, "UPDATED");
        assertEquals("UPDATED", hashTable.get(null));

        hashTable.remove(null);
        assertNull(hashTable.get(null));
    }

    @Test
    void testNullValueHandling() {
        hashTable.put(10, null);
        assertNull(hashTable.get(10));
        assertEquals(1, hashTable.size());
    }

    @Test
    void testLargeInsertionsPerformanceAndCorrectness() {
        int n = 1_000_000;
        for (int i = 0; i < n; i++) {
            hashTable.put(i, "V" + i);
        }

        assertEquals(n, hashTable.size());
        for (int i = 0; i < n; i++) {
            assertEquals("V" + i, hashTable.get(i));
        }
    }

    @Test
    void testDuplicateKeysWithDifferentValues() {
        hashTable.put(1, "A");
        hashTable.put(1, "B");
        hashTable.put(1, "C");
        assertEquals("C", hashTable.get(1));
        assertEquals(1, hashTable.size());
    }

    @Test
    void testMultipleRemovals() {
        for (int i = 0; i < 10; i++) {
            hashTable.put(i, "V" + i);
        }

        for (int i = 0; i < 10; i++) {
            assertEquals("V" + i, hashTable.remove(i));
        }

        assertEquals(0, hashTable.size());
    }
}