package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH = 10;
    private int count = 0;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        this.keys = (K[]) new Object[LENGTH];
        this.values = (V[]) new Object[LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && key == null) {
                values[i] = value;
                break;
            }
            if (keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                break;
            }
        }
        keys[count] = key;
        values[count] = value;
        count++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && key == null) {
                count--;
                return values[i];
            }
            if (keys[i] != null && keys[i].equals(key)) {
                count--;
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
