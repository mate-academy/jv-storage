package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys = (K[]) new Object[10];
    private V[] values = (V[]) new Object[10];
    @Override
    public void put(K key, V value) {
        for (int j = 0; j < values.length; j++) {
            if (keys[j] == null && values[j] == null || keys[j] == null && key == null
                    && values[j] != null || keys[j] != null && keys[j].equals(key)) {
                keys[j] = key;
                values[j] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) {
                if (keys[i] == null && key == null || keys[i] != null && keys[i].equals(key)) {
                    return values[i];
                }
            }
            }
        return null;
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < values.length; i++) {
            if (keys[i] != null | values[i] != null) {
                counter++;
            }
        }
        return counter;
    }
}
