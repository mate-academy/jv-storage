package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_STORAGE_CAP = 10;
    private int counter = 0;
    private boolean hasKey = false;
    private K[] arrayOfKeys = (K[]) new Object[MAX_STORAGE_CAP];
    private V[] arrayOfValues = (V[]) new Object[MAX_STORAGE_CAP];

    @Override
    public void put(K key, V value) {
        hasKey = false;
        if (counter == 0) {
            arrayOfKeys[counter] = key;
            arrayOfValues[counter] = value;
            counter++;
            return;
        } else if (counter > 0) {
            for (int i = 0; i < counter; i++) {
                if ((key != null && key.equals(arrayOfKeys[i]))
                        || (key == null && key == arrayOfKeys[i])) {
                    arrayOfValues[i] = value;
                    hasKey = true;
                }
            }
        }
        if (!hasKey) {
            arrayOfKeys[counter] = key;
            arrayOfValues[counter] = value;
            counter++;
        }
    }

    @Override
    public V get(K key) {
        V result = null;
        for (int i = 0; i < counter; i++) {
            if ((key != null && key.equals(arrayOfKeys[i]))
                    || (key == null && key == arrayOfKeys[i])) {
                result = arrayOfValues[i];
            }
        }
        return result;
    }

    private int keyLocator(K key) {
        int result = 0;
        for (int i = 0; i < counter; i++) {
            if ((key != null && key.equals(arrayOfKeys[i]))
                    || (key == null && key == arrayOfKeys[i])) {
                result = i;
            }
        }
        return result;
    }

    @Override
    public int size() {
        return counter;
    }
}
