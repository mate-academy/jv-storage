package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int COUNT_OF_ELEMENT = 10;
    private int size;
    private Value<K, V>[] products;

    {
        products = new Value[COUNT_OF_ELEMENT];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (products[i].key == key
                    || products[i].key != null && products[i].key.equals(key)) {
                products[i].value = value;
                return;
            }
        }
        products[size] = new Value<>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (products[i].key == key
                    || products[i].key != null && products[i].key.equals(key)) {
                return (V) products[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private class Value<K, V> {
        private K key;
        private V value;

        private Value(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
