package adt;

public class HashTable<K, V> {

	// Inner class representing a key-value pair in a linked list.
	private class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

	private Entry<K, V>[] table; // Array of buckets (each bucket is the head of a linked list).
	private int capacity; // Current number of buckets.
	private int size; // Total number of key-value pairs.
	private double loadFactorThreshold; // Threshold to trigger resizing.

	// Initial capacity of 16 buckets and load factor threshold of 0.75.
	public HashTable() {
		this.capacity = 16;
		this.size = 0;
		this.loadFactorThreshold = 0.75;
		this.table = new Entry[capacity];
	}

	// Computes the bucket index for a given key.
	private int hash(K key) {
		if (key == null) {
			return 0;
		}
		int hashCode = key.hashCode();
		int positiveHash = (hashCode < 0) ? -hashCode : hashCode;
		return positiveHash % capacity;
	}

	/**
	 * Inserts a key-value pair into the hash table. If the key already exists, its
	 * value is updated.
	 */
	public void put(K key, V value) {
		int index = hash(key);
		Entry<K, V> current = table[index];
		// Check if the key exists and update its value.
		while (current != null) {
			if ((key == null && current.key == null) || (key != null && key.equals(current.key))) {
				current.value = value;
				return;
			}
			current = current.next;
		}
		// If not found, create a new entry and insert it at the head of the chain.
		Entry<K, V> newEntry = new Entry<K, V>(key, value);
		newEntry.next = table[index];
		table[index] = newEntry;
		size++;

		// Resize if the current load factor exceeds the threshold.
		if ((double) size / capacity >= loadFactorThreshold) {
			resize();
		}
	}

	// Retrieves the value associated with the given key.
	public V get(K key) {
		int index = hash(key);
		Entry<K, V> current = table[index];
		while (current != null) {
			if ((key == null && current.key == null) || (key != null && key.equals(current.key))) {
				return current.value;
			}
			current = current.next;
		}
		return null;
	}

	// Removes the key-value pair for the specified key.
	public V remove(K key) {
		int index = hash(key);
		Entry<K, V> current = table[index];
		Entry<K, V> prev = null;
		while (current != null) {
			if ((key == null && current.key == null) || (key != null && key.equals(current.key))) {
				if (prev == null) {
					table[index] = current.next;
				} else {
					prev.next = current.next;
				}
				size--;
				return current.value;
			}
			prev = current;
			current = current.next;
		}
		return null;
	}

	// Doubles the capacity of the table and rehashes all entries.
	private void resize() {
		int oldCapacity = capacity;
		capacity *= 2;
		Entry<K, V>[] oldTable = table;
		table = new Entry[capacity];
		size = 0; // Will be updated as we reinsert entries.

		for (int i = 0; i < oldCapacity; i++) {
			Entry<K, V> current = oldTable[i];
			while (current != null) {
				// Save next pointer because put() will overwrite current.next.
				Entry<K, V> nextEntry = current.next;
				// Reinsert the entry into the new table.
				put((K) current.key, (V) current.value);
				current = nextEntry;
			}
		}
	}

	// Returns the current number of key-value pairs.
	public int size() {
		return size;
	}

	// Returns the current capacity (number of buckets).
	public int capacity() {
		return capacity;
	}
}