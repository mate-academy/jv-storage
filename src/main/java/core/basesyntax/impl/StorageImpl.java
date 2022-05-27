package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] storageK = new Object[10];
    private Object[] storageV = new Object[10];
    private int index = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storageK.length; i++) {
            if ((key == null && storageK[i] == null) || (storageK[i] == key || storageK[i] != null && storageK[i].equals(key))) {
                storageV[i] = value;
            }
        }
        storageK[index] = key;
        storageV[index] = value;
        index++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageK.length; i++) {
            if ((key == null && storageK[i] == null) || ((key != null) && (key.equals(storageK[i])))) {
                return (V)storageV[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
