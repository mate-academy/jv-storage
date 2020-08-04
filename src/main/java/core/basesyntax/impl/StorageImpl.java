package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private int realSize = 0;
    private MyPair<K, V>[] myStorage = new MyPair[MAX_STORAGE_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < realSize; i++) {
            if (isKeysEqual(key, myStorage[i])) {
                myStorage[i].setValue(value);
                return;
            }
        }
        myStorage[realSize++] = new MyPair<>(key, value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < realSize; i++) {
            if (isKeysEqual(key, myStorage[i])) {
                return myStorage[i].getValue();
            }
        }
        return null;
    }

    private boolean isKeysEqual(K key, MyPair<K, V> kvMyPair) {
        return kvMyPair.getKey() == key
                || (kvMyPair.getKey() != null && kvMyPair.getKey().equals(key));
    }
}
