package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final Object[][] STORAGE = new Object[2][10];
    private int index = 0;

    public void put(K key, V value) {
        STORAGE[0][index] = key;
        STORAGE[1][index++] = value;
    }

    @Override
    public V get(K key) {
        V value = null;
        for (int i = 0; i < index; i++) {
            if (Objects.equals(STORAGE[0][i], key)) {
                value = (V) STORAGE[1][i];
            }
        }
        return value;
    }
}
