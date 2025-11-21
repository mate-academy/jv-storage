package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys = (K[]) new Object[10];
    private V[] values = (V[]) new Object[10];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        boolean keyExists = false;
        for (int i = 0; i < size; i++) {
            if ((key != null && keys[i] != null) && key.equals(keys[i])
                    || (key == null && keys[i] == null)) {
                values[i] = value;
                keyExists = true;
            }
        }
        if (!keyExists) {
            values[size] = value;
            keys[size] = key;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((key != null && keys[i] != null) && key.equals(keys[i])
                    || (key == null && keys[i] == null)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
