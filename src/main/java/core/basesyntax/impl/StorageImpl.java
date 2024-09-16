package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;
    @SuppressWarnings("unchecked")
    private K[] originalKeys = (K[]) new Object[1];
    @SuppressWarnings("unchecked")
    private K[] newKeys = (K[]) new Object[0];

    @SuppressWarnings("unchecked")
    private V[] originalValues = (V[]) new Object[1];

    @SuppressWarnings("unchecked")
    private V[] newValues = (V[]) new Object[0];
    private int count = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (key == originalKeys[i]) {
                originalValues[i] = value;
                break;
            }
        }

        newKeys = (K[]) new Object[newKeys.length + 1];
        for (int c = 0; c < originalKeys.length; c++) {
            newKeys[c] = originalKeys[c];
        }
        newKeys[newKeys.length - 1] = key;

        originalKeys = (K[]) new Object[newKeys.length];
        for (int c = 0; c < originalKeys.length; c++) {
            originalKeys[c] = newKeys[c];
        }

        newValues = (V[]) new Object[newValues.length + 1];

        for (int j = 0; j < originalValues.length; j++) {
            newValues[j] = originalValues[j];
        }
        newValues[newValues.length - 1] = value;

        originalValues = (V[]) new Object[newValues.length];

        for (int j = 0; j < originalValues.length; j++) {
            originalValues[j] = newValues[j];
        }
        count++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < newKeys.length; i++) {
            if (Objects.equals(newKeys[i], key)) {
                return newValues[i];
            }
        }
        System.out.println("There is no such key");
        return null;
    }

    @Override
    public int size() {
        return newValues.length;
    }
}
