package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    K[] keys = (K[]) new Object[10];
    V[] values = (V[]) new Object[10];
    int size;

    @Override
    public void put(K key, V value) {
        int index = putValidator(keys, values, key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else if (index >= 0) {
            keys[index] = key;
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        return getValidator(key);
    }

    @Override
    public int size() {
        return size;
    }

    private int putValidator(K[] keys, V[] values, K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((((key == null && keys[i] == null) || (keys[i] != null && keys[i].equals(key))) && values[i] != null)) {
                return i;
            } else if ((key == null && keys[i] == null) || (key != null && keys[i] == null)) {
                return -1;
            }
        }
        return -1;
    }

    private V getValidator(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                return values[i];
            }
        }
        return null;
    }
}

