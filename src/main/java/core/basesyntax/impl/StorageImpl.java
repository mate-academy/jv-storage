package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final int maxSize = 10;
    Object[] keys =  new Object[maxSize];
    Object[] values = new Object[maxSize];
    private int indexCounter = 0;
    private int nullIndex;

    @Override
    public void put(K key, V value) {
        if (key == null) {
            keys[indexCounter] = null;
            values[indexCounter] = value;
            nullIndex = indexCounter;
            indexCounter++;
        } else {
            keys[indexCounter] = key;
            values[indexCounter] = value;
            indexCounter++;
            for (int i = 0; i < keys.length; i++) {
                if (key.equals(keys[i])) {
                    values[i] = value;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key == null) {
                return (V)values[nullIndex];
            } else if (keys[i] != null && keys[i].equals(key)) {
                return (V)values[i];
            }
        }
        return null;
    }
}
