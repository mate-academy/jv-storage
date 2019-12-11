package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private int size;
    private Object[] arrayKeys;
    private Object[] arrayValues;

    public StorageImpl() {
        this.size = 0;
        this.arrayKeys = new Object[CAPACITY];
        this.arrayValues = new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size + 1; i++) {
            if (key == arrayKeys[i] && key != null && key.equals(arrayKeys[i])) {
                arrayValues[i] = value;
                return;
            } else if (i == size && size < CAPACITY) {
                arrayKeys[i] = key;
                arrayValues[i] = value;
            }
        }
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arrayKeys.length; i++) {
            if (key == arrayKeys[i] || (key != null && key.equals(arrayKeys[i]))) {
                return (V) arrayValues[i];
            }
        }
        return null;
    }
}
