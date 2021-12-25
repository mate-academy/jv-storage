package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Pair[] pairs;

    public StorageImpl() {
        pairs = new Pair[0];
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            putKeyNull(value);
            return;
        }
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i].getKey() != null && pairs[i].getKey().equals(key)) {
                pairs[i].setValue(value);
                return;
            }
        }
        Pair[] newPairs = new Pair[pairs.length + 1];
        for (int i = 0; i < pairs.length; i++) {
            newPairs[i] = pairs[i];
        }
        newPairs[pairs.length] = new Pair(key, value);
        pairs = newPairs;
    }

    private void putKeyNull(V value) {
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i].getKey() == null) {
                pairs[i].setValue(value);
                return;
            }
        }
        Pair[] newPairs = new Pair[pairs.length + 1];
        for (int i = 0; i < pairs.length; i++) {
            newPairs[i] = pairs[i];
        }
        newPairs[pairs.length] = new Pair(null, value);
        pairs = newPairs;
    }

    @Override
    public V get(K key) {
        V value = null;
        if (key == null) {
            for (int i = 0; i < pairs.length; i++) {
                if (pairs[i].getKey() == null) {
                    value = (V) pairs[i].getValue();
                }
            }
        } else {
            for (int i = 0; i < pairs.length; i++) {
                if (pairs[i].getKey() != null && pairs[i].getKey().equals(key)) {
                    value = (V) pairs[i].getValue();
                }
            }
        }
        return value;
    }

    @Override
    public int size() {
        return pairs.length;
    }
}
