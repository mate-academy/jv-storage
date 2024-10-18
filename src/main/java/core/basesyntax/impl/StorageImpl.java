package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_CAPACITY = 10;
    private final Object[] keyStorage;
    private final Object[] valueStorage;
    private int storageCapacity;
    private V nullKeyStorage;
    private boolean hasNullKey;

    public StorageImpl() {
        keyStorage = new Object[MAX_STORAGE_CAPACITY];
        valueStorage = new Object[MAX_STORAGE_CAPACITY];
        storageCapacity = 0;
        hasNullKey = false;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            if (!hasNullKey) {
                storageCapacity++;
            }
            nullKeyStorage = value;
            hasNullKey = true;
            return;
        }
        for (int i = 0; i < storageCapacity; i++) {
            if (Objects.equals(keyStorage[i], key)) {
                valueStorage[i] = value;
                return;
            }
        }
        if (storageCapacity < MAX_STORAGE_CAPACITY) {
            keyStorage[storageCapacity] = key;
            valueStorage[storageCapacity] = value;
            storageCapacity++;
        } else {
            System.out.println("Out of storage capacity");
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return hasNullKey ? nullKeyStorage : null;
        }
        for (int i = 0; i < keyStorage.length; i++) {
            if (Objects.equals(keyStorage[i], key)) {
                return (V) valueStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageCapacity;
    }
}

