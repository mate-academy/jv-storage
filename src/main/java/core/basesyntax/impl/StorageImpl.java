package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private KeyValue<K, V>[] keyValueArray;

    public StorageImpl() {
        keyValueArray = new KeyValue[0];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyValueArray.length; i++) {
            if (Objects.equals(keyValueArray[i].getKey(), key)) {
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
            if (Objects.deepEquals(keyValue.getKey(), key)) {
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
