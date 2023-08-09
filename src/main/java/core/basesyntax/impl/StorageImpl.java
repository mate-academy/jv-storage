package core.basesyntax.impl;

import core.basesyntax.Pair;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private Pair<K, V>[] pairs;
    private int modCount = 0;

    public StorageImpl() {
        pairs = new Pair[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null && getIndexByKey(key) == -1) {
            pairs[modCount] = new Pair<>(key, value);
            modCount++;
            return;
        }
        pairs[getIndexByKey(key)].setKey(key);
        pairs[getIndexByKey(key)].setValue(value);
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> keyValuePair : pairs) {
            if (keyValuePair == null) {
                return null;
            }
            if (key == null && keyValuePair.getKey() == null && keyValuePair.getValue() != null) {
                return keyValuePair.getValue();
            }
            if (keyValuePair.getKey() != null && keyValuePair.getKey().equals(key)) {
                return keyValuePair.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return pairs == null ? 0 : modCount;
    }

    public int getIndexByKey(K key) {
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i] == null) {
                return -1;
            }
            if (key == null && pairs[i].getKey() == null) {
                return i;
            }
            if (pairs[i].getKey() != null && pairs[i].getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
