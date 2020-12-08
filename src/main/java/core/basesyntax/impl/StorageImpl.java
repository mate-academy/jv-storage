package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private final K[] keyArray = (K[]) new Object[ARRAY_LENGTH];
    private final V[] valueArray = (V[]) new Object[ARRAY_LENGTH];
    private int index = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            if (Objects.equals(keyArray[i], key) && keyArray[i] != null) {
                valueArray[i] = value;
            }
        }
        keyArray[index] = key;
        valueArray[index++] = value;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (Objects.equals(keyArray[i], key)) {
                return valueArray[i];
            }
        }
        return null;
    }
}
