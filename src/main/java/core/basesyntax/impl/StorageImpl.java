package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBERS_OF_ELEMENTS = 10;
    private static final int INITIAL_INDEX = 0;
    private K[] keys;
    private V[] values;
    private int index;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_NUMBERS_OF_ELEMENTS];
        this.values = (V[]) new Object[MAX_NUMBERS_OF_ELEMENTS];
        this.index = INITIAL_INDEX;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < index; i++) {
            if (Objects.equals(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[index] = key;
        values[index] = value;
        index++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (Objects.equals(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
