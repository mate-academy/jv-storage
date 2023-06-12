package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_CAPACITY = 10;

    private final K[] keys;
    private final V[] values;
    private int currentSizeOfStorage;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_CAPACITY];
        values = (V[]) new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSizeOfStorage; i++) {
            if (Objects.equals(key, keys[i])) {
                values[i] = value;
                return;
            }
        }

        if (currentSizeOfStorage == MAX_CAPACITY) {
            throw new RuntimeException("Storage is full!");
        }

        keys[currentSizeOfStorage] = key;
        values[currentSizeOfStorage] = value;
        currentSizeOfStorage++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSizeOfStorage; i++) {
            if (Objects.equals(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSizeOfStorage;
    }
}
