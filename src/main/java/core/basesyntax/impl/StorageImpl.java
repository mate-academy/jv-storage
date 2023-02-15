package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int START_CAPACITY = 10;
    private final KeyValuePair<K, V>[] array = new KeyValuePair[START_CAPACITY];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (size == 10) {
            throw new RuntimeException("The storage is full, you can replace an existing item!");
        }
        boolean isExist = false;
        KeyValuePair<K, V> instanceOfKeyValue = new KeyValuePair<>(key, value);
        for (int i = 0; i < size; i++) {
            if (array[i].getKey() == key || array[i].getKey() != null
                    && array[i].getKey().equals(key)) {
                array[i] = instanceOfKeyValue;
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            array[size] = instanceOfKeyValue;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (array[i].getKey() == key || array[i].getKey() != null
                    && array[i].getKey().equals(key)) {
                return array[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
