package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private K[] key;
    private V[] value;
    private int size;

    public StorageImpl() {
        this.key = (K[]) new Object[ARRAY_SIZE];
        this.value = (V[]) new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isEquals(this.key[i], key)) {
                this.value[i] = value;
                return;
            }
        }
        this.key[size] = key;
        this.value[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < this.key.length; i++) {
            if (isEquals(this.key[i], key)) {
                return value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isEquals(K firstKey, K secondKey) {
        if (firstKey == secondKey || (firstKey != null && firstKey.equals(secondKey))) {
            return true;
        }
        return false;
    }
}
