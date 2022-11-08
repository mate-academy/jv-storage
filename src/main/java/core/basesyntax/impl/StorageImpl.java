package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_OF_ARRAY = 10;
    private K[] keyArr;
    private V[] valueArr;
    private int sizeOfArr;

    public StorageImpl() {
        keyArr = (K[]) new Object[MAX_SIZE_OF_ARRAY];
        valueArr = (V[]) new Object[MAX_SIZE_OF_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < sizeOfArr; i++) {
            if (key != null && key.equals(keyArr[i]) || keyArr[i] == key) {
                valueArr[i] = value;
                return;
            }
        }
        keyArr[sizeOfArr] = key;
        valueArr[sizeOfArr] = value;
        sizeOfArr++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < sizeOfArr; i++) {
            if (key != null && key.equals(keyArr[i]) || keyArr[i] == key) {
                return valueArr[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeOfArr;
    }
}
