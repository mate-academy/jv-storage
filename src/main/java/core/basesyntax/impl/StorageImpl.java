package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final Object[][] STORAGE = new Object[2][10];
    private static final int KEY = 0;
    private static final int VALUE = 1;
    private int index = 0;

    public void put(K key, V value) {
        int existKey = inedxOf(key);
        if (existKey < 0) {
            STORAGE[KEY][index] = key;
            STORAGE[VALUE][index++] = value;
        } else {
            STORAGE[VALUE][existKey] = value;
        }
    }

    @Override
    public V get(K key) {
        int existKey = inedxOf(key);
        return existKey < 0 ? null : (V) STORAGE[VALUE][existKey];
    }

    private int inedxOf(K key) {
        for (int i = 0; i < index; i++) {
            if (key != null && key.equals(STORAGE[KEY][i])
                    || key == null && STORAGE[KEY][i] == null) {
                return i;
            }
        }
        return -1;
    }
}
