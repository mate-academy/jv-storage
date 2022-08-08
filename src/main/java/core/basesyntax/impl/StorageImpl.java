package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 5;

    private Pair<K,V>[] pair = new Pair[MAX_ELEMENTS_NUMBER];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_ELEMENTS_NUMBER; i++) {
            if (pair[i] == null) {
                pair[i] = new Pair<K,V>(key, value);
                return;
            }

            if (pair[i].getValue() != null
                    && key == null
                    && pair[i].getKey() == null) {
                pair[i] = new Pair<K,V>(key, value);
                return;
            } else if (key != null
                    && pair[i].getKey() != null
                    && pair[i].getKey().equals(key)) {
                pair[i] = new Pair<K,V>(key, value);
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        V foundValue = null;
        for (int i = 0; i < MAX_ELEMENTS_NUMBER; i++) {
            if (pair[i] == null) {
                return null; //or not found logic
            }
            if (key == null && pair[i].getKey() == null && pair[i].getValue() != null) {
                return pair[i].getValue();
            } else if (key != null
                    && pair[i].getKey() != null
                    && key.equals(pair[i].getKey())) {
                return pair[i].getValue();
            }
        }
        return foundValue;
    }

    @Override
    public int size() {
        int sizeOfStorage = 0;
        while (pair[sizeOfStorage] != null) {
            sizeOfStorage++;
        }
        return sizeOfStorage;
    }
}
