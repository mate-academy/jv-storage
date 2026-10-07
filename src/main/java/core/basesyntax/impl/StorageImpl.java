package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        this.size = 0;
        keys = (K[]) new Object[DEFAULT_CAPACITY];
        values = (V[]) new Object[DEFAULT_CAPACITY];
    }

    private boolean isSameKey(K k1, K k2) {
        return (k1 == null && k2 == null) || (k1 != null && k1.equals(k2));
    }

    @Override
    public void put(K newKey, V newValue) {
        for (int i = 0; i < keys.length; i++) {
            if (isSameKey(keys[i], newKey)) {
                if (values[i] == null) {
                    size++;
                }
                values[i] = newValue;
                return;
            }
        }
        if (size < DEFAULT_CAPACITY) {
            keys[size] = newKey;
            values[size] = newValue;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (isSameKey(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
