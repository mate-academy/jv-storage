package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH = 10;
    private final K[] keys;
    private final V[] values;
    private int index;

    public StorageImpl() {
        index = 0;
        keys = (K[]) new Object[LENGTH];
        values = (V[]) new Object[LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (indexOf(key) == -1) {
            keys[index] = key;
            values[index] = value;
            index++;
        } else {
            values[indexOf(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }

    private int indexOf(K key) {
        for (int i = 0; i < index; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }

}
