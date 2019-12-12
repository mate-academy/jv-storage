package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static int MAX_SIZE = 10;
    private int counter = 0;
    private K key;
    private V value;
    Object[] keyStorage = new Object[MAX_SIZE];
    Object[] valueStorage = new Object[MAX_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < counter; i++) {
            if (key == keyStorage[i] || (key != null && key.equals(keyStorage[i]))) {
                valueStorage[i] = value;
                return;
            }
        }
        keyStorage[counter] = key;
        valueStorage[counter] = value;
        counter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < counter; i++) {
            if (key == null & key == keyStorage[i] || (key != null & keyStorage[i].equals(key))) {
                return (V) valueStorage[i];
            }
        }
        counter++;
        return null;
    }
}
