package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] keysArray;
    private Object[] valuesArray;
    private final int baseArraySize = 10;
    private int lastElementIndex;

    public <K, V> StorageImpl() {
        keysArray = (K[]) (new Object[baseArraySize]);
        valuesArray = (V[]) (new Object[baseArraySize]);
        lastElementIndex = -1;
    }

    public <K, V> StorageImpl(K key, V value) {
        keysArray = (K[]) (new Object[baseArraySize]);
        valuesArray = (V[]) (new Object[baseArraySize]);
        lastElementIndex = 0;
        keysArray[lastElementIndex] = key;
        valuesArray[lastElementIndex] = value;
    }

    @Override
    public void put(K key, V value) {
        if (lastElementIndex <= keysArray.length - 1) {
            int index = findValueIndex(key);
            if (index == -1) {
                ++lastElementIndex;
                keysArray[lastElementIndex] = key;
                valuesArray[lastElementIndex] = value;
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
        return lastElementIndex + 1;
    }

    private int findValueIndex(K key) {
        if (key == null) {

            int index = -1;
            for (int i = 0; i <= lastElementIndex; ++i) {
                if (keysArray[i] == null) {
                    index = i;
                    return index;
                }
            }
        }
        int index = -1;
        for (int i = 0; i <= lastElementIndex; ++i) {
            if (keysArray[i] != null) {
                if (keysArray[i].equals(key)) {
                    index = i;
                    return index;
                }
            }
        }
        return index;
    }

    private void enlargeArrays() {
        Object[] newKeysArray = new Object[keysArray.length * 3 / 2];
        Object[] newValuesArray = new Object[keysArray.length * 3 / 2];
        System.arraycopy(keysArray, 0, newKeysArray, 0, keysArray.length);
        System.arraycopy(valuesArray, 0, newValuesArray, 0, valuesArray.length);
        keysArray = newKeysArray;
        valuesArray = newValuesArray;
    }
}