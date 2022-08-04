package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.lang.reflect.Array;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private K[] keyArray;
    private V[] valueArray;
    private int firstEmptyIndex;

    public StorageImpl() {
        firstEmptyIndex = 0;
        keyArray = (K[]) Array.newInstance(Object.class, MAX_ARRAY_LENGTH);
        valueArray = (V[]) Array.newInstance(Object.class, MAX_ARRAY_LENGTH);
    }

    @Override
    public void put(K key, V value) {
        int containsIndex = contains(firstEmptyIndex, key);
        if (containsIndex != -1) {
            replace(containsIndex, value);
        } else if (firstEmptyIndex < MAX_ARRAY_LENGTH) {
            replace(firstEmptyIndex, key, value);
        }
    }

    private void replace(int index, V value) {
        valueArray[index] = value;
    }

    private void replace(int index, K key, V value) {
        keyArray[index] = key;
        valueArray[index] = value;
        firstEmptyIndex = index + 1;
    }

    private int contains(int firstEmptyIndex, K key) {
        for (int i = 0; i < firstEmptyIndex; i++) {
            if (key == keyArray[i] || (key != null && key.equals(keyArray[i]))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        return contains(firstEmptyIndex, key) == -1
                ? null : valueArray[contains(firstEmptyIndex, key)];
    }

    @Override
    public int size() {
        return firstEmptyIndex;
    }
}
