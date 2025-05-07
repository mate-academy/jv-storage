package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int BORDER = -1;
    private static final int MAX_ITEMS_NUMBER = 10;
    private int size = 0;
    private K[] key;
    private V[] value;

    public StorageImpl() {
        this.key = (K[]) new Object[MAX_ITEMS_NUMBER];
        this.value = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    private int createStorageCell(K key) {
        for (int i = 0; i < size(); i++) {
            if (key == this.key[i] || key != null && key.equals(this.key[i])) {
                return i;
            }
        }
        return BORDER;
    }

    @Override
    public void put(K key, V value) {
        if (createStorageCell(key) != BORDER) {
            this.value[createStorageCell(key)] = value;
        } else {
            this.key[size] = key;
            this.value[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        if (createStorageCell(key) != BORDER) {
            return (V) value[createStorageCell(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
