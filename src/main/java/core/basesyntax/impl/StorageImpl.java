package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;
    @SuppressWarnings("unchecked")
    private K[] originalKeys = (K[]) new Object[0];
    @SuppressWarnings("unchecked")
    private K[] newKeys = (K[]) new Object[0];

    @SuppressWarnings("unchecked")
    private V originalValues[] = (V[]) new Object[0];

    @SuppressWarnings("unchecked")
    private V newValues[] = (V[]) new Object[0];
    private int count = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < originalKeys.length; i++) {
            if (key == originalKeys[i]) {
                newValues = (V[]) new Object[originalValues.length + 1];
                for (int j = 0; j < originalValues.length; j++) {
                    newValues[j] = originalValues[j];
                }
            } else {
                newKeys = (K[]) new Object[originalKeys.length + 1];

                for (int c = 0; c < originalKeys.length; c++) {
                    newKeys[c] = originalKeys[c];
                }
                newKeys[originalKeys.length] = key;

                newValues = (V[]) new Object[originalValues.length + 1];

                for (int j = 0; j < originalValues.length; j++) {
                    newValues[j] = originalValues[j];
                }
                newValues[originalValues.length] = value;
            }
        }
    }

    @Override
    public V get(K key) {
        V value2 = null;
        for (int i = 0; i < newKeys.length; i++) {
            if(Objects.equals(newKeys[i], key)) {
                value2 = newValues[i];
            } else {
                value2 = null;
                System.out.println("There is no such key");
            }
        }
        return value2;
    }

    @Override
    public int size() {
        return newValues.length;
    }
}
