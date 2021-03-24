package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private final Object[] keyStorage = new Object[MAX_STORAGE_SIZE];
    private final Object[] valueStorage = new Object[MAX_STORAGE_SIZE];
    private int count = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (key == null && keyStorage[i] == null || key != null && key.equals(keyStorage[i])) {
                valueStorage[i] = value;
                return;
            }
        }

        keyStorage[count] = key;
        valueStorage[count] = value;
        count++;
    }

    @Override
    public V get(K key) {
        V result = null;

        for (int i = 0; i < count; i++) {
            if (key == null && keyStorage[i] == null || key != null && key.equals(keyStorage[i])) {
                result = (V) valueStorage[i];
            }
        }

        return result;
    }

    @Override
    public int size() {
        return count;
    }
}
