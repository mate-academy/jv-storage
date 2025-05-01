package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private int size;
    private Element<K, V>[] storage;

    public StorageImpl() {
        storage = new Element[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = new Element<>(key, value);
                size++;
                break;
            }
            if (equality(storage[i].key, key)) {
                storage[i].value = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (equality(storage[i].key, key)) {
                return storage[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private <T> boolean equality(K elementOne, K elementSecond) {
        return elementOne == elementSecond
                || elementOne != null && elementOne.equals(elementSecond);
    }

    private class Element<K, V> {
        private K key;
        private V value;

        public Element(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
