package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_INITIAL_SIZE = 0;
    private K key;
    private V value;

    private K[] keysArray = (K[]) new Object[ARRAY_INITIAL_SIZE];
    private V[] valuesArray = (V[]) new Object[ARRAY_INITIAL_SIZE];

    private void expandValuesArray() {
        V[] newArray = (V[]) new Object[valuesArray.length + 1];
        for (int i = 0; i < valuesArray.length; i++) {
            newArray[i] = valuesArray[i];
        }
        valuesArray = newArray;
    }

    private void expandKeysArray() {
        K[] newArray = (K[]) new Object[keysArray.length + 1];
        for (int i = 0; i < keysArray.length; i++) {
            newArray[i] = keysArray[i];
        }
        keysArray = newArray;
    }

    @Override
    public void put(K key, V value) {
        this.key = key;
        this.value = value;

        if (!checkKeyDuplicate(key)) {
            expandKeysArray();
            expandValuesArray();
            keysArray[keysArray.length - 1] = this.key;
            valuesArray[valuesArray.length - 1] = this.value;
        }
    }

    private boolean checkKeyDuplicate(K key) {
        for (int i = 0; i < keysArray.length; i++) {
            if (key == keysArray[i] || key != null && key.equals(keysArray[i])) {
                valuesArray[i] = this.value;
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keysArray.length; i++) {
            if (key == keysArray[i] || key != null && key.equals(keysArray[i])) {
                return valuesArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return keysArray.length;
    }
}
