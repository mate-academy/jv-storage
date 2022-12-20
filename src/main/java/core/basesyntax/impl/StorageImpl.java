package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private K key;
    private V value;
    private int size = size();
    private final K[] keys;
    private final V[] values;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public StorageImpl() {
        keys = (K[]) new Object[MAX_CAPACITY];
        values = (V[]) new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        keys[size + 1] = getKey();
        values[size + 1] = getValue();
    }

    @Override
    public V get(K key) {
        if (size == 0) {
            keys[0] = key;
            values[0] = value;
        }
        for (int i = 0; i < size; i++) {
            if (!key.equals(keys[i])) {
                put(key, value);
                return values[size];
            } else {
                values[i] = value;
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int count = 0;
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
                count++;
            }
        }
        return count;
    }
}
