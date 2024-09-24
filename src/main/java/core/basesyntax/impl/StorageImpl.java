package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_NUMBER_ELEMENTS_IN_STORAGE = 10;
    private int index = 0;
    private final Pair<K, V>[] pairStorage = new Pair[MAXIMUM_NUMBER_ELEMENTS_IN_STORAGE];

    @Override
    public void put(K key, V value) {
        boolean flag = true;

        for (int i = 1; i <= index; i++) {

            if (index > 0 && pairStorage[i - 1].getKey() == null && key == null
                    || pairStorage[i - 1].getKey() != null
                    && pairStorage[i - 1].getKey().equals(key)) {
                pairStorage[i - 1].setValue(value);
                flag = false;
            }
        }

        if (flag) {
            pairStorage[index] = new Pair<>(key, value);
            index++;
        }
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> storage: pairStorage) {
            if (storage == null) {
                return null;
            }

            if (storage.getKey() == null && key == null) {
                return storage.getValue();
            }

            if (storage.getKey() != null && storage.getKey().equals(key)) {
                return storage.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}

