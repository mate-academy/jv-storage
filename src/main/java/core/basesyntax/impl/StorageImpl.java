package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH = 10;
    private Pair<K, V>[] storageArray = new Pair[LENGTH];
    private int size;

    @Override
    public void put(K key, V value) {
        Pair<K, V> pair = new Pair<>(key, value);
        size++;
        for (int i = 0; i < size; i++) {
            if (storageArray[i] != null && (storageArray[i].getKey() == key
                    || (storageArray[i].getKey() != null
                    && storageArray[i].getKey().equals(pair.getKey())))) {
                storageArray[i].setValue(pair.getValue());
                size--;
                break;
            }
            if (storageArray[i] == null) {
                storageArray[i] = pair;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (storageArray[i].getKey() == key
                    || (storageArray[i].getKey() != null
                    && storageArray[i].getKey().equals(key))) {
                return storageArray[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private K getKey() {
            return key;
        }

        private void setKey(K key) {
            this.key = key;
        }

        private V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
