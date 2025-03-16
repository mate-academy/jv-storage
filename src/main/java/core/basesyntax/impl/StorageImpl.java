package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_COUNT = 10;
    private int size;
    private Pair<K, V>[] items;

    public StorageImpl() {
        items = new Pair[MAX_ELEMENTS_COUNT];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int i = getIndex(key);
        if (i != -1) {
            items[i].setValue(value);
        } else {
            items[size++] = new Pair<>(key, value);
        }
    }

    @Override
    public V get(K key) {
        int i = getIndex(key);
        return i != -1 ? items[i].getValue() : null;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            K currentKey = items[i].getKey();
            if (key == currentKey || currentKey != null && currentKey.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}
