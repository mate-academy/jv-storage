package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int size = 0;
    private final Object[] keys;
    private final Object[] values;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_NUMBER];
        values = new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (containsKey(key) != size) {
            values[containsKey(key)] = value;
            return;
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (containsKey(key) != size) {
            return (V) values[containsKey(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int containsKey(K key) {
        for (int i = 0; i < size; i++) {
            if (equalsObjects(keys[i], key)) {
                return i;
            }
        }
        return size;
    }

    private boolean equalsObjects(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }
}
