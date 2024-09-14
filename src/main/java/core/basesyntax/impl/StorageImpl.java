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
                this.value = value;
                count++;
            } else {
                this.key = key;
                this.value = value;
                count++;
            }
        }

        newKeys = (K[]) new Object[originalKeys.length + 1];

        for (int i = 0; i < originalKeys.length; i++) {
            newKeys[i] = originalKeys[i];
        }
        newKeys[originalKeys.length] = key;

        newValues = (V[]) new Object[originalValues.length + 1];

        for (int i = 0; i < originalValues.length; i++) {
            newValues[i] = originalValues[i];
        }
        newValues[originalValues.length] = value;
    }

    @Override
    public V get(K key) {
        V value2 = null;
        for (int i = 0; i < newKeys.length; i++) {
            if(Objects.equals(newKeys[i], key)) {
                value2 = value;
            } else {
                System.out.println("There is no such key");
            }
        }
        return value;
    }

    @Override
    public int size() {
        return count;
    }
}
