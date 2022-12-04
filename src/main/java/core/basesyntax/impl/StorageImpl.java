package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENT_NUMBER = 10;
    private static final int ELEMENT_OF_PAIR_NUMBER = 2;
    private static final int NUMBER_OF_KEY = 0;
    private static final int NUMBER_OF_VALUE = 1;
    private final Object[][] storages = new Object[MAX_ELEMENT_NUMBER][ELEMENT_OF_PAIR_NUMBER];
    private int counter = 0;

    @Override
    public void put(K key, V value) {
        int replacedElements = 0;
        for (int i = 0; i < counter; i++) {
            if (keyAlreadyExist(key, i)) {
                storages[i][NUMBER_OF_VALUE] = value;
                replacedElements++;
            }
        }
        if (replacedElements == 0) {
            storages[counter][NUMBER_OF_KEY] = key;
            storages[counter][NUMBER_OF_VALUE] = value;
            counter++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < counter; i++) {
            if (keyAlreadyExist(key, i)) {
                return (V) storages[i][NUMBER_OF_VALUE];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return counter;
    }

    private boolean keyAlreadyExist(K key, int i) {
        return storages[i][NUMBER_OF_KEY] == key
                || storages[i][NUMBER_OF_KEY] != null
                && storages[i][NUMBER_OF_KEY].equals(key);
    }
}
