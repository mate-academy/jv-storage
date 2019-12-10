package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] keyArr = new Object[10];
    private Object[] valueArr = new Object[10];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyArr.length; i++) {
            if (key == keyArr[i]) {
                valueArr[i] = value;
            } else if (keyArr[i] == null && valueArr[i] == null) {
                keyArr[i] = key;
                valueArr[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyArr.length; i++) {
            if (key != null && key.equals((keyArr[i]))) {
                return (V) valueArr[i];
            } else if (keyArr[i] == null) {
                return (V) valueArr[i];
            }
        }
        return null;
    }
}
