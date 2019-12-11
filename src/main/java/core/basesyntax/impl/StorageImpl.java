package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private int Counter = 0;
    private Object[] Keys;
    private Object[] Values;

    public StorageImpl() {
        Keys = new Object[CAPACITY];
        Values = new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < Keys.length; i++) {
            if (key != null && key.equals(Keys[i])) {
                Keys[i] = key;
                Values[i] = value;
                return;
            }
        }
        Keys[Counter] = key;
        Values[Counter] = value;
        Counter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < Keys.length; i++) {
            if (Keys[i] == key || (key != null && key.equals(Keys[i]))) {
                return (V) Values[i];
            }
        }
        return null;
    }
}
