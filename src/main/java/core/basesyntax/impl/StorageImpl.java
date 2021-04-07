package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH_STORAGE = 10;
    private K[] itemK;
    private V[] itemV;

    public StorageImpl() {
        this.itemK = (K[]) new Object[LENGTH_STORAGE];
        this.itemV = (V[]) new Object[LENGTH_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < LENGTH_STORAGE; i++) {
            if (itemV[i] != null && check(itemK[i], key)) {
                itemV[i] = value;
                return;
            }
            if (itemK[i] == null && itemV[i] == null) {
                itemK[i] = key;
                itemV[i] = value;
                return;

            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < itemK.length; i++) {
            if (itemV[i] != null && check(itemK[i], key)) {
                return itemV[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int result = 0;
        for (int i = 0; i < itemV.length; i++) {
            if (itemV[i] != null) {
                result++;
            }
        }
        return result;
    }

    public boolean check(K itemK, K key) {
        return ((key == itemK) || (itemK != null
                && itemK.equals(key)));
    }
}