package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LIST_SIZE = 10;
    private StoragePair<K,V>[] storagePairs;
    private int size;

    public StorageImpl() {
        storagePairs = new StoragePair[MAX_LIST_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isKeyInPair(storagePairs[i], key)) {
                storagePairs[i].value = value;
                return;
            }
        }
        storagePairs[size++] = new StoragePair<>(key, value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (isKeyInPair(storagePairs[i], key)) {
                return storagePairs[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isKeyInPair(StoragePair<K,V> pair, K key) {
        return pair != null && (pair.key == key
                || (pair.key != null && pair.key.equals(key)));
    }

    public class StoragePair<K,V> {
        private K key;
        private V value;

        private StoragePair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
