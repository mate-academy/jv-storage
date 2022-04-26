package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private final K[] key;
    private final V[] value;
    private int size;

    public StorageImpl() {
        this.key = (K[]) new Object[STORAGE_SIZE];
        this.value = (V[]) new Object[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((key == null && key == this.key[i]) || (key != null && key.equals(this.key[i]))) {
                this.value[i] = value;
                return;
            }
        }
        this.key[size] = key;
        this.value[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < this.key.length; i++) {
            if (key == this.key[i] || (this.key[i] != null && this.key[i].equals(key))) {
                return this.value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
