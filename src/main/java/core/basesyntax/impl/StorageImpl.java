package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final static int ARRAY_SIZE = 10;
    private K[] keyList;
    private V[] valueList;
    private int size;

    public StorageImpl() {
        keyList = (K[]) new Object[ARRAY_SIZE];
        valueList = (V[]) new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getKeyIndex(key);
        if (keyIndex != -1) {
            valueList[keyIndex] = value;
        } else {
            keyList[size] = key;
            valueList[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = getKeyIndex(key);
        if (keyIndex != -1) {
            return valueList[keyIndex];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean checkEquals(K item, K key) {
        return Objects.equals(item, key);
    }

    private int getKeyIndex(K key) {
        for (int index = 0; index < size; index++) {
            if (checkEquals(key, keyList[index])) {
                return index;
            }
        }
        return -1;
    }
}
