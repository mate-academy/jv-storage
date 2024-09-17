package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;
    private int size;
    private Pair<K, V>[] pair;

    public StorageImpl() {
        pair = new Pair[MAX_ELEMENTS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == pair[i].getKey() || (key != null && key.equals(pair[i].getKey()))) {
                pair[i].setValue(value);
                return;
            }
        }
        pair[size] = new Pair<K, V>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == pair[i].getKey() || key != null && key.equals(pair[i].getKey())) {
                return pair[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
