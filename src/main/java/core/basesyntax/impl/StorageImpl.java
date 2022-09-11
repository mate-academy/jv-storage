package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_CAPACITY = 10;
    private Entry<K,V>[] table;
    private int size;

    public StorageImpl() {
        table = new Entry[MAXIMUM_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (equalKeys(table[i].getKey(), key)) {
                table[i].setValue(value);
                return;
            }
        }
        table[size] = new Entry<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        if (size > 0) {
            for (Entry<K, V> element: table) {
                if (equalKeys(key, element.getKey())) {
                    return element.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean equalKeys(K first, K second) {
        return (first == second) || (first != null && first.equals(second));
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
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
