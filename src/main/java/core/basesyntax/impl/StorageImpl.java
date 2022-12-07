package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 20;
    private static final int TWO = 2;
    private static final int ONE = 1;
    private final Object[] temp;
    private int size;

    public StorageImpl() {
        temp = new Object[MAX_ITEMS_NUMBER];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0, tempLength = temp.length; i < tempLength; i = i + TWO) {
            Object item = temp[i];
            if ((item == null && key == null && temp[i + ONE] != null)
                    || (item != null && item.equals(key))) {
                temp[i + ONE] = value;
                return;
            }
        }
        temp[size * TWO] = key;
        temp[size * TWO + ONE] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0, tempLength = temp.length; i < tempLength; i++) {
            Object item = temp[i];
            if ((item == null && key == null && temp[i + ONE] != null)
                    || (item != null && item.equals(key))) {
                return (V) temp[i + ONE];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
