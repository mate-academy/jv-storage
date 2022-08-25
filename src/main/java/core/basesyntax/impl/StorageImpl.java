package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_SIZE = 10;
    private final K[] keysArray = (K[]) new Object[MAX_SIZE];
    private final V[] valuesArray = (V[]) new Object[MAX_SIZE];
    private int size;

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index != -1) {
            valuesArray[index] = (V) value;
            return;
        }
        keysArray[size] = (K) key;
        valuesArray[size] = (V) value;
        size++;
        return;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keysArray[i] == key || key != null && key.equals(keysArray[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index != -1) {
            return valuesArray[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

}
