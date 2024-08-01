package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_SIZE_OF_ARRAY = 10;
    private int size;
    private EntityOfStorageImpl<K, V>[] entityOfStorageArr;

    public StorageImpl() {
        this.entityOfStorageArr = new EntityOfStorageImpl[DEFAULT_SIZE_OF_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        EntityOfStorageImpl<K, V> entity;
        if (!checkIfKeyPresent(key)) {
            entity = new EntityOfStorageImpl<>(key, value);
            entityOfStorageArr[size] = entity;
            size++;
        } else {
            for (int i = 0; i < size; i++) {
                if (entityOfStorageArr[i].getKey() == null
                        || entityOfStorageArr[i].getKey().equals(key)) {
                    entityOfStorageArr[i].setValue(value);
                }
            }
        }
    }

    @Override
    public V get(K key) {
        V result = null;
        for (int i = 0; i < size; i++) {
            if (entityOfStorageArr[i].getKey() == null && key != null) {
                continue;
            }
            if (entityOfStorageArr[i].getKey() == key
                    || entityOfStorageArr[i].getKey().equals(key)) {
                result = entityOfStorageArr[i].getValue();
            }

        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean checkIfKeyPresent(K key) {
        for (int i = 0; i < size; i++) {
            if (entityOfStorageArr[i].getKey() == null && key != null) {
                continue;
            }
            if (entityOfStorageArr[i].getKey() == key
                    || entityOfStorageArr[i].getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

}


