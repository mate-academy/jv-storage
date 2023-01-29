package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private K[] keys = (K[]) new Object[DEFAULT_CAPACITY];
    private V[] values = (V[]) new Object[DEFAULT_CAPACITY];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (isKeyRepeative(key, keys[i])) {
                values[i] = value;
                size++;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (isKeyRepeative(key, keys[i])) {
                size = getSizeWithUniqElements();
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isKeyRepeative(K key, K key2) {
        return ((key == null) && (key2 == null)
                || ((key != null) && (key.equals(key2))));
    }

    private int getSizeWithUniqElements() {
        int counterOfRepElemetns = 0;
        for (int i = 1; i <= size; i++) {
            if (isKeyRepeative(keys[i - 1], keys[i])) {
                counterOfRepElemetns++;
            }
        }
        return size - counterOfRepElemetns;
    }
}
