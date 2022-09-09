package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_CAPACITY = 10;
    private Entry<K,V>[] table;
    private int size;

    public StorageImpl() {
        table = new Entry[MAXIMUM_CAPACITY];
    }

    public static class Entry<K, V> {
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

    @Override
    public void put(K key, V value) {
        Entry<K, V> element = new Entry<>(key, value);
        for (int i = 0; i < MAXIMUM_CAPACITY; i++) {
            if (i > 0 && Objects.equals(key,
                    table[i - 1].getKey()) && !value.equals(table[i - 1].getValue())) {
                table[i - 1].setValue(value);
                return;
            }
            if (table[i] == null) {
                table[i] = element;
                size++;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        if (size == 0) {
            return null;
        } else {
            for (Entry<K, V> element: table) {
                if (Objects.equals(key, element.getKey())) {
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
}
