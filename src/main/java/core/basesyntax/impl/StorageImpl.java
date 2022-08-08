package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_VALUE = 10;
    private final K[] keyArray;
    private final V[] valueArray;

    public StorageImpl() {
        keyArray = (K[]) new Object[MAX_ITEMS_VALUE];
        valueArray = (V[]) new Object[MAX_ITEMS_VALUE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyArray.length; i++) {
            if (Objects.equals(key, keyArray[i])) {
                keyArray[i] = key;
                valueArray[i] = value;
                return;
            }
        }
        int length = size();
        keyArray[length] = key;
        valueArray[length] = value;
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
        int size = 0;
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i] != null || valueArray[i] != null) {
                size++;
            }
        }
        return size;
    }
}
