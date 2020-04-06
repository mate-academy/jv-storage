package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int CAPACITY = 10;
    private K [] arrayKey;
    private V [] arrayValue;
    private int size = 0;

    public StorageImpl() {
        arrayKey = (K[]) new Object[CAPACITY];
        arrayValue = (V[]) new Object[CAPACITY];

    }

    @Override
    public void put(K key, V value) {
        int indexKey = -1;
        for (int i = 0; i < arrayKey.length; i++) {
            if (arrayKey[i] == key) {
                indexKey = i;
            }
        }
        if (indexKey == -1) {
            arrayKey[size] = key;
            arrayValue[size] = value;
            size++;
        } else {
            arrayValue[indexKey] = value;
        }
    }

    @Override
    public V get(K key) {
        int indexKey = -1;
        for (int i = 0; i < arrayKey.length; i++) {
            if (Objects.equals(arrayKey[i], key)) {
                indexKey = i;
            }
        }
        if (indexKey == -1) {
            return null;
        } else {
            return arrayValue[indexKey];
        }

    }
}
