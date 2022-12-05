package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] key;
    private final V[] value;
    private int size = 0;

    public StorageImpl() {
        this.key = (K[]) new Object[MAX_SIZE];
        this.value = (V[]) new Object[MAX_SIZE];
    }

    public int getPosition(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(this.key[i], key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        if (this.getPosition(key) == -1) {
            if (this.size < MAX_SIZE) {
                this.key[size] = key;
                this.value[size] = value;
                this.size++;
            } else {
                System.out.println("Storage is full!");
            }
        } else {
            this.value[getPosition(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        if (getPosition(key) == -1) {
            return null;
        }
        return this.value[this.getPosition(key)];
    }

    @Override
    public int size() {
        return this.size;
    }
}
