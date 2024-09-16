package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Pair<K, V>[] pairArray = new Pair[MAX_SIZE];
    private int arraySize;

    public class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arraySize; i++) {
            if (pairArray[i].key == key
                    || pairArray[i].key != null && pairArray[i].key.equals(key)) {
                pairArray[i] = new Pair<>(key, value);
                return;
            }
        }
        pairArray[arraySize] = new Pair<>(key, value);
        arraySize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arraySize; i++) {
            if (pairArray[i] != null
                    && ((pairArray[i].key == null && key == null)
                    || (pairArray[i].key != null && pairArray[i].key.equals(key)))) {
                return (V) pairArray[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return arraySize;
    }
}
