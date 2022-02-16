package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static int MAX_ARRAY_VALUE = 10;
    private K key;
    private V value;
    private K[] keyArray = (K[]) new Object[MAX_ARRAY_VALUE];
    private V[] valueArray = (V[]) new Object[MAX_ARRAY_VALUE];
    private int storageValue = 0;
    // Next try

    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public StorageImpl() {

    }

    @Override
    public void put(K key, V value) {
        if (storageValue == 0) {
            keyArray[0] = key;
            valueArray[0] = value;
            storageValue++;
        } else {
            for (int i = 0; i < MAX_ARRAY_VALUE - 1; i++) {
                if (Objects.equals(key, keyArray[i])) {
                    valueArray[i] = value;
                    return;
                } else {
                    keyArray[storageValue] = key;
                    valueArray[storageValue] = value;
                    storageValue++;
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int k = 0; k < MAX_ARRAY_VALUE - 1; k++) {
            if (Objects.equals(key, keyArray[k])) {
                return valueArray[k];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageValue;
    }

}
