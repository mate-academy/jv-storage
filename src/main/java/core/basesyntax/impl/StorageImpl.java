package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ELEMENTS = 10;
    private StorageItem<K, V>[] storageItems;
    private int size;

    public StorageImpl() {
        storageItems = new StorageItem[MAX_NUMBER_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (areKeysEqual(storageItems[i].key, key)) {
                storageItems[i].key = key;
                storageItems[i].value = value;
                return;
            }
        }
        if (size < MAX_NUMBER_OF_ELEMENTS) {
            storageItems[size++] = new StorageItem<>(key, value);
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (areKeysEqual(storageItems[i].key, key)) {
                return storageItems[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean areKeysEqual(K key1, K key2) {
        return key1 == null && key2 == null
                || key1 != null && key1.equals(key2);
    }

    private static class StorageItem<K, V> {
        private K key;
        private V value;

        public StorageItem(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
