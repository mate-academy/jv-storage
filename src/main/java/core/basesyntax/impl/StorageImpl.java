package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private int size;
    private final K[] storageK;
    private final V[] storageV;

    public StorageImpl() {
        storageK = (K[]) new Object[MAX_ARRAY_SIZE];
        storageV = (V[]) new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keyExists(storageK[i], key)) {
                storageV[i] = value;
                return;
            }
        }
        storageK[size] = key;
        storageV[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keyExists(storageK[i],key)) {
                return storageV[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean keyExists(K firstKey, K secondKey) {
        return firstKey == secondKey || firstKey != null && firstKey.equals(secondKey);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StorageImpl<?, ?> storage = (StorageImpl<?, ?>) o;
        return Arrays.equals(storageK, storage.storageK)
                && Arrays.equals(storageV, storage.storageV);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(storageK);
        result = 31 * result + Arrays.hashCode(storageV);
        return result;
    }
}
