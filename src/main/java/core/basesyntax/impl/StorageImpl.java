package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    //private static final int START_INDEX = 1;
    private static final int UNEXPECTED_KEY = -1;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int i = indexOFkey(key);
        addWithNullKey(key, value);
        if (i != UNEXPECTED_KEY) {
            if (key == null && value != null) {
                values[i] = value;
                return;
            }
            if (key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (indexOFkey(key) != UNEXPECTED_KEY) {
            return values[indexOFkey(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return size = keys[0] == null && values[0] != null ? 1 : size;
    }

    private int indexOFkey(K key) {
        if (key != null) {
            for (int i = 0; i < size; i++) {
                if (key.equals(keys[i])) {
                    return i;
                }
            }
        }
        if (key == null) {
            return 0;
        }
        return UNEXPECTED_KEY;
    }

    private void addWithNullKey(K key, V value) {
        if (key == null) {
            if (keys[0] != null) {
                K[] keysWithNull = (K[]) new Object[MAX_SIZE];
                System.arraycopy(keys, 0, keysWithNull, 1, MAX_SIZE - 1);
                V[] valuesWithNullKey = (V[]) new Object[MAX_SIZE];
                System.arraycopy(values, 0, valuesWithNullKey, 1, MAX_SIZE - 1);
                valuesWithNullKey[0] = value;
                for (int i = 0; i < size + 1; i++) {
                    values[i] = valuesWithNullKey[i];
                    keys[i] = keysWithNull[i];
                }
                size++;
            } else {
                values[0] = value;
            }
        }
    }
}
