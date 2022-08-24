package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private final Object[] arrayOfKeys = new Object[ARRAY_LENGTH];
    private final Object[] arrayOfValues = new Object[ARRAY_LENGTH];
    private int size = 0;

    public StorageImpl() {
    }

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < size; i++) {
            if (((key != null) && key.equals(arrayOfKeys[i])) || (arrayOfKeys[i] == key)) {
                arrayOfValues[i] = value;
                return;
            }
        }
        arrayOfKeys[size] = key;
        arrayOfValues[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, arrayOfKeys[i])) {
                return (V) arrayOfValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {

        return size;
    }
}
