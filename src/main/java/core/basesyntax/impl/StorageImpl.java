package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    public static final int INITIAL_SIZE = 10;
    public static final int LAST_INDEX_NUMBER = 9;

    private K[] keys = (K[]) new Object[INITIAL_SIZE];
    private V[] values = (V[]) new Object[INITIAL_SIZE];
    private int index = 0;

    @Override
    public void put(K key, V value) {
        if (index > LAST_INDEX_NUMBER) {
            throw new RuntimeException("Too many!");
        }
        for (int i = 0; i < keys.length; i++) {
            if (key == null && keys[i] == null) {
                if (values[i] == null) {
                    values[i] = value;
                    index++;
                    return;
                } else {
                    values[i] = value;
                    return;
                }

            }
            if (key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[index] = key;
        values[index] = value;
        index++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key != null && key.equals(keys[i])) {
                return values[i];
            }
            if (key == null && keys[i] == null) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
