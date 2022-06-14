package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_ARRAY = 10;
    private int sizeOfArray = 0;
    private K[] keysForValueInArray = (K[]) new Object[MAX_SIZE_ARRAY];
    private V[] values = (V[]) new Object[MAX_SIZE_ARRAY];

    private Integer getIndex(K key) {
        Integer result = null;
        for (int i = 0; i < sizeOfArray; i++) {
            if ((keysForValueInArray[i] != null && keysForValueInArray[i].equals(key))
                    || (keysForValueInArray[i] == key && keysForValueInArray[i] == null)) {
                result = i;
            }
        }
        return result;
    }

    @Override
    public void put(K key, V value) {
        Integer index = getIndex(key);
        if (index != null) {
            values[index] = value;
        } else {
            keysForValueInArray[sizeOfArray] = key;
            values[sizeOfArray] = value;
            sizeOfArray++;
        }
    }

    @Override
    public V get(K key) {
        Integer index = getIndex(key);
        return index != null ? (V) values[index] : null;
    }

    @Override
    public int size() {
        return sizeOfArray;
    }
}
