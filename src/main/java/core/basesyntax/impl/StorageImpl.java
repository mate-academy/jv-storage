package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS = 10;
    private KeyValuePair<K, V>[] storage;
    private int size = 0;

    public StorageImpl() {
        storage = new KeyValuePair[MAX_ITEMS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (equalsKeys(storage[i].getKey(), key)) {
                storage[i].setValue(value);
                return;
            }
        }
        if (size < MAX_ITEMS) {
            storage[size] = new KeyValuePair<>(key, value);
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (equalsKeys(storage[i].getKey(), key)) {
                return storage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean equalsKeys(K key1, K key2) {
        return (key1 == key2) || (key1 != null && key1.equals(key2));
    }
}
