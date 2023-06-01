package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    //створити масив об'єктів, в який зберігати під час put
    private static final int MAX_ARRAY_LENGTH = 10;

    private K key;
    private V value;
    private V[] valuesArray;

    public StorageImpl() {
    }

    @Override
    public void put(K key, V value) {
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < valuesArray.length; i++) {
            if (valuesArray[i] == null) {
                return i - 1;
            }
            return valuesArray.length;
        }
    }
}
