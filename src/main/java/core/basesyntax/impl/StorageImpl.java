package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ELEMENTS = 10;
    private StorageItem[] storageItems;
    private int size;

    public StorageImpl() {
        storageItems = new StorageItem[MAX_NUMBER_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (storageItems[i].key == null && key == null
                    || storageItems[i].key != null && storageItems[i].key.equals(key)) {
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
            if (storageItems[i].key == null && key == null
                    || storageItems[i].key != null && storageItems[i].key.equals(key)) {
                return (V) storageItems[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
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
