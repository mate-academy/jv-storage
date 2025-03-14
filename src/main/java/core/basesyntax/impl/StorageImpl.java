package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static int MAX_NUMBER_OF_ELEMENTS = 10;
    private K[] key = (K[]) new Object[MAX_NUMBER_OF_ELEMENTS];
    private V[] value = (V[]) new Object[MAX_NUMBER_OF_ELEMENTS];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(this.key[i], key)) {
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
        for (int i = 0; i < size; i++) {
            if (Objects.equals(this.key[i], key)) {
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
