package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10; // Maximum number of elements
    private K[] keys; // Array to store keys
    private V[] values; // Array to store values
    private int currentSize; // Number of elements currently stored

    // Constructor
    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE]; // Initialize keys array
        values = (V[]) new Object[MAX_SIZE]; // Initialize values array
        currentSize = 0; // Initialize size
    }

    @Override
    public void put(K key, V value) {
        // Check if the key already exists and update the value if it does
        for (int i = 0; i < currentSize; i++) {
            if (Objects.equals(keys[i], key)) {
                values[i] = value;
                return;
            }
        }

        // Add the new key-value pair if there's space
        if (currentSize < MAX_SIZE) {
            keys[currentSize] = key;
            values[currentSize] = value;
            currentSize++;
        } else {
            throw new IllegalStateException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        // Search for the key and return the corresponding value
        for (int i = 0; i < currentSize; i++) {
            if (Objects.equals(keys[i], key)) {
                return values[i];
            }
        }
        return null; // Return null if the key is not found
    }

    @Override
    public int size() {
        return currentSize; // Return the number of elements currently stored
    }
}
