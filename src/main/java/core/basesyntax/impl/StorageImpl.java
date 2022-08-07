package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final KeyValueStorage[] keyValueStorages = new KeyValueStorage[10];
    private int index = 0;

    @Override
    public void put(K key, V value) {
        if (isUniqueKey(key, value)) {
            return;
        }
        KeyValueStorage.Builder builder = new KeyValueStorage.Builder();
        builder.setValueObject(value);
        builder.setKeyObject(key);
        keyValueStorages[index] = builder.build();
        index++;
    }

    @Override
    public V get(K key) {
        Object value = null;
        for (KeyValueStorage keyValueStorage : keyValueStorages) {
            if (keyValueStorage != null && keyValueStorage.getKey() == key
                    || (keyValueStorage != null
                    && keyValueStorage.getKey() != null
                    && keyValueStorage.getKey().equals(key))) {
                value = keyValueStorage.getValue();
                break;
            }
        }
        return (V) value;
    }

    @Override
    public int size() {
        int size = 0;
        for (KeyValueStorage keyValueStorage : keyValueStorages) {
            if (keyValueStorage != null) {
                size++;
            }
        }
        return size;
    }

    private boolean isUniqueKey(K key, V value) {
        for (KeyValueStorage keyValueStorage : keyValueStorages) {
            if (keyValueStorage != null && ((keyValueStorage.getKey() == null && key == null)
                    || (keyValueStorage.getKey() != null
                    && keyValueStorage.getKey().equals(key)))) {
                keyValueStorage.setValue(value);
                return true;
            }
        }
        return false;
    }
}
