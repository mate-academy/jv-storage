package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int counter = 0;
    private final Object[] arrayK;
    private final Object[] arrayV;

    public StorageImpl() {
        arrayK = new Object[MAX_ITEMS_NUMBER];
        arrayV = new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if (arrayK[i] == null && arrayV[i] == null) {
                arrayK[i] = key;
                arrayV[i] = value;
                counter++;
                return;
            }
            if (Objects.equals(arrayK[i], key)) {
                arrayV[i] = value;
                return;
            }

        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if (Objects.equals(arrayK[i], key)) {
                return (V) arrayV[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return counter;
    }
}
