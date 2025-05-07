package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_LENGTH = 10;
    private static final int NO_INDEX = -1;
    private int size = 0;
    private StorageObject<K, V>[] storage;

    public StorageImpl() {
        storage = new StorageObject[DEFAULT_LENGTH];
    }

    private class StorageObject<K, V> {
        private K key;
        private V value;

        public StorageObject(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void put(K key, V value) {
        int index = getIndexByKey(key);
        if (index != NO_INDEX) {
            storage[index].value = value;
            return;
        }
        if (size < DEFAULT_LENGTH) {
            storage[size] = new StorageObject<>(key, value);
            size++;
            return;
        }
        throw new StorageIndexOutOfBoundsException(DEFAULT_LENGTH);
    }

    @Override
    public V get(K key) {
        int index = getIndexByKey(key);
        return index != NO_INDEX ? storage[index].value : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keyCheck(key, storage[i].key)) {
                return i;
            }
        }
        return NO_INDEX;
    }

    private boolean keyCheck(K key, K storageObjectKey) {
        return ((key == storageObjectKey)
                || (storageObjectKey != null && storageObjectKey.equals(key)));
    }
}
