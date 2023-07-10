package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private KeyValue<K, V>[] keyValueArray;
    private int size = 0;

    public StorageImpl() {
        keyValueArray = (KeyValue<K, V>[]) new KeyValue[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyValueArray.length; i++) {
            if (keyValueArray[i] == null) {
                keyValueArray[i] = new KeyValue<>(key, value);
                size++;
                return;
            }
            if (keyValueArray[i].getKey() == key || keyValueArray[i].getKey() != null
                    && keyValueArray[i].getKey().equals(key)) {
                keyValueArray[i] = new KeyValue<>(key, value);
                return;
            }
        }
        throw new RuntimeException("The storage is full!");
    }

    @Override
    public V get(K key) {
        for (KeyValue<K, V> keyValue : keyValueArray) {
            if (keyValue == null) {
                continue;
            }
            if (keyValue.getKey() == key || keyValue.getKey() != null
                    && keyValue.getKey().equals(key)) {
                return keyValue.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
