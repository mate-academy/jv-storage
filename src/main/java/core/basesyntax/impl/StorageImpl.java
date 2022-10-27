package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private final Object[] keys = new Object[MAX_LENGTH];
    private final Object[] values = new Object[MAX_LENGTH];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        boolean flag = true;
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if ((keys[i] != null && keys[i].equals(key))
                        || (keys[i] == null && key == null)) {
                    values[i] = value;
                    flag = false;
                    break;
                }
            }
        }
        if (flag && size < MAX_LENGTH) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if ((keys[i] != null && keys[i].equals(key))
                        || (keys[i] == null && key == null)) {
                    return (V)values[i];
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
