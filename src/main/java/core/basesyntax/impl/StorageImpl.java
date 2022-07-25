package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_PAIRS_NUMBER = 10;
    private K key;
    private V value;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        keys = new Object[MAX_PAIRS_NUMBER];
        values = new Object[MAX_PAIRS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int index = 0; index < MAX_PAIRS_NUMBER; index++) {
            if (Objects.equals(keys[index], key)) {
                values[index] = value;
                break;
            } else if (keys[index] == null && values[index] == null) {
                keys[index] = key;
                values[index] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int index = 0; index < MAX_PAIRS_NUMBER; index++) {
            if (Objects.equals(keys[index], key)) {
                return (V) values[index];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int count = 0;
        for (int index = 0; index < MAX_PAIRS_NUMBER; index++) {
            if (keys[index] == null && values[index] == null) {
                count++;
            }
        }
        return MAX_PAIRS_NUMBER - count;
    }
}
