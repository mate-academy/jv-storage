package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private int storageElementsAmount = 0;
    private final K[] keyStorage = (K[]) new Object[STORAGE_SIZE];
    private final V[] valueStorage = (V[]) new Object[STORAGE_SIZE];

    @Override
    public void put(K key, V value) {
        int isPresentResult = isPresent(key);
        if (isPresentResult == -1) {
            keyStorage[storageElementsAmount] = key;
            valueStorage[storageElementsAmount] = value;
            storageElementsAmount++;
        } else {
            valueStorage[isPresentResult] = value;
        }
    }

    public int isPresent(K key) {
        for (int i = 0; i < storageElementsAmount; i++) {
            if (Objects.equals(keyStorage[i], key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        int isPresentResult = isPresent(key);
        if (isPresentResult == -1) {
            return null;
        } else {
            return valueStorage[isPresentResult];
        }
    }

    @Override
    public int size() {
        return storageElementsAmount;
    }
}
