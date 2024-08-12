package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_LENGTH = 10;

    private StorageItem[] storageItems = (StorageItem[]) new Object[MAX_STORAGE_LENGTH];

    @Override
    public void put(K key, V value) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    private class StorageItem {
        private K key;
        private V value;

        protected StorageItem(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
