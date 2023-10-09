package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBERS_OF_ELEMENTS = 10;
    private Object[] keys;
    private Object[] values;
    private int index;

    public StorageImpl() {
        this.keys = new Object[MAX_NUMBERS_OF_ELEMENTS];
        this.values = new Object[MAX_NUMBERS_OF_ELEMENTS];
        this.index = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < index; i++) {
            if (Objects.equals(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
        if (index < MAX_NUMBERS_OF_ELEMENTS) {
            keys[index] = key;
            values[index] = value;
            index++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (Objects.equals(key, keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
