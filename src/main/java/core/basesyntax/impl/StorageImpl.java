package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private int size;
    private final K[] key;
    private final V[] value;

    public StorageImpl() {
        size = 0;
        key = (K[]) new Object[CAPACITY];
        value = (V[]) new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        if (getCellKey(key) >= 0) {
            this.value[getCellKey(key)] = value;
        } else {
            this.key[size] = key;
            this.value[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = getCellKey(key);
        if (index == -1) {
            return null;
        }
        return this.value[index];
    }

    @Override
    public int size() {
        return size;
    }

    public int getCellKey(K key) {
        for (int index = 0; index < size; index++) {
            if (this.key[index] == key || (this.key[index] != null && this.key[index].equals(
                    key))) {
                return index;
            }
        }
        return -1;
    }
}
