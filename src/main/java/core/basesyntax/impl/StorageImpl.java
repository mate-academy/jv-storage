package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_STORAGE_PLACE = 10;
    private final Object[] value;
    private final Object[] key;
    private int currentSize;

    public StorageImpl() {
        key = new Object[MAX_STORAGE_PLACE];
        value = new Object[MAX_STORAGE_PLACE];
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
                return (V) this.value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private boolean equal(Object a, Object b) {
        if (a == b) {
            return true;
        }
        if (a == null || b == null || a.getClass() != b.getClass()) {
            return false;
        }
        return (a == b) || (a != null && a.equals(b));
    }
}
