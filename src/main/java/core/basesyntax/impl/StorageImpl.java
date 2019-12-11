package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private final int ARRAY_SIZE = 10;

    public StorageImpl() {
        this.keys = (K[]) new Object[ARRAY_SIZE];
        this.values = (V[]) new Object[ARRAY_SIZE];
    }

    private int index = 0;

    @Override
    public void put(K key, V value) {
        if (key == null) {
            keys[index] = null;
            values[index] = value;
            index++;
        } else {
            for (int i = 0; i < index; i++) {
                if (key.equals(keys[i])) {
                    values[i] = value;
                    return;
                }
            }
            keys[index] = key;
            values[index] = value;
            index++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
                return values[i];
            }
        }
        return null;
    }

}
