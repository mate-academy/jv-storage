package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_ITEMS_NUMBER = 10;

    private Pair[] pairs = new Pair[MAX_ITEMS_NUMBER];
    private int lengthOfStorage = 0;

    private class Pair<K, V> {
        private K key;
        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private int getPairIndex(K key) {
        int index = -1;
        for (int i = 0; i < lengthOfStorage; i++) {
            if (pairs[i].getKey() == key || key != null && key.equals(pairs[i].getKey())) {
                return i;
            }
        }
        return index;
    }

    @Override
    public void put(K key, V value) {
        int pairIndex = getPairIndex(key);
        if (pairIndex == -1) {
            if (lengthOfStorage >= MAX_ITEMS_NUMBER) {
                throw new RuntimeException("You have reached the maximum of the storage! "
                        + "Adding elements is forbidden");
            }

            Pair newPair = new Pair(key, value);
            pairs[lengthOfStorage] = newPair;
            lengthOfStorage++;
        } else {
            pairs[pairIndex].setValue(value);
        }
    }

    @Override
    public V get(K key) {
        int pairIndex = getPairIndex(key);
        if (pairIndex == -1) {
            return null;
        }

        return (V) pairs[pairIndex].getValue();
    }

    @Override
    public int size() {
        return lengthOfStorage;
    }
}
