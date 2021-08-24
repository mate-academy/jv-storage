package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Object[] keyStorage = new Object[MAX_SIZE];
    private Object[] valueStorage = new Object[MAX_SIZE];
    private int counter = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < counter; i++) {
            if (Objects.equals(key, keyStorage[i])) {
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
            if (key == null && keyStorage[i] == null) {
                return (V) valueStorage[i];
            }
            if (key != null && keyStorage[i] != null && key.equals(keyStorage[i])) {
                return (V) valueStorage[i];
            }
        }
        counter++;
        return null;
    }

    @Override
    public int size() {
        return counter;
    }
}
