package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_IN_STORAGE = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_ELEMENTS_IN_STORAGE];
        this.values = (V[]) new Object[MAX_ELEMENTS_IN_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        int index = indexElement(key);
        if (index >= 0) {
            this.values[index] = value;
        } else {
            if (size == this.keys.length) {
                throw new OutOfMemoryError("Storage is completely full");
            }
            this.keys[size] = key;
            this.values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = indexElement(key);
        return index >= 0 ? values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexElement(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] != null && keys[i].equals(key)) || (key == null && keys[i] == null)) {
                return i;
            }
        }
        return -1;
    }
}

