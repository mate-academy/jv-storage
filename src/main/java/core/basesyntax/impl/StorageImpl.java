package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Pair<K, V>[] resultArray;
    private int size = 0;

    public StorageImpl() {
        resultArray = new Pair[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> pairToStore = Pair.of(key, value);
        for (int i = 0; i <= size; i++) {
            if (resultArray[i] == null) {
                resultArray[i] = pairToStore;
                size++;
                return;
            }
            if ((resultArray[i].getKey() == null
                    ? resultArray[i].getKey() == key : resultArray[i].getKey().equals(key))) {
                resultArray[i].value = pairToStore.value;
            }
        }
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> pair : resultArray) {
            if (pair != null && ((pair.getKey() == null
                    ? pair.getKey() == key : pair.getKey().equals(key)))) {
                return pair.getValue();
            }
        }
        return null;
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        static <K, V> Pair of(K key, V value) {
            return new Pair(key, value);
        }
    }
}
