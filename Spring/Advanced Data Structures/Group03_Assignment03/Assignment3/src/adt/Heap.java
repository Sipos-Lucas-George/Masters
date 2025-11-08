package adt;

import java.util.ArrayList;
import java.util.Comparator;

public class Heap<T extends Comparable<T>> {
	private ArrayList<T> heap;
	private Comparator<T> comparator;

	public Heap() {
		this.heap = new ArrayList<>();
		this.comparator = Comparator.naturalOrder();
	}

	public Heap(Comparator<T> comparator) {
		this.heap = new ArrayList<>();
		this.comparator = comparator;
	}

	// Swap two elements in the heap
	private void swap(int i, int j) {
		T temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}

	// Restore heap property upwards after insertion
	private void heapifyUp(int index) {
		while (index > 0) {
			int parent = (index - 1) / 2;
			if (comparator.compare(heap.get(index), heap.get(parent)) < 0) {
				swap(index, parent);
				index = parent;
			} else {
				index = -1;
			}
		}
	}

	// Restore heap property downwards after extraction
	private void heapifyDown(int index) {
		int size = heap.size();
		while (true) {
			int left = 2 * index + 1;
			int right = 2 * index + 2;
			int smallest = index;

			if (left < size && comparator.compare(heap.get(left), heap.get(smallest)) < 0) {
				smallest = left;
			}
			if (right < size && comparator.compare(heap.get(right), heap.get(smallest)) < 0) {
				smallest = right;
			}
			if (smallest == index) {
				break;
			}
			swap(index, smallest);
			index = smallest;
		}
	}

	// Insert a new value into the heap
	public void insert(T value) {
		heap.add(value);
		heapifyUp(heap.size() - 1);
	}

	// Extract the minimum value from the heap
	public T popMin() {
		if (heap.isEmpty()) {
			throw new IllegalStateException("Heap is empty");
		}
		T min = heap.get(0);
		T last = heap.remove(heap.size() - 1);
		if (!heap.isEmpty()) {
			heap.set(0, last);
			heapifyDown(0);
		}
		return min;
	}

	// Peek at the minimum value without removing it
	public T peek() {
		if (heap.isEmpty()) {
			throw new IllegalStateException("Heap is empty");
		}
		return heap.get(0);
	}

	// Change the value of a key and maintain heap property
	public void changeValue(int index, T newValue) {
		if (index < 0 || index >= heap.size()) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		T oldValue = heap.get(index);
		heap.set(index, newValue);

		if (comparator.compare(newValue, oldValue) < 0) {
			heapifyUp(index);
		} else {
			heapifyDown(index);
		}
	}

	// Get the size of the heap
	public int size() {
		return heap.size();
	}

	// Check if the heap is empty
	public boolean isEmpty() {
		return heap.isEmpty();
	}
}
