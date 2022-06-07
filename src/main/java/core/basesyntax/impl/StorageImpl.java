package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.lang.reflect.Array;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    //private StorageImpl[] arrayPair = new StorageImpl[MAX_LENGTH];
    private K[] genericArrayKeys;
    private V[] genericArrayValues;
    private int nextIndex;
    private K key;
    private V value;

    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public StorageImpl() {

    }

    public StorageImpl(Class<K> classType, int size ) {
       genericArrayKeys = (K[]) Array.newInstance(classType,size);
    }

    public K[] getKey(int index) {
        return (K[]) genericArrayKeys[index];
    }

    public void setKey(int index, K element) {
        genericArrayKeys[index] = element;
    }

    public StorageImpl(Class<V> classType, int size ) {
        genericArrayValues = (V[]) Array.newInstance(classType,size);
    }

    public V[] getValue(int index) {
        return (V[]) genericArrayValues[index];
    }

    public void setValue(int index, V element) {
        genericArrayValues[index] = element;
    }

    public int getKeyHashCode(K key) {
        int result = 1618;
        result = result + (key == null ? 0 : key.hashCode());
        return result;
    }

    public boolean testArray(StorageImpl[] array) {
        boolean result = false;
        for (StorageImpl element : array) {
            if (element != null) {
                result = true;
            }
        }
        return result;
    }

    public boolean[] searchedKey(K key) {
        boolean[] comparisonTable = new boolean[MAX_LENGTH];
        if (testArray(arrayPair)) {
            for (int index = 0; index < nextIndex; index++) {
                int arrayKeyHash = getKeyHashCode((K) arrayPair[index].key);
                int keyHash = getKeyHashCode(key);
                if (arrayKeyHash == keyHash) {
                    comparisonTable[index] = true;
                } else {
                    comparisonTable[index] = false;
                }
            }
        }
        return comparisonTable;
    }

    @Override
    public void put(K key, V value) {
        int currentIndex;
        boolean checkPresent = false;
        if (!testArray(arrayPair)) {
            currentIndex = 0;
            nextIndex = 0;
            arrayPair[currentIndex] = new StorageImpl(key, value);
            nextIndex++;
        } else {
            boolean[] comparisonTable = searchedKey(key);
            for (currentIndex = 0; currentIndex < nextIndex; currentIndex++) {
                if (comparisonTable[currentIndex]) {
                    arrayPair[currentIndex].value = value;
                    checkPresent = true;
                }
            }
            if (!checkPresent && (nextIndex < MAX_LENGTH)) {
                arrayPair[currentIndex] = new StorageImpl(key, value);
                nextIndex++;
            }
        }
    }

    @Override
    public V get(K key) {
        if (testArray(arrayPair)) {
            boolean[] comparisonTable = searchedKey(key);
            int index;
            for (index = 0; index < nextIndex; index++) {
                if (comparisonTable[index]) {
                    return (V) arrayPair[index].value;
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return nextIndex;
    }
}
