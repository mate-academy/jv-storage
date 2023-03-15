package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;
    private int sizeInt = 0;

    public StorageImpl[] array =  new StorageImpl[10];

    @Override
    public void put(K key, V value) {
        this.key = key;
        this.value = value;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].key == key) {
                array[i] = this;
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = this;
                sizeInt++;
                break;
            }
        }

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].key == key) {
                return (V) array[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeInt;
    }
}
