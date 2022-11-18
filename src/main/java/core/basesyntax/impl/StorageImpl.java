package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFOULT_SIZE = 10;
    private Pairs[] pairs;
    private Pairs[] massiv;
    private int index = 0;

    public StorageImpl() {
        pairs = new Pairs[DEFOULT_SIZE];
        massiv = new Pairs[index];
    }

    @Override
    public void put(K key, V value) {
        Pairs pair = findPair(key);
        if (pair == null) {
            Pairs pairToPut = new Pairs(key, value);
            pairs[index] = pairToPut;
            massiv = createReternMassive();
            index++;
        } else {
            pair.setValue(value);
        }
    }

    private Pairs findPair(K key) {
        Pairs unicPair = null;
        for (int i = 0; i < pairs.length; i++) {
            Pairs pair = pairs[i];
            if (pairs[i] != null && pair.getKey() != null && pair.getKey().equals(key)) {
                unicPair = pair;
            }
            if ((pairs[i] != null && pair.getKey() == null) && (key == null)) {
                unicPair = pair;
            }
        }
        return unicPair;
    }

    public Pairs[] createReternMassive() {
        Pairs[] pairsResive = new Pairs[index + 1];
        for (int k = 0; k < pairsResive.length; k++) {
            pairsResive[k] = pairs[k];
        }
        return pairsResive;
    }

    @Override
    public V get(K key) {
        V value = null;
        for (int i = 0; i < massiv.length; i++) {
            if (massiv[i].getKey() != null && massiv[i].getKey().equals(key)) {
                value = (V) massiv[i].getValue();
            }
            if (massiv[i].getKey() == null && key == null) {
                value = (V) massiv[i].getValue();
            }
        }
        return value;
    }

    @Override
    public int size() {

        return massiv.length;
    }

    private class Pairs<K, V> {
        private K key;
        private V value;

        public Pairs(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}