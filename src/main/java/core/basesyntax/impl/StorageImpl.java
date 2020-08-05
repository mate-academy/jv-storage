package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAXIMUM_SIZE = 10;
    private final Pair<K, V>[] storageArray;
    private int size = 0;

    public StorageImpl() {
        storageArray = new Pair[MAXIMUM_SIZE];
    }

    @Override
    public void put(K key, V value) {
        Pair pair = Pair.of(key, value);
        for (int i = 0; i <= size; i++) {
            if (i == size || storageArray[i].first == key
                    || storageArray[i] != null && isKeysEqual(storageArray[i].first,key)) {
                storageArray[i] = pair;
                size++;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        return storageArray[0] == null ? null : Arrays.stream(storageArray)
                .filter(x -> x.first == key
                        || x.first != null && isKeysEqual(x.first, key))
                .findFirst()
                .get().second;
    }

    public boolean isKeysEqual(K key,K storageKey) {
        return storageKey == null ?
                storageKey == key : storageKey.equals(key);
    }

    static class Pair<K, V> {
        private K first;
        private V second;

        private Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
        
        public static <K, V> Pair of(K first, V second) {
            return new Pair<>(first, second);
        }
    }
}