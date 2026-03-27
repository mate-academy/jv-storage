package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;

    private final K[] keys = (K[]) new Object[MAX_SIZE];
    private final V[] values = (V[]) new Object[MAX_SIZE];
    private int currentIndex;

    public StorageImpl() {
        this.currentIndex = 0;
    }

    @Override
    public void put(K key, V value) {
        if (this.size() == MAX_SIZE) {
            return;
        }

        int index = this.getIndexByKey(key);

        if (index == -1) {
            this.keys[currentIndex] = key;
            this.values[currentIndex] = value;

            this.currentIndex++;
        } else {
            this.values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = this.getIndexByKey(key);

        if (index == -1) {
            return null;
        }

        return this.values[index];
    }

    @Override
    public int size() {
        return this.currentIndex;
    }

    private int getIndexByKey(K key) {
        for (int i = 0; i < this.currentIndex; i++) {
            if (Objects.equals(key, this.keys[i])) {
                return i;
            }
        }

        return -1;
    }
}
