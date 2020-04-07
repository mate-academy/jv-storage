package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int SIZE = 10;

    private K[] keys;
    private V[] values;
    private int count = 0;

    public StorageImpl() {
        keys = (K[]) new Object[SIZE];
        values = (V[]) new Object[SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i <= count; i++) {
            if (keys[i] == null && key == null
                    || keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                count++;
                return;
            }
            if (keys[i] == null && values[i] == null && key != null) {
                keys[i] = key;
                values[i] = value;
                count++;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i <= count; i++) {
            if (keys[i] == null && key == null
                    || keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }
}
