package tests;

import java.util.Comparator;
import adt.Heap;

import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {

    @Test
    public void testIsEmpty() {
        Heap<Integer> minHeap = new Heap<>();
        assertTrue(minHeap.isEmpty());
        minHeap.insert(10);
        assertFalse(minHeap.isEmpty());
        minHeap.popMin();
        assertTrue(minHeap.isEmpty());
    }

    @Test
    public void testInsertAndPeek() {
        Heap<Integer> minHeap = new Heap<>();
        minHeap.insert(10);
        assertEquals(10, (int) minHeap.peek());
        minHeap.insert(5);
        assertEquals(5, (int) minHeap.peek());
        minHeap.insert(20);
        assertEquals(5, (int) minHeap.peek());
        minHeap.insert(1);
        assertEquals(1, (int) minHeap.peek());
    }

    @Test
    public void testExtractMin() {
        Heap<Integer> minHeap = new Heap<>();
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(20);
        minHeap.insert(1);
        assertEquals(1, (int) minHeap.popMin());
        assertEquals(5, (int) minHeap.popMin());
        assertEquals(10, (int) minHeap.popMin());
        assertEquals(20, (int) minHeap.popMin());
        assertTrue(minHeap.isEmpty());
    }

    @Test
    public void testChangeValue() {
        Heap<Integer> minHeap = new Heap<>();
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(20);
        minHeap.insert(1);
        minHeap.changeValue(1, 0); // Change index 1 (value 5) to 0
        assertEquals(0, (int) minHeap.peek());
        minHeap.changeValue(0, 5); // Change index 0 (value 0) to 5
        assertEquals(1, (int) minHeap.peek());
    }

    @Test
    public void testHeapWithCustomComparator() {
    	Heap<String> stringHeap = new Heap<>(Comparator.<String>reverseOrder()); // Max heap
        stringHeap.insert("banana");
        assertEquals("banana", stringHeap.peek());
        stringHeap.insert("apple");
        assertEquals("banana", stringHeap.peek());
        stringHeap.insert("cherry");
        assertEquals("cherry", stringHeap.popMin());
    }

    @Test
    public void testExtractMinOnEmptyHeap() {
        Heap<Integer> minHeap = new Heap<>();
        Exception exception = assertThrows(IllegalStateException.class, minHeap::popMin);
        assertEquals("Heap is empty", exception.getMessage());
    }

    @Test
    public void testPeekOnEmptyHeap() {
        Heap<Integer> minHeap = new Heap<>();
        Exception exception = assertThrows(IllegalStateException.class, minHeap::peek);
        assertEquals("Heap is empty", exception.getMessage());
    }

    @Test
    public void testChangeValueOutOfBounds() {
        Heap<Integer> minHeap = new Heap<>();
        minHeap.insert(10);
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> minHeap.changeValue(2, 5));
        assertEquals("Index out of bounds", exception.getMessage());
    }

    @Test
    public void stressTest() {
        Heap<Integer> minHeap = new Heap<>();
        int size = 1_000_000;
        for (int i = size; i > 0; i--) {
            minHeap.insert(i);
        }
        for (int i = 1; i <= size; i++) {
            assertEquals(i, (int) minHeap.popMin()); // Should extract in sorted order
        }
        assertTrue(minHeap.isEmpty());
    }
}