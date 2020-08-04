package core.basesyntax.impl;

import core.basesyntax.Pair;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NUMBEROFPAIRS = 10;
    private Pair<K,V>[] arrayOfPairs;
    private int size = 0;

    public StorageImpl() {
        arrayOfPairs = new Pair[NUMBEROFPAIRS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arrayOfPairs.length; i++) {
            if (i == size || arrayOfPairs[i].getFirst() == key
                    || arrayOfPairs[i].getFirst() != null
                    && arrayOfPairs[i].getFirst().equals(key)) {
                arrayOfPairs[i] = Pair.of(key, value);
                break;
            }
        }
        size++;
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> pair : arrayOfPairs) {
            if (pair != null && (pair.getFirst() == key
                    || pair.getFirst() != null && pair.getFirst().equals(key))) {
                return pair.getSecond();
            }
        }
        return null;
    }
}
