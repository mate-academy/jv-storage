package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ROW = 10;
    private static final int MAX_COLUMN = 2;
    private static final int KEY_INDEX = 0;
    private static final int VALUE_INDEX = 1;
    private Object[][] pairs;
    private int usedSpace;

    public StorageImpl() {
        this.pairs = new Object[MAX_ROW][MAX_COLUMN];
    }

    @Override
    public void put(K key, V value) {
        boolean newKey = true;
        for (int i = 0; i < usedSpace; i++) {
            if (compare(pairs[i][KEY_INDEX], key)) {
                pairs[i][VALUE_INDEX] = value;
                newKey = false;
                break;
            }
        }
        if (this.usedSpace == MAX_ROW) {
            throw new RuntimeException("Storage is full! Denys asked me to throw this exception");
        }
        if (newKey) {
            pairs[usedSpace][KEY_INDEX] = key;
            pairs[usedSpace][VALUE_INDEX] = value;
            usedSpace++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < usedSpace; i++) {
            if (compare(pairs[i][KEY_INDEX], key)) {
                return (V) pairs[i][VALUE_INDEX];
            }
        }
        return null;
    }

    private boolean compare(Object a, Object b) {
        return a == null ? a == b : a.equals(b);
    }

    @Override
    public int size() {
        return usedSpace;
    }
}
