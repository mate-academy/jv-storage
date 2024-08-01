package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_SIZE_OF_ARRAY = 10;
    private int size;
    private Entity<K, V> entity;
    private Entity<K, V>[] entityArr;

    public StorageImpl() {
        this.entityArr = new Entity[DEFAULT_SIZE_OF_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        if (!checkIfKeyPresent(key)) {
            entity = new Entity<>(key, value);
            entityArr[size] = entity;
            size++;
        } else {
            for (int i = 0; i < size; i++) {
                if (entityArr[i].getKey() == null || entityArr[i].getKey().equals(key)) {
                    entityArr[i].setValue(value);
                }

            }
        }
    }

    @Override
    public V get(K key) {
        V result = null;
        for (int i = 0; i < size; i++) {
            if (entityArr[i].getKey() == null && key != null) {
                continue;
            }
            if (entityArr[i].getKey() == key || entityArr[i].getKey().equals(key)) {
                result = entityArr[i].getValue();
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
            if (entityArr[i].getKey() == null && key != null) {
                continue;
            }
            if (entityArr[i].getKey() == key || entityArr[i].getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

}


