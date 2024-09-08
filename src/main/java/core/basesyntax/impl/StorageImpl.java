package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAYS_LENGTH = 10;
    private Object[] arrayOfKeys = new Object[ARRAYS_LENGTH];
    private Object[] arrayOfValues = new Object[ARRAYS_LENGTH];
    private int lastIndex = 0;

    public StorageImpl() {
        Arrays.fill(this.arrayOfKeys, new Object());
        Arrays.fill(this.arrayOfValues, new Object());
    }
    
    @Override
    public void put(K key, V value) {
        for (int i = 0; i < ARRAYS_LENGTH - 1; i++) {
            if (Objects.equals(key, arrayOfKeys[i])) {
                arrayOfValues[i] = value;
                return;
            }
        }
        arrayOfKeys[lastIndex] = key;
        arrayOfValues[lastIndex] = value;
        lastIndex++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < ARRAYS_LENGTH - 1; i++) {
            if (Objects.equals(key, arrayOfKeys[i])) {
                return (V) arrayOfValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return lastIndex;
    }
}
