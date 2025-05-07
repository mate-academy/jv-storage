package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS = 10;
    private static final int MIN_INDEX = 0;
    private KeyValue<K, V>[] keysValues;
    private int size;

    public StorageImpl() {
        keysValues = new KeyValue[MAX_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getKeyIndex(key);
        if (keyIndex >= MIN_INDEX) {
            keysValues[keyIndex].setValue(value);
            return;
        }
        if (size >= MAX_ELEMENTS) {
            throw new RuntimeException("You can't put at the storage more than "
                    + MAX_ELEMENTS + " elements");
        }
        keysValues[size++] = new KeyValue<>(key, value);
    }

    @Override
    public V get(K key) {
        int keyIndex = getKeyIndex(key);
        return keyIndex >= MIN_INDEX ? keysValues[keyIndex].getValue() : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            K currentKey = keysValues[i].getKey();
            if (key == currentKey || currentKey != null
                    && currentKey.equals(key)) {
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
