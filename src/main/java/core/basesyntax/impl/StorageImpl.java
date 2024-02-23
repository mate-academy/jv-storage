package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size = 0;

    public StorageImpl() {
        this.keys = new Object[MAX_ITEMS_NUMBER];
        this.values = new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getKeyIndex(key);
        if (keyIndex != -1) {
            values[keyIndex] = value;
            return;
        }

        if (size < MAX_ITEMS_NUMBER) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new RuntimeException("Storage is full!");
        }
    }

    private int getKeyIndex(K keyToCompare) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], keyToCompare)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        if (index == -1) {
            return null;
        }
        return (V) values[index];
    }

    @Override
    public int size() {
        return size;
    }
}
