package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;
    private K[] arrayKey = (K[]) new Object[MAX_ELEMENTS_NUMBER];
    private V[] arrayValue = (V[]) new Object[MAX_ELEMENTS_NUMBER];
    private int size;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arrayKey.length; i++) {
            if (arrayKey[i] == key && arrayValue[i] != null) {
                arrayValue[i] = value;
                break;
            } else if (arrayKey[i] == null && arrayValue[i] == null) {
                arrayKey[i] = key;
                arrayValue[i] = value;
                size++;
                break;
            } else if (arrayKey[i] != null) {
                if (arrayKey[i].equals(key)) {
                    arrayValue[i] = value;
                    break;
                }
            } 
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size(); i++) {
            if (Objects.equals(arrayKey[i], key)) {
                return arrayValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
