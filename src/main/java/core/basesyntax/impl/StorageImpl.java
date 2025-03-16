package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int DOUBLE_CAPACITY = 20;
    private final Object[] objects;
    private int size;

    public StorageImpl() {
        objects = new Object[DOUBLE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (checkEqualObjects(key, objects[i])) {
                objects[i + 1] = value;
                return;
            }
        }
        objects[size] = key;
        size++;
        objects[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (checkEqualObjects(key, objects[i])) {
                return (V) objects[i + 1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size / 2;
    }

    private boolean checkEqualObjects(Object first, Object second) {
        return first == second || first != null && first.equals(second);
    }
}
