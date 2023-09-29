package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private K[] keyArray;
    private V[] valueArray;
    private int index;

    public StorageImpl() {
        keyArray = (K[]) new Object[MAX_ITEMS_NUMBER];
        valueArray = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < index; i++) {
            if (keyArray[i] == key || keyArray[i] != null && keyArray[i].equals(key)) {
                valueArray[i] = value;
                return;
            }
        }
        keyArray[index] = key;
        valueArray[index] = value;
        index++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (keyArray[i] == key || keyArray[i] != null && keyArray[i].equals(key)) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
