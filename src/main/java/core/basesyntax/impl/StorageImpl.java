package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int EMPTY_INDEX = -1;
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Pair<K, V>[] storage;
    private int size;

    public StorageImpl() {
        storage = new Pair[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (getElementIndex(key) == EMPTY_INDEX) {
            storage[size] = new Pair<>(key, value);
            size++;
        } else {
            storage[getElementIndex(key)].value = new Pair<>(key, value).value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((storage[i].key == key) || (storage[i].key != null && storage[i].key.equals(key))) {
                return storage[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public int getElementIndex(K key) {
        for (int i = 0; i < size; i++) {
            if ((storage[i].key == key) || (storage[i].key != null && storage[i].key.equals(key))) {
                return i;
            }
        }
        return EMPTY_INDEX;
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
