package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int INDEX_NOT_FOUND = -1;
    private int size;
    private K[] keys;
    private V[] values;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.size = 0;
        this.keys = (K[]) new Object[MAX_SIZE];
        this.values = (V[]) new Object[MAX_SIZE];
    }

    private void changeExistingKeyValue(K key, V value) {
        values[indexOf(key)] = value;
    }

    private int indexOf(K key) {
        if (size == 0) {
            return INDEX_NOT_FOUND;
        }
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    @Override
    public void put(K key, V value) {
        if (indexOf(key) != INDEX_NOT_FOUND) {
            changeExistingKeyValue(key, value);
            return;
        }
        keys[size] = key;
        values[size++] = value;
    }

    @Override
    public V get(K key) {
        return indexOf(key) != INDEX_NOT_FOUND
               ? values[indexOf(key)]
               : null;
    }

    @Override
    public int size() {
        return size;
    }
}
