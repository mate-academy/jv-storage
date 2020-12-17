package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private Object[] keys;
    private Object[] values;
    private int index = 0;

    public StorageImpl() {
        this.keys = (K[]) new Object[ARRAY_LENGTH];
        this.values = (V[]) new Object[ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i <= index; i++) {
            if (keys[i] == null && values[i] != null) {
                continue;
            }
            if ((keys[i] == null && values[i] == null)
                    || (keys[i].equals(key) && values[i] != null)) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
        index++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i <= index; i++) {
            if (keys[i] == key
                    || keys[i] != null && keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return -1;
    }
}
