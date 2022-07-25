package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_PAIRS_NUMBER = 10;
    private K key;
    private V value;
    private StorageImpl<K, V>[] pairs;

    public StorageImpl() {
        pairs = new StorageImpl[MAX_PAIRS_NUMBER];
    }

    private StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public void put(K key, V value) {
        if (getIndex(key) < size()) {
            pairs[getIndex(key)].value = value;
        }
        pairs[getIndex(key)] = new StorageImpl<K, V>(key, value);
    }

    @Override
    public V get(K key) {
        return (getIndex(key) < size()) ? pairs[getIndex(key)].value : null;
    }

    @Override
    public int size() {
        int count = 0;
        for (int index = 0; index < MAX_PAIRS_NUMBER; index++) {
            if (pairs[index] == null) {
                count++;
            }
        }
        return MAX_PAIRS_NUMBER - count;
    }

    public int getIndex(K key) {
        for (int index = 0; index < MAX_PAIRS_NUMBER; index++) {
            if (pairs[index] != null && pairs[index].key == key) {
                return index;
            } else if (pairs[index] != null && pairs[index].key != null
                    && pairs[index].key.equals(key)) {
                return index;
            } else if (pairs[index] == null) {
                return index;
            }
        }
        return -1;
    }
}
