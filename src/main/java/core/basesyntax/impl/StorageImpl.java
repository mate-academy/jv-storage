package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] valueArr;
    private int[] keyArr;
    private int counter;

    public <K, V> StorageImpl() {
        this.valueArr = new Object[10];
        this.keyArr = new int[10];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyArr.length; i++) {
            if (key != null && key.hashCode() == keyArr[i]) {
                keyArr[i] = key.hashCode();
                valueArr[i] = value;
                return;
            }
        }
        if (key != null) {
            keyArr[counter] = key.hashCode();
            valueArr[counter] = value;
            counter++;
        } else {
            keyArr[counter] = 0;
            valueArr[counter] = value;
            counter++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyArr.length; i++) {
            if (key != null && keyArr[i] == key.hashCode()) {
                return (V) valueArr[i];
            } else if (key == null && keyArr[i] == 0) {
                return (V) valueArr[i];
            }
        }
        return null;
    }
}
