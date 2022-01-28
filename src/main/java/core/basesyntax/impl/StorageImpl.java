package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_INDEX = 10;
    private final K[] keyArr;
    private final V[] valueArr;

    public StorageImpl() {
        this.keyArr = (K[]) new Object[MAX_INDEX];
        this.valueArr = (V[]) new Object[MAX_INDEX];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyArr.length; i++) {
            if ((keyArr[i] == key) || (key != null && key.equals(keyArr[i]))) {
                keyArr[i] = key;
                valueArr[i] = value;
                break;
            }
            if (keyArr[i] == null & valueArr[i] == null) {
                keyArr[i] = key;
                valueArr[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyArr.length; i++) {
            if ((keyArr[i] == key) || (key != null && key.equals(keyArr[i]))) {
                return valueArr[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0;i < valueArr.length;i++) {
            if (valueArr[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
