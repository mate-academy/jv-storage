package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static int indexStorage = 0;
    private static int indexKey = 0;
    private static StorageImpl[] storage;
    private K key;
    private V value;

    public StorageImpl() {
        storage = new StorageImpl[MAX_SIZE];
    }

    public StorageImpl(K key, V value) {
        if (indexStorage == 0) {
            saveStorage(key, value);
        } else if (isKey(key)) {
            this.key = key;
            this.value = value;
            storage[indexKey] = this;
        } else {
            saveStorage(key, value);
        }
        indexKey = 0;
    }

    @Override
    public void put(K key, V value) {
        if (key != null) {
            new StorageImpl<>(key, value);
        } else {
            new StorageImpl<>(null, value);
        }
    }

    @Override
    public V get(K key) {
        for (; indexKey < indexStorage; indexKey++) {
            this.key = (K) storage[indexKey].key;
            if (isKey(key)) {
                return (V) storage[indexKey].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return indexStorage;
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (key != null) {
            return 31 * result + key.hashCode();
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
        if ((obj instanceof StorageImpl)) {
            return false;
        }
        return obj.hashCode() == key.hashCode();
    }

    public boolean isKey(K key) {
        if (key != null) {
            for (;indexKey < indexStorage; indexKey++) {
                if (storage[indexKey].key != null) {
                    if (storage[indexKey].key.equals(key)) {
                        return true;
                    }
                }
            }
        } else {
            for (;indexKey < indexStorage; indexKey++) {
                if (storage[indexKey].key == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void saveStorage(K key, V value) {
        this.key = key;
        this.value = value;
        storage[indexStorage] = this;
        indexStorage++;
    }
}
