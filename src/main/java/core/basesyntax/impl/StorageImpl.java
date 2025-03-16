package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_ARRAY = 10;
    private K[] keysArray;
    private V[] valuesArray;
    private int size;

    public StorageImpl() {
        this.keysArray = (K[]) new Object[MAX_SIZE_ARRAY];
        this.valuesArray = (V[]) new Object[MAX_SIZE_ARRAY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isequals(keysArray[i],key)) {
                valuesArray[i] = value;
                return;
            }
        }
        if (size < MAX_SIZE_ARRAY) {
            keysArray[size] = key;
            valuesArray[size] = value;
            size++;
        } else {
            throw new RuntimeException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (isequals(keysArray[i], key)) {
                return valuesArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isequals(Object obj1, Object obj2) {
        return obj2 == obj1 || obj2 != null && obj2.equals(obj1);
    }
}
