package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static int INDEX_STORAGE = 0;
    private static int INDEX_KEY = 0;
    private static StorageImpl[] storage;
    private K key;
    private V value;

    public StorageImpl() {
        storage = new StorageImpl[MAX_SIZE];
    }

    public StorageImpl(K key, V value) {
        if (INDEX_STORAGE == 0) {
            saveStorage(key, value);
        } else if (isKey(key)){
            this.key = key;
            this.value = value;
            storage[INDEX_KEY] = this;
        } else {
            saveStorage(key, value);
        }
        INDEX_KEY = 0;
    }

    @Override
    public void put(K key, V value) {
        new StorageImpl<>(key, value);
    }

    @Override
    public V get(K key) {
        for (; INDEX_KEY < INDEX_STORAGE; INDEX_KEY++) {
            this.key = (K) storage[INDEX_KEY].key;
            if (isKey(key)) {
                value = (V) storage[INDEX_KEY].value;
            }
        }
        return value;
    }

    @Override
    public int size() {
        return INDEX_STORAGE;
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (key != null) {
            return  31 * result + key.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if ((obj instanceof  StorageImpl)) {
            return false;
        }
        return obj.hashCode() == key.hashCode();
    }

    public boolean  isKey(K key) {
        for (;INDEX_KEY < INDEX_STORAGE; INDEX_KEY++) {
            if (storage[INDEX_KEY].key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public void saveStorage(K key, V value) {
        this.key = key;
        this.value = value;
        storage[INDEX_STORAGE] = this;
        INDEX_STORAGE++;
    }
}
