package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private  int nowKey = 0;
    private int  nowValue = 0;
    private static final int LENGTH_STORAGE = 10;
    private K key;
    private V value;

    private K [] itemK;
    private V [] itemV;

    public StorageImpl() {
        this.itemK = (K[]) new Object[LENGTH_STORAGE];
        this.itemV = (V[]) new Object[LENGTH_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        this.key = key;
        if (nowKey < LENGTH_STORAGE && key != null && value != null) {
            itemK[nowKey] = key;
            nowKey++;
            itemV[nowValue] = value;
            nowValue++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < itemK.length; i++) {
            if (itemK[i] != null && value != null && this.key == itemK[i] && this.value == itemK[i]) {
                return itemV[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}