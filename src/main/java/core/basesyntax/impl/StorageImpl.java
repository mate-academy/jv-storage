package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.lang.reflect.Array;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int STORAGE_CAPACITY = 10;
    private K [] keyStorage;
    private V [] valueStorage;
    private int size = 0;

    public StorageImpl() {
        keyStorage = (K[]) Array.newInstance(Object.class, STORAGE_CAPACITY);
        valueStorage = (V[]) Array.newInstance(Object.class, STORAGE_CAPACITY);
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getIndex(key);
        if (keyIndex != size) {
            keyStorage[keyIndex] = key;
            valueStorage[keyIndex] = value;
            return;
        }
        keyStorage[keyIndex] = key;
        valueStorage[keyIndex] = value;
        size++;
    }

    public int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keyStorage[i] == key || keyStorage[i] != null && keyStorage[i].equals(key)) {
                return i;
            }
        }
        return size;
    }

    @Override
    public V get(K key) {
        int keyIndex = getIndex(key);
        return valueStorage[keyIndex];
    }

    @Override
    public int size() {
        return size;
    }
}
