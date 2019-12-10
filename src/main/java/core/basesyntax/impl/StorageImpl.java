package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private Object[] store;
    private int position;

    public StorageImpl() {
        store = new Object[CAPACITY];
        position = 0;
    }

    @Override
    public void put(K key, V value) {
        Entry temp;
        if (key == null) {
            for (int i = 0; i < position; i++) {
                temp = (Entry) store[i];
                if (key == temp.getKey()) {
                    temp.setValue(value);
                    store[i] = temp;
                }
            }
            store[position] = new Entry(key, value);
            position++;
        } else {
            for (int i = 0; i < position; i++) {
                temp = (Entry) store[i];
                if (key.equals(temp.getKey())) {
                    temp.setValue(value);
                    store[i] = temp;
                }
            }

            store[position] = new Entry(key, value);
            position++;
        }
    }

    @Override
    public V get(K key) {
        Entry temp;
        if (key == null) {
            for (int i = 0; i < position; i++) {
                temp = (Entry) store[i];
                if (key == temp.getKey()) {
                    return temp.getValue();
                }
            }
        } else {
            for (int i = 0; i < position; i++) {
                temp = (Entry) store[i];
                if (key == temp.getKey() || key.equals(temp.getKey())) {
                    return temp.getValue();
                }
            }
        }
        return null;
    }

    public class Entry {
        private K key;
        private V value;

        Entry(K k, V v) {
            key = k;
            value = v;
        }

        public K getKey() {
            return key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public V getValue() {
            return value;
        }
    }
}
