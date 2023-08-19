package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS = 10;
    private KeyValue<K, V>[] keysValues;
    private int countOfElements;

    public StorageImpl() {
        keysValues = new KeyValue[MAX_ELEMENTS];
        countOfElements = 0;
    }

    @Override
    public void put(K key, V value) {
        boolean isInArray = false;
        if (countOfElements > 0) {
            for (int i = 0; i < countOfElements; i++) {
                if (keysValues[i].getKey() == key || (keysValues[i].getKey() != null
                                                   && keysValues[i].getKey().equals(key))) {
                    keysValues[i].setValue(value);
                    isInArray = true;
                }
            }
        }
        if (!isInArray) {
            keysValues[countOfElements] = new KeyValue<>(key, value);
            countOfElements += 1;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < countOfElements; i++) {
            if (keysValues[i].getKey() == key || (keysValues[i].getKey() != null
                                                && keysValues[i].getKey().equals(key))) {
                return keysValues[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return countOfElements;
    }
}
