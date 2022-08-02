package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Object[] keys;
    private final Object[] values;
    private int pointer;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_NUMBER];
        values = new Object[MAX_ITEMS_NUMBER];
        pointer = 0;
    }

    @Override
    public void put(K key, V value) {
        if (pointer > 0) {
            for (int i = 0; i < size(); i++) {
                if (keys[i] == null && key == null || keys[i] != null && keys[i].equals(key)) {
                    values[i] = value;
                    return;
                }
            }
        }
        keys[pointer] = key;
        values[pointer++] = value;
    }

    @Override
    public V get(K key) {
        if (size() > 0) {
            for (int i = 0; i < size(); i++) {
                if (keys[i] == null && key == null || keys[i] != null && keys[i].equals(key)) {
                    return (V) values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return pointer;
    }
}
