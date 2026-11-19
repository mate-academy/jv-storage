package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private int size;
    private K[] key;
    private V[] value;

    public StorageImpl() {
        size = 0;
        key = (K[]) new Object[10];
        value = (V[]) new Object[10];
    }

    @Override
    public void put(K key, V value) {
        if (getCellKey(key) >= 0) {
            this.value[getCellKey(key)] = value;
        } else {
            this.key[size] = key;
            this.value[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = getCellKey(key);
        if (index == -1) {
            return null;
        }
        return this.value[index];
    }

    @Override
    public int size() {
        return size;
    }

    public int getCellKey(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(this.key[i], key)) {
                return i;
            }
        }
        return -1;
    }
}
