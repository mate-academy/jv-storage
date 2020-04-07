package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int top;

    public StorageImpl() {
        this.keys = new Object[SIZE];
        this.values = new Object[SIZE];
        top = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < top; i++) {
            if (compare(key, (K) keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[top] = key;
        values[top] = value;
        top++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < top; i++) {
            if (compare(key, (K) keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    private boolean compare(K key, K keyArr) {
        return keyArr == key || (key != null && key.equals(keyArr));
    }
}
