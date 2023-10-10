package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENT_COUNT = 10;
    private static final int ZERO_VALUE = 0;
    private final Object[] keys;
    private final Object[] values;
    private int index;

    public StorageImpl() {
        this.keys = new Object[MAX_ELEMENT_COUNT];
        this.values = new Object[MAX_ELEMENT_COUNT];
        index = ZERO_VALUE;
    }

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < index; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        if (index < MAX_ELEMENT_COUNT) {
            keys[index] = key;
            values[index] = value;
            index++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_ELEMENT_COUNT; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int counter = ZERO_VALUE;
        for (int i = 0; i < MAX_ELEMENT_COUNT; i++) {
            if (values[i] != null) {
                counter++;
            }
        }
        return counter;
    }
}
