package core.basesyntax.impl;

import core.basesyntax.Pair;
import core.basesyntax.Storage;
import java.util.Arrays;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAXIMUM_SIZE = 10;
    private final Pair<K, V>[] storageArray;
    private int size = 0;

    public StorageImpl() {
        storageArray = new Pair[MAXIMUM_SIZE];
    }

    @Override
    public void put(K key, V value) {
        boolean isKeyExist = storageArray[0] != null && Arrays.stream(storageArray)
                .filter(Objects::nonNull)
                .noneMatch(x -> x.getFirst() != key);
        if (!isKeyExist) {
            for (int i = 0; i < storageArray.length; i++) {
                if (i == size) {
                    storageArray[i] = Pair.of(key, value);
                    size++;
                    return;
                }
            }
        } else {
            Arrays.stream(storageArray)
                    .filter(x -> x.getFirst().equals(key))
                    .findFirst()
                    .ifPresent(x -> x.setSecond(value));
        }
    }

    @Override
    public V get(K key) {
        return storageArray[0] == null ? null : Arrays.stream(storageArray)
                .filter(x -> x.getFirst() == key
                        || x.getFirst() != null && x.getFirst().equals(key))
                .findFirst()
                .get()
                .getSecond();
    }
}

