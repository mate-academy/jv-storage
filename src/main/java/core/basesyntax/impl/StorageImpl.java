package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENT = 10;
    private static final int NO_INDEX = -1;
    private K[] keyArray;
    private V[] valueArray;
    private int size;

    public StorageImpl() {
        this.keyArray = (K[]) new Object[MAX_ELEMENT];
        this.valueArray = (V[]) new Object[MAX_ELEMENT];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndexOf(key);
        if (index != NO_INDEX) {
            keyArray[index] = key;
            valueArray[index] = value;
            return;
        }
        keyArray[size] = key;
        valueArray[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int index = getIndexOf(key);
        return index != NO_INDEX ? valueArray[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexOf(K key) {
        for (int i = 0; i < size(); i++) {
            if ((key == null && keyArray[i] == null)
                    || (keyArray[i] != null && keyArray[i].equals(key))) {
                return i;
            }
        }
        return NO_INDEX;
    }
}
