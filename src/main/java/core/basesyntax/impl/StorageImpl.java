package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_SIZE_OF_ARRAY = 10;
    private int size;
    private Entity<K, V>[] entityOfStorageArr;

    public StorageImpl() {
        entityOfStorageArr = new Entity[DEFAULT_SIZE_OF_ARRAY];
    }

    @Override
    public void put(K key, V value) throws FullStorageException {
        if (size + 1 > DEFAULT_SIZE_OF_ARRAY) {
            throw new FullStorageException("The storage is full");
        }
        Entity<K, V> entity;
        for (int i = 0; i < size; i++) {
            if (entityOfStorageArr[i].getKey() == key || (entityOfStorageArr[i].getKey() != null
                    && entityOfStorageArr[i].getKey().equals(key))) {
                entityOfStorageArr[i].setValue(value);
                return;
            }
        }
        entity = new Entity<>(key, value);
        entityOfStorageArr[size] = entity;
        size++;
    }

    @Override
    public V get(K key) {
        V result = null;
        for (int i = 0; i < size; i++) {
            if (entityOfStorageArr[i].getKey() == key || (entityOfStorageArr[i].getKey() != null
                    && entityOfStorageArr[i].getKey().equals(key))) {
                result = entityOfStorageArr[i].getValue();
            }
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }
}


