package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUE = 10;
    private static final int VALUE_NOT_FOUND = -1;
    private K[] keyList;
    private V[] valueList;
    private int count = 0;

    public StorageImpl() {
        keyList = (K[]) new Object[MAX_VALUE];
        valueList = (V[]) new Object[MAX_VALUE];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index != VALUE_NOT_FOUND) {
            valueList[index] = value;
        } else {
            keyList[count] = key;
            valueList[count] = value;
            count++;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index != VALUE_NOT_FOUND) {
            return (V) valueList[index];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return count;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size(); i++) {
            if ((keyList[i] == null && key == null)
                    || (keyList[i] != null && keyList[i].equals(key))) {
                return i;
            }
        }
        return VALUE_NOT_FOUND;
    }
}
