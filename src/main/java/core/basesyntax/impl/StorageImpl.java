package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int size;
    private Object[] keyArray;
    private Object[] valueArray;

    public StorageImpl() {
        keyArray = new Object[MAX_ITEMS_NUMBER];
        valueArray = new Object[MAX_ITEMS_NUMBER];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size >= MAX_ITEMS_NUMBER) {
            return;
        }
        boolean isRepeted = false;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keyArray[i])) {
                valueArray[i] = value;
                isRepeted = true;
            }
        }

        if (isRepeted == false) {
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keyArray[i])) {
                return (V) valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
