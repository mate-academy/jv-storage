package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_ITEMS_QUANTITY = 10;
    private Pair[] storage = new Pair[MAX_ITEMS_QUANTITY];
    private Pair elements;
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_ITEMS_QUANTITY; i++) {
            elements = new Pair(key, value);
            if (isNull(storage[i])) {
                storage[i] = elements;
                size++;
                break;
            } else if (isKeyNull((storage[i])) && !isKeyNull((elements))) {
                continue;
            } else if (areKeysEqual(storage[i], elements)) {
                storage[i] = elements;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (Pair pair : storage) {
            if (isNull(pair)) {
                return null;
            } else if (isKeyNull(pair) && key == null) {
                return (V) pair.getValue();
            } else if (isKeyNull(pair) && key != null) {
                continue;
            } else if (pair.key.equals(key)) {
                return (V) pair.getValue();
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

    private boolean isKeyNull(Pair pair) {
        return pair.getKey() == null ? true : false;
    }

    private boolean areKeysEqual(Pair pair1, Pair pair2) {
        return ((isKeyNull(pair1) && isKeyNull(pair2))
            || pair1.getKey() == pair2.getKey()
            || pair1.getKey().equals(pair2.getKey()));
    }

    public static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
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



