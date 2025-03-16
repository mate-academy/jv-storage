package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keyValue;
    private final V[] valueValue;
    private int counter;

    public StorageImpl() {
        keyValue = (K[]) new Object[MAX_SIZE];
        valueValue = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index != -1) {
            valueValue[index] = value;
        } else if (counter < MAX_SIZE) {
            keyValue[counter] = key;
            valueValue[counter] = value;
            counter++;
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        return index != -1 ? valueValue[index] : null;
    }

    @Override
    public int size() {
        return counter;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < counter; i++) {
            if (key != null && key.equals(keyValue[i]) || key == keyValue[i]) {
                return i;
            }
        }
        return -1;
    }
}
