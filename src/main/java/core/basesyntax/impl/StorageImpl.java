package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.StringJoiner;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String STRING_FORMAT = "%s : %s";
    private static final int RETURN_VALUE_IF_KEY_NOT_FOUND = -1;

    private final Pair<K, V>[] storage;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        storage = new Pair[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = findPairByKey(key);
        if (index == RETURN_VALUE_IF_KEY_NOT_FOUND) {
            storage[size++] = new Pair<>(key, value);
        } else {
            storage[index] = new Pair<>(key, value);
        }
    }

    @Override
    public V get(K key) {
        int index = findPairByKey(key);
        if (index == RETURN_VALUE_IF_KEY_NOT_FOUND) {
            return null;
        } else {
            return storage[index].value();
        }
    }

    private int findPairByKey(K key) {
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

    private record Pair<K, V>(K key, V value) {
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(DELIMITER, PREFIX, SUFFIX);
        for (int i = 0; i < size; i++) {
            stringJoiner.add(String.format(STRING_FORMAT, storage[i].key(), storage[i].value));
        }
        return stringJoiner.toString();
    }
}
