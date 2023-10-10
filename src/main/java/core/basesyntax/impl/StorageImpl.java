package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_ELEMENTS = 10;

    private final K[] keys = (K[]) new Object[MAX_STORAGE_ELEMENTS];
    private final V[] values = (V[]) new Object[MAX_STORAGE_ELEMENTS];
    private int counter = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_STORAGE_ELEMENTS; i++) {
            if ((keys[i] == null && key == null) || (keys[i] == null && values[i] == null)) {
                keys[i] = key;
                if (values[i] == null) {
                    counter++;
                }
                values[i] = value;
                return;
            }
            if (keys[i] != null) {
                if (keys[i].equals(key)) {
                    keys[i] = key;
                    values[i] = value;
                    return;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_STORAGE_ELEMENTS; i++) {
            if ((keys[i] == null && key == null) || keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return counter;
    }
}
