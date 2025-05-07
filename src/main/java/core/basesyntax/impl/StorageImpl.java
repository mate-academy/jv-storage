package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Pair<K, V>[] items;
    private int size;

    public StorageImpl() {
        items = new Pair[MAX_ITEMS_NUMBER];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size == MAX_ITEMS_NUMBER) {
            return;
        }
        int index = getIndex(key);
        Pair<K, V> item = new Pair<>(key, value);
        items[index] = item;
        if (index == size) {
            size++;
        }
    }

    @Override
    public V get(K key) {
        V value;
        int index = getIndex(key);
        value = index == size ? null : items[index].getValue();
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            K currentKey = items[i].getKey();
            if (currentKey == null ? key == null : currentKey.equals(key)) {
                return i;
            }
        }
        return size;
    }
}
