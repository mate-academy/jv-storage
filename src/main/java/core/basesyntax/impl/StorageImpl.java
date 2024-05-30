package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_INDEX = 10;
    private int size;
    private final K[] keys;
    private final V[] value;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ARRAY_INDEX];
        value = (V[]) new Object[MAX_ARRAY_INDEX];
    }

    @Override
    public void put(K key, V value) {
        if (indexOf(key) != -1) {
            this.value[indexOf(key)] = value;
            return;
        }
        this.keys[size] = key;
        this.value[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (indexOf(key) != -1) {
            return this.value[indexOf(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
