package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;
    private static int MAX_ARRAY_VALUE = 10;
    K[] keyArray = (K[]) new Object[MAX_ARRAY_VALUE];;
    V[] valueArray = (V[]) new Object[MAX_ARRAY_VALUE];
    private int storageSize;

    private StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public <K, V> void StorageCount(K key, V value) {
        Storage<K, V> storage = new StorageImpl<>(key, value);

       for(int i = 0; i < MAX_ARRAY_VALUE - 1; i++) {
           if(storage.get(key).equals(value)) {
               storage.put(key, value);

           }
       }

    }


    @Override
    public void put(K key, V value) {
        K[i] = key;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }
/*
    @Override
    public boolean equals(Object storageImpl) {
        if (this == storageImpl) {
            return true;
        }
        if (storageImpl == null) {
            return false;
        }
        if (!storageImpl.getClass().equals(StorageImpl.class)) {
            return false;
        }
        StorageImpl<K, V> testStorageImpl = (StorageImpl<K, V>) storageImpl;
        return (((key == testStorageImpl.key) || (key != null
                && key.equals(testStorageImpl.key))) && ((value == testStorageImpl.value)
                || ((value != null && value.equals(testStorageImpl.value)))));

    }

    @Override
    public int hashCode() {
        int result = 71;
        result = 43 * result + (key == null ? 0 : key.hashCode());
        result = 43 * result + (value == null ? 0 : value.hashCode());
        return result;
    }

 */
}
