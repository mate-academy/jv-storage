package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER = 10;
    private Pair<K, V>[] pairs;

    public StorageImpl() {
        this.pairs = new Pair[MAX_NUMBER];
    }

    @Override
    public void put(K key,V value) {
        int filledSize = size();
        if (filledSize == 0) {
            pairs[filledSize] = new Pair(key, value);
        }
        if (filledSize <= MAX_NUMBER) {
            if (get(key) == null) {
                for (int i = 0; i < pairs.length; i++) {
                    if (pairs[i] == null) {
                        pairs[i] = new Pair(key, value);
                        break;
                    }
                }
            }
            if (get(key) != null) {
                for (int i = 0; i < filledSize; i++) {
                    if ((pairs[i].myKey == null && key == null)
                            || ((pairs[i].myKey != null && key != null)
                                    && pairs[i].myKey.equals(key))) {
                        pairs[i].myValue = value;
                    }
                }
            }
        }

    }

    @Override
    public V get(K key) {
        int length = size();
        for (int i = 0; i < length; i++) {
            if ((pairs[i].myKey == null && key == null)
                    || ((pairs[i].myKey != null && key != null)
                           && pairs[i].myKey.equals(key))) {
                return (V) pairs[i].myValue;
            }
        }
        return null;
    }

    @Override
    public int size() {
        int count = 0;
        for (Pair pair : pairs) {
            if (pair != null) {
                count++;
            }
        }
        return count;
    }

    private static class Pair<K, V> {
        private K myKey;
        private V myValue;

        Pair(K key, V value) {
            this.myKey = key;
            this.myValue = value;
        }

        @Override
        public boolean equals(Object key) {
            K rightObj = (K) key;
            if (this.myKey == null && rightObj == null) {
                return true;
            } else {
                return Objects.equals(this.myKey, rightObj);
            }
        }
    }
}
