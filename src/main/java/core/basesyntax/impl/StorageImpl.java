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
        for (int i = 0; i < size; i++) {
            if (isKeysEqual(key, i)) {
                items[i].setValue(value);
                return;
            }
        }
        items[size++] = new Pair<>(key, value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (isKeysEqual(key, i)) {
                return items[i].getValue();
            }
        }
        return null;
    }

    private boolean isKeysEqual(K key, int i) {
        K currentKey = items[i].getKey();
        return (key == currentKey) || (currentKey != null && currentKey.equals(key));
    }

    @Override
    public int size() {
        return size;
    }
}
