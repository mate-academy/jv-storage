package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_CAPACITY = 10;

    private final K[] keys;
    private final V[] values;
    private int currentSizeOfStorage;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_CAPACITY];
        values = (V[]) new Object[MAX_CAPACITY];
        currentSizeOfStorage = 0;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            for (int i = 0; i < currentSizeOfStorage; i++) {
                if (keys[i] == null) {
                    values[i] = value;
                    return;
                }
            }
        } else {
            for (int i = 0; i < currentSizeOfStorage; i++) {
                if (key.equals(keys[i])) {
                    values[i] = value;
                    return;
                }
            }
        }

        if (currentSizeOfStorage == MAX_CAPACITY) {
            throw new RuntimeException("Storage is full!");
        }

        keys[currentSizeOfStorage] = key;
        values[currentSizeOfStorage] = value;
        currentSizeOfStorage++;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (int i = 0; i < currentSizeOfStorage; i++) {
                if (keys[i] == null) {
                    return  values[i];
                }
            }
        } else {
            for (int i = 0; i < currentSizeOfStorage; i++) {
                if (key.equals(keys[i])) {
                    return values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSizeOfStorage;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Storage content: ");
        for (int i = 0; i < currentSizeOfStorage; i++) {
            stringBuilder.append("[").append(keys[i]).append(", ").append(values[i]).append("]");
            if (i < currentSizeOfStorage - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }
}
