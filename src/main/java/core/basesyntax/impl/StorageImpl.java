package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private int size = 0;
    private final Pair<K, V>[] storageMap = new Pair[10];

    public void put(K key, V value) {
        Pair<K, V> tempPair = findValue(key);
        if (tempPair == null) {
            storageMap[size++] = new Pair<>(key, value);
        } else {
            tempPair.setValue(value);
        }
    }

    private Pair<K, V> findValue(K key) {
        for (int i = 0; i < size; i++) {
            if (storageMap[i].getKey() != null
                    && storageMap[i].getKey().equals(key)
                    && storageMap[i].getValue() != null) {
                return storageMap[i];
            }
            if (storageMap[i].getKey() == null && key == null) {
                return storageMap[i];
            }
        }
        return null;
    }

    @Override
    public V get(K key) {
        return findValue(key) != null ? findValue(key).getValue() : null;
    }

    @Override
    public int size() {
        return size;
    }
}
