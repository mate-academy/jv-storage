package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private int storageSize = 0;
    private K[] keyStorage;
    private V[] valueStorage;

    public StorageImpl() {
        keyStorage = (K[]) new Object[]{};
        valueStorage = (V[]) new Object[]{};
    }

    @Override
    public void put(K key, V value) {
        if (size() == MAX_STORAGE_SIZE) {
            throw new RuntimeException("You rich the max size");
        }

        int keyIndex = getKeyIndex(key);
        if (keyIndex != -1) {
            valueStorage[keyIndex] = value;
        } else {
            keyStorage = addElementToArray(keyStorage, key);
            valueStorage = addElementToArray(valueStorage, value);

            storageSize++;
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = getKeyIndex(key);
        return (keyIndex == -1) ? null : valueStorage[keyIndex];
    }

    @Override
    public int size() {
        return storageSize;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < keyStorage.length; i++) {
            if ((key == null) && (keyStorage[i] != null)
                    || (key != null) && (keyStorage[i] == null)
            ) {
                continue;
            }
            if ((keyStorage[i] == null) && (key == null) || keyStorage[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private <T> T[] addElementToArray(T[] array, T element) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = element;
        return array;
    }
}
