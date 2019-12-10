package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static int DEFAULT_CAPACITY = 10;
    private Object[] valueArr;
    private Object[] keyArr;
    private int counter;

    public <K, V> StorageImpl() {
        this.valueArr = new Object[DEFAULT_CAPACITY];
        this.keyArr = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyArr.length; i++) {
            if (key != null && key.equals(keyArr[i])) {
                keyArr[i] = key;
                valueArr[i] = value;
                return;
            }
        }
        keyArr[counter] = key;
        valueArr[counter] = value;
        counter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyArr.length; i++) {
            if (keyArr[i] == key || (key != null && key.equals(keyArr[i]))) {
                return (V) valueArr[i];
            }
        }
        return null;
    }
}
