package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUES_QUANTITY = 10;
    private K[] keys;
    private V[] values;
    private int putIndex;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_VALUES_QUANTITY];
        this.values = (V[]) new Object[MAX_VALUES_QUANTITY];
    }

    private boolean isKeysEqual(K arrayKey, K inputKey) {
        return arrayKey == inputKey
                || (arrayKey != null && arrayKey.equals(inputKey));
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < putIndex; i++) {
            if (isKeysEqual(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        keys[putIndex] = key;
        values[putIndex] = value;
        putIndex++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_VALUES_QUANTITY; i++) {
            if (isKeysEqual(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (V value : values) {
            size += value != null ? 1 : 0;
        }
        return size;
    }
}
