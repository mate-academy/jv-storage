package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private final K[] keyBox = (K[]) new Object[ARRAY_LENGTH];
    private final V[] valueBox = (V[]) new Object[ARRAY_LENGTH];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            if (key == keyBox[i]
                    || keyBox[i] != null && keyBox[i].equals(key)) {
                valueBox[i] = value;
                break;
            }
            if (keyBox[i] == null && key != null && valueBox[i] == null) {
                keyBox[i] = key;
                valueBox[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            if (key == keyBox[i]
                    || key != null && key.equals(keyBox[i])) {
                return valueBox[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int counter = 0;
        for (V valuebox : valueBox) {
            if (valuebox != null) {
                counter++;
            }
        }
        return counter;
    }
}
