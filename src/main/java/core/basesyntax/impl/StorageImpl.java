package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] kValue;
    private final V[] vValue;
    private int counter;

    public StorageImpl() {
        kValue = (K[]) new Object[MAX_SIZE];
        vValue = (V[]) new Object[MAX_SIZE];
    }
    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index != -1) {
            vValue[index] = value;
        } else if (counter < MAX_SIZE) {
            kValue[counter] = key;
            vValue[counter] = value;
            counter ++;
        }
    }

    @Override
    public V get(K key) {
       int index = findKeyIndex(key);
       return index != -1 ? vValue[index] : null;
    }

    @Override
    public int size() {
        return counter;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < counter; i++) {
            if (key != null && key.equals(kValue[i]) || key == kValue[i]) {
                return i;
            }
        }
        return -1;
    }
}
