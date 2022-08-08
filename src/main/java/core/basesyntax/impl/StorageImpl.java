package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final KeyValueStorage[] keyValueStorages = new KeyValueStorage[10];
    private int index = 0;

    @Override
    public void put(K key, V value) {
        KeyValueStorage existPairByKey = findExistPairByKey(key);
        if (existPairByKey != null) {
            replaceOldValue(existPairByKey, value);
            return;
        }
        keyValueStorages[index] = new KeyValueStorage(key, value);
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

    private KeyValueStorage findExistPairByKey(K key) {
        for (KeyValueStorage keyValueStorage : keyValueStorages) {
            if (keyValueStorage != null && ((keyValueStorage.getKey() == null && key == null)
                    || (keyValueStorage.getKey() != null
                    && keyValueStorage.getKey().equals(key)))) {
                return keyValueStorage;
            }
        }
        return null;
    }

    private void replaceOldValue(KeyValueStorage keyValueStorage, V value) {
        for (int i = 0; i < size(); i++) {
            if (keyValueStorages[i].equals(keyValueStorage)) {
                keyValueStorages[i].setValue(value);
            }
        }
    }

    public static class KeyValueStorage {
        private Object key;
        private Object value;

        public KeyValueStorage(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }
}
