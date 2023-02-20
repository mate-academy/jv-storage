package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_SIZE = 10;
    private Object[] key;
    private Object[] value;
    private int size = 0;

    public StorageImpl() {
        value = (V[]) new Object[MAX_SIZE];
        key = (K[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (compareValue(this.key[i], key)) {
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
        for (int i = 0; i < size; i++) {
            if (compareValue(this.key[i], key)) {
                return (V) value[i];
            }
        }
        return null;
    }

    private boolean compareValue(Object obj1, Object obj2) {
        return obj1 == obj2 || obj1 != null && obj1.equals(obj2);
    }

    @Override
    public int size() {
        return size;
    }
}
