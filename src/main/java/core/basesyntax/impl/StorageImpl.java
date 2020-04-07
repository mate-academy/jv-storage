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
            for (int i = massiveLength; i < this.keyArray.length; i++) {
                if (this.keyArray[i] == null && this.valuesArray[i] == null) {
                    this.keyArray[i] = key;
                    this.valuesArray[i] = value;
                    this.massiveLength += 1;
                    break;
                }
            }
        } else {
            valuesArray[checking(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        if (checking(key) != null) {
            return this.valuesArray[checking(key)];
        } else {
            return null;
        }
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
