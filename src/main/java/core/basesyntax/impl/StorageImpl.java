package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private final K[] keysArray;
    private final V[] valuesArray;
    private int size;

    public StorageImpl() {
        keysArray = (K[]) new Object[MAX_ARRAY_SIZE];
        valuesArray = (V[]) new Object[MAX_ARRAY_SIZE];
    }

    private boolean isEqualsKeys(Object first, Object second) {
        return (first == second) || (first != null && first.equals(second));
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keysArray.length; i++) {
            if (keysArray[i] == null && valuesArray[i] == null) {
                size = size() + 1;
                keysArray[i] = key;
                valuesArray[i] = value;
                return;
            } else if (isEqualsKeys(keysArray[i], key)){
                valuesArray[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keysArray.length; i++) {
            if (Objects.equals(key, keysArray[i])) {
                return valuesArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
