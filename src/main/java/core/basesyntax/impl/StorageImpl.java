package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] keysArray;
    private Object[] valuesArray;
    private final int BASE_ARRAY_SIZE = 10;
    private int size;

    public <K, V> StorageImpl() {
        keysArray = (K[]) (new Object[BASE_ARRAY_SIZE]);
        valuesArray = (V[]) (new Object[BASE_ARRAY_SIZE]);
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size <= keysArray.length - 1) {
            int index = findValueIndex(key);
            if (index == -1) {
                ++size;
                keysArray[size - 1] = key;
                valuesArray[size - 1] = value;
            } else {
                valuesArray[index] = value;
                keysArray[index] = key;
            }
        } else {
            enlargeArrays();
            put(key, value);
        }
    }

    @Override
    public V get(K key) {
        int index = findValueIndex(key);
        if (index == -1) {
            return null;
        } else {
            return (V) valuesArray[index];
        }
    }

    @Override
    public int size() {
        return size;
    }

    private int findValueIndex(K key) {
        if (key == null) {
            int index = -1;
            for (int i = 0; i < size; ++i) {
                if (keysArray[i] == null) {
                    index = i;
                    return index;
                }
            }
        }
        int index = -1;
        for (int i = 0; i < size; ++i) {
            if (keysArray[i] != null) {
                if (keysArray[i].equals(key)) {
                    index = i;
                    return index;
                }
            }
        }
        return index;
    }

    //Growing array may be not mandatory, but I still think it's needed here.
    private void enlargeArrays() {
        Object[] newKeysArray = new Object[keysArray.length * 3 / 2];
        Object[] newValuesArray = new Object[keysArray.length * 3 / 2];
        System.arraycopy(keysArray, 0, newKeysArray, 0, keysArray.length);
        System.arraycopy(valuesArray, 0, newValuesArray, 0, valuesArray.length);
        keysArray = newKeysArray;
        valuesArray = newValuesArray;
    }
}
