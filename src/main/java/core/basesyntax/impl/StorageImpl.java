package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NUMBER_OF_ELEMENTS = 10;
    private final K[] keyArray = (K[]) new Object[NUMBER_OF_ELEMENTS];
    private final V[] valArray = (V[]) new Object[NUMBER_OF_ELEMENTS];

    private byte index = 0;
    private boolean isNullInArray = false;

    @Override
    public void put(K key, V value) {
        if (key == null && !isNullInArray) {
            isNullInArray = true;
        } else {
            for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
                if (key == null ? keyArray[i] == null : key.equals(keyArray[i])) {
                    valArray[i] = value;
                    return;
                }
            }
        }

        keyArray[index] = key;
        valArray[index++] = value;

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < 10; i++) {
            if (key == null ? keyArray[i] == null : key.equals(keyArray[i])) {
                return valArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
