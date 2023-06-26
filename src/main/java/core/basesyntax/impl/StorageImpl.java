package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int START_CAPACITY = 10;
    private final KeyValuePair<K, V>[] array;
    private int size;

    public StorageImpl() {
        this.array = new KeyValuePair[START_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        KeyValuePair<K, V> instanceOfKeyValue = new KeyValuePair<>(key, value);
        for (int i = 0; i < size; i++) {
            if (check(key, i)) {
                array[i] = instanceOfKeyValue;
                return;
            }
        }
        if (size == START_CAPACITY) {
            throw new RuntimeException("The storage is full, you can replace an existing"
                    + " element!");
        }
        array[size++] = instanceOfKeyValue;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (check(key, i)) {
                return array[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean check(K key, int i) {
        return array[i].getKey() == key || array[i].getKey() != null
                && array[i].getKey().equals(key);
    }
}
