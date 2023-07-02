package core.basesyntax.impl;

import java.util.Objects;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private KeyValue<K, V>[] keyValueArray;

    public StorageImpl() {
        keyValueArray = new KeyValue[0];
    }

    @Override
    public void put(K key, V value) {
        keyValueArray = new KeyValue[keyValueArray.length+1];
        keyValueArray[keyValueArray.length-1] = new KeyValue<>(key, value);
    }

    @Override
    public V get(K key) {
        for (KeyValue keyValue : keyValueArray) {
            if (Objects.deepEquals(keyValue.getKey(), key)) {
                return (V) keyValue.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return keyValueArray.length;
    }
}
