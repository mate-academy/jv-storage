package core.basesyntax.impl;

import core.basesyntax.Storage;


public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private int size;
    private K key;
    private V value;
    GenericArray <K> arrayKeys = new GenericArray(MAX_LENGTH);
    GenericArray <V> ArrayValues = new GenericArray(MAX_LENGTH);

    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public StorageImpl() {

    }
    class GenericArray <T> {
        private Object[] arrayT;

        public GenericArray(int size) {
            arrayT = new Object[size];
        }

        public T get(int index) {
            return (T) arrayT[index];
        }

        public void set(int index, T element) {
            arrayT[index] = element;
        }
    }

    public int getKeyHashCode(K key) {
        int result = 1618;
        result = result + (key == null ? 0 : key.hashCode());
        return result;
    }

    public boolean testArray(K[] array) {
        boolean result = false;
        for (K element : array) {
            if (element != null) {
                result = true;
            }
        }
        return result;
    }

    public boolean[] searchedKey(K key) {
        boolean[] comparisonTable = new boolean[MAX_LENGTH];
        if (testArray(arrayPair)) {
            for (int index = 0; index < size; index++) {
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
            size = 0;
            arrayPair[currentIndex] = new StorageImpl(key, value);
            size++;
        } else {
            boolean[] comparisonTable = searchedKey(key);
            for (currentIndex = 0; currentIndex < size; currentIndex++) {
                if (comparisonTable[currentIndex]) {
                    arrayPair[currentIndex].value = value;
                    checkPresent = true;
                }
            }
            if (!checkPresent && (size < MAX_LENGTH)) {
                arrayPair[currentIndex] = new StorageImpl(key, value);
                size++;
            }
        }
    }

    @Override
    public V get(K key) {
        if (testArray(arrayPair)) {
            boolean[] comparisonTable = searchedKey(key);
            int index;
            for (index = 0; index < size; index++) {
                if (comparisonTable[index]) {
                    return (V) arrayPair[index].value;
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
