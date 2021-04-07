package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static int arrayIndex;
    private Object[] keyArray;
    private Object[] valueArray;

    public StorageImpl() {
        keyArray = new Object[MAX_ITEMS_NUMBER];
        valueArray = new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arrayIndex; i++) {
            if (key == keyArray[i] || key != null && key.equals(keyArray[i])) {
                valueArray[i] = value;
                return;
            }
        }
        checkArrayIndex();
        keyArray[arrayIndex] = key;
        valueArray[arrayIndex] = value;
        arrayIndex++;
    }

    public void checkArrayIndex() {
        if (arrayIndex >= MAX_ITEMS_NUMBER) {
            throw new RuntimeException("Cant add new Element to Array");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arrayIndex; i++) {
            if (key == keyArray[i] || key != null && key.equals(keyArray[i])) {
                return (V) valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return arrayIndex;
    }
}
