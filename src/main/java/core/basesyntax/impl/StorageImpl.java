package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUE = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        this.keys = new Object [MAX_VALUE];
        this.values = new Object [MAX_VALUE];
    }

    @Override
    public void put(K key, V value) {
        Integer n = toFindIndex(key);
        if (n == null) {
            this.keys[size] = key;
            this.values[size] = value;
            size++;
        } else {
            this.values[n] = value;
        }
    }

    @Override
    public V get(K key) {
        Integer n = toFindIndex(key);
        return n != null ? (V)values[n] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private Integer toFindIndex(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return null;
    }
}
