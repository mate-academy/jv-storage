package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private K[] keys = (K[]) new Object[ARRAY_SIZE];
    private V[] values = (V[]) new Object[ARRAY_SIZE];
    private int index;
    private int size;
    private K key;

    @Override
    public void put(K key, V value) {
        boolean isDuplicated = false;
        if (this.key == null && key == null) {
            size++;
        }
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == null && key == null) || (key != null && key.equals(keys[i]))) {
                values[i] = value;
                isDuplicated = true;
            }
        }
        if (isDuplicated == false) {
            keys[index] = key;
            values[index] = value;
            index++;
            size++;
        }
        this.key = key;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            key = (K) "null";
        }
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null) {
                keys[i] = (K) "null";
            }
            if (keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
