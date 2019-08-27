package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K,V> {
    private int size = 0;
    private Provision [] provisionArr = new Provision[15];

    @Override
    public void put(K key, V value) {
        if (size > provisionArr.length) {
            provisionArr = Arrays.copyOfRange(provisionArr, 0, provisionArr.length * 2);
        }
        for (int i = 0; i < size; i++) {
            if (provisionArr[i].getKey().equals(key) || key == null) {
                provisionArr[i] = new Provision(key, value);
                break;
            }
        }
        provisionArr[size++] = new Provision(key, value);
    }


    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (provisionArr[i].getKey() == key || key == null) {
                return (V) provisionArr[i].getValue();
            }
        }
        return null;
    }

    public class Provision<K, V> {
        private K key;
        private V value;

        public Provision(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

}

