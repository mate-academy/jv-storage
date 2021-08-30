package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int DEFAULT_CAPACITY = 10;
    private Pair<K, V>[] storageOfPairs;
    private int size;

    public StorageImpl() {
        storageOfPairs = new Pair[DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> pair = new Pair<K, V>(key, value);
        for (int i = 0; i < size; i++) {
            if (isDublicate(key, storageOfPairs[i].getKey())) {
                storageOfPairs[i] = pair;
                return;
            }
        }
        storageOfPairs[size] = pair;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (isDublicate(key, storageOfPairs[i].getKey())) {
                return storageOfPairs[i].getData();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private class Pair<K, V> {
        private K key;
        private V data;

        private Pair(K key, V data) {
            this.key = key;
            this.data = data;
        }

        private K getKey() {
            return key;
        }

        private void setKey(K key) {
            this.key = key;
        }

        private V getData() {
            return data;
        }

        private void setData(V data) {
            this.data = data;
        }
    }

    private boolean isDublicate(K key, K storedKey) {
        return ((storedKey == key) || (storedKey != null && storedKey.equals(key)));
    }
}
