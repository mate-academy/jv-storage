package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_SIZE = 10;
    private Object[] keyArr;
    private Object[] valueArr;

    public StorageImpl() {
        keyArr = new Object[MAX_SIZE];
        valueArr = new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyArr.length; i++) {
            if ((key == null)
                    || (keyArr[i] == null && valueArr[i] == null)) {
                keyArr[i] = key;
                valueArr[i] = value;
                break;
            } else if (key.equals(keyArr[i])) {
                valueArr[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyArr.length; i++) {
            if ((key == null && keyArr[i] == null)
                    || (key != null && key.equals(keyArr[i]))) {
                return (V) valueArr[i];
            }
        }
        return null;
    }
}
