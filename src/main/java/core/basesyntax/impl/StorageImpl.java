package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private K[] keys;
    private V[] values;
    private int index = 0;

    public StorageImpl() {
        index = 0;
        keys = (K[]) new Object[ARRAY_LENGTH];
        values = (V[]) new Object[ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (indexOf(key) == index) {
            keys[index] = key;
            values[index] = value;
            index++;
        }
        if (key != null) {
            for (int i = 0; i < keys.length; i++) {
                if (key.equals(keys[i])) {
                    values[i] = value;
                }
            }
        }
    }

    public int indexOf(K key) {
        if (key != null) {
            for (int i = 0; i < keys.length; i++) {
                if (key.equals(keys[i])) {
                    return i;
                }
            }
        }
        return index;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((key == keys[i]) || (key != null && key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }
}
