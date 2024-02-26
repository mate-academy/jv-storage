package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.StringJoiner;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int RETURN_VALUE_IF_KEY_NOT_FOUND = -1;

    private final Pair<K, V>[] storage;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        storage = new Pair[DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int index = findPairIndexByKey(key);
        Pair<K, V> pair = new Pair<>(key, value);
        if (index == RETURN_VALUE_IF_KEY_NOT_FOUND) {
            storage[size++] = pair;
            return;
        }
        storage[index] = pair;
    }

    @Override
    public V get(K key) {
        int index = findPairIndexByKey(key);
        if (index == RETURN_VALUE_IF_KEY_NOT_FOUND) {
            return null;
        }
        return storage[index].value();
    }

    private int findPairIndexByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key == storage[i].key() || (key != null && key.equals(storage[i].key()))) {
                return i;
            }
        }
        return RETURN_VALUE_IF_KEY_NOT_FOUND;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String delimiter = ", ";
        String prefix = "[";
        String suffix = "]";
        String format = "%s : %s";
        StringJoiner stringJoiner = new StringJoiner(delimiter, prefix, suffix);
        for (int i = 0; i < size; i++) {
            stringJoiner.add(String.format(format, storage[i].key(), storage[i].value));
        }
        return stringJoiner.toString();
    }

    private record Pair<K, V>(K key, V value) {
    }
}
