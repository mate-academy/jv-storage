package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Pair<K,V> [] pairArray;
    private int actualSize;

    public StorageImpl() {
        this.pairArray = new Pair[MAX_SIZE];
    }

    public class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Pair<?, ?> pair = (Pair<?, ?>) o;

            if (key != null ? !key.equals(pair.key) : pair.key != null) {
                return false;
            }
            return value != null ? value.equals(pair.value) : pair.value == null;
        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < actualSize; i++) {
            if (pairArray[i].key == key
                    || (pairArray[i].key != null && pairArray[i].key.equals(key))) {
                pairArray[i] = new Pair<>(key, value);
                return;
            }
        }
        pairArray[actualSize] = new Pair<>(key, value);
        actualSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < actualSize; i++) {
            if (pairArray[i] != null && (pairArray[i].key == null && key == null)
                    || (pairArray[i].key != null && pairArray[i].key.equals(key))) {
                return (V) this.pairArray[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.actualSize;
    }
}
