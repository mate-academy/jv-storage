package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys = (K[]) new Object[10];
    private V[] values = (V[]) new Object[10];
    private int index = 0;
    private int nullIndex = 0;

    @Override
    public void put(K key, V value) {
        if (key == null) {
            keys[index] = null;
            values[index] = value;
            nullIndex = index;
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
        if (key == null) {
            return values[nullIndex];
        }
        for (int i = 0; i < index; i++) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

}
