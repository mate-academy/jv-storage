package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_OF_STORAGE = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE_OF_STORAGE];
        values = (V[]) new Object[MAX_SIZE_OF_STORAGE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && key == null) {
                if (values[i] == null) {
                    size++;
                }
                values[i] = value;
                break;
            }
            if (keys[i] == null && key != null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                size++;
                break;
            }
            if (keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                break;
            }

        }

    }

    @Override
    public V get(K key) {
        if (key == null) {

            for (int i = 0; i < size(); i++) {
                if (keys[i] == null) {
                    return values[i];
                }
            }

        } else {
            for (int i = 0; i < size(); i++) {

                if (key.equals(keys[i])) {
                    return values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
