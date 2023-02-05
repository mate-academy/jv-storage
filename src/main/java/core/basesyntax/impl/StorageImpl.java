package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static int INDEX = 0;
    private K key;
    private V value;
    private StorageImpl[] storage;

    public StorageImpl() {
        storage = new StorageImpl[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        this.key = key;
        this.value = value;
        storage[INDEX] = this;
        INDEX++;
    }

    @Override
    public V get(K key) {
        V valueStorage = null;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].key.equals(key)) {
                valueStorage = (V) storage[i].value;
            }
        }
        return valueStorage;
    }

    @Override
    public int size() {
        return INDEX + 1;
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (key != null) {
            result = 31 * result + key.hashCode();
            result = 31 * result + value.hashCode();
            return result;
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
        StorageImpl equalsKey = (StorageImpl) obj;
        return (key == null && equalsKey.key == null) || equalsKey.key.equals(key);
    }
}
