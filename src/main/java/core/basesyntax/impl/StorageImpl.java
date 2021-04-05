package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LIMIT = 10;
    private static final int COUNTER_AT_START = 0;

    private final K[] keys;
    private final V[] values;
    private int counterOfPairs;

    public StorageImpl() {
        this.keys = (K[]) new Object[ARRAY_LIMIT];
        this.values = (V[]) new Object[ARRAY_LIMIT];
        counterOfPairs = COUNTER_AT_START;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] != null && keys[i].equals(key))
                    || (keys[i] == null && key == keys[i] && values[i] != null)) {
                values[i] = value;
                return;
            }
        }
        keys[counterOfPairs] = key;
        values[counterOfPairs] = value;
        counterOfPairs++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] != null && keys[i].equals(key))
                    || (keys[i] == null && key == keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return counterOfPairs;
    }
}
