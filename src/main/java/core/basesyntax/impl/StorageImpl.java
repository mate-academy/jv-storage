package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private int size;
    private final Entry<K, V>[] kyeValues = new Entry[MAX_CAPACITY];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (kyeValues[i].getKey() == key
                    || (kyeValues[i].getKey() != null && kyeValues[i].getKey().equals(key))) {
                kyeValues[i].setValue(value);
                return;
            }
        }
        kyeValues[size] = new Entry<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (kyeValues[i].getKey() == key
                    || (kyeValues[i].getKey() != null
                    && kyeValues[i].getKey().equals(key))) {
                return kyeValues[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
