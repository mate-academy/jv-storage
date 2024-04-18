package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_STORAGE_VALUE = 10;
    private int size = 0;

    private final V[] valueArray = (V[]) new Object [MAX_STORAGE_VALUE];
    private final K[] keyArray = (K[]) new Object [MAX_STORAGE_VALUE];

    @Override
    public void put(K key, V value) {
        if (!keyExists(key)) {
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        }
        for (int i = 0; i < keyArray.length; i++) {
            if (Objects.equals(key, keyArray[i])) {
                valueArray[i] = value;
            }
        }
    }

    public boolean keyExists(K key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (Objects.equals(key, keyArray[i]) && valueArray[i] != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        V output = null;
        for (int i = 0; i < keyArray.length; i++) {
            if (Objects.equals(key, keyArray[i])) {
                output = valueArray[i];
            }
        }
        return output;
    }

    @Override
    public int size() {
        return size;
    }
}
