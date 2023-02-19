package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final Integer STORE_SIZE = 10;
    private Object[] keyArr;
    private Object[] valueArr;
    private int lengthOfActualValue = 0;

    public StorageImpl() {
        valueArr = (V[]) new Object[STORE_SIZE];
        keyArr = (K[]) new Object[STORE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < lengthOfActualValue; i++) {
            if (Objects.equals(keyArr[i], key)) {
                valueArr[i] = value;
                return;
            }
        }
        keyArr[lengthOfActualValue] = key;
        valueArr[lengthOfActualValue] = value;
        lengthOfActualValue++;
    }

    @Override
    public V get(K key) {
        int index = -1;
        for (int i = 0; i < lengthOfActualValue; i++) {
            if (Objects.equals(keyArr[i], key)) {
                index = i;
                return (V) valueArr[index];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return lengthOfActualValue;
    }
}
