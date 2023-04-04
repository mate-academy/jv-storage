package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int STORAGE_SIZE = 10;
    private int storageIndex;
    private final Pair<K, V>[] storageArray;

    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public StorageImpl() {
        storageIndex = 0;
        storageArray = new Pair[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> newObject = new Pair<>(key, value);
        int maxElementNumber = 10;
        for (int i = 0; i < storageIndex; i++) {
            if ((storageArray[i] != null) && ((storageArray[i].key == key)
                    || (storageArray[i].key != null
                    && storageArray[i].key.equals(key)))) {
                storageArray[i].value = value;
                return;
            }
        }
        storageArray[storageIndex] = newObject;
        storageIndex++;
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> si : storageArray) {
            if ((si != null) && ((si.key == key) || (si.key != null
                    && si.key.equals(key)))) {
                return si.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        int arraySize = 0;
        for (Pair<K, V> si : storageArray) {
            if (si != null) {
                arraySize++;
            }
        }
        return arraySize;
    }
}
