package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Hub<K, V>[] storageArray = new Hub[0];
    private int checkSize = 0;

    @Override
    public void put(K key, V value) {
        if (storageArray.length == checkSize) {
            checkSize++;
            addArray(storageArray);
        }
        Hub<K, V> hub = new Hub<>(key, value);
        for (int i = 0; i < checkSize; i++) {
            if (storageArray[i] != null) {
                if (storageArray[i].getKey() == null && storageArray[i].getValue() != null
                        && hub.getKey() == null) {
                    storageArray[i].setValue(hub.getValue());
                    checkLength(storageArray);
                    break;
                }
                if (storageArray[i].getKey() != null) {
                    if (storageArray[i].getKey().equals(hub.getKey())) {
                        storageArray[i].setValue(hub.getValue());
                        checkLength(storageArray);
                        break;
                    }
                }
            }
            if (storageArray[i] == null) {
                storageArray[i] = hub;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageArray.length; i++) {
            if (storageArray[i].getKey() != null) {
                if (storageArray[i].getKey().equals(key)) {
                    return storageArray[i].getValue();
                }
            }
            if (storageArray[i].getKey() == key) {
                return storageArray[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageArray.length;
    }

    private Hub<K, V>[] addArray(Hub<K, V>[] oldArray) {
        storageArray = new Hub[checkSize];
        for (int i = 0; i < oldArray.length; i++) {
            storageArray[i] = oldArray[i];
        }
        return storageArray;
    }

    private Hub<K, V>[] checkLength(Hub<K, V>[] oldArray) {
        checkSize--;
        storageArray = new Hub[checkSize];
        for (int i = 0; i < checkSize; i++) {
            storageArray[i] = oldArray[i];
        }
        return storageArray;
    }

    private static class Hub<K, V> {
        private K key;
        private V value;

        private Hub(K key, V value) {
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
