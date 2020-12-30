package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_OF_ARRAY = 10;
    private final Object[] keys;
    private final Object[] values;
    private int currentIndex;

    public StorageImpl() {
        this.keys = new Object[SIZE_OF_ARRAY];
        this.values = new Object[SIZE_OF_ARRAY];
        this.currentIndex = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentIndex; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[currentIndex] = key;
        values[currentIndex] = value;
        currentIndex++;
    }

    @Override
    public V get(K key) {
        for (int j = 0; j < currentIndex; j++) {
            if ((key == null & keys[j] == null) || (key != null && key.equals(keys[j]))) {
                return (V) values[j];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return -1;
    }
}
