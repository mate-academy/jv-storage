package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] storageK = (K[]) new Object[10];
    private V[] storageV = (V[]) new Object[10];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            // Обробка випадку з null ключем
            if (key == null ? storageK[i] == null : key.equals(storageK[i])) {
                storageV[i] = value;
                return;
            }
        }
        if (size < 10) {
            storageK[size] = key;
            storageV[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            // Обробка випадку з null ключем
            if (key == null ? storageK[i] == null : key.equals(storageK[i])) {
                return storageV[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
