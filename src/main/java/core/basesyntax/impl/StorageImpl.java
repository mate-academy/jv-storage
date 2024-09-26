package core.basesyntax.impl;

import core.basesyntax.Pair;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_OF_STORAGE = 10;
    private Pair[]pairs;
    private int counterOfSavedValues;

    public StorageImpl() {
        pairs = new Pair[MAX_SIZE_OF_STORAGE];
        counterOfSavedValues = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < counterOfSavedValues; i++) {
            if (pairs[i].getKey() == key || (key != null && key.equals(pairs[i].getKey()))) {
                pairs[i].setValue(value);
                return;
            }
        }
        Pair<K, V> pair = new Pair<>(key,value);
        pairs [counterOfSavedValues] = pair;
        counterOfSavedValues++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < counterOfSavedValues; i++) {
            if (pairs[i].getKey() == key || (key != null && key.equals(pairs[i].getKey()))) {
                return (V) pairs[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return counterOfSavedValues;
    }
}
