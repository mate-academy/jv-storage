package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K,V> {

    private Object[] keys = new Object[16];
    private Object[] values =  new Object[16];
    int topArray = -1;

    @Override
    public void put(K key, V value) {
        K k;
        for (int i = 0; i < keys.length; i++) {
            k = (K) keys[i];
            if (k == key) {
                values[i] = value;
                return;
            }
        }
        topArray++;
        if (topArray < keys.length - 1) {
            keys[topArray] = key;
            values[topArray] = value;
        } else {
            keys = Arrays.copyOf(keys, keys.length * 2);
            values = Arrays.copyOf(keys, keys.length * 2);
            keys[topArray] = key;
            values[topArray] = value;
        }
    }

    @Override
    public V get(K key) {
        K k;
        for (int i = 0; i < keys.length; i++) {
            k = (K) keys[i];
            if (k == key) {
                return (V) values[i];
            }
        }
        return null;
    }
}
