package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUES_QUANTITY = 10;
    private K[] keys;
    private V[] values;
    private int size;

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
        for (int i = 0; i < size; i++) {
            if (isKeysEqual(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int valueIndex = 0;
        for (K k : keys) {
            if (isKeysEqual(k, key)) {
                return values[valueIndex];
            }
            valueIndex++;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
