package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_STORAGE_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int index = 0;
    private int sizeOfStorage;

    public StorageImpl() {
        keys = (K[]) new Object[DEFAULT_STORAGE_SIZE];
        values = (V[]) new Object[DEFAULT_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < index; i++) {
            if (Objects.equals(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[index] = key;
        values[index] = value;
        index++;
    }

    private int existingKeySearch(K key) {
        for (int i = 0; i < index; i++) {
            if (Objects.equals(key, keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        if (existingKeySearch(key) >= 0) {
            return values[existingKeySearch(key)];
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < DEFAULT_STORAGE_SIZE - 1; i++) {
            if (values[i] == null) {
                return sizeOfStorage;
            }
            sizeOfStorage++;
        }
        return sizeOfStorage;
    }
}
