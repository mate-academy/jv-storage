package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int CAPACITY = 10;

    private Object[] keys;
    private Object[] values;
    private int itemsCount;

    public StorageImpl() {
        keys = new Object[CAPACITY];
        values = new Object[CAPACITY];
        itemsCount = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < itemsCount; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
            }
        }
        keys[itemsCount] = key;
        values[itemsCount] = value;
        itemsCount++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < itemsCount; i++) {
            if (keys[i] == key || keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }
}
