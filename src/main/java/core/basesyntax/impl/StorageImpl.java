package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private final Object[] keyStorage = new Object[MAX_STORAGE_SIZE];
    private final Object[] valueStorage = new Object[MAX_STORAGE_SIZE];
    private int count = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (Objects.equals(key, keyStorage[i])) {
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
        for (int i = 0; i < count; i++) {
            if (Objects.equals(key, keyStorage[i])) {
                return (V) valueStorage[i];
            }
        }

        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
