package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[10];
        values = new Object[10];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            @SuppressWarnings("unchecked")
            K existingKey = (K) keys[i];
            if (Objects.equals(existingKey, key)) {
                values[i] = value;
                return;
            }
        }
        if (size == keys.length) {
            expand();
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            K existingKey = (K) keys[i];
            if (Objects.equals(existingKey, key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private void expand() {
        Object[] newKeys = new Object[keys.length * 2];
        Object[] newValues = new Object[values.length * 2];
        System.arraycopy(keys, 0, newKeys, 0, keys.length);
        System.arraycopy(values, 0, newValues, 0, values.length);
        keys = newKeys;
        values = newValues;
    }
}
