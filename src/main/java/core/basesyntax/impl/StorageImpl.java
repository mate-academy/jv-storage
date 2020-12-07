package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final Object[][] STORAGE = new Object[2][10];
    private static final int KEY = 0;
    private static final int VALUE = 1;
    private int index = 0;

    public void put(K key, V value) {
        STORAGE[KEY][index] = key;
        STORAGE[VALUE][index++] = value;
    }

    @Override
    public V get(K key) {
        V value = null;
        for (int i = 0; i < index; i++) {
            if (key != null && key.equals(STORAGE[KEY][i])
                    || key == null && STORAGE[KEY][i] == null) {
                value = (V) STORAGE[VALUE][i];
            }
        }
        return value;
    }
}
