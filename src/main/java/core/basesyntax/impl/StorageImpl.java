package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final int MAX_SIZE = 10;
    private Pair[] pairArr;
    private int actualSize;

    public StorageImpl() {
        this.pairArr = new Pair[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < pairArr.length; i++) {
            if (pairArr[i] != null && ((pairArr[i].getKey() == key)
                || (pairArr[i].getKey() != null && pairArr[i].getKey().equals(key)))) {
                pairArr[i] = new Pair<>(key, value);
                return;
            } else if (pairArr[i] == null) {
                pairArr[i] = new Pair<>(key, value);
                actualSize++;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < actualSize; i++) {
            if (pairArr[i] != null && (pairArr[i].getKey() == null && key == null)
                    || (pairArr[i].getKey() != null && pairArr[i].getKey().equals(key))) {
                return (V) this.pairArr[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.actualSize;
    }
}
