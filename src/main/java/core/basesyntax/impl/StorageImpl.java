package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS = 10;
    private KeyValue<K, V>[] keysValues;
    private int size;

    public StorageImpl() {
        keysValues = new KeyValue[MAX_ELEMENTS];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        boolean isInArray = false;
        if (size > 0 && get(key) != null) {
            keysValues[getKeyIndex(key)].setValue(value);
            isInArray = true;
        }
        if (!isInArray && size != MAX_ELEMENTS) {
            keysValues[size++] = new KeyValue<>(key, value);
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = getKeyIndex(key);
        return keyIndex >= 0 ? keysValues[keyIndex].getValue() : null;
    }

    @Override
    public int size() {
        return size;
    }

    public int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keysValues[i].getKey() == key || keysValues[i].getKey() != null
                    && keysValues[i].getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private class KeyValue<K, V> {
        private K key;
        private V value;

        public KeyValue(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
