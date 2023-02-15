package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_RANGE = 10;
    private K[] keysRange;
    private V[] valuesRange;
    private int index;

    public StorageImpl() {
        keysRange = (K[]) new Object[MAX_RANGE];
        valuesRange = (V[]) new Object[MAX_RANGE];
        index = 0;
    }

    @Override
    public void put(K key, V value) {
        int i = 0;
        for (; i < index; i++) {
            if (keysRange[i] == key || (keysRange[i] != null && keysRange[i].equals(key))) {
                valuesRange[i] = value;
                break;
            }
        }
        if (i == index) {
            keysRange[index] = key;
            valuesRange[index++] = value;
        }
    }

    @Override
    public V get(K key) {
        int i = 0;
        for (; i < index; i++) {
            if (keysRange[i] == key || (keysRange[i] != null && keysRange[i].equals(key))) {
                break;
            }
        }
        return i < index ? valuesRange[i] : null;
    }

    @Override
    public int size() {
        return index;
    }
}
