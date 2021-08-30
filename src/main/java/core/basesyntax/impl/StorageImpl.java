package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Pair<K, V>[] storageArray = new Pair[10];
    private int size = 0;

    @Override
    public void put(K key, V value) {

        Pair<K, V> hub = new Pair<>(key, value);
        for (int i = 0; i <= size; i++) {
            if (storageArray[i] != null) {
                if (storageArray[i].getKey() == null && storageArray[i].getValue() != null
                        && hub.getKey() == null) {
                    storageArray[i].setValue(hub.getValue());
                    break;
                }
                if (storageArray[i].getKey() != null) {
                    if (storageArray[i].getKey().equals(hub.getKey())) {
                        storageArray[i].setValue(hub.getValue());
                        break;
                    }
                }
            }
            if (storageArray[i] == null) {
                storageArray[i] = hub;
                size++;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (storageArray[i].getKey() == key
                    || (storageArray[i].getKey() != null
                    ? storageArray[i].getKey().equals(key) : false)) {
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
