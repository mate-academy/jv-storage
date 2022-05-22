package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] key;
    private V[] value;
    private int size;

    private void increaseArrays() {
        size++;
        if (size == 1) {
            key = (K[]) new Object[size];
            value = (V[]) new Object[size];
        }
        key = (K[]) Arrays.copyOf(key, size);
        value = (V[]) Arrays.copyOf(value, size);;
    }

    @Override
    public void put(K key, V value) {
        int index = keyIndex(key);
        if (index == -1) {
            increaseArrays();
            this.key[size - 1] = key;
            this.value[size - 1] = value;
        } else {
            this.value[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = keyIndex(key);
        if (index == -1) {
            return null;
        }
        return value[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int keyIndex(K findKey) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key[i], findKey)) {
                return i;
            }
        }
        return -1;
    }
}
