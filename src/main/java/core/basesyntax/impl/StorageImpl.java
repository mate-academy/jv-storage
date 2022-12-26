package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keyStorage;
    private final V[] valueStorage;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keyStorage = (K[]) new Object[MAX_SIZE];
        valueStorage = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        checkSimilarity(key, value);
    }

    @Override
    public V get(K key) {
        for (K keyValue : keyStorage) {
            if (equals(keyValue, key)) {
                return valueStorage[indexOf(keyValue)];
            }
        }
        return null;
    }

    private void checkSimilarity(K key, V value) {
        if (contains(key)) {
            Arrays.asList(valueStorage).set(indexOf(key), value);
            valueStorage[size] = null;
            keyStorage[size] = null;
            size--;
        } else {
            keyStorage[size] = key;
            valueStorage[size] = value;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean contains(K key) {
        return equals(keyStorage[indexOf(key)], key);
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (equals(keyStorage[i], key)) {
                return i;
            }
        }
        return 0;
    }

    public boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(keyStorage);
        result = 31 * result + Arrays.hashCode(valueStorage);
        return result;
    }
}
