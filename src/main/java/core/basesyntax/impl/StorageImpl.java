package core.basesyntax.impl;
import core.basesyntax.Storage;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int sizeOfStorage = 0;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (sizeOfStorage >= MAX_SIZE) {
            System.out.println("Array is full!");
        } else {
            for (int i = 0; i < sizeOfStorage; i++) {
                if (Objects.equals(key, this.keys[i])) {
                    this.values[i] = value;
                    return;
                }
            }
            this.keys[sizeOfStorage] = key;
            this.values[sizeOfStorage] = value;
            sizeOfStorage++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < sizeOfStorage; i++) {
            if (Objects.equals(key, this.keys[i])) {
                return this.values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeOfStorage;
    }
}