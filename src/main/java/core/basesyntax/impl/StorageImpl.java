package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE = 10;
    private K[] keyArray;
    private V[] valueArray;
    private int count = 0;

    public StorageImpl() {
        keyArray = (K[]) new Object[MAX_STORAGE];
        valueArray = (V[]) new Object[MAX_STORAGE];
    }

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
