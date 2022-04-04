package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] objectsK = new Object[10];
    private Object[] objectsV = new Object[10];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        objectsK[size] = (key == null) ? 1000 : key;
        objectsV[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        size++;
        Object result = new Object();
        Object cast = (Object) key;
        if (key == null) {
            for (int j = 0; j < size; j++) {
                if (objectsK[j].equals(1000)) {
                    result = objectsV[j];
                    size--;
                }
            }
            return (V)result;
        }
        result = null;
        for (int j = 0; j < objectsK.length; j++) {
            if (cast.equals(objectsK[j])) {
                result = objectsV[j];
                size--;
            }
        }
        return (V)result;
    }

    @Override
    public int size() {
        return size;
    }

}
