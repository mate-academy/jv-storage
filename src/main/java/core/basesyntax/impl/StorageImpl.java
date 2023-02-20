package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys = (K[]) new Object[10];
    private V[] values = (V[]) new Object[10];
    private int size;

    @Override
    public void put(K key, V value) {
        if (this.keys != null) {
            for (int i = 0; i < size; i++) {
                if (key == this.keys[i]
                        || key != null && key.equals(this.keys[i])) {
                    this.values[i] = value;
                    return;
                }
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
        //addCell(key, value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == this.keys[i]
                    || key != null && key.equals(this.keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return keys == null ? 0 : size;
    }
}
