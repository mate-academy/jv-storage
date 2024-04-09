package core.basesyntax.impl;

import core.basesyntax.KV;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private KV<K, V>[] storage;

    public StorageImpl() {
        storage = (KV<K, V>[]) new KV<?, ?>[STORAGE_SIZE];
    }

    @Override
    public V get(K key) {
        int index = this.findIndex(key);

        return index == -1 ? null : storage[index].getValue();
    }

    @Override
    public void put(K key, V value) {
        int index = this.findIndex(key);

        if (index != -1) {
            storage[index].setValue(value);
            return;
        }

        for (int i = 0; i < STORAGE_SIZE; i++) {
            if (storage[i] == null) {
                storage[i] = new KV(key, value);
                return;
            }
        }
    }

    private int findIndex(K key) {
        for (int i = 0; i < STORAGE_SIZE; i++) {
            if (storage[i] != null) {
                if ((storage[i].getKey() == null && key == null)
                        || (storage[i].getKey() != null && storage[i].getKey().equals(key))) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < STORAGE_SIZE; i++) {
            if (storage[i] != null) {
                counter++;
            }
        }
        return counter;
    }
}
