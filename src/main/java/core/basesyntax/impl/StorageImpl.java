package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final StorageItem[] storageItems;
    private int indexCounter = 0;

    public StorageImpl() {
        this.storageItems = new StorageItem[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        StorageItem<K, V> existingStorageItem = getStorageItemByKey(key);
        if (existingStorageItem != null) {
            existingStorageItem.setValue(value);
            return;
        }
        StorageItem<K, V> storageItem = new StorageItem<>(key, value);
        try {
            storageItems[indexCounter] = storageItem;
            indexCounter++;
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("Storage is FULL, you can't add new item", e);
        }
    }

    @Override
    public V get(K key) {
        StorageItem<K, V> existingStorageItem = getStorageItemByKey(key);
        if (existingStorageItem != null) {
            return existingStorageItem.getValue();
        }
        return null;
    }

    @Override
    public int size() {
        return indexCounter;
    }

    private StorageItem<K, V> getStorageItemByKey(K key) {
        for (StorageItem<K, V> item : storageItems) {
            if (item != null) {
                if (item.getKey() == key || (item.getKey() != null && item.getKey().equals(key))) {
                    return item;
                }
            }
        }
        return null;
    }
}
