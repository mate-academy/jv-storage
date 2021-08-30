package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ELEMENTS = 10;
    private static int actualNumberOfElements;
    private final K[] arrayKeys;
    private final V[] arrayValues;

    public StorageImpl() {
        //noinspection unchecked
        arrayKeys = (K[]) new Object[MAX_NUMBER_OF_ELEMENTS];
        //noinspection unchecked
        arrayValues = (V[]) new Object[MAX_NUMBER_OF_ELEMENTS];
        actualNumberOfElements = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < actualNumberOfElements; i++) {
            if (Objects.equals(key, arrayKeys[i])) {
                arrayValues[i] = value;
                return;
            }
        }
        arrayKeys[actualNumberOfElements] = key;
        arrayValues[actualNumberOfElements] = value;
        actualNumberOfElements++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < actualNumberOfElements; i++) {
            if (Objects.equals(key, arrayKeys[i])) {
                return arrayValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return actualNumberOfElements;
    }
}
