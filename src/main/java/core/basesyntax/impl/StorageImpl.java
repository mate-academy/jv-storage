package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;
    private final Pair[] data;
    private int size;

    public StorageImpl() {
        data = new Pair[MAX_ELEMENTS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (getElementOfData(key) != null) {
                data[i].setValue(value);
                return;
            }
        }
        Pair<K, V> pair = new Pair<>(key, value);
        data[size] = pair;
        size++;
    }

    @Override
    public V get(K key) {
        return getElementOfData(key) != null ? getElementOfData(key).getValue() : null;
    }

    @Override
    public int size() {
        return size;
    }

    private Pair<K, V> getElementOfData(K key) {
        for (int i = 0; i < size; i++) {
            if (key == data[i].getKey() || key != null && key.equals(data[i].getKey())) {
                return data[i];
            }
        }
        return null;
    }
}
