package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys = (K[]) new Object[10];
    private V[] values = (V[]) new Object[10];
    private int index;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                keys[i] = key;
                values[i] = value;
                index++;
                return;
            }
        }
        keys[index] = key;
        values[index] = value;
        index++;
    }

    @Override
    public V get(K key) {
        V value = null;
        for (int i = 0; i < keys.length; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                value = (V) values[i];
                break;
            }
        }
        return value;
    }
}
