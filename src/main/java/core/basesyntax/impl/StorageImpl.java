package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private K[] keyArray;
    private V[] valueArray;
    private int size;

    public StorageImpl() {
        size = 0;
        keyArray = (K[]) new Object[MAX_ARRAY_LENGTH];
        valueArray = (V[]) new Object[MAX_ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        int containsIndex = contains(key);
        if (containsIndex != -1) {
            replace(containsIndex, value);
        } else if (size < MAX_ARRAY_LENGTH) {
            replace(key, value);
        }
    }

    @Override
    public V get(K key) {
        return contains(key) == -1
                ? null : valueArray[contains(key)];
    }

    @Override
    public int size() {
        return size;
    }

    private void replace(int index, V value) {
        valueArray[index] = value;
    }

    private void replace(K key, V value) {
        keyArray[size] = key;
        valueArray[size] = value;
        size++;
    }

    private int contains(K key) {
        int containsIndex = -1;
        for (int i = 0; i < size; i++) {
            if (key == keyArray[i] || key != null && key.equals(keyArray[i])) {
                containsIndex = i;
            }
        }
        return containsIndex;
    }
}
