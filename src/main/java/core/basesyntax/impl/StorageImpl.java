package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private static final int NOT_FOUND = -1;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_LENGTH];
        values = (V[]) new Object[MAX_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        int currentIndex = foundIndexKey(key);
        if (currentIndex == NOT_FOUND) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[currentIndex] = value;
        }
    }

    @Override
    public V get(K key) {
        int currentIndex = foundIndexKey(key);
        if (currentIndex != NOT_FOUND) {
            return values[currentIndex];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int foundIndexKey(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return NOT_FOUND;
    }
}
