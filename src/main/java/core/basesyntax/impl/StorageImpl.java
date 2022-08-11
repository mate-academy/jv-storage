package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;
    private K[] keys = (K[]) new Object[MAX_ELEMENTS_NUMBER];
    private V[] values = (V[]) new Object[MAX_ELEMENTS_NUMBER];
    private int size;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key && values[i] != null || keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                break;
            } else if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                size++;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size(); i++) {
            if (this.keys[i] == key || this.keys[i] != null && this.keys[i].equals(key)) {
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
