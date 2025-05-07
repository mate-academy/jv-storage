package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMB = 10;
    private int elementsNumb;
    private int existedKeyIndex;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ELEMENTS_NUMB];
        values = (V[]) new Object[MAX_ELEMENTS_NUMB];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keys[elementsNumb] = key;
            values[elementsNumb] = value;
            elementsNumb++;
        } else {
            values[existedKeyIndex] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < elementsNumb; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                existedKeyIndex = i;
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return elementsNumb;
    }
}
