package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_LENGTH = 10;

    private V[] values;
    private K[] keys;

    private int storageIndex;

    public StorageImpl() {
        this.values = (V[]) new Object[MAX_STORAGE_LENGTH];
        this.keys = (K[]) new Object[MAX_STORAGE_LENGTH];
        this.storageIndex = 0;
    }

    @Override
    public void put(K key, V value) {
        if (isIndexOutOfBounds()) {
            throw new RuntimeException("Storage is out of bounds");
        }

        if (isItemExistsInArray(key)) {
            values[getValueIndex(key)] = value;
        } else {
            this.keys[storageIndex] = key;
            this.values[storageIndex] = value;

            storageIndex++;
        }
    }

    @Override
    public V get(K key) {
        if (isItemExistsInArray(key)) {
            return values[getValueIndex(key)];
        }

        return null;
    }

    @Override
    public int size() {
        return storageIndex;
    }

    private class StorageItem {
        private K key;
        private V value;

        protected StorageItem(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private boolean isIndexOutOfBounds() {
        return storageIndex - 1 >= MAX_STORAGE_LENGTH;
    }

    private boolean isItemExistsInArray(K key) {
        int index = getValueIndex(key);

        return index >= 0;
    }

    private int getValueIndex(K key) {
        for (int i = 0; i < storageIndex; i++) {
            if (key != null ? key.equals(keys[i]) : keys[i] == null) {
                return i;
            }
        }

        return -1;
    }

}
