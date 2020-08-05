package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    static final int currentSize = 10;
    int size = 0;
    private K[] keyArr;
    private V[] valueArr;

    public StorageImpl() {
        keyArr = (K[]) new Object[currentSize];
        valueArr = (V[]) new Object[currentSize];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keyArr[i] == null)
                    || (keyArr[i] != null && keyArr[i].equals(key))) {
                valueArr[i] = value;
                return;
            }
        }
        keyArr[size] = key;
        valueArr[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keyArr[i] == null)
                    || (keyArr[i] != null && keyArr[i].equals(key))) {
                return valueArr[i];
            }
        }
        return null;
    }
}
