package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private K[] keyArray = (K[]) new Object[10];
    private V[] valArray = (V[]) new Object[10];
    private int sizeArray = 0;

    @Override
    public void put(K key, V value) {

        for (int i = 0;i < this.sizeArray;i++) {
            if (keyEquals(i,key)) {
                keyArray[i] = key;
                valArray[i] = value;
                return;
            }
        }
        keyArray[this.sizeArray] = key;
        valArray[this.sizeArray] = value;
        this.sizeArray++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < this.sizeArray;i++) {
            if (keyEquals(i,key)) {
                return valArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.sizeArray;
    }

    private boolean keyEquals(int index,K key) {

        if (this.keyArray[index] != null) {
            return this.keyArray[index].equals(key);
        }
        return (key == null);
    }
}
