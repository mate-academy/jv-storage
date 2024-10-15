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
        if (findIndexOfItemByKey(key) == INDEX_OF_ABSENT_KEY) {
            try {
                items[size] = new Pair<>(key, value);
            } catch (ArrayIndexOutOfBoundsException e) {
                increaseStorageSize();
                items[size] = new Pair<>(key, value);
            } finally {
                size++;
            }
        } else {
            items[findIndexOfItemByKey(key)] = new Pair<>(key, value);
        }
    }

    @Override
    public V get(K key) {
        return findIndexOfItemByKey(key) == -1
                ? null
                : items[findIndexOfItemByKey(key)].getValue();
    }

    @Override
    public int size() {
        return size;
    }

    private boolean areBothKeysNull(K firstKey, K secondKey) {
        return secondKey == null && firstKey == null;
    }

    private boolean areKeysEqual(K firstKey, K secondKey) {
        return secondKey != null && secondKey.equals(firstKey);
    }

    private void increaseStorageSize() {
        Pair<K, V>[] doubleSizedArray = new Pair[items.length * ARRAY_SIZE_MULTIPLICATOR];
        System.arraycopy(items, 0, doubleSizedArray, 0, items.length);
        items = doubleSizedArray;
    }

    private int findIndexOfItemByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (areKeysEqual(key, items[i].getKey()) || areBothKeysNull(items[i].getKey(), key)) {
                return i;
            }
        }
        return INDEX_OF_ABSENT_KEY;
    }
}
