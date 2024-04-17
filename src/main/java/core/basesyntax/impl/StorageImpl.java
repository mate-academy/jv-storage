package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private final int maxStorage = 10;
    private int currentSize = 0;
    private int currentIndex = 0;

    private final V[] valueArray = (V[]) new Object [maxStorage];
    private final K[] keyArray = (K[]) new Object [maxStorage];
    private V valueForKeyNullCase = null;

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            if (valueForKeyNullCase == null) {
                currentSize++;
                currentIndex++;
            }
            valueForKeyNullCase = value;

        } else if (!isKeyExist(key)) {
            valueArray[currentIndex] = value;
            keyArray[currentIndex] = key;
            currentSize++;
            currentIndex++;
        } else if (isKeyExist(key)) {
            valueArray[currentIndex] = value;
            keyArray[currentIndex] = key;
            currentIndex++;
        }
    }

    public boolean isKeyExist(K key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i] != null && keyArray[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return valueForKeyNullCase;
        }
        V output = null;
        for (int i = 0; i < keyArray.length; i++) {
            if (key.equals(keyArray[i])) {
                output = valueArray[i];
            }
        }
        return output;
    }
}
