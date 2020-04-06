package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_VALUES = 10;
    private Pair<K, V>[] array;
    private int size;

    public StorageImpl() {
        array = new Pair[MAX_NUMBER_OF_VALUES];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index == -1) {
            array[size] = new Pair<K, V>(key, value);
            size++;
        } else {
            array[index] = new Pair<K, V>(key, value);
        }
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        if (index == -1) {
            return null;
        }
        return array[index].getValue();
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == array[i].getKey())
                    || (key != null && key.equals(array[i].getKey()))) {
                return i;
            }
        }
        return -1;
    }
}
