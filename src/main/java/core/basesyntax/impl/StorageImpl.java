package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NOT_FOUND = -1;

    private static final int MAX_ITEMS_NUMBER = 10;
    private int size;
    private Pair<K, V> [] items;

    public StorageImpl() {
        items = new Pair[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int index = findIndexByKey(key);
        if (index != NOT_FOUND) {
            items[index].setValue(value);
            return;
        }

        items[size] = new Pair<>(key, value);
        size++;
    }

    private int findIndexByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (items[i].getKey() == key
                    || items[i].getKey() != null
                    && items[i].getKey().equals(key)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    @Override
    public V get(K key) {
        int index = findIndexByKey(key);
        return index == NOT_FOUND ? null : items[index].getValue();
    }

    @Override
    public int size() {
        return size;
    }

    private void compareStorage() {
        if (size == MAX_ITEMS_NUMBER) {
            throw new RuntimeException("Storage is full");
        }
    }
}
