package core.basesyntax.impl;

import core.basesyntax.KeyValue;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int size = 0;
    private final KeyValue<K, V>[] storage = new KeyValue[MAX_SIZE];

    @Override
    public void put(K key, V value) {
        for (int ind = 0; ind < size; ind++) {
            if (storage[ind].getKey() == key
                    || (storage[ind].getKey() != null && storage[ind].getKey().equals(key))) {
                storage[ind].setValue(value);
                return;
            }
        }
        KeyValue<K, V> newKeyValue = new KeyValue<>(key, value);
        storage[size] = newKeyValue;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            KeyValue<K, V> kv = storage[i];
            if (kv.getKey() == key || (kv.getKey() != null && kv.getKey().equals(key))) {
                return kv.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
