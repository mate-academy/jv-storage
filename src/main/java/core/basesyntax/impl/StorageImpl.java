package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int HASHCODE_FOR_NULL = 121314;
    private static final int ARRAY_CAPACITY = 10;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        this.keys = new Object[ARRAY_CAPACITY];
        this.values = new Object[ARRAY_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && key != null) {
                keys[i] = key;
                values[i] = value;
                break;
            }
            if (key != null && keys[i].equals(key)) {
                values[i] = value;
                break;
            }
            if (key == null) {
                keys[i] = key;
                values[i] = value;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key != null && keys[i] != null && keys[i].equals(key)) {
                return (V) values[i];
            }

            if (key == null && keys[i] == null) {
                return (V) values[i];
            }
        }
        return null;
    }
}
