package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_VALUE = 10;
    private K[] key;
    private V[] value;
    private int size;

    public StorageImpl() {
        key = (K[]) new Object[MAX_STORAGE_VALUE];
        value = (V[]) new Object[MAX_STORAGE_VALUE];
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(this.key[i], key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        if (getIndex(key) == -1) {
            this.value[size] = value;
            this.key[size] = key;
            size++;
        } else {
            this.value[getIndex(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        if (getIndex(key) != -1) {
            return value[getIndex(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
