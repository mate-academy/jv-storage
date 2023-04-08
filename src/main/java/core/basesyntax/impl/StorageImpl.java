package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Pair<K, V>[] storage;

    public StorageImpl() {
        storage = new Pair[0];
    }

    @Override
    public void put(K key, V value) {
        int lengthStorage = storage.length;
        for (int i = 0; i < lengthStorage; i++) {
            if (storage[i].getKey() == null && key == null) {
                storage[i].setValue(value);
                return;
            } else if (storage[i].getKey() == null || key == null) {
                continue;
            }
            if (storage[i].getKey().equals(key)) {
                storage[i].setValue(value);
                return;
            }
        }
        Pair<K, V>[] localStorage = new Pair[lengthStorage + 1];
        for (int i = 0; i < lengthStorage; i++) {
            localStorage[i] = storage[i];
        }
        localStorage[lengthStorage] = new Pair<>(key, value);
        storage = localStorage;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].getKey() == null && key == null) {
                return storage[i].getValue();
            } else if (storage[i].getKey() == null || key == null) {
                continue;
            }
            if (storage[i].getKey().equals(key)) {
                return storage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storage.length;
    }
}
