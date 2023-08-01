package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int count = 0;
    private Inner[] items;

    public StorageImpl() {
        items = new Inner[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (count > MAX_ITEMS_NUMBER) {
            return;
        }

        int index = findIndexByKey(key);
        if (index != -1) {
            items[index] = new Inner(key, value);
            return;
        }

        items[count] = new Inner(key, value);
        count++;
    }

    @Override
    public V get(K key) {
        int index = findIndexByKey(key);
        if (index != -1) {
            Inner item = (Inner) items[index];
            return (V) item.value;
        }

        return null;
    }

    @Override
    public int size() {
        return count;
    }

    private int findIndexByKey(K key) {
        for (int i = 0; i < count; i++) {
            Inner item = (Inner) items[i];
            if (key == item.key || (key != null && key.equals(item.key))) {
                return i;
            }
        }

        return -1;
    }

    public class Inner<K, V> {
        private K key;
        private V value;

        public Inner(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
