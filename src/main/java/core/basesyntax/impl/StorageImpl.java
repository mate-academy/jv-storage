package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Pair<K, V>[] items;

    public StorageImpl() {
        this.items = new Pair[STORAGE_DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (items[i].getKey() == null && key == null) {
                items[i].setValue(value);
                return;
            }
            if (items[i].getKey() != null && items[i].getKey().equals(key)) {
                items[i] = new Pair<>(key, value);
                return;
            }
        }
        if (size < STORAGE_DEFAULT_CAPACITY - 1) {
            items[size] = new Pair<>(key, value);
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && items[i].getKey() == null) {
                return items[i].getValue();
            }
            if (items[i].getKey() == null && key != null) {
                continue;
            }
            if (items[i].getKey().equals(key)) {
                return items[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
