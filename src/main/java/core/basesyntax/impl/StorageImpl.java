package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_COUNT = 10;
    private int size;
    private Container<K, V>[] containers;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.containers = new Container[MAX_ELEMENTS_COUNT];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((containers[i].getKey() == null && key == null)
                    || (containers[i].getKey() != null && containers[i].getKey().equals(key))) {
                containers[i].setValue(value);
                return;
            }
        }
        if (size < MAX_ELEMENTS_COUNT) {
            containers[size] = new Container<>(key, value);
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((containers[i].getKey() == null && key == null)
                    || (containers[i].getKey() != null && containers[i].getKey().equals(key))) {
                return containers[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
