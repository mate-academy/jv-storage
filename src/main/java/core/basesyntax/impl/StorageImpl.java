package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private int sizeValue;
    private Object[] keyArray;
    private Object[] valueArray;

    public StorageImpl() {
        this.keyArray = new Object[ARRAY_SIZE];
        this.sizeValue = 0;
        this.valueArray = new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = indexHelper(key);
        if (index == -1) {
            if (sizeValue < 9) {
                this.keyArray[sizeValue] = key;
                this.valueArray[sizeValue] = value;
                sizeValue++;
            }
        } else {
            this.keyArray[index] = key;
            this.valueArray[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = indexHelper(key);
        return index == -1 ? null : (V) this.valueArray[index];
    }

    @Override
    public int size() {
        return sizeValue;
    }

    public int indexHelper(K key) {
        for (int i = 0; i < sizeValue; i++) {
            if ((this.keyArray[i] == key)
                    || ((this.keyArray[i] != null) && this.keyArray[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }

}
