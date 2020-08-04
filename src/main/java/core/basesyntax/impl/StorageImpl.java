package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final Pair<K, V>[] resultArray;

    public StorageImpl() {
        resultArray = new Pair[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> pairToStore = Pair.of(key, value);
        for (int i = 0; i < MAX_SIZE; i++) {
            if (resultArray[i] == null) {
                resultArray[i] = pairToStore;
                return;
            } else if ((resultArray[i].getKey() == null
                    ? resultArray[i].getKey() == key : resultArray[i].getKey().equals(key))) {
                resultArray[i].value = pairToStore.value;
                return;
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

        @Override
        public int hashCode() {
            int prime = 31;
            int result = 1;
            result = prime * result + (key == null ? 0 : key.hashCode());
            result = prime * result + (value == null ? 0 : value.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !obj.getClass().equals(Pair.class)) {
                return false;
            }
            Pair objCast = (Pair) obj;
            return (key != null ? key.equals(objCast.key) : key == objCast.key)
                    && (value != null ? value.equals(objCast.value) : value == objCast.value);
        }
    }
}
