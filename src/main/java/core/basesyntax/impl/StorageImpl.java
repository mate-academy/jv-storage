package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int lastElement;

    public StorageImpl() {
        keys = (K[]) new Object[ARRAY_SIZE];
        values = (V[]) new Object[ARRAY_SIZE];
        lastElement = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < lastElement; i++) {
            if ((keys[i] == key) || keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[lastElement] = key;
        values[lastElement] = value;
        lastElement++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < lastElement; i++) {
            if ((keys[i] == key) || keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return lastElement;
    }
}
