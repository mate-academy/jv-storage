package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int ELEMENT_NOT_FOUND = -1;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            int nullKeyIndex = findNullKeyIndex();
            if (nullKeyIndex != ELEMENT_NOT_FOUND) {
                values[nullKeyIndex] = value;
                return;
            }
        } else {
            int existingKeyIndex = findKeyIndex(key);
            if (existingKeyIndex != ELEMENT_NOT_FOUND) {
                values[existingKeyIndex] = value;
                return;
            }
        }
        if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            int nullKeyIndex = findNullKeyIndex();
            if (nullKeyIndex != ELEMENT_NOT_FOUND) {
                return values[nullKeyIndex];
            }
        } else {
            int existingKeyIndex = findKeyIndex(key);
            if (existingKeyIndex != ELEMENT_NOT_FOUND) {
                return values[existingKeyIndex];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    private int findNullKeyIndex() {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null) {
                return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }
}
