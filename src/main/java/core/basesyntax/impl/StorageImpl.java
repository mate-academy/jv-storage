package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int DOUBLE_CAPACITY = 20;
    private final Object[] allObjects;
    private int lastAdded;

    public StorageImpl() {
        this.allObjects = new Object[DOUBLE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < lastAdded; i++) {
            if (Objects.equals(key, allObjects[i])) {
                allObjects[i + 1] = value;
                return;
            }
        }
        allObjects[lastAdded] = key;
        lastAdded++;
        allObjects[lastAdded] = value;
        lastAdded++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < lastAdded; i++) {
            if (Objects.equals(key, allObjects[i])) {
                return (V) allObjects[i + 1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return lastAdded / 2;
    }
}
