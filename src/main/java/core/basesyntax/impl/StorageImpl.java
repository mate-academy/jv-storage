package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_LENGTH = 10;
    private int size;
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

        private boolean keyCheck(K key) {
            return ((key == null && this.key == null)
                    || (this.key != null && this.key.equals(key)));
        }
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (storage[i].keyCheck(key)) {
                storage[i].value = value;
                return;
            }
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
        for (int i = 0; i < size; i++) {
            if (storage[i].keyCheck(key)) {
                return storage[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
