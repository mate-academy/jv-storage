package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS = 10;
    private KeyValue<K, V>[] keysValues;
    private int size;
    private int tempIndex;

    public StorageImpl() {
        keysValues = new KeyValue[MAX_ELEMENTS];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        boolean isInArray = false;
        if (size > 0 && get(key) != null) {
            keysValues[tempIndex].setValue(value);
            isInArray = true;
        }
        if (!isInArray && size != MAX_ELEMENTS) {
            keysValues[size++] = new KeyValue<>(key, value);
        } else {
            System.out.println("There are maximum count of elements in array");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keysValues[i].getKey() == key || (keysValues[i].getKey() != null
                    && keysValues[i].getKey().equals(key))) {
                tempIndex = i;
                return keysValues[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
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
