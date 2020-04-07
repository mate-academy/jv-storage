package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    static final int ARRAY_LENGTH = 10;
    K[] keyArray;
    V[] valuesArray;
    Integer massiveLength;

    public StorageImpl() {
        this.keyArray = (K[]) new Object[ARRAY_LENGTH];
        this.valuesArray = (V[]) new Object[ARRAY_LENGTH];
        this.massiveLength = 0;

    }

    @Override
    public void put(K key, V value) {
        if (checking(key) == null) {
            this.keyArray[massiveLength] = key;
            this.valuesArray[massiveLength] = value;
            this.massiveLength += 1;
        } else {
            valuesArray[checking(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        if (checking(key) != null) {
            return this.valuesArray[checking(key)];
        }
        return null;
    }

    public Integer checking(K key) {
        for (int i = 0; i < this.keyArray.length; i++) {
            if (((key == null && this.keyArray[i] == null)
                    || (key != null && key.equals(this.keyArray[i])))
                    && this.valuesArray[i] != null) {
                return i;
            }
        }
        return null;
    }
}
