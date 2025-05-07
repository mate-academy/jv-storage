package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static int MAX_ITEMS_NUMBER = 10;
    private KeyValue<K, V>[] storage = new KeyValue[MAX_ITEMS_NUMBER];
    private int currSize = 0;

    private static class KeyValue<K, V> {
        private K key;
        private V value;

        private KeyValue(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currSize; i++) {
            if (storage[i].key == key || (storage[i].key != null && storage[i].key.equals(key))) {
                storage[i].value = value;
                return;
            }
        }
        storage[currSize] = new KeyValue<>(key, value);
        currSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currSize; i++) {
            if (storage[i].key == key || (storage[i].key != null && storage[i].key.equals(key))) {
                return storage[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currSize;
    }
}
