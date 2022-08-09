package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int ARRAY_SIZE = 10;
    private final Object[] keys = new Object[ARRAY_SIZE];
    private final Object[] values = new Object[ARRAY_SIZE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (size == 0) {
            this.keys[size] = key;
            this.values[size] = value;
            size++;
        } else {
            int index = getIndex(key);
            if (index != -1) {
                this.keys[index] = key;
                this.values[index] = value;
            } else {
                this.keys[size] = key;
                this.values[size] = value;
                size++;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
                return i;
            }
        }
        return -1;
    }
}
