package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Pair<K, V>[] storage;
    private int size;

    public StorageImpl() {
        storage = new Pair[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (size < MAX_ITEMS_NUMBER) {
            for (int i = 0; i < size; i++) {
                if (key == storage[i].getKey()
                        || (key != null && key.equals(storage[i].getKey()))) {
                    storage[i].setValue(value);
                    return;
                }
            }
            storage[size] = new Pair<>(key, value);
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == storage[i].getKey() || (key != null && key.equals(storage[i].getKey()))) {
                return storage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
