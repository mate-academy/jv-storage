package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Pair<K, V>[] pairs;
    private int size = 0;

    public StorageImpl() {
        pairs = new Pair[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index != -1) {
            pairs[index].setValue(value);
        } else {
            pairs[size++] = new Pair<>(key, value);
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return index == -1 ? null : pairs[index].getValue();
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            K currentKey = pairs[i].getKey();
            if (Objects.equals(key, currentKey) || currentKey != null && currentKey.equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
