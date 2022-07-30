package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE = 10;
    private Storage[] storage = new Storage[SIZE];
    private K key;
    private V value;

    public StorageImpl() {
    }

    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < SIZE; i++) {
            if (this.storage[i] == null) {
                this.storage[i] = new StorageImpl<>(key, value);
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < SIZE; i++) {
            if (this.storage[i] != null) {
                StorageImpl<K, V> temp = (StorageImpl<K, V>) this.storage[i];
                if (temp.key.equals(key)) {
                    return temp.value;
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return SIZE;
    }
}
