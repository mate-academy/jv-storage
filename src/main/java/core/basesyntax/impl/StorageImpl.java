package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final String NULL_EXPRESSION = "null";
    private static final int MAX_RANGE = 10;
    private int size;
    private final K[] arrayOfKeys = (K[]) new Object[MAX_RANGE];
    private final V[] arrayOfValues = (V[]) new Object[MAX_RANGE];
    private boolean nullWasCreatedOnce = false;

    @Override
    public void put(K key, V value) {
        boolean isUnique = true;
        for (int i = 0; i < arrayOfKeys.length; i++) {
            if (arrayOfKeys[i] != null && key != null && arrayOfKeys[i].equals(key.toString())) {
                arrayOfValues[i] = (V) (value != null ? value.toString() : NULL_EXPRESSION);
                isUnique = false;
            } else if (key == null && arrayOfKeys[i] == null && isUnique) {
                arrayOfValues[i] = (V) (value != null ? value.toString() : NULL_EXPRESSION);
                isUnique = false;
                if (nullWasCreatedOnce == false) {
                    size++;
                    nullWasCreatedOnce = true;
                }
            }
        }
        if (isUnique) {
            if (key == null) {
                key = (K) NULL_EXPRESSION;
            }
            arrayOfKeys[size] = (K) key.toString();
            arrayOfValues[size] = (V) (value != null ? value.toString() : NULL_EXPRESSION);
            size++;
        }
    }

    public void getAK() {
        System.out.println(Arrays.toString(arrayOfKeys));
    }

    public void getAV() {
        System.out.println(Arrays.toString(arrayOfValues));
    }

    @Override
    public V get(K key) {
        V valueOfKey = null;
        int count = 0;
        boolean isPresentKey = isPresentKey(key);

        if (!isPresentKey) {
            return null;
        }

        for (int i = 0; i < arrayOfKeys.length; i++) {
            if (count != 0) {
                return valueOfKey;
            }
            if (arrayOfKeys[i] == null && key == null) {
                valueOfKey = arrayOfValues[i];
                count++;
            } else if (key != null && arrayOfKeys[i] != null
                    && arrayOfKeys[i].equals(key.toString())) {
                valueOfKey = arrayOfValues[i];
                count++;
            }
        }
        return valueOfKey;
    }

    private boolean isPresentKey(K key) {
        boolean isPresentInArray = true;
        int count = 0;

        for (int i = 0; i < arrayOfKeys.length; i++) {
            if (arrayOfKeys[i] == null && key == null) {
                count++;
                break;
            } else if (key == null && arrayOfKeys[i] != null
                    && arrayOfKeys[i].equals(NULL_EXPRESSION)) {
                count++;
                break;
            } else if (key != null && arrayOfKeys[i] != null
                    && arrayOfKeys[i].equals(key.toString())) {
                count++;
                break;
            }
        }
        if (count == 0) {
            isPresentInArray = false;
        }
        return isPresentInArray;
    }

    @Override
    public int size() {
        return size;
    }
}
