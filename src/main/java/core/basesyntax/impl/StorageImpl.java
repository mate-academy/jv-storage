package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private Object[] arrayKey = new Object[MAX_ITEMS_NUMBER];
    private Object[] arrayValue = new Object[MAX_ITEMS_NUMBER];
    private int count = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (key == null && arrayKey[i] == null || key != null && key.equals(arrayKey[i])) {
                arrayValue[i] = value;
                return;
            }
        }
        arrayKey[count] = key;
        arrayValue[count] = value;
        count++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if (key == null && arrayKey[i] == null || key != null && key.equals(arrayKey[i])) {
                return (V) arrayValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
    private boolean isRight(K key) {
        for (int i = 0; i < count; i++) {
            if (key == null && arrayKey[i] == null || key != null && key.equals(arrayKey[i])) {
            return true;
            }
        }
        return false;
    }
}
