package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int elementQuantity = 0;

    public StorageImpl() {
        this.keys = new Object[SIZE];
        this.values = new Object[SIZE];
    }

    private int compareKeys(K key) {
        for (int i = 0; i < elementQuantity; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = compareKeys(key);
        if (index == -1) {
            values[elementQuantity] = value;
            keys[elementQuantity] = key;
            elementQuantity++;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = compareKeys(key);
        return index >= 0 ? (V) values[index] : null;
    }

    @Override
    public int size() {
        return elementQuantity;
    }
}
