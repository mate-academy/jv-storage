package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_STORAGE_PLACE = 10;
    private final V[] value;
    private final K[] key;
    private int currentSize;

    public StorageImpl() {
        key = (K[]) new Object[MAX_STORAGE_PLACE];
        value = (V[]) new Object[MAX_STORAGE_PLACE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSize; i++) {
            if (equal(key,this.key[i])) {
                this.value[i] = value;
                return;
            }
        }
        this.key[currentSize] = key;
        this.value[currentSize] = value;
        currentSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (equal(key,this.key[i])) {
                return this.value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private boolean equal(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }
}
