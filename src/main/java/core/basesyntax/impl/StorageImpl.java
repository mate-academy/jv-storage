package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_NUMBER_ELEMENTS_IN_STORAGE = 10;
    private int size;
    private final Pair<K, V>[] pairStorage = new Pair[MAXIMUM_NUMBER_ELEMENTS_IN_STORAGE];

    @Override
    public void put(K key, V value) {
        boolean flag = true;

        for (int i = 0; i < size; i++) {

            if (pairStorage[i].getKey() == null && key == null
                    || size > 0 && pairStorage[i].getKey() != null
                    && pairStorage[i].getKey().equals(key)) {
                pairStorage[i].setValue(value);
                flag = false;
            }
        }

        if (flag) {
            pairStorage[size] = new Pair<>(key, value);
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            
            if (pairStorage[i].getKey() == null && key == null) {
                return pairStorage[i].getValue();
            }

            if (pairStorage[i].getKey() != null && pairStorage[i].getKey().equals(key)) {
                return pairStorage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}

