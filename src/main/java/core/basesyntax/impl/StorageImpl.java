package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private StorageItem<K, V>[] storageItems;

    public StorageImpl() {
        this.storageItems = new StorageItem[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        storageItems[index] = new StorageItem<>(key, value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageItems.length; i++) {
            if (storageItems[i] != null && Objects.equals(key, storageItems[i].getKey())) {
                return storageItems[i].getValue();
            }
        }
        return null;
    }

    private Integer getIndex(K key) {
        int i = 0;
        for (; i < storageItems.length; i++) {
            if (storageItems[i] == null || Objects.equals(key, storageItems[i].getKey())) {
                return i;
            }
        }
        throw new RuntimeException("Storage is full ");
    }

    @Override
    public int size() {
        int result = 0;
        for (int i = 0; i < storageItems.length; i++) {
            if (storageItems[i] != null) {
                result++;
            }
        }
        return result;
    }
}
