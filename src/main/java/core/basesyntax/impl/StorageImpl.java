package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private Object[] store;
    private Entry nullEntry;
    private int pos;

    public StorageImpl() {
        this.store = new Object[CAPACITY];
        nullEntry = new Entry(null, null);
        this.pos = 0;
    }

    @Override
    public void put(K key, V value) {
        Entry temp;
        if (key == null) {
            nullEntry.setValue(value);
        } else {
            for (int i = 0; i < pos; i++) {
                temp = (Entry) store[i];
                if (key.equals(temp.getKey())) {
                    temp.setValue(value);
                    store[i] = temp;
                }
            }
            store[pos] = new Entry(key, value);
            pos++;
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return nullEntry.getValue();
        } else {
            Entry temp;
            for (int i = 0; i < pos; i++) {
                temp = (Entry) store[i];
                if (key.equals(temp.getKey())) {
                    return temp.getValue();
                }
            }
        }
        return null;
    }

    private class Entry {
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
