package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Object[] objectsK = new Object[MAX_SIZE];
    private Object[] objectsV = new Object[MAX_SIZE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((key == objectsK[i]) || (key != null && key.equals(objectsK[i]))) {
                objectsV[i] = value;
                return;
            }
        }
        objectsK[size] = key;
        objectsV[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        Object result = new Object();
        Object cast = (Object) key;
        for (int j = 0; j < size; j++) {
            if ((key == objectsK[j]) || (key != null && key.equals(objectsK[j]))) {
                return (V)objectsV[j];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
