package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private Element<K, V>[] storage = null;
    private int position = 0;

    private static class Element<K, V> {
        private K key;
        private V value;

        public Element(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        if (size() == 0) {
            storage = new Element[STORAGE_SIZE];
        }
        for (int i = 0; i < size(); i++) {
            if (compareKeyAndStorageKey(key, storage[i].key)) {
                storage[i].value = value;
                return;
            }
        }
        if (position < STORAGE_SIZE) {
            Element<K, V> element = new Element<>(key, value);
            storage[position++] = element;
        }
    }

    @Override
    public V get(K key) {
        if (size() > 0) {
            for (int i = 0; i < size(); i++) {
                if (compareKeyAndStorageKey(key, storage[i].key)) {
                    return storage[i].value;
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return position;
    }

    private boolean compareKeyAndStorageKey(K key, K storageKey) {
        return ((key == null && storageKey == null)
                || (storageKey != null && storageKey.equals(key)));
    }
}
