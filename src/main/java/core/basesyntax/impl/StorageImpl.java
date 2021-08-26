package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int FIRST_PAIR = 0;
    public static final int DEFAULT_CAPACITY = 10;
    private Pair[] storageOfPairs = new Pair[DEFAULT_CAPACITY];
    private int size;

    protected class Pair<K, V> {
        private K indexKey;
        private V data;

        private Pair(K indexKey, V data) {
            this.indexKey = indexKey;
            this.data = data;
        }

        public K getIndexKey() {
            return indexKey;
        }

        public void setIndexKey(K indexKey) {
            this.indexKey = indexKey;
        }

        public V getData() {
            return data;
        }

        public void setData(V data) {
            this.data = data;
        }
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> pair = new Pair<K, V>(key, value);
        for (int i = 0; i < storageOfPairs.length; i++) {
            if (storageOfPairs[i] == null) {
                storageOfPairs[i] = pair;
                size++;
                break;
            } else if (isDublicate(pair, i)) {
                storageOfPairs[i] = pair;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageOfPairs.length; i++) {
            if (!isStorageEmpty() && Objects.equals(storageOfPairs[i].getIndexKey(),key)) {
                return (V) storageOfPairs[i].getData();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isStorageEmpty() {
        return storageOfPairs[FIRST_PAIR] == null;
    }

    private int checkEmptySlot() {
        for (int i = 0; i < 10; i++) {
            if (storageOfPairs[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private boolean isDublicate(Pair pair, int i) {
        if (storageOfPairs[i] != null
                && (storageOfPairs[i].getIndexKey() == pair.getIndexKey()
                || (storageOfPairs[i].getIndexKey() != null
                && storageOfPairs[i].getIndexKey().equals(pair.getIndexKey())))) {
            storageOfPairs[i] = pair;
            return true;
        }

        return false;
    }
}
