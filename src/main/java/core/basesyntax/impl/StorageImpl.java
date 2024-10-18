package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_DEFAULT_CAPACITY = 10;
    private static final int INDEX_OF_ABSENT_KEY = -1;
    private static final int ARRAY_SIZE_MULTIPLICATOR = 2;
    private int size;
    private Pair<K, V>[] items;

    public StorageImpl() {
        this.items = new Pair[STORAGE_DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int indexOfItemByKey = findIndexOfItemByKey(key);
        if (indexOfItemByKey == INDEX_OF_ABSENT_KEY) {
            if (size == items.length) {
                increaseStorageSize();
            }
            items[size] = new Pair<>(key, value);
            size++;
        } else {
            items[indexOfItemByKey] = new Pair<>(key, value);
        }
    }

    @Override
    public V get(K key) {
        int indexOfItemByKey = findIndexOfItemByKey(key);
        return indexOfItemByKey == INDEX_OF_ABSENT_KEY
                ? null
                : items[indexOfItemByKey].getValue();
    }

    @Override
    public int size() {
        return size;
    }

    private void increaseStorageSize() {
        Pair<K, V>[] doubleSizedArray = new Pair[items.length * ARRAY_SIZE_MULTIPLICATOR];
        System.arraycopy(items, 0, doubleSizedArray, 0, items.length);
        items = doubleSizedArray;
    }

    private int findIndexOfItemByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (items[i].areKeysEqual(key, items[i].getKey())) {
                return i;
            }
        }
        return INDEX_OF_ABSENT_KEY;
    }
}
