package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private final Pair<K, V>[] data;
    private int size;

    public StorageImpl() {
        size = 0;
        data = new Pair[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndexByKey(key);
        if (index != -1) {
            data[index].setValue(value);
        } else {
            data[size++] = new Pair<>(key, value);
        }
    }

    @Override
    public V get(K key) {
        int index = getIndexByKey(key);
        return index != -1 ? data[index].getValue() : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexByKey(K key) {
        for (int i = 0; i < size; i++) {
            K currentKey = data[i].getKey();
            if (currentKey == key || (currentKey != null && currentKey.equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
