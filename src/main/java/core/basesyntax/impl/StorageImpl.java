package core.basesyntax.impl;

import core.basesyntax.KeyValue;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final Integer storageSize = 10;
    private final KeyValue<K, V>[] storage = new KeyValue[storageSize];

    @Override
    public void put(K key, V value) {
        for (int ind = 0; ind < storageSize; ind++) {
            if (storage[ind] == null) {
                KeyValue<K, V> newKeyValue = new KeyValue<>(key, value);
                storage[ind] = newKeyValue;
                break;
            } else if (storage[ind].getKey() == key
                    || (storage[ind].getKey() != null && storage[ind].getKey().equals(key))) {
                storage[ind].setValue(value);
                break;
            }
        }

    }

    @Override
    public V get(K key) {
        for (KeyValue<K, V> kv : storage) {
            if (kv == null) {
                continue;
            }
            if (kv.getKey() == key) {
                return kv.getValue();
            }
            if (kv.getKey() != null && kv.getKey().equals(key)) {
                return kv.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (KeyValue<K, V> kv : storage) {
            if (kv != null) {
                size++;
            }
        }
        return size;
    }
}
