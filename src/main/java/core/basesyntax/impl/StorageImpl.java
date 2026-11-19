package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int CAPACITY = 10;

    private int count;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        this.values = new Object[CAPACITY];
        this.keys = new Object[CAPACITY];
        this.count = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int keyIndex = 0; keyIndex < count; keyIndex++) {
            Object storedKey = keys[keyIndex];
            if (storedKey == null ? key == null : storedKey.equals(key)) {
                values[keyIndex] = value;
                return;
            }
        }
        keys[count] = key;
        values[count] = value;
        count++;
    }

    @Override
    public V get(K key) {
        for (int keyIndex = 0; keyIndex < count; keyIndex++) {
            Object storedKey = keys[keyIndex];
            if (storedKey == null ? key == null : storedKey.equals(key)) {
                return (V) values[keyIndex];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
