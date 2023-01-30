package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K key;
    private V value;
    private int size = 0;
    private final StorageImpl<K, V>[] storage = new StorageImpl[MAX_SIZE];

    public StorageImpl() {
    }

    private StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public void put(K key, V value) {
        boolean isExist = false;
        for (int i = 0; i < size; i++) {
            if (key == storage[i].getKey()
                    || (storage[i].getKey() != null && storage[i].getKey().equals(key))) {
                storage[i].setValue(value);
                isExist = true;
            }
        }
        if (!isExist && size < MAX_SIZE) {
            storage[size] = new StorageImpl<>(key, value);
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == storage[i].getKey()
                    || (storage[i].getKey() != null && storage[i].getKey().equals(key))) {
                return storage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private K getKey() {
        return this.key;
    }

    private void setValue(V value) {
        this.value = value;
    }

    private V getValue() {
        return value;
    }
}
