package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAYS_LENGTH = 10;
    private final K[] keysArray;
    private final V[] valuesArray;
    private int keyValuePlace = 0;

    public StorageImpl() {
        this.keysArray = (K[]) new Object[ARRAYS_LENGTH];
        this.valuesArray = (V[]) new Object[ARRAYS_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (key == null && value != null) {
            for (int i = 0; i < keysArray.length; i++) {
                if (keysArray[i] == null && valuesArray[i] != null) {
                    valuesArray[i] = value;
                    break;
                } else if (keysArray[i] == null && valuesArray[i] == null) {
                    valuesArray[keyValuePlace] = value;
                    keyValuePlace++;
                    break;
                }
            }
        }
        if (!Arrays.asList(keysArray).contains(key)) {
            keysArray[keyValuePlace] = key;
            valuesArray[keyValuePlace] = value;
            keyValuePlace++;

        }
        valuesArray[Arrays.asList(keysArray).indexOf(key)] = value;
    }

    @Override
    public V get(K key) {
        if (!Arrays.asList(keysArray).contains(key)) {
            return null;
        }
        return valuesArray[Arrays.asList(keysArray).indexOf(key)];
    }

    @Override
    public int size() {
        int res = 0;
        for (int i = 0; i < valuesArray.length; i++) {
            if (keysArray[i] == null && valuesArray[i] != null
                    || keysArray[i] != null && valuesArray[i] == null
                    || keysArray[i] != null && valuesArray[i] != null) {
                res++;
            }
        }
        return res;
    }
}
