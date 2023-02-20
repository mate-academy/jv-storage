package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LIST_SIZE = 10;
    private static final int START_SIZE_VALUE = 1;
    private StoragePair<K,V>[] list;
    private int size = 0;

    public StorageImpl() {
        list = new StoragePair[MAX_LIST_SIZE];
    }

    @Override
    public void put(K key, V value) {
        size = START_SIZE_VALUE;
        StoragePair<K,V> tempStorage = new StoragePair<>(key, value);
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                size++;
            }
            if (list[i] == null || valid(i, key)) {
                list[i] = tempStorage;
                break;
            }
        }

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < list.length; i++) {
            if (valid(i, key)) {
                return list[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean valid(int i, K key) {
        return (list[i] != null && (list[i].getKey() == key
                || (list[i].getKey() != null && list[i].getKey().equals(key))));
    }
}
