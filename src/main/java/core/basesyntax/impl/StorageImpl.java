package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int size = 0;
    private Pair[] items;

    public StorageImpl() {
        items = new Pair[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (size > MAX_ITEMS_NUMBER) {
            return;
        }

        int index = findIndexByKey(key);
        if (index != -1) {
            items[index] = new Pair(key, value);
            return;
        }

        items[size] = new Pair(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        int index = findIndexByKey(key);
        if (index != -1) {
            Pair item = (Pair) items[index];
            return (V) item.value;
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndexByKey(K key) {
        for (int i = 0; i < size; i++) {
            Pair item = (Pair) items[i];
            if (key == item.key || (key != null && key.equals(item.key))) {
                return i;
            }
        }

        return -1;
    }

    private class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
