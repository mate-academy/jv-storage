package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final KeyValueStorage[] keyValueStorages = new KeyValueStorage[10];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        KeyValueStorage existPairByKey = findExistPairByKey(key);
        if (existPairByKey != null) {
            replaceOldValue(existPairByKey, value);
            return;
        }
        keyValueStorages[size] = new KeyValueStorage(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        Object value = null;
        for (int i = 0; i < size; i++) {
            if (keyValueStorages[i] != null && keyValueStorages[i].getKey() == key
                    || (keyValueStorages[i] != null
                    && keyValueStorages[i].getKey() != null
                    && keyValueStorages[i].getKey().equals(key))) {
                value = keyValueStorages[i].getValue();
                break;
            }
        }
        return (V) value;
    }

    @Override
    public int size() {
        return size;
    }

    private KeyValueStorage findExistPairByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keyValueStorages[i] != null
                    && ((keyValueStorages[i].getKey() == null && key == null)
                    || (keyValueStorages[i].getKey() != null
                    && keyValueStorages[i].getKey().equals(key)))) {
                return keyValueStorages[i];
            }
        }
        return null;
    }

    private void replaceOldValue(KeyValueStorage keyValueStorage, V value) {
        for (int i = 0; i < size; i++) {
            if ((keyValueStorages[i].equals(keyValueStorage)
                    && (keyValueStorages[i].getKey() == keyValueStorage.getKey())
                    || (keyValueStorages[i].getKey().equals(keyValueStorage.getKey())))) {

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
