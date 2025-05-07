package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keys;
    private final V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (keys[i] == null && values[i] == null
                    || isKeysEqual(keys[i], key)) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
    }

    private boolean isKeysEqual(K key1, K key2) {
        return key1 == key2
                || key1 != null && key1.equals(key2);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_SIZE; i++) {
            if (isKeysEqual(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int index = MAX_SIZE - 1; index >= 0; index--) {
            if (keys[index] != null || values[index] != null) {
                return index + 1;
            }
        }
        return 0;
    }
}
