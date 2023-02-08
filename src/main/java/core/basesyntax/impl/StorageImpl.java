package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_ITEMS_QUANTITY = 10;
    private int size;
    private Pair[] storage;

    public StorageImpl() {
        storage = new Pair[MAX_ITEMS_QUANTITY];
    }

    @Override
    public void put(K key, V value) {
        Pair elements;
        elements = new Pair(key, value);
        for (int i = 0; i <= size; i++) {
            if (isNull(storage[i])) {
                addElement(elements);
                break;
            } else if (areKeysEqual((K) storage[i].key, (K) elements.key)) {
                storage[i] = elements;
                break;
            }
        }
    }

    public void addElement(Pair pair) {
        storage[size] = pair;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (!isNull(storage[i]) && areKeysEqual((K) storage[i].key, key)) {
                return (V) storage[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isNull(Pair pair) {
        return pair == null ? true : false;
    }

    private boolean isKeyNull(K key) {
        return key == null ? true : false;
    }

    private boolean areKeysEqual(K key1, K key2) {
        return ((isKeyNull(key1) && isKeyNull(key2))
            || key1 == key2
            || !isKeyNull(key1) && key1.equals(key2));
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}



