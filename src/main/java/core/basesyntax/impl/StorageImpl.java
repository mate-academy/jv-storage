package core.basesyntax.impl;

import core.basesyntax.Pair;
import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_STORAGE_SIZE = 2;
    private static final int MULTIPLIER_STORAGE_SIZE = 2;
    private int nextFreeIndex = 0;
    private Pair<K, V>[] storage = new Pair[INITIAL_STORAGE_SIZE];

    @Override
    public void put(K key, V value) {
        boolean hasEqualKey = false;

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                break;
            }

            if (Objects.equals(storage[i].getKey(), key)) {
                hasEqualKey = true;
                storage[i].setValue(value);
            }
        }

        if (hasEqualKey) {
            return;
        }

        if (nextFreeIndex >= storage.length) {
            Pair<K, V>[] newPairStorage = new Pair[storage.length * MULTIPLIER_STORAGE_SIZE];
            for (int i = 0; i < storage.length; ++i) {
                newPairStorage[i] = storage[i];
            }
            storage = newPairStorage;
        }

        storage[nextFreeIndex++] = new Pair<>(key, value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < nextFreeIndex; ++i) {
            if (Objects.equals(storage[i].getKey(), key)) {
                return storage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return nextFreeIndex;
    }
}
