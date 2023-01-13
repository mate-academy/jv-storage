package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Pair<K,V>[] valuesArr;
    private int amountElements;

    public StorageImpl() {
        this.valuesArr = new Pair[MAX_SIZE];
    }

    public class Pair<K,V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
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

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < amountElements; i++) {
            if (valuesArr[i].getKey() == key
                    || valuesArr[i].getKey() != null && valuesArr[i].getKey().equals(key)) {
                valuesArr[i] = new Pair<>(key,value);
                return;
            }
        }
        valuesArr[amountElements] = new Pair<>(key,value);
        amountElements++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < amountElements; i++) {
            if (valuesArr[i].getKey() == key
                    || valuesArr[i].getKey() != null && valuesArr[i].getKey().equals(key)) {
                return valuesArr[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return amountElements;
    }
}
