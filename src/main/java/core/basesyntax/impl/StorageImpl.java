package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys = (K[]) new Object[10];
    private V[] values = (V[]) new Object[10];
    private int size;

    @Override
    public void put(K key, V value) {
        equalsPutGet(key, value);
    }

    @Override
    public V get(K key) {
        return equalsPutGet(key, null);
    }

    @Override
    public int size() {
        return size;
    }

    private V equalsPutGet(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || (keys[i] != null && keys[i].equals(key))) {
                if (value == null) {
                    return values[i];
                } else {
                    values[i] = value;
                    return null;
                }
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
        return null;
    }
}
