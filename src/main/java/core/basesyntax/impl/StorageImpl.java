package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int BASE_CAPACITY = 0;
    private KeyValue<K, V>[] keyValueArray;

    public StorageImpl() {
        keyValueArray = new KeyValue[BASE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyValueArray.length; i++) {
            if (keyValueArray[i].getKey() == key || keyValueArray[i].getKey() != null
                    && keyValueArray[i].getKey().equals(key)) {
                keyValueArray[i] = new KeyValue<>(key, value);
                return;
            }
        }
        KeyValue<K, V>[] oldKayValueArray = keyValueArray;
        keyValueArray = new KeyValue[keyValueArray.length + 1];
        for (int i = 0; i < oldKayValueArray.length; i++) {
            keyValueArray[i] = oldKayValueArray[i];
        }
        keyValueArray[keyValueArray.length - 1] = new KeyValue<>(key, value);
    }

    @Override
    public V get(K key) {
        for (KeyValue<K, V> keyValue : keyValueArray) {
            if (keyValue.getKey() == key || keyValue.getKey() != null
                    && keyValue.getKey().equals(key)) {
                return keyValue.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return keyValueArray.length;
    }
}
