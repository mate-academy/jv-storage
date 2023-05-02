package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private int size;
    private final Pair<K, V>[] storageArray;

    public StorageImpl() {
        size = 0;
        storageArray = new Pair[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> newObject = new Pair<>(key, value);
        for (int i = 0; i < size; i++) {
            if ((storageArray[i] != null) && ((storageArray[i].key == key)
                    || (storageArray[i].key != null
                    && storageArray[i].key.equals(key)))) {
                storageArray[i].value = value;
                return;
            }
        }
        storageArray[size] = newObject;
        size++;
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> pair : storageArray) {
            if ((pair != null) && ((pair.key == key) || (pair.key != null
                    && pair.key.equals(key)))) {
                return pair.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
