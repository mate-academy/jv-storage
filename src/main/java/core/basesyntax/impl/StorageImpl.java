package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private Object[] keys = new Object[ARRAY_LENGTH];
    private Object[] values = new Object[ARRAY_LENGTH];

    @Override
    public void put(K key, V value) {
        new PutValue<>(key, value, keys, values);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((key == null && keys[i] == null) || ((key != null) && (key.equals(keys[i])))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int index = 0;
        for (Object obj : values) {
            if (obj != null) {
                index++;
            }
        }
        return index;
    }
}
