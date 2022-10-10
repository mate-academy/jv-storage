package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int START_SIZE = 0;
    private static final int MISSING_KEY = -1;
    private K[] key;
    private V[] value;
    private int size;

    public StorageImpl() {
        this.key = (K[]) new Object[MAX_SIZE];
        this.value = (V[]) new Object[MAX_SIZE];
        this.size = START_SIZE;
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            this.key[size] = key;
            this.value[size] = value;
            size++;
        } else {
            this.value[indexOf(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (index != MISSING_KEY) {
            return this.value[index];
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < this.size; i++) {
            if (this.key[i] == key || (key != null && key.equals(this.key[i]))) {
                return i;
            }
        }
        return MISSING_KEY;
    }
}
