package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int AMOUNT_OF_STORAGE = 10;
    private Object[] keys;
    private Object[] values;
    private int realLengthStorage;

    public StorageImpl() {
        keys = new Object[AMOUNT_OF_STORAGE];
        values = new Object[AMOUNT_OF_STORAGE];
        realLengthStorage = 0;
    }

    @Override
    public void put(K key, V value) {

        if (get(key) == null) {
            keys[realLengthStorage] = key;
            values[realLengthStorage] = value;
            realLengthStorage++;
        } else {
            values[realLengthStorage - 1] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < realLengthStorage; i++) {
            if (isEqual((K) keys[i], key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    public boolean isEqual(K keyFirst, K keySecond) {
        return ((keyFirst == null && keySecond == null)
                || (keySecond != null && keySecond.equals(keyFirst)));
    }

    @Override
    public int size() {
        return realLengthStorage;
    }
}
