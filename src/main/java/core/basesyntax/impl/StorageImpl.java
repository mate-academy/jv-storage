package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keys = (K[]) new Object[MAX_SIZE];
    private final V[] values = (V[]) new Object[MAX_SIZE];
    private int size = 0;

    private boolean objectsEquals(K o1, K o2) {
        return o1 == o2 || (o1 != null && o1.equals(o2));
    }

    @Override
    public void put(K key, V value) {
        boolean newKey = true;
        for (int i = 0; i < size; i++) {
            if (objectsEquals(key, keys[i])) {
                values[i] = value;
                newKey = false;
            }
        }
        if (newKey) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (objectsEquals(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
