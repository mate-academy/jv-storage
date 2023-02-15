package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_RANGE = 10;
    private K[] keysRange;
    private V[] valuesRange;

    public StorageImpl() {
        keysRange = (K[]) new Object[MAX_RANGE];
        valuesRange = (V[]) new Object[MAX_RANGE];
    }

    @Override
    public void put(K key, V value) {
        int i = 0;
        for (; i < MAX_RANGE; i++) {
            if (keysRange[i] == key || keysRange[i] == valuesRange[i]
                    || (keysRange[i] != null && keysRange[i].equals(key))) {
                keysRange[i] = key;
                valuesRange[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        int i = 0;
        for (; i < MAX_RANGE; i++) {
            if (keysRange[i] == key || keysRange[i] == valuesRange[i]
                    || (keysRange[i] != null && keysRange[i].equals(key))) {
                break;
            }
        }
        return valuesRange[i];
    }

    @Override
    public int size() {
        int i = 0;
        for (;i < MAX_RANGE; i++) {
            if (keysRange[i] == valuesRange[i]) {
                break;
            }
        }
        return i;
    }
}
