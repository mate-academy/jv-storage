package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private int size;
    private final Object[] keys;
    private final Object[] values;

    public StorageImpl() {
        keys = new Object[MAX_CAPACITY];
        values = new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = indexOf(key);
        if (isValidIndex(keyIndex)) {
            this.values[keyIndex] = value;
        } else {
            this.keys[size] = key;
            this.values[size] = value;
            size++;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) {
        int keyIndex = indexOf(key);
        if (isValidIndex(keyIndex)) {
            return (V) this.values[keyIndex];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private int indexOf(K key) {
        for (int i = 0; i < this.size(); i++) {
            if (areEqualsKeys((K) keys[i], key)) {
                return i;
            }
        }
        return -1;
    }

    private boolean areEqualsKeys(K firstKey, K secondKey) {
        return firstKey == secondKey || firstKey != null && firstKey.equals(secondKey);
    }

    private boolean isValidIndex(int keyIndex) {
        return keyIndex != -1;
    }
}
