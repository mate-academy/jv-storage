package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keySet;
    private V[] valueSet;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keySet = (K[]) new Object[0];
        valueSet = (V[]) new Object[0];
    }

    @Override
    @SuppressWarnings("unchecked")
    public void put(K key, V value) {
        if (keySet.length == 0) {
            keySet = (K[]) new Object[keySet.length + 1];
            valueSet = (V[]) new Object[valueSet.length + 1];
            keySet[keySet.length - 1] = key;
            valueSet[valueSet.length - 1] = value;
            return;
        }
        if (get(key) == null && getIndexByKey(key) == -1) {
            keySet = Arrays.copyOf(keySet, keySet.length + 1);
            valueSet = Arrays.copyOf(valueSet, valueSet.length + 1);
            keySet[keySet.length - 1] = key;
            valueSet[valueSet.length - 1] = value;
            return;
        }
        keySet[getIndexByKey(key)] = key;
        valueSet[getIndexByKey(key)] = value;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keySet.length; i++) {
            if (key == null && keySet[i] == null) {
                return valueSet[i];
            }
            if (keySet[i] == null) {
                continue;
            }
            if (keySet[i].equals(key)) {
                return valueSet[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return keySet == null ? 0 : keySet.length;
    }

    public int getIndexByKey(K key) {
        for (int i = 0; i < keySet.length; i++) {
            if (key == null && keySet[i] == null) {
                return i;
            }
            if (keySet[i] == null) {
                continue;
            }
            if (keySet[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
