package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final int MAX_SIZE = 10;
    private Pair<K,V> [] pairArr;
    private int actualSize;

    public StorageImpl() {
        this.pairArr = new Pair[MAX_SIZE];
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

        for (int i = 0; i < pairArr.length; i++) {
            if (pairArr[i] != null && ((pairArr[i].key == key)
                    || (pairArr[i].key != null && pairArr[i].key.equals(key)))) {
                pairArr[i] = new Pair<>(key, value);
                return;
            } else if (pairArr[i] == null) {
                pairArr[i] = new Pair<>(key, value);
                actualSize++;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < actualSize; i++) {
            if (pairArr[i] != null && (pairArr[i].key == null && key == null)
                    || (pairArr[i].key != null && pairArr[i].key.equals(key))) {
                return (V) this.pairArr[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.actualSize;
    }
}
