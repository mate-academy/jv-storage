package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keyList;
    private V[] valueList;

    @Override
    public void put(K key, V value) {
        if (keyList != null) {
            for (int i = 0; i < keyList.length; i++) {
                if (key == null && keyList[i] == null) {
                    valueList[i] = value;
                    return;
                }
                if (keyList[i] != null && keyList[i].equals(key)) {
                    valueList[i] = value;
                    return;
                }
            }
        }
        addCell(key, value);
    }

    private void addCell(K key, V value) {
        if (keyList == null) {
            keyList = (K[])new Object[1];
            keyList[0] = key;
            valueList = (V[])new Object[1];
            valueList[0] = value;
            return;
        }
        keyList = appendKeyArray(keyList, key);
        valueList = appendValuesArray(valueList, value);
    }

    private K[] appendKeyArray(K[] original, K toAdd) {
        K[] newArr = (K[])new Object[original.length + 1];
        System.arraycopy(original, 0, newArr, 0, original.length);
        newArr[newArr.length - 1] = toAdd;
        return newArr;
    }

    private V[] appendValuesArray(V[] original, V toAdd) {
        V[] newArr = (V[])new Object[original.length + 1];
        System.arraycopy(original, 0, newArr, 0, original.length);
        newArr[newArr.length - 1] = toAdd;
        return newArr;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyList.length; i++) {
            if (key == null && keyList[i] == null) {
                return valueList[i];
            }
            if (keyList[i] != null && keyList[i].equals(key)) {
                return valueList[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return keyList == null ? 0 : keyList.length;
    }
}
