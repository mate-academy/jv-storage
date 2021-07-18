package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

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

    private static final int MAX_ITEMS_NUMBER = 10;
    private Pair[] pairs = new Pair[MAX_ITEMS_NUMBER];

    private int getPairIndex(K key) {
        int index = -1;
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if (pairs[i] == null) {
                continue;
            }
            if (pairs[i].getKey() == null && key == null) {
                index = i;
                break;
            } else if (pairs[i].getKey() != null && pairs[i].getKey().equals(key)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public void put(K key, V value) {
        int pairIndex = getPairIndex(key);
        if (pairIndex == -1) {
            int lengthOfStorage = size();
            if (lengthOfStorage >= MAX_ITEMS_NUMBER) {
                System.out.println("You have reached the maximum of the storage! "
                        + "Adding elements is forbidden");
                return;
            }

            Pair newPair = new Pair(key, value);
            pairs[lengthOfStorage] = newPair;
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
        int result = 0;
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if (pairs[i] != null) {
                result++;
            }
        }
        return result;
    }
}
