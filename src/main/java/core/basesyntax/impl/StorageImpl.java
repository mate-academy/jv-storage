package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;
    private K key;
    private V value;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == null && key == null)
                    || ((keys[i] == key) || (keys[i] != null && keys[i].equals(key)))) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == null && key == null)
                    || ((keys[i] == key) || (keys[i] != null && keys[i].equals(key)))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) {
                size++;
            }
        }
        return size;
    }

    private V info(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == null && key == null)
                    || ((keys[i] == key) || (keys[i] != null && keys[i].equals(key)))) {
                return values[i];
            }
        }
        return null;
    }
}
