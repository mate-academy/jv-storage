package core.basesyntax.impl;

import core.basesyntax.Pair;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NUMBER_OF_PAIRS = 10;
    private Pair<K,V>[] arrayOfPairs;
    private int size;

    public StorageImpl() {
        arrayOfPairs = new Pair[NUMBER_OF_PAIRS];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        boolean flagKeyExists = false;
        if (size == NUMBER_OF_PAIRS) {
            throw new RuntimeException("No more item can be added. Maximum 10 items");
        }
        for (int i = 0; i < size; i++) {
            if (arrayOfPairs[i].getKey() == key
                    || arrayOfPairs[i].getKey() != null
                    && arrayOfPairs[i].getKey().equals(key)) {
                arrayOfPairs[i].setValue(value);
                flagKeyExists = true;
                break;
            }
        }
        if (!flagKeyExists) {
            arrayOfPairs[size] = Pair.of(key, value);
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (arrayOfPairs[i].getKey() == key
                    || arrayOfPairs[i].getKey() != null && arrayOfPairs[i].getKey().equals(key)) {
                return arrayOfPairs[i].getValue();
            }
        }
        return null;
    }
}
