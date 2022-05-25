package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE = 10;
    private K[] keyArray = (K[]) new Object[MAX_STORAGE];
    private V[] valueArray = (V[]) new Object[MAX_STORAGE];
    private int count = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (Objects.equals(key, keyArray[i])) {
                valueArray[i] = value;
                return;
            }
        }
        keyArray[count] = key;
        valueArray[count] = value;
        count++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (Objects.equals(key, keyArray[i])) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
